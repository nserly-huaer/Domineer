package com.YF;


import com.RunMainSoft.MainS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    static void Finally(long Starttime) {
        Logger logger = LogManager.getLogger(Main.class);
        long Endtime = System.currentTimeMillis();
        logger.info("结束时间：" + Endtime);
        long Charter = Endtime - Starttime;
        logger.info("计算毫秒值：" + Charter);
        System.out.println("\n" + "Done!                                      计算总耗时:" + Charter + "ms");
        logger.info("Done!计算总耗时:" + Charter + "ms");
        System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版权所有权、解释权：nserly(恩瑟莉)");
        logger.info("仅限个人使用，请勿用于商业用途！！！！版权所有权、解释权：nserly(恩瑟莉)");
    }

    public static void Run1() {

        try {
            Scan sc = new Scan();
            sc.scan();

        } catch (Exception e) {
            try {
                throw new error("Input Error");
            } catch (error e1) {
                MainS.centel(e1, true);
            }
        }
    }

    public static void main() {
        try {
            Run1();
        } catch (Exception e) {
            MainS.centel(e, true);
            try {
                Thread.sleep(500);
            } catch (Exception e1) {
                MainS.centel(e, true);
            }
        }

    }
}
