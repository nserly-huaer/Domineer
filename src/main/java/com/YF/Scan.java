package com.YF;

import java.util.Scanner;

import com.RunMainSoft.scan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Scan {
    void scan() {
        Logger logger = LogManager.getLogger(Scan.class);
        System.err.println("示例：第一行的1、2，第二行的3、4");
        logger.info("示例：第一行的1、2，第二行的3、4");

        Scanner a = new Scanner(System.in);
        System.out.print("请输入第一行第一个值(1)：");
        logger.info("请输入第一行第一个值(1)：");
        String str1 = scan.str();
        double q = Double.parseDouble(str1);
        logger.info("用户输入:" + q);

        Scanner b = new Scanner(System.in);
        System.out.print("请输入第一行第二个值(2)：");
        logger.info("请输入第一行第二个值(2)：");
        String str2 = scan.str();
        double w = Double.parseDouble(str2);
        logger.info("用户输入:" + w);

        Scanner c = new Scanner(System.in);
        System.out.print("请输入第二行第一个值(3)：");
        logger.info("请输入第二行第一个值(3)：");
        String str3 = scan.str();
        double e = Double.parseDouble(str3);
        logger.info("用户输入:" + e);

        Scanner d = new Scanner(System.in);
        System.out.print("请输入第二行第二个值(4)：");
        logger.info("请输入第二行第二个值(4)：");
        String str4 = scan.str();
        double r = Double.parseDouble(str4);
        logger.info("用户输入:" + r);

        Scan s = new Scan();
        long Starttime = System.currentTimeMillis();
        logger.info("开始时间：" + Starttime);
        s.Try(q, w, e, r, Starttime);
//        a.close();
//        b.close();
//        c.close();
//        d.close();
    }

    void Try(double q, double w, double e, double r, long Starttime) {
        Logger logger = LogManager.getLogger(Scan.class);
        if (Starttime == 0) {
            logger.error("时间获取失败，请与系统管理员联系");
        }
        double qq1 = q * r;
        double qq2 = w * e;
        double er = q * w;
        double err = e * r;

        boolean b1 = er == err;//反比例
        boolean b2 = qq1 == qq2;//正比例
        boolean bv = (qq1 == qq2) && (er == err);//反比例、正比例

        if (bv) {
            System.out.println("结果：成正比例、反比例！");
            logger.info("结果：成正比例、反比例！");
        } else if (b2) {
            System.out.println("结果：成正比例！");
            logger.info("结果：成正比例！");

        } else if (b1) {
            System.out.println("结果：成反比例！");
            logger.info("结果：成反比例！");
        } else {
            System.out.println("结果：不成比例！");
            logger.info("结果：不成比例！");
        }
        Main.Finally(Starttime);
    }
}
