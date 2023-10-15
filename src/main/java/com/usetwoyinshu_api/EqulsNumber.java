package com.usetwoyinshu_api;

import java.util.Random;

public class EqulsNumber implements Runnable {
    public static int t = 0;
    //临时比较缓存
    public static long[] cacheEquals;

    public static int a = 0;

    //运行成功返回true；否则返回false
    public boolean Equals() {
        int a = TwoThread.times;
        Thread t1 = new Thread(this, "third");
        Thread t2 = new Thread(this, "forth");
        Random r = new Random(2);
        this.a--;
//        a--;
        while (a > 0) {
            if (r.nextInt(2) == 1) {
                t1.run();
            } else {
                t2.run();
            }
            a--;
        }
        return true;

    }

    @Override
    public void run() {
//        synchronized (this) {
        if (t == 0) {
            cacheEquals = Main.resold2(TwoThread.result1[a], TwoThread.result1[--a]);
        } else {
            if (a > 0)
                cacheEquals = Main.resold2(TwoThread.result1[--a], cacheEquals);
        }

        t++;
        //        }
    }
}
