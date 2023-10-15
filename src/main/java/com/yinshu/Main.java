package com.yinshu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    public void run_Main() {
        Logger logger = LogManager.getLogger(Main.class);
        Scan s = new Scan();
        logger.info("运行-扫描器");
        long l = s._Scan();
        long begintime = System.currentTimeMillis();
        logger.info("开始时间：" + begintime);
        String cfd = Crate.run(l, begintime);
        System.out.println("结果：" + cfd);
        logger.info("结果:" + cfd);
        long endtime = Crate.endtime;
        long charter = endtime - begintime;
        logger.info("计算毫秒值：" + charter);
        System.err.println("\n" + "Done!                                            运行总耗时:" + charter + "ms");
        logger.info("Done!运行总耗时:" + charter + "ms");

        System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
        logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
    }
}
