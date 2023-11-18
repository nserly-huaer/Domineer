package com.town;

import java.util.InputMismatchException;

import com.RunMainSoft.scan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Da {

    public static void demo() throws error {
        Logger logger = LogManager.getLogger(Da.class);
        try {
            System.err.println("-------------------如果是未知量，请写0（零）！！！-------------------\n");
            logger.info("如果是未知量，请写0（零）！！！");
            System.out.println("示例：q : w = e : r");
            logger.info("示例：q : w = e : r");
            System.out.println();

            System.out.print("请输入上述所示的q:\n");
            logger.info("请输入上述所示的q:");
            String str1 = scan.str();
            double u = Double.parseDouble(str1);
            logger.info("用户输入:" + u);

            System.out.print("请输入上述所示的w:\n");
            logger.info("请输入上述所示的w:");
            String str2 = scan.str();
            double i = Double.parseDouble(str2);
            logger.info("用户输入:" + i);

            System.out.print("请输入上述所示的e:\n");
            logger.info("请输入上述所示的e:");
            String str3 = scan.str();
            double o = Double.parseDouble(str3);
            logger.info("用户输入:" + o);

            System.out.print("请输入上述所示的r:\n");
            logger.info("请输入上述所示的r:");
            String str4 = scan.str();
            double p = Double.parseDouble(str4);
            logger.info("用户输入:" + p);

            There t = new There();
            try {
                t.Check(u, i, o, p);
            } catch (NoNullException e) {
                logger.error(e);
            }

//            a.close();
//            b.close();
//            c.close();
//            d.close();
        } catch (InputMismatchException e) {
            throw new error("Accessing Value has Error!");
        }

    }

}
