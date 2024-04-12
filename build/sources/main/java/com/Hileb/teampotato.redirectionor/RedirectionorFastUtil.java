package com.Hileb.teampotato.redirectionor;

import it.unimi.dsi.fastutil.ints.Int2IntArrayMap;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.Opcodes;

import java.lang.reflect.Modifier;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/8/29 22:00
 **/
public class RedirectionorFastUtil {
    public static boolean isEnum(byte[] clazz){
        int constantsCount = readUnsignedShort(clazz,8);
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
                    size = 5;
                    break;
                case 5:
                case 6:
                    size = 9;
                    break;
                case 1:
                    int UTFSize=readUnsignedShort(clazz,passcount + 1);
                    size = 3 + UTFSize;
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
    public static int readUnsignedShort(byte[] b, int index) {
        return ((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF);
    }
    public static boolean isAvailable(String name){
        for(String modid : RedirectionorConfig.Config.contains){
            if (name.contains(modid)){
                return !RedirectionorConfig.Config.isBlocking();
            }
        }
        return RedirectionorConfig.Config.isBlocking();
    }
}
