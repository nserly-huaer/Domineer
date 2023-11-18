package com.town;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Finally {
    void finallyt() {
        Logger logger = LogManager.getLogger(Finally.class);
        long starttime = There.StartTime;
        logger.info("开始时间" + starttime);
        long endtime = System.currentTimeMillis();
        logger.info("结束时间" + endtime);
        long charter = endtime - starttime;
        logger.info("计算毫秒值：" + charter);
        if (charter > 999) {
            charter = 999;
            System.err.println("\n" + "Done!                          计算总耗时:" + charter + "ms（已超标，可能存在异常！）");
            logger.info("Done!计算总耗时:" + charter + "ms（已超标，可能存在异常！）");
        } else {
            System.err.println("\n" + "Done!                                            计算总耗时:" + charter + "ms");
            logger.info("Done!计算总耗时:" + charter + "ms");
        }

        System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
        logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
    }
}
