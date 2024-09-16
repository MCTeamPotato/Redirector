/*
 * Decompiled with CFR 0.152.
 * 
 * Could not load the following classes:
 *  java.lang.IllegalArgumentException
 *  java.lang.Object
 *  java.lang.String
 *  java.util.HashSet
 *  java.util.Locale
 */
package com.Hileb.teampotato.redirectionor;

import java.util.HashSet;
import java.util.Locale;

public static class RedirectionorConfig.Config {
    public static boolean generateConfigWhenCrash = true;
    public static boolean printTransformedClasses = false;
    public static boolean isBlock = true;
    public static HashSet<String> contains = new HashSet();
    public static HashSet<String> prefix = new HashSet();

    public static boolean setBlocking(String s) {
        if ("block".equals((Object)s.toLowerCase(Locale.ENGLISH))) {
            return true;
        }
        if ("allow".equals((Object)s.toLowerCase(Locale.ENGLISH))) {
            return false;
        }
        throw new IllegalArgumentException("unknown type for config/redirectionor_cfg.json :" + s + " it should be \"block\" or \"allow\"");
    }
}
