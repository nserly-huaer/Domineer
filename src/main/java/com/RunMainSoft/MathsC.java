package com.RunMainSoft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class MathsC {

    public static boolean Main() {
        Logger logger = LogManager.getLogger(MathsC.class);
        boolean dd = false;
        System.err.println("请继续输入(1.比例求比器;2.查看是否成比例;3.化简器;4.因数求解器;5.多数公因数求解器[beta])--输入back返回--");
        logger.info("1.比例求比器;2.查看是否成比例;3.化简器;4.因数求解器;5.多数公因数求解器[beta]");
        String str = scan.str();
        logger.info("用户输入：" + str);
        str = str.toLowerCase();
        if (str.equals("back")) {
            MainS.GotoMath = false;
            MainS.isGoing = true;
            dd = true;
            logger.info("用户控制：返回上一步");
            System.out.println();
            Default.d();
            return true;
        } else if (str.equals("$exit")) {
            System.out.println("已退出");
            logger.info("用户控制：关闭程序");
            logger.info("已退出");
            System.exit(1);
            return true;

        }
        int index = Integer.parseInt(str);
        switch (index) {
            case 1 -> dd = MainS.townd();//比例求比器
            case 2 -> dd = MainS.YFd();//查看是否成比例
            case 3 -> dd = MainS.castRund();//化简器
            case 4 -> dd = MainS.yin_shu();//因数求解器
            case 5 -> dd = MainS.usetwoyinshu();//多数公因数求解器[beta]
            default -> MainS.error();
        }


        return dd;
    }
}
