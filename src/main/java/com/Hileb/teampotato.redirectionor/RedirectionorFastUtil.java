package com.Hileb.teampotato.redirectionor;

import java.util.HashMap;

/**
 * @Project Redirectionor
 * @Author Hileb
 * @Date 2023/8/29 22:00
 **/
public class RedirectionorFastUtil {
    public static String getSuperClass(byte[] clazz){
        HashMap<Integer,Integer> UTF=new HashMap<Integer,Integer>();
        HashMap<Integer,Integer> CLASS=new HashMap<Integer,Integer>();
        int constantsCount=readUnsignedShort(clazz,8);
        int passcount=10;
        for(int i=1;i<constantsCount;i++){
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
                case 1://UTF8
                    int UTFSize=readUnsignedShort(clazz,passcount + 1);
                    size = 3 + UTFSize;
                    UTF.put(i,passcount);
                    break;
                case 15:
                    size = 4;
                    break;
                case 7://class
                    size = 3;
                    int index=readUnsignedShort(clazz,passcount+1);
                    CLASS.put(i,index);
                    break;
                default:
                    size = 3;
                    break;
            }
            passcount+=size;

        }
        passcount+=4;
        passcount=readUnsignedShort(clazz,passcount);
        passcount=CLASS.get(passcount);
        passcount=UTF.get(passcount);
        int UTFSize=readUnsignedShort(clazz,passcount + 1);
        return readUTF8(clazz,passcount+3,UTFSize);
    }
    public static int readUnsignedShort(byte[] b, int index) {
        return ((b[index] & 0xFF) << 8) | (b[index + 1] & 0xFF);
    }
    public static String readUTF8(byte[] b,int index,int length){
        StringBuilder builder=new StringBuilder(length);
        builder.setLength(length);
        for(int i=0;i<length;i++){
            builder.setCharAt(i,((char)b[i+index]));
        }
        return builder.toString();
    }
}
