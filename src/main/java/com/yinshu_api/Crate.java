package com.yinshu_api;

public class Crate {
    public static long endtime;
    public static String result = "";//求数的因数

    static String run(long l) {
        result="";
        boolean r = false;
        int i1 = 0;
        for (int i = 1; i <= l; i++) {
            r = (l % i == 0);
            if (r) {
                i1++;
                result += i + "、";
            }
        }
        if (i1 == 0) {
            result += "、";
        }
        StringBuilder str1 = new StringBuilder(result);
        int len = str1.length() - 1;
        str1 = str1.deleteCharAt(len);
        endtime = System.currentTimeMillis();
        return str1.toString();
    }


}
