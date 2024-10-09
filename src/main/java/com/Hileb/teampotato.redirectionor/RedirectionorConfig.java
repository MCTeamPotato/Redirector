package com.Hileb.teampotato.redirectionor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSyntaxException;
import net.minecraft.crash.CrashReport;
import net.minecraft.launchwrapper.Launch;
import net.minecraftforge.fml.common.ICrashCallable;
import sun.awt.windows.ThemeReader;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/9/9 18:14
 **/
public class RedirectionorConfig {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();

    public static File CONFIG_FILE = null;

    public static boolean decode(JsonObject jsonObject){
        boolean rewrite = false;
        try{

            if (jsonObject.has("printTransformedClasses")){
                Config.printTransformedClasses = jsonObject.get("printTransformedClasses").getAsBoolean();
            } else rewrite = true;

            if (jsonObject.has("type")) Config.isBlock = Config.setBlocking(jsonObject.get("type").getAsString());
            else rewrite = true;

            if (jsonObject.has("contains")){
                JsonArray contains = jsonObject.get("contains").getAsJsonArray();
                Config.contains = new HashSet<>(contains.size());
                for (JsonElement element : contains) {
                    Config.contains.add(element.getAsString());
                }
            } else rewrite = true;

            if (jsonObject.has("prefix")){
                JsonArray prefix = jsonObject.get("prefix").getAsJsonArray();
                Config.prefix = new HashSet<>(prefix.size());
                for (JsonElement element : prefix) {
                    Config.prefix.add(element.getAsString());
                }
            } else rewrite = true;

            if (jsonObject.has("generateConfigWhenCrash")){
                Config.generateConfigWhenCrash = jsonObject.get("generateConfigWhenCrash").getAsBoolean();
            } else rewrite = true;
        }catch (Throwable e){
            throw new RuntimeException("Could not read the config", e);
        }
        return rewrite;
    }

    public static JsonObject encode(){
        JsonObject json = new JsonObject();
        json.addProperty("printTransformedClasses", Config.printTransformedClasses);
        json.addProperty("type", Config.isBlock ? "block" : "allow");

        JsonArray contains = new JsonArray();
        for(String element : Config.contains){
            contains.add(new JsonPrimitive(element));
        }
        json.add("contains", contains);

        JsonArray prefix = new JsonArray();
        for(String element : Config.prefix){
            prefix.add(new JsonPrimitive(element));
        }

        json.add("prefix", prefix);

        json.addProperty("generateConfigWhenCrash", Config.generateConfigWhenCrash);
        return json;
    }

    public static void save(){
        try (PrintWriter pw = new PrintWriter(CONFIG_FILE, "UTF-8")){
            pw.println(GSON.toJson(encode()));
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
        CONFIG_FILE = file;


        if (file.exists()){
            try {
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject)jsonParser.parse(new String(Files.readAllBytes(file.toPath())));
                if (decode(jsonObject)) save();
            } catch (IOException e) {
                throw new RuntimeException("Could not read the config", e);
            } catch (JsonSyntaxException e){
                throw new RuntimeException("The Json is bad", e);
            }
        } else {
            try {
                file.createNewFile();
                save();
            } catch (IOException e) {
                throw new RuntimeException("Could not create config file", e);
            }
        }
    }
    public static class Config{
        public static boolean generateConfigWhenCrash = true;
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
            return "An automatic prefix block config generated";
        }

        @Override
        public String getLabel() {
            return "Redirectionor is enabled. Check your enums!";
        }

        @SuppressWarnings("unused") // ASM invoke
        public static void handleCrash(CrashReport crashReport){
                if (Config.generateConfigWhenCrash){
                    if ("ThisIsFake".equals(crashReport.getDescription())) return;
                    else if (Config.isBlock){
                        Iterator<Throwable> iterator = new Iterator<Throwable>() {
                            public Throwable current = crashReport.getCrashCause();
                            @Override
                            public boolean hasNext() {
                                return current != null;
                            }

                            @Override
                            public Throwable next() {
                                Throwable toReturn = current;
                                current = toReturn.getCause();
                                return toReturn;
                            }
                        };
                        while (iterator.hasNext()){
                            for(StackTraceElement element : iterator.next().getStackTrace()){
                                try{
                                    Class<?> cls = Class.forName(element.getClassName(), false, Launch.classLoader);
                                    if (cls.isEnum()){
                                        Config.prefix.add(cls.getName());
                                    }
                                } catch (ClassNotFoundException ignored) {
                                    // no ops
                                }
                            }
                        }
                        save();
                    }
                }
        }
    }
}
