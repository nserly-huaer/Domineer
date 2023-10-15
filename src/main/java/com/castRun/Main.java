package com.castRun;

import com.RunMainSoft.scan;
import com.RunMainSoft.MainS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    // 被除数
    public static double bcs;
    // 除数
    public static double cs;
    // 时间差，用来记录用时时长
    public static long chartertime;
    // 乘以个数，数字越大支持越大小数，同时计算速度将减少
    static long charter = 10000000000L;

    public void runfirst() {
        Logger logger = LogManager.getLogger(Main.class);
        Main m = new Main();
        boolean sc = m.scan();
        if (sc) {
            long begintime = System.currentTimeMillis();
            logger.info("获取开始时间:" + begintime);
            try {
                logger.info("运行-转换器");
                m.cast(Main.bcs, Main.cs, begintime);
            } catch (ZeroException e) {
                logger.error(e);
            }
        } else {
            try {
                throw new ZeroException(1, "Number has Zero!");
            } catch (ZeroException e) {
                logger.error(e);
            }
        }
    }

    public boolean scan() {
        Logger logger = LogManager.getLogger(Main.class);
        System.out.println("请输入被除数");
        logger.info("请输入被除数");
        double bcs = Double.parseDouble(scan.str());// 被除数
        logger.info("用户输入:" + bcs);
        System.out.println("请输入除数");
        logger.info("请输入除数");
        double cs = Double.parseDouble(scan.str());// 除数
        logger.info("用户输入:" + cs);
        Main.bcs = bcs;
        Main.cs = cs;
        if (cs != 0) {
            return true;
        } else {
            return false;
        }
    }

    public void cast(double bcs, double cs, long begintime) throws ZeroException {
        Logger logger = LogManager.getLogger(Main.class);
        double bcs123 = bcs * Main.charter;
        double cs123 = cs * Main.charter;
        Main m = new Main();
        logger.info("运行-转最简比例器");
        if (!m.Calaurtor((long) bcs123, (long) cs123, begintime)) {
            throw new ZeroException(2,"Casted Number Error!");
        }
    }

    public boolean Calaurtor(long bcs123, long cs123, long begintime) {// 转换最简比例
        Logger logger = LogManager.getLogger(Main.class);
        // 质数，越多准确性越大，但同时计算量也将越大
//        int think[] = {2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89,
//                97};
        try {
            a:
            for (int i = 2; i <= MAX.min(bcs123, cs123); i++) {
                b:
                for (; ; ) {
                    if (bcs123 == cs123) {
                        bcs123 = 1;
                        cs123 = 1;
                        break a;
                    } else if ((bcs123 % i == 0) && (cs123 % i == 0)) {
                        bcs123 = bcs123 / i;//
                        cs123 = cs123 / i;//
                    } else {
                        break b;
                    }
                }
            }
        } catch (Exception e) {
            MainS.centel(e, false);
            return false;
        }
        Main.bcs = bcs123;
        Main.cs = cs123;
        long endtime = System.currentTimeMillis();
        logger.info("结束时间:" + endtime);
        long chartertime = endtime - begintime;
        logger.info("毫秒值：" + chartertime);
        Main.chartertime = chartertime;
        return true;
    }
}
