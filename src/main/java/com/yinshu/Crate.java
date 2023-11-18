package com.yinshu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Crate {
    public static long endtime;

    static String run(long l, long begintime) {
        Logger logger = LogManager.getLogger(Crate.class);
        boolean r = false;
        StringBuffer result = new StringBuffer();
        int i1 = 0;
        for (int i = 1; i <= l; i++) {
            if (i <= 0) {
                logger.warn("此运算可能出现问题！");
                break;
            }
            r = (l % i == 0);
            if (r) {
                i1++;
                result = result.append(i + "、");
            }
        }
        int len = result.length() - 1;
        result = result.deleteCharAt(len);
        long endtime = System.currentTimeMillis();
        logger.info("结束时间：" + endtime);
        Crate.endtime = endtime;
        String sa = "";
        sa += l + "的因数为(" + i1 + "个)：" + result;
        return sa;
    }


}
