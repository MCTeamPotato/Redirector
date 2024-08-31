package com.Hileb.teampotato.redirectionor;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import net.minecraft.launchwrapper.Launch;
import net.minecraft.launchwrapper.LaunchClassLoader;
import net.minecraftforge.fml.common.ICrashCallable;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Locale;
import java.util.Map;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/9/9 18:14
 **/
public class RedirectionorConfig {

    public static File CONFIG_FILE = null;

    public static void decode(JsonObject jsonObject){
        try{
            if (jsonObject.has("printTransformedClasses")){
                Config.printTransformedClasses = jsonObject.get("printTransformedClasses").getAsBoolean();
            }
            if (jsonObject.has("type")) Config.isBlock = Config.setBlocking(jsonObject.get("type").getAsString());
            if (jsonObject.has("contains")){
                JsonArray contains = jsonObject.get("contains").getAsJsonArray();
                Config.contains = new HashSet<>(contains.size());
                for (JsonElement element : contains) {
                    Config.contains.add(element.getAsString());
                }
            }
            if (jsonObject.has("prefix")){
                JsonArray prefix = jsonObject.get("prefix").getAsJsonArray();
                Config.prefix = new HashSet<>(prefix.size());
                for (JsonElement element : prefix) {
                    Config.prefix.add(element.getAsString());
                }
            }
        }catch (Throwable e){
            throw new RuntimeException("Could not read the config", e);
        }
    }

    public static JsonObject encode(){
        JsonObject json = new JsonObject();
        json.addProperty("printTransformedClasses", Config.isBlock);
        json.addProperty("type", Config.isBlock ? "block" : "allow");

        JsonArray contains = new JsonArray();
        for(String element : Config.contains){
            contains.add(element);
        }

        JsonArray prefix = new JsonArray();
        for(String element : Config.prefix){
            prefix.add(element);
        }

        json.add("prefix", prefix);
        return json;
    }

    public static void save(){
        if (CONFIG_FILE == null) initConfig();
        try (PrintWriter pw = new PrintWriter(CONFIG_FILE,"UTF-8")){
            pw.println(encode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void initConfig(){
        File gameRunRoot = Launch.minecraftHome;
        File config = new File(gameRunRoot,"config");

        if (!config.exists()){
            config.mkdir();
        }

        File file = new File(config,"redirectionor_cfg.json");
        if (file.exists()){
            try {
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject)jsonParser.parse(new String(Files.readAllBytes(file.toPath())));
                decode(jsonObject);
            } catch (IOException e) {
                throw new RuntimeException("Could not read the config", e);
            } catch (JsonSyntaxException e){
                throw new RuntimeException("The Json is bad", e);
            }
        } else {
            try {
                file.createNewFile();
            } catch (IOException e) {
                throw new RuntimeException("Could not operate config file", e);
            }
        }
        try (PrintWriter pw = new PrintWriter(file,"UTF-8")){
            pw.println(encode());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        CONFIG_FILE = file;
    }
    public static class Config{
        public static boolean printTransformedClasses = false;
        public static boolean isBlock = true;
        public static HashSet<String> contains = new HashSet<>();
        public static HashSet<String> prefix = new HashSet<>();
        public static boolean setBlocking(String s){
            if ("block".equals(s.toLowerCase(Locale.ENGLISH))) return true;
            else if ("allow".equals(s.toLowerCase(Locale.ENGLISH))) return false;
            else throw new IllegalArgumentException("unknown type for config/redirectionor_cfg.json :" + s + " it should be \"block\" or \"allow\"");
        }

    }

    // For 1.9.4 and above, scanned, but coremod and 1.8.8 care, we inject it.
    public static class CrashHandler implements ICrashCallable {

        @Override
        public String call() {
            handleCrash();
            save();
            return "An automatic prefix block config generated";
        }

        @Override
        public String getLabel() {
            return "Redirectionor is enabled. Check your enums!";
        }

        public static final Object lock = new Object();

        public static void handleCrash(){
            synchronized (lock){
                if (Config.isBlock){
                    Method untransformName;
                    try {
                        untransformName = Launch.classLoader.getClass().getDeclaredMethod("untransformName", String.class);
                    } catch (NoSuchMethodException e) {
                        throw new RuntimeException(e);
                    }
                    for(Map.Entry<Thread, StackTraceElement[]> thread : Thread.getAllStackTraces().entrySet()){
                        for(StackTraceElement elements : thread.getValue()){
                            try {
                                if (RedirectionorFastUtil.isEnum(Launch.classLoader.getClassBytes((String) untransformName.invoke(Launch.classLoader, elements.getClassName())))){
                                    Config.prefix.add(elements.getClassName());
                                }
                            } catch (IOException | InvocationTargetException | IllegalAccessException ignored) {
                                //declare but never throws
                            }
                        }
                    }
                }
            }
        }
    }
}
