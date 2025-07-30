package com.Hileb.teampotato.redirectionor.transformers;

import com.Hileb.teampotato.redirectionor.Redirectionor;
import com.Hileb.teampotato.redirectionor.RedirectionorConfig;
import com.Hileb.teampotato.redirectionor.RedirectionorFastUtil;
import net.minecraft.launchwrapper.IClassTransformer;
import org.apache.commons.lang3.SystemUtils;
import org.objectweb.asm.*;

import static org.objectweb.asm.Opcodes.*;

@SuppressWarnings("unused")
public class RedirectionorTransformer implements IClassTransformer {
    public static final int ASM_API = SystemUtils.IS_JAVA_1_8 ? (5 << 16 | 0 << 8) : (9 << 16 | 0 << 8); // ASM5 : ASM9

    @Override
    public byte[] transform(String name, String transformedName, byte[] basicClass) {
        try{
            if (!RedirectionorFastUtil.isEnum(basicClass) || !RedirectionorFastUtil.isAvailable(transformedName)){
                return basicClass;
            }
            ClassReader classReader = new ClassReader(basicClass);
            final String arrayType = "[L" + classReader.getClassName() + ';';
            ClassWriter classWriter = new ClassWriter(0);
            ClassVisitor classVisitor = new ClassVisitor(ASM_API, classWriter) {
                @Override
                public MethodVisitor visitMethod(int access, String name, String desc, String signature, String[] exceptions) {
                    if ("values".equals(name) && desc.startsWith("()")) {
                        return new MethodVisitor(ASM_API, super.visitMethod(access, name, desc, signature, exceptions)) {
                            @Override
                            public void visitMethodInsn(int opcode, String owner, String name, String desc, boolean itf) {
                                if ("clone".equals(name)) {
                                    if (RedirectionorConfig.Config.printTransformedClasses) Redirectionor.LOGGER.info("Redirectionor : " + transformedName);
                                    if (RedirectionorConfig.Config.checkEnumsWhenRunningTime) {
                                        super.visitMethodInsn(Opcodes.INVOKESTATIC, classReader.getClassName(), "redirectionor_checkEnums", "(" + arrayType + ")" + arrayType, false);
                                    }
                                } else super.visitMethodInsn(opcode, owner, name, desc, itf);
                            }
                        };
                    } else if ("<clinit>".equals(name) && RedirectionorConfig.Config.checkEnumsWhenRunningTime) {
                        return new MethodVisitor(ASM_API, super.visitMethod(access, name, desc, signature, exceptions)) {

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
                    if (RedirectionorConfig.Config.checkEnumsWhenRunningTime) {
                        this.visitField(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "redirectionor_check", "Z", null, null).visitEnd();
                        MethodVisitor methodVisitor;
                        {
                            methodVisitor = this.visitMethod(Opcodes.ACC_PRIVATE | Opcodes.ACC_STATIC, "redirectionor_logError", "()V", null, null);
                            methodVisitor.visitCode();
                            methodVisitor.visitTypeInsn(Opcodes.NEW, "java/lang/IllegalStateException");
                            methodVisitor.visitInsn(Opcodes.DUP);
                            methodVisitor.visitLdcInsn(classReader.getClassName() + "#values() has been broken.");
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
            Redirectionor.LOGGER.error(ignore);
            return basicClass;
        }
    }
}
