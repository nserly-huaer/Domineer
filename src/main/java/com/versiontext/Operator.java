package com.versiontext;

import com.RunMainSoft.MainS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Operator {
    private final String version = "9.5.26";
    Logger logger = LogManager.getLogger(Operator.class);

    public String[] version() {
        logger.info("检查版本号...");
        try {
            Thread.sleep(15);
        } catch (InterruptedException e) {
            MainS.centel(e, true);
        }
        String list = "软件版本:" + version;
        logger.info(list);
        String log4jVersion = "Log4j版本:" + org.apache.logging.log4j.util.PropertiesUtil.class.getPackage().getImplementationVersion();
        logger.info(log4jVersion);
        String[] str = {list, log4jVersion};
        return str;


    }

}
