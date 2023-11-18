package com.usetwoyinshu_api;

//导入包

import java.util.Random;

import com.usetwoyinshu_api.StringTolong;
import com.yinshu_api.Main;

/**
 * 此软件将用到2至4个线程
 */
public class TwoThread implements Runnable {
    //多少因数
    private static int howMany;
    //每个因数（用中文下"、"隔开），类型为StringBuffer对象
    private static StringBuffer str;
    //运行结果，用于返回最后运算结果
    public static long[] result;
    //所需公因数，用于运行，此数为数组类型的long值
    private static long[] number;
    //运行次数
    public static int times = 0;
    //用于返回result数组
    public static long[][] result1;

    //如果此处执行成功，则返回true；否则返回false
    public boolean Run() throws ZeroNumberException, OnlyOneNumberException {
        number = new long[howMany];
        result1 = new long[howMany][];
        if (howMany < 1) {
            throw new ZeroNumberException("No any Number");
        } else if (howMany == 1) {
            throw new OnlyOneNumberException("Number size is one");
        }

        number = com.usetwoyinshu_api.Main.Slip(str);
        Thread first = new Thread(this, "first");
        Thread second = new Thread(this, "second");
        first.run();
        Random r = new Random(2);
        for (; ; ) {
            if (times >= howMany)
                break;
            if (r.nextInt(2) == 1) {
                first.run();
            } else {
                second.run();
            }

        }
        EqulsNumber eq = new EqulsNumber();
        EqulsNumber.a = TwoThread.times;
        eq.Equals();
        result = EqulsNumber.cacheEquals;
        return true;
    }

    public static void end() {
        howMany = 0;
        str = null;
        result = null;
        number = null;
        times = 0;
        result1 = null;
        EqulsNumber.t = 0;
        EqulsNumber.cacheEquals = null;
        EqulsNumber.a = 0;
    }

    @Override
    public void run() {
        Main m = new Main();
        if (!(times >= howMany)) {
            m.run_Main(String.valueOf(number[times]));
            String a = com.yinshu_api.Main.result;
            long[] l = StringTolong.Cast(a);
            TwoThread.result1[times] = l;
            times++;
        }


    }

    public long[] Slip(StringBuffer str) {
        String str1 = str.toString();
        String[] str2 = str1.split("、");
        long[] l = new long[str2.length];
        for (int i = 0; i < str2.length; i++) {
            l[i] = Long.parseLong(str2[i]);
        }
        return l;
    }

    public TwoThread(int howMany, StringBuffer str) {
        TwoThread.howMany = howMany;
        TwoThread.str = str;
    }
}
