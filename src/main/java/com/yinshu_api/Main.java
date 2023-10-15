package com.yinshu_api;

/**
 * 此类中的成员方法说明：
 * usetime为处理时长（单位为“ms”）
 * result用于返回因数，类型为String
 * 可以直接使用结果（不用result全局变量）
 */
public class Main {
    public static String result = "";
    public static long usetime;

    public String run_Main(String yinshu) {
        Scan s = new Scan(yinshu);
        long l = s._Scan();
        long begintime = System.currentTimeMillis();
        result = Crate.run(l);
        long endtime = Crate.endtime;
        long charter = endtime - begintime;
        usetime = charter;
        return result;
    }
}
