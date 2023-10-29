package com.Connect;

import com.RunMainSoft.MainS;
import com.RunMainSoft.scan;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.versiontext.Operator;

import java.io.File;

class Default {
    private static final Logger logger = LogManager.getLogger(Default.class);

    public static void main(String[] args) {
        System.out.println("                                  <输入$Exit退出>");
        // org.slf4j.Logger logger = org.slf4j.LoggerFactory.getLogger(Default.class);
        System.out.println("是否通过服务器来运行程序？(true是;false否)");
        logger.info("是否通过服务器来运行程序？(true是;false否)");
        String str = scan.str();
        logger.info("用户输入" + str.trim().toLowerCase());
        if (Boolean.parseBoolean(str.trim().toLowerCase())) {
            Connect();
        } else {
            offLine(args);
        }
    }

    private static void offLine(String[] args) {
        boolean runfast = false;
        if (args.length != 0) {
            args[0] = args[0].toLowerCase();
            runfast = Boolean.parseBoolean(args[0]);
            if (runfast) {
                while (true) {
                    d();
                    if (MainS.isGoing) {
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

    public static void Connect() {
        logger.info("用户同意使用服务器");
        System.out.println("请输入服务器IP地址");
        logger.info("请输入服务器IP地址");
        String ServerIP = scan.str();
        logger.info("用户输入：" + ServerIP);
        System.out.println("请输入服务器端口");
        logger.info("请输入服务器端口");
        int ServerPort = Integer.parseInt(scan.str().trim());
        logger.info("用户输入：" + ServerIP);
        CreateMainFile c = new CreateMainFile(new File("data\\Server"));
        c.Write(ServerIP, ServerPort);
        Here.RunSoft(ServerIP, ServerPort);
//            System.exit(1);
    }

    public static void d() {
        boolean dd = true;
        String SP1;
        System.err.println("-----------软件七合一(软件所有权归nserly所有，未经允许，禁止复制、摘用!)-----------");
        logger.info("-----------软件七合一(软件所有权：nserly;未经允许，禁止复制!)-----------");
//        System.out.println("-----------------------------输入$Exit退出-----------------------------");
//        logger.info("输入$Exit退出");
        if (MainS.GotoMath) {
            dd = MainS.Maths_C();
            return;
        } else if (MainS.GotoFileWatch) {
            dd = MainS.fileRund();
            return;
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
            System.exit(0);
//            System.exit(1);
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
        } else {
            try {
                MainS.isGoing = false;
                SP2 = Integer.valueOf(SP1);
                SP = SP2.intValue();
            } catch (Exception e) {
                MainS.centel(e, true);
                System.exit(2);
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
            System.exit(2);
        }
    }
}