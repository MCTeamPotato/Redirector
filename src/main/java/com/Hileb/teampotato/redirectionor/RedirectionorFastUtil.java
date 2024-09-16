/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  com.Hileb.teampotato.redirectionor.RedirectionorConfig$Config
 *  java.lang.CharSequence
 *  java.lang.Object
 *  java.lang.String
 */
package com.Hileb.teampotato.redirectionor;

import com.Hileb.teampotato.redirectionor.RedirectionorConfig;

public class RedirectionorFastUtil {
    public static boolean isEnum(byte[] clazz) {
        if (clazz == null || clazz.length < 8) {
            return false;
        }
        int constantsCount = RedirectionorFastUtil.readUnsignedShort(clazz, 8);
        int passcount = 10;
        for (int i = 1; i < constantsCount; ++i) {
            int size = 0;
            switch (clazz[passcount]) {
                case 3: 
                case 4: 
                case 9: 
                case 10: 
                case 11: 
                case 12: 
                case 18: {
                    size = 5;
                    break;
                }
                case 5: 
                case 6: {
                    size = 9;
                    break;
                }
                case 1: {
                    size = 3 + RedirectionorFastUtil.readUnsignedShort(clazz, passcount + 1);
                    break;
                }
                case 15: {
                    size = 4;
                    break;
                }
                default: {
                    size = 3;
                }
            }
            passcount += size;
        }
        return ((passcount = RedirectionorFastUtil.readUnsignedShort(clazz, passcount)) & 0x4000) != 0;
    }

    public static int readUnsignedShort(byte[] b, int index) {
        return (b[index] & 0xFF) << 8 | b[index + 1] & 0xFF;
    }

    public static boolean isAvailable(String name) {
        return RedirectionorConfig.Config.isBlock != (RedirectionorFastUtil.isPrefixed(name) || RedirectionorFastUtil.isContained(name));
    }

    public static boolean isContained(String name) {
        for (String modid : RedirectionorConfig.Config.contains) {
            if (!name.contains((CharSequence)modid)) continue;
            return true;
        }
        return false;
    }

    public static boolean isPrefixed(String name) {
        for (String modid : RedirectionorConfig.Config.prefix) {
            if (!name.startsWith(modid)) continue;
            return true;
        }
        return false;
    }
}
