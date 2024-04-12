package com.Hileb.teampotato.redirectionor;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import net.minecraft.launchwrapper.Launch;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Locale;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/9/9 18:14
 **/
public class RedirectionorConfig {
    public static void initConfig(){
        File gameRunRoot = Launch.minecraftHome;
        File config=new File(gameRunRoot,"config");
        if (!config.exists()){
            config.mkdir();
        }
        File file=new File(config,"redirectionor_cfg.json");
        if (!file.exists()){
            try {
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file,"UTF-8");
                pw.println("{\"printTransformedClasses\":true,\"type\":\"block\", \"contains\":[]}");
                pw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            JsonParser jsonParser = new JsonParser();
            JsonObject jsonObject = (JsonObject)jsonParser.parse(new String(Files.readAllBytes(file.toPath())));
            if (jsonObject.has("printTransformedClasses")){
                RedirectionorTransformer.isDeBug = jsonObject.get("printTransformedClasses").getAsBoolean();
            }
            Config.type = jsonObject.get("type").getAsString();
            JsonArray contains = jsonObject.get("contains").getAsJsonArray();
            for(JsonElement element : contains){
                Config.contains.add(element.getAsString());
            }
        } catch (IOException e) {
            throw new RuntimeException("Could not read the config", e);
        } catch (ClassCastException e){
            throw new RuntimeException("The config is not json", e);
        } catch (JsonSyntaxException e){
            throw new RuntimeException("The Json is bad", e);
        }
    }
    public static class Config{
        public static String type = "block";
        public static HashSet<String> contains = new HashSet<>();
        public static boolean isBlocking(){
            if ("block".equals(type.toLowerCase(Locale.ENGLISH)))return true;
            else if ("allow".equals(type.toLowerCase(Locale.ENGLISH)))return false;
            else throw new IllegalArgumentException("unknown type for config/redirectionor_cfg.json :"+type+" it should be \"block\" or \"allow\"");
        }
    }
}
