package com.Hileb.teampotato.redirectionor;

import nilloader.api.lib.asm.ClassReader;
import nilloader.api.lib.asm.ClassWriter;
import nilloader.api.lib.asm.Opcodes;
import nilloader.api.lib.asm.tree.AbstractInsnNode;
import nilloader.api.lib.asm.tree.ClassNode;
import nilloader.api.lib.asm.tree.MethodNode;

import nilloader.api.lib.nanojson.JsonArray;
import nilloader.api.lib.nanojson.JsonWriter;
import nilloader.api.lib.nanojson.JsonObject;
import nilloader.api.lib.nanojson.JsonParser;
import nilloader.api.lib.nanojson.JsonParserException;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

import java.util.ListIterator;

// All entrypoint classes must implement Runnable.
public class RedirectionorTransformer implements nilloader.api.ClassTransformer, Runnable {

    public RedirectionorTransformer() {
        initConfig();
    }

    @Override
	public void run() {
		// You can change your desired mapping here. Setting it to "default" doesn't accomplish
		// anything, but it's here for illustration.
		ModRemapper.setTargetMapping("default");
		
		// Any class transformers need to be registered with NilLoader like this.
		ClassTransformer.register(this);
	}

    // NilLoader comes with a logger abstraction that Does The Right Thing depending on the environment.
	// You should always use it.
    public static final NilLogger LOGGER = NilLogger.get("Redirectionor");

	@Override
	public byte[] transform(String className, byte[] originalData) {
		try{
            if (!isAvailable(className, originalData)){
                return originalData;
            }
            ClassReader classReader = new ClassReader(originalData);
            ClassNode cn = new ClassNode();
            classReader.accept(cn, 0);
            for(MethodNode mn:cn.methods){
                if ("values".equals(mn.name) && mn.desc.startsWith("()")){
                    ListIterator<AbstractInsnNode> iterator = mn.instructions.iterator();
                    AbstractInsnNode node;
                    while (iterator.hasNext()){
                        node = iterator.next();
                        int code = node.getOpcode();
                        if (code != Opcodes.GETSTATIC && code != Opcodes.ARETURN){
                            iterator.remove();
                        }
                    }
                    if (printTransformedClasses) LOGGER.info("Redirectionor : " + className);
                    ClassWriter classWriter = new ClassWriter(classReader, 0);
                    cn.accept(classWriter);
                    return classWriter.toByteArray();
                }
            }
            return originalData;
        }catch (Throwable ignore){
            return originalData;
        }
	}

    public static boolean isEnum(byte[] clazz){
        if (clazz == null || clazz.length < 8) return false;
        int constantsCount = readUnsignedShort(clazz, 8);
        int passcount = 10;
        for(int i = 1; i < constantsCount; i++){
            int size=0;
            switch (clazz[passcount]){
                case 9:
                case 10:
                case 11:
                case 3:
                case 4:
                case 12:
                case 18:
                case 17:
                    size = 5;
                    break;
                case 5:
                case 6:
                    size = 9;
                    ++i;
                    break;
                case 1:
                    size = 3 + readUnsignedShort(clazz,passcount + 1);
                    break;
                case 15:
                    size = 4;
                    break;
                default:
                    size = 3;
                    break;
            }
            passcount += size;
        }
        passcount = readUnsignedShort(clazz, passcount);
        return (passcount & 16384) !=0;
    }
    \
    public static int readUnsignedShort(byte[] b, int index) {
        return ((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF);
    }

    public static File CONFIG_FILE = null;

    public static boolean decode(JsonObject jsonObject){
        boolean rewrite = false;
        try{

            if (jsonObject.isBoolean("printTransformedClasses")){
                printTransformedClasses = jsonObject.getBoolean("printTransformedClasses");
            } else rewrite = true;

            if (jsonObject.getString("type") != null) isBlock = setBlocking(jsonObject.getString("type"));
            else rewrite = true;

            if (jsonObject.getArray("contains") != null){
                JsonArray contains_ = jsonObject.getArray("contains");
                contains = new HashSet<>(contains_.size());
                int size = contains_.size();
                for (int i = 0; i < size ; i++) {
                    contains.add(contains_.getString(i));
                }
            } else rewrite = true;

            if (jsonObject.getArray("prefix") != null){
                JsonArray prefix_ = jsonObject.getArray("prefix");
                prefix = new HashSet<>(prefix_.size());
                int size = prefix_.size();
                for (int i = 0; i < size ; i++) {
                    prefix.add(prefix_.getString(i));
                }
            } else rewrite = true;

            if (jsonObject.isBoolean("generateConfigWhenCrash")){
                generateConfigWhenCrash = jsonObject.getBoolean("generateConfigWhenCrash");
            } else rewrite = true;
        }catch (Throwable e){
            throw new RuntimeException("Could not read the config", e);
        }
        return rewrite;
    }

    public static JsonObject encode(){
        JsonObject json = new JsonObject();
        json.put("printTransformedClasses", printTransformedClasses);
        json.put("type", isBlock ? "block" : "allow");

        JsonArray contains = new JsonArray(contains.size());
        contains.addAll(contains);
        json.put("contains", contains);

        JsonArray prefix = new JsonArray(prefix.size());
        prefix.addAll(prefix);
        json.put("prefix", prefix);

        json.put("generateConfigWhenCrash", generateConfigWhenCrash);
        return json;
    }

    public static void save(){
        try (PrintWriter pw = new PrintWriter(CONFIG_FILE, "UTF-8")){
            pw.println(JsonWriter.string(encode()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void initConfig(){
        if (CONFIG_FILE == null) {
            File gameRunRoot = null;
        File config = new File(gameRunRoot,"config");

        if (!config.exists()){
            config.mkdir();
        }

        File file = new File(config,"redirectionor_cfg.json");
        CONFIG_FILE = file;


        if (file.exists()){
            try {
                JsonObject jsonObject = JsonParser.object().from(new String(Files.readAllBytes(file.toPath())));
                if (decode(jsonObject)) save();
            } catch (IOException e) {
                throw new RuntimeException("Could not read the config", e);
            } catch (JsonParserException e){
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
    }

    public static boolean isAvailable(String name, byte[] datas){
        return datas != null && isEnum(datas) && (isBlock != (isPrefixed(name) || isContained(name)));
    }

    public static boolean isContained(String name){
        for(String modid : contains){
            if (name.contains(modid)){
                return true;
            }
        }
        return false;
    }

    public static boolean isPrefixed(String name){
        for(String modid : prefix){
            if (name.startsWith(modid)){
                return true;
            }
        }
        return false;
    }

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
