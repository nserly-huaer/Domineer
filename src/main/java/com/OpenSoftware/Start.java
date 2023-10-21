package com.OpenSoftware;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Scanner;

public class Start {
    static Logger logger = LogManager.getLogger(Start.class);

    public void RunSoftware() {
        System.out.println("---------------------------软件自动打开(beta-3.72)---------------------------");
        Scanner sc = new Scanner(System.in);
        final Runtime runtime = Runtime.getRuntime();
        Process process = null;

        String[] openPath = null;
        Reader r = null;
        boolean isOpen = false;
        if (Reader.Cache.length() != 0) {
            System.out.println("请输入是否沿用上次打开方法(true;false)");
            isOpen = sc.nextBoolean();
        }

        if (isOpen) {
            System.out.println("Loading...\n------------------------------------------------");

            logger.info("Loading...");
            r = new Reader(new File(""));
            openPath = r.Read();
        } else {
            r = new Reader(new File(""));
            r.CleanData();
            System.out.println("请输入文件路径($<返回)");
            for (; ; ) {
                String str = sc.nextLine();
                str = str.trim();
                if (str.endsWith("\"") && str.startsWith("\"")) {
                    str = str.replace("\"", "");
                }
                if (str.equals("$<"))
                    break;
                r.Write(str);
            }
            openPath = r.Read();
        }
        long beginTime = System.currentTimeMillis();
        boolean exception = false;
        try {
//            for (int i = 0; i < openPath.length; i++) {
//                if (openPath[i].isEmpty())
//                    continue;
//                String cmd = openPath[i];
//                ProcessBuilder processBuilder = new ProcessBuilder("cmd", "/c", "start", "notepad.exe", cmd);
//                process = processBuilder.start();
//            }


            for (int i = 0; i < openPath.length; i++) {
                if (openPath[i].isEmpty())
                    continue;
                String filePath = openPath[i];
                File file = new File(filePath);
                if (file.exists()) {
                    try {
                        Desktop.getDesktop().open(file);
                        System.out.println("正在打开:" + filePath);
                        logger.info("正在打开:" + "filePath");
                    } catch (IOException e) {
                        logger.error(e);
                    }
                } else {
                    logger.error("打开失败，文件不存在!");
                }
            }


        } catch (final Exception e) {
            exception = true;
            logger.error(e);
        } finally {
            if (exception) {
                logger.error("运行失败，请与管理员联系~");
            } else {
                double charter = System.currentTimeMillis() - beginTime;
                BigDecimal bd = null;
                boolean b = false;
                if (charter >= 1000) {
                    b = true;
                    bd = new BigDecimal(charter);
                    bd = bd.divide(new BigDecimal(1000), 2, RoundingMode.HALF_UP);
                }
                if (b) {
                    System.out.println("------------------------------------------------\n运行完毕！(总耗时" + bd.toString() + "s)");
                    logger.info("运行完毕！(总耗时：" + charter + "s)");
                } else {
                    System.out.println("------------------------------------------------\n运行完毕！(总耗时" + (long) charter + "ms)");
                    logger.info("运行完毕！(总耗时：" + (long) charter + "ms)");
                }
            }
        }
    }
}


