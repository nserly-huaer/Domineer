package com.yinshu;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.RunMainSoft.scan;

public class Scan {
    public long _Scan() {
        Logger logger = LogManager.getLogger(Scan.class);
        String str = str();
        return stringToLong(str);

    }

    String str() {
        String str = null;
        Logger logger = LogManager.getLogger(Scan.class);
        System.out.println("请输入某个因数");
        str = scan.str();
        logger.info("请输入某个因数:" + str);
        return str;
    }

    long stringToLong(String str) {
        long l = Long.parseLong(str);
        return l;
    }
}
