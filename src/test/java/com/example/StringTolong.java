package com.example;

public class StringTolong {
    public static long[] Cast(String CastString) {
        String[] str = CastString.split("、");
        long[] l = new long[str.length];
        for (int i = 0; i < str.length; i++) {
            l[i] = Long.parseLong(str[i]);
        }
        return l;
    }
}
