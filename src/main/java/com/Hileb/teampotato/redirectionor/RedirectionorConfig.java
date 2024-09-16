/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.Hileb.teampotato.redirectionor.RedirectionorConfig$Config
 *  com.google.gson.Gson
 *  com.google.gson.GsonBuilder
 *  com.google.gson.JsonArray
 *  com.google.gson.JsonElement
 *  com.google.gson.JsonObject
 *  com.google.gson.JsonParser
 *  com.google.gson.JsonSyntaxException
 *  java.io.File
 *  java.io.IOException
 *  java.io.PrintWriter
 *  java.lang.Boolean
 *  java.lang.Object
 *  java.lang.RuntimeException
 *  java.lang.String
 *  java.lang.Throwable
 *  java.nio.file.Files
 *  java.nio.file.Path
 *  java.util.HashSet
 *  net.minecraft.launchwrapper.Launch
 */
package com.Hileb.teampotato.redirectionor;

import com.Hileb.teampotato.redirectionor.RedirectionorConfig;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import com.google.gson.JsonSyntaxException;
import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import net.minecraft.launchwrapper.Launch;

/*
 * Exception performing whole class analysis ignored.
 */
public class RedirectionorConfig {
    public static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
    public static File CONFIG_FILE = null;

    public static boolean decode(JsonObject jsonObject) {
        boolean rewrite = false;
        try {
            if (jsonObject.has("printTransformedClasses")) {
                Config.printTransformedClasses = jsonObject.get("printTransformedClasses").getAsBoolean();
            } else {
                rewrite = true;
            }
            if (jsonObject.has("type")) {
                Config.isBlock = Config.setBlocking((String)jsonObject.get("type").getAsString());
            } else {
                rewrite = true;
            }
            if (jsonObject.has("contains")) {
                JsonArray contains = jsonObject.get("contains").getAsJsonArray();
                Config.contains = new HashSet(contains.size());
                for (JsonElement element : contains) {
                    Config.contains.add((Object)element.getAsString());
                }
            } else {
                rewrite = true;
            }
            if (jsonObject.has("prefix")) {
                JsonArray prefix = jsonObject.get("prefix").getAsJsonArray();
                Config.prefix = new HashSet(prefix.size());
                for (JsonElement element : prefix) {
                    Config.prefix.add((Object)element.getAsString());
                }
            } else {
                rewrite = true;
            }
            if (jsonObject.has("generateConfigWhenCrash")) {
                Config.generateConfigWhenCrash = jsonObject.get("generateConfigWhenCrash").getAsBoolean();
            } else {
                rewrite = true;
            }
        }
        catch (Throwable e) {
            throw new RuntimeException("Could not read the config", e);
        }
        return rewrite;
    }

    public static JsonObject encode() {
        JsonObject json = new JsonObject();
        json.addProperty("printTransformedClasses", Boolean.valueOf((boolean)Config.printTransformedClasses));
        json.addProperty("type", Config.isBlock ? "block" : "allow");
        JsonArray contains = new JsonArray();
        for (String element : Config.contains) {
            contains.add(element);
        }
        json.add("contains", (JsonElement)contains);
        JsonArray prefix = new JsonArray();
        for (String element : Config.prefix) {
            prefix.add(element);
        }
        json.add("prefix", (JsonElement)prefix);
        json.addProperty("generateConfigWhenCrash", Boolean.valueOf((boolean)Config.generateConfigWhenCrash));
        return json;
    }

    public static void save() {
        try (PrintWriter pw = new PrintWriter(CONFIG_FILE, "UTF-8");){
            pw.println(GSON.toJson((JsonElement)RedirectionorConfig.encode()));
        }
        catch (IOException e) {
            throw new RuntimeException((Throwable)e);
        }
    }

    /*
     * Enabled force condition propagation
     * Lifted jumps to return sites
     */
    public static void initConfig() {
        File file;
        File gameRunRoot = Launch.minecraftHome;
        File config = new File(gameRunRoot, "config");
        if (!config.exists()) {
            config.mkdir();
        }
        CONFIG_FILE = file = new File(config, "redirectionor_cfg.json");
        if (file.exists()) {
            try {
                JsonParser jsonParser = new JsonParser();
                JsonObject jsonObject = (JsonObject)jsonParser.parse(new String(Files.readAllBytes((Path)file.toPath())));
                if (!RedirectionorConfig.decode(jsonObject)) return;
                RedirectionorConfig.save();
                return;
            }
            catch (IOException e) {
                throw new RuntimeException("Could not read the config", (Throwable)e);
            }
            catch (JsonSyntaxException e) {
                throw new RuntimeException("The Json is bad", (Throwable)e);
            }
        }
        try {
            file.createNewFile();
            RedirectionorConfig.save();
            return;
        }
        catch (IOException e) {
            throw new RuntimeException("Could not create config file", (Throwable)e);
        }
    }
}
