package com.Hileb.teampotato.redirectionor;

import nilloader.api.lib.asm.*;
import nilloader.api.lib.asm.tree.*;

import nilloader.api.lib.nanojson.JsonArray;
import nilloader.api.lib.nanojson.JsonWriter;
import nilloader.api.lib.nanojson.JsonObject;
import nilloader.api.lib.nanojson.JsonParser;
import nilloader.api.lib.nanojson.JsonParserException;

import nilloader.api.ClassTransformer;
import nilloader.api.ModRemapper;
import nilloader.api.NilLogger;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Locale;

import java.util.ListIterator;

import static nilloader.api.lib.asm.Opcodes.*;

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
    public byte[] transform(String transformedName, byte[] basicClass) {
        try{
            if (!isAvailable(transformedName, basicClass)){
                return basicClass;
            }
            ClassReader classReader = new ClassReader(basicClass);
            final String arrayType = "[L" + classReader.getClassName() + ';';
            ClassWriter classWriter = new ClassWriter(0);
            ClassVisitor classVisitor = new ClassVisitor(ASM9, classWriter) {
                @Override
                public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                    if ("values".equals(name) && desc.startsWith("()")) {
                        return new MethodVisitor(ASM9, super.visitMethod(access, name, desc, signature, exceptions)) {
                            @Override
                            public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                                if ("clone".equals(name)) {
                                    if (printTransformedClasses) LOGGER.info("Redirectionor : " + transformedName);
                                    if (checkEnumsWhenRunningTime) {
                                        super.visitMethodInsn(Opcodes.INVOKESTATIC, classReader.getClassName(), "redirectionor_checkEnums", "(" + arrayType + ")" + arrayType, false);
                                    }
                                } else super.visitMethodInsn(opcode, owner, name, desc, itf);
                            }
                        };
                    } else if ("<clinit>".equals(name) && checkEnumsWhenRunningTime) {
                        return new MethodVisitor(ASM9, super.visitMethod(access, name, desc, signature, exceptions)) {

                            @Override
                            public void visitInsn(int opcode) {
                                if (opcode == RETURN) {
                                    this.visitInsn(ICONST_1);
                                    this.visitFieldInsn(PUTSTATIC, classReader.getClassName(), "redirectionor_check", "Z");
                                    super.visitInsn(RETURN);
                                } else super.visitInsn(opcode);
                            }
                        };
                    } else return super.visitMethod(access, name, desc, signature, exceptions);
                }

                @Override
                public void visitEnd() {
                    if (checkEnumsWhenRunningTime) {
                        this.visitField(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "redirectionor_check", "Z", null, null).visitEnd();
                        MethodVisitor methodVisitor;
                        {
                            methodVisitor = this.visitMethod(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "redirectionor_logError", "()V", null, null);
                            methodVisitor.visitCode();
                            methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalStateException");
                            methodVisitor.visitInsn(Opcodes.DUP);
                            methodVisitor.visitLdcInsn("Enum#values() has been broken.");
                            methodVisitor.visitMethodInsn(Opcodes.INVOKESPECIAL, "java/lang/IllegalStateException", "<init>", "(Ljava/lang/String;)V", false);
                            methodVisitor.visitMethodInsn(INVOKESTATIC, "com/Hileb/teampotato/redirectionor/Redirectionor", "logError", "(Ljava/lang/Throwable;)V", false);
                            methodVisitor.visitInsn(Opcodes.RETURN);
                            methodVisitor.visitMaxs(2, 0);
                            methodVisitor.visitEnd();
                        }
                        {
                            methodVisitor = this.visitMethod(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "redirectionor_checkEnums", "(" + arrayType + ")" + arrayType, null, null);
                            methodVisitor.visitCode();
                            Label label0 = new Label();
                            methodVisitor.visitLabel(label0);
                            methodVisitor.visitFieldInsn(GETSTATIC, classReader.getClassName(), "redirectionor_check", "Z");
                            Label label1 = new Label();
                            methodVisitor.visitJumpInsn(IFEQ, label1);
                            Label label2 = new Label();
                            methodVisitor.visitLabel(label2);
                            methodVisitor.visitInsn(ICONST_0);
                            methodVisitor.visitVarInsn(ISTORE, 1);
                            Label label3 = new Label();
                            methodVisitor.visitLabel(label3);
                            methodVisitor.visitFrame(Opcodes.F_APPEND, 1, new Object[]{Opcodes.INTEGER}, 0, null);
                            methodVisitor.visitVarInsn(ALOAD, 0);
                            methodVisitor.visitInsn(ARRAYLENGTH);
                            methodVisitor.visitVarInsn(ILOAD, 1);
                            methodVisitor.visitJumpInsn(IF_ICMPLE, label1);
                            Label label4 = new Label();
                            methodVisitor.visitLabel(label4);
                            methodVisitor.visitVarInsn(ALOAD, 0);
                            methodVisitor.visitVarInsn(ILOAD, 1);
                            methodVisitor.visitInsn(AALOAD);
                            methodVisitor.visitMethodInsn(INVOKEVIRTUAL, "java/lang/Enum", "ordinal", "()I", false);
                            methodVisitor.visitVarInsn(ILOAD, 1);
                            Label label5 = new Label();
                            methodVisitor.visitJumpInsn(IF_ICMPEQ, label5);
                            Label label6 = new Label();
                            methodVisitor.visitLabel(label6);
                            methodVisitor.visitMethodInsn(INVOKESTATIC, classReader.getClassName(), "redirectionor_logError", "()V", false);
                            Label label7 = new Label();
                            methodVisitor.visitLabel(label7);
                            methodVisitor.visitInsn(ICONST_0);
                            methodVisitor.visitFieldInsn(PUTSTATIC, classReader.getClassName(), "redirectionor_check", "Z");
                            Label label8 = new Label();
                            methodVisitor.visitLabel(label8);
                            methodVisitor.visitJumpInsn(GOTO, label1);
                            methodVisitor.visitLabel(label5);
                            methodVisitor.visitFrame(Opcodes.F_SAME, 0, null, 0, null);
                            methodVisitor.visitIincInsn(1, 1);
                            methodVisitor.visitJumpInsn(GOTO, label3);
                            methodVisitor.visitLabel(label1);
                            methodVisitor.visitFrame(Opcodes.F_CHOP, 1, null, 0, null);
                            methodVisitor.visitVarInsn(ALOAD, 0);
                            methodVisitor.visitInsn(ARETURN);
                            Label label9 = new Label();
                            methodVisitor.visitLabel(label9);
                            methodVisitor.visitLocalVariable("i", "I", null, label3, label1, 1);
                            methodVisitor.visitLocalVariable("enumArray", arrayType, arrayType, label0, label9, 0);
                            methodVisitor.visitMaxs(2, 2);
                            methodVisitor.visitEnd();
                        }
                    }
                    super.visitEnd();
                }
            };
            classReader.accept(classVisitor, 0);
            return classWriter.toByteArray();
        }catch (Exception ignore){
            ignore.printStackTrace();
            return basicClass;
        }
    }

    public static boolean isEnum(byte[] clazz) {
        if (clazz == null || clazz.length < 8) return false;
        int constantsCount = readUnsignedShort(clazz, 8);
        int passcount = 10;
        for (int i = 1; i < constantsCount; i++) {
            int size = 0;
            switch (clazz[passcount]) {
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
                    size = 3 + readUnsignedShort(clazz, passcount + 1);
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
        return (passcount & 16384) != 0;
    }

    public static int readUnsignedShort(byte[] b, int index) {
        return ((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF);
    }

    public static File CONFIG_FILE = null;

    public static boolean decode(JsonObject jsonObject) {
        boolean rewrite = false;
        try {

            if (jsonObject.isBoolean("checkEnumsWhenRunningTime")) {
                checkEnumsWhenRunningTime = jsonObject.getBoolean("checkEnumsWhenRunningTime");
            } else rewrite = true;

            if (jsonObject.isBoolean("printTransformedClasses")) {
                printTransformedClasses = jsonObject.getBoolean("printTransformedClasses");
            } else rewrite = true;

            if (jsonObject.getString("type") != null) isBlock = setBlocking(jsonObject.getString("type"));
            else rewrite = true;

            if (jsonObject.getArray("contains") != null) {
                JsonArray contains_ = jsonObject.getArray("contains");
                contains = new HashSet < > (contains_.size());
                int size = contains_.size();
                for (int i = 0; i < size; i++) {
                    contains.add(contains_.getString(i));
                }
            } else rewrite = true;

            if (jsonObject.getArray("prefix") != null) {
                JsonArray prefix_ = jsonObject.getArray("prefix");
                prefix = new HashSet < > (prefix_.size());
                int size = prefix_.size();
                for (int i = 0; i < size; i++) {
                    prefix.add(prefix_.getString(i));
                }
            } else rewrite = true;

            if (jsonObject.isBoolean("generateConfigWhenCrash")) {
                generateConfigWhenCrash = jsonObject.getBoolean("generateConfigWhenCrash");
            } else rewrite = true;
        } catch (Throwable e) {
            throw new RuntimeException("Could not read the config", e);
        }
        return rewrite;
    }

    public static JsonObject encode() {
        JsonObject json = new JsonObject();
        json.put("printTransformedClasses", printTransformedClasses);
        json.put("checkEnumsWhenRunningTime", checkEnumsWhenRunningTime);
        json.put("type", isBlock ? "block" : "allow");

        JsonArray contains_ = new JsonArray(contains.size());
        contains_.addAll(contains);
        json.put("contains", contains_);

        JsonArray prefix_ = new JsonArray(prefix.size());
        prefix_.addAll(prefix);
        json.put("prefix", prefix_);

        json.put("generateConfigWhenCrash", generateConfigWhenCrash);
        return json;
    }

    public static void save() {
        try (PrintWriter pw = new PrintWriter(CONFIG_FILE, "UTF-8")) {
            pw.println(JsonWriter.string(encode()));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    public static void initConfig() {
        if (CONFIG_FILE == null) {
            File gameRunRoot = null;
            File config = new File(gameRunRoot, "config");

            if (!config.exists()) {
                config.mkdir();
            }

            File file = new File(config, "redirectionor_cfg.json");
            CONFIG_FILE = file;


            if (file.exists()) {
                try {
                    JsonObject jsonObject = JsonParser.object().from(new String(Files.readAllBytes(file.toPath())));
                    if (decode(jsonObject)) save();
                } catch (IOException e) {
                    throw new RuntimeException("Could not read the config", e);
                } catch (JsonParserException e) {
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

    public static boolean isAvailable(String name, byte[] datas) {
        return datas != null && isEnum(datas) && (isBlock != (isPrefixed(name) || isContained(name)));
    }

    public static boolean isContained(String name) {
        for (String modid: contains) {
            if (name.contains(modid)) {
                return true;
            }
        }
        return false;
    }

    public static boolean isPrefixed(String name) {
        for (String modid: prefix) {
            if (name.startsWith(modid)) {
                return true;
            }
        }
        return false;
    }

    public static boolean generateConfigWhenCrash = true;
    public static boolean printTransformedClasses = false;
    public static boolean checkEnumsWhenRunningTime = false;
    public static boolean isBlock = true;
    public static HashSet < String > contains = new HashSet < > ();
    public static HashSet < String > prefix = new HashSet < > ();
    public static boolean setBlocking(String s) {
        if ("block".equals(s.toLowerCase(Locale.ENGLISH))) return true;
        else if ("allow".equals(s.toLowerCase(Locale.ENGLISH))) return false;
        else throw new IllegalArgumentException("unknown type for config/redirectionor_cfg.json :" + s + " it should be \"block\" or \"allow\"");
    }
}
