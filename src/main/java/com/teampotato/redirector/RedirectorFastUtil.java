package com.teampotato.redirector;

import org.jetbrains.annotations.Contract;
import org.jetbrains.annotations.NotNull;

import java.util.HashMap;

public class RedirectorFastUtil {
    public static @NotNull String getSuperClass(byte[] clazz) {
        HashMap<Integer, Integer> utfMap = new HashMap<>();
        HashMap<Integer, Integer> classMap = new HashMap<>();
        int constantsCount = readUnsignedShort(clazz, 8);
        int passcount = 10;
        for (int i = 1; i < constantsCount; i++) {
            int size;
            switch (clazz[passcount]) {
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
                case 1://UTF8
                    int UTFSize = readUnsignedShort(clazz, passcount + 1);
                    size = 3 + UTFSize;
                    utfMap.put(i, passcount);
                    break;
                case 15:
                    size = 4;
                    break;
                case 7://class
                    size = 3;
                    int index = readUnsignedShort(clazz, passcount + 1);
                    classMap.put(i, index);
                    break;
                default:
                    size = 3;
                    break;
            }
            passcount += size;

        }
        passcount += 4;
        passcount = readUnsignedShort(clazz, passcount);
        passcount = classMap.get(passcount);
        passcount = utfMap.get(passcount);
        int UTFSize = readUnsignedShort(clazz, passcount + 1);
        return readUTF8(clazz, passcount + 3, UTFSize);
    }

    @Contract(pure = true)
    public static int readUnsignedShort(byte @NotNull [] b, int index) {
        return ((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF);
    }

    @Contract(value = "_, _, _ -> new", pure = true)
    public static @NotNull String readUTF8(byte[] b, int index, int length) {
        char[] str = new char[length];
        for (int i = 0; i < length; i++) {
            str[i] = (char) b[i + index];
        }
        return new String(str);
    }
}
