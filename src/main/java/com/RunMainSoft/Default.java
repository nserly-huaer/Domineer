package com.RunMainSoft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.versiontext.Operator;

class Default {
    public static boolean end;

    public static void main(String[] args) {

        System.err.println("                                  <输入$Exit退出>");
        // org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Default.class);
        boolean runfast = false;
        if (args.length != 0) {
            args[0] = args[0].toLowerCase();
            runfast = Boolean.parseBoolean(args[0]);
            if (runfast) {
                while (true) {
                    boolean ad = d();
                    if (!ad) {
                        break;
                    } else if (MainS.isGoing) {
                        break;
                    } else if (end) {
                        break;
                    }

                    System.err.println("\n\n\n\n\n\n");
                }
            } else {
                d();
            }
        } else {
            d();
        }
    }

    public static boolean d() {
        boolean dd = false;
        Logger logger = LogManager.getLogger(Default.class);
        String SP1;
        System.err.println("-----------软件七合一(软件所有权归nserly所有，未经允许，禁止复制、摘用!)-----------");
        logger.info("-----------软件七合一(软件所有权：nserly;未经允许，禁止复制!)-----------");
//        System.out.println("-----------------------------输入$Exit退出-----------------------------");
//        logger.info("输入$Exit退出");
        if (MainS.GotoMath) {
            dd = MainS.Maths_C();
            return true;
        } else if (MainS.GotoFileWatch) {
            dd = MainS.fileRund();
            return true;
        }
        System.err.println("请输入你要运行的软件(1.数学工具;2.文件管理;3.猜数字（游戏）)");
        logger.info("软件：1.数学工具;2.文件管理;3.猜数字");
        SP1 = scan.str();
        int SP = 0;
        Integer SP2 = null;
        SP1 = SP1.toLowerCase();
        logger.info("用户输入：" + SP1);
        if (SP1.equals("$exit")) {
            logger.info("用户控制：关闭程序");
            System.out.println("已退出");
            logger.info("已退出");
            return false;
        } else if (SP1.equals("version")) {
            logger.info("用户控制：读取版本号");
            Operator op = new Operator();
            String[] version = op.version();
//            System.out.println(version);
            for (String s : version) {
                System.out.println(s);
            }
            try {
                Thread.sleep(5);
            } catch (InterruptedException e) {
                MainS.centel(e, true);
            }
            return true;
        } else {
            try {
                MainS.isGoing = false;
                SP2 = Integer.valueOf(SP1);
                SP = SP2.intValue();
            } catch (Exception e) {
                MainS.centel(e, true);
                return true;
            }

            //switch表达式
            switch (SP) {
                case 1 -> dd = MainS.Maths_C();
                case 2 -> dd = MainS.fileRund();
                case 3 -> dd = MainS.gamed();
                default -> MainS.error();

            }

        }
        if (!dd) {
            logger.error("运行中触发异常，请与开发者联系！");
            return false;
        }
        return true;
    }
}