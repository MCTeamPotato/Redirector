package com.Hileb.teampotato.redirectionor;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;
import com.google.gson.stream.JsonReader;
import net.minecraft.launchwrapper.Launch;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.Reader;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/9/9 18:14
 **/
public class RedirectionorConfig {
    public static final Gson GSON=(new GsonBuilder()).setPrettyPrinting().disableHtmlEscaping().create();
    public static Config instance=new Config();
    public static void initConfig(){
        File gameRunRoot= Launch.minecraftHome;
        File config=new File(gameRunRoot,"config");
        if (!config.exists()){
            config.mkdir();
        }
        File file=new File(config,"redirectionor_cfg.json");
        if (!file.exists()){
            try {
                file.createNewFile();
                PrintWriter pw = new PrintWriter(file,"UTF-8");
                pw.println(GSON.toJson(instance));
                pw.close();
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        try {
            Config cConfig=GSON.fromJson(new String(Files.readAllBytes(file.toPath()), StandardCharsets.UTF_8),Config.class);
            instance=cConfig;
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static class Config{
        public String type;
        public String[] contains;
        public Config(){
            type="block";
            contains=new String[0];
        }
        public boolean isBlocking(){
            if ("block".equals(type))return true;
            else if ("allow".equals(type))return false;
            else throw new IllegalArgumentException("unknown type for config/redirectionor_cfg.json :"+type+" it should be \"block\" or \"allow\"");
        }
    }
}
