package com.yinshu_api;


public class Scan {
    static String yinshu;

    public Scan(String yinshu) {
        Scan.yinshu = yinshu;
    }

    public long _Scan() {
        String str = yinshu;
        return stringToLong(str);

    }


    long stringToLong(String str) {
        long l = Long.parseLong(str);
        return l;
    }
}
