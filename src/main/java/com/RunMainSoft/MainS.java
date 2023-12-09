package com.RunMainSoft;

import java.text.MessageFormat;

import com.OpenSoftware.Start;
import com.usetwoyinshu_api.ExampleClass;
import com.usetwoyinshu_api.OnlyOneNumberException;
import com.usetwoyinshu_api.ZeroNumberException;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import com.castRun.Main;
import com.fileRun.Read;
import com.fileRun.CannotFindException;

public class MainS {
    public static boolean isGoing;
    public static boolean GotoMath;
    public static boolean GotoFileWatch;

    public static boolean usetwoyinshu() {
        Logger logger = LogManager.getLogger(Default.class);
        logger.info("用户控制：运行-多数公因数求解器");
//        System.out.println("-------------------声明：此程序处于测试阶段，有误差（误差不大），预计于2023/10/2正式发布-------------------");
        try {
            ExampleClass.Example();

        } catch (ZeroNumberException e) {
            centel(e, true);
            return false;
        } catch (OnlyOneNumberException e) {
            centel(e, true);
            return false;
        }

        return true;
    }

    public static boolean Maths_C() {
        Logger logger = LogManager.getLogger(Default.class);
        boolean result = false;
        try {
            GotoMath = true;
            GotoFileWatch = false;
            logger.info("用户控制：运行-数学工具");
            result = MathsC.Main();
        } catch (Exception e) {
            centel(e, true);
            return false;
        }
        return result;
    }

    public static boolean townd() {
        Logger logger = LogManager.getLogger(Default.class);
        try {
            logger.info("用户控制：运行-比例求比器");
            com.town.loser.main();
        } catch (Exception e) {
            centel(e, true);
            return false;
        }
        return true;
    }

    public static boolean YFd() {
        Logger logger = LogManager.getLogger(Default.class);
        try {
            logger.info("用户控制：运行-查看是否成比例");
            com.YF.Main.main();
        } catch (Exception e) {
            centel(e, true);

            return false;
        }
        return true;
    }

    public static boolean gamed() {
        Logger logger = LogManager.getLogger(Default.class);
        try {
            logger.info("用户控制：运行-猜数字”");
            com.game.Main.main();
        } catch (Exception e) {
            centel(e, true);
            return false;
        }
        return true;
    }

    public static boolean fileRund() {
        Logger logger = LogManager.getLogger(Default.class);
        Read r = new Read();
        int SP = 0;
        try {
            logger.info("用户控制：运行-文件管理");
            System.err.println("请继续输入;1.读取文件内容;2.写入文件内容;3.查看文件属性;4.软件快速开 =-=输入back返回=-=");
            logger.info("软件：1.读取文件内容;2.写入文件内容;3.查看文件属性;4.软件快速开");
            GotoMath = false;
            GotoFileWatch = true;
            String ST1 = scan.str();
            logger.info("用户输入：" + ST1);
            if (ST1.trim().equals("4")) {
                Start st = new Start();
                st.RunSoftware();
                return true;
            }
            ST1 = ST1.toLowerCase();
            if (ST1.equals("back")) {
                GotoFileWatch = false;
                isGoing = true;
                logger.info("用户控制：返回上一步");
                System.out.println();
                Default.d();
                return true;
            } else if (ST1.equals("$exit")) {
                System.out.println("已退出");
                logger.info("用户控制：关闭程序");
                logger.info("已退出");
                System.exit(1);
                return true;
            }
            @SuppressWarnings("removal") Integer in = Integer.valueOf(ST1);
            int ST = in.intValue();
            System.out.println("请输入文件路径");
            logger.info("控制台提示：请输入文件路径");
            String str = scan.str();
            String str2 = str.trim();
            logger.info("文件路径为：" + str2);
            if (!(str2.endsWith("\"") && str2.startsWith("\""))) {
                logger.warn("未在路径首尾加\"，可能出现异常!");
            }
            String str1 = str2.replace("\"", "");
            r.Start(ST, str1, 1);
        } catch (Exception e) {
            centel(e, true);
            return false;
        }
//        s1.close();
        return true;
    }

    public static boolean castRund() {
        Logger logger = LogManager.getLogger(Default.class);
        try {
            logger.info("用户控制：运行-简化器");
            com.castRun.Main cm = new com.castRun.Main();
//            System.out.println("-------------------免费声明：此程序处于测试阶段，有误差（误差不大），预计于2023/8/1正式发布-------------------");
            cm.runfirst();
            String end = "------------------------------结果： " + (long) Main.bcs + ":" + (long) Main.cs + "------------------------------";
            System.out.println(end);
            logger.info("结果：" + (long) Main.bcs + ":" + (long) Main.cs);
            System.err.println("\n\n" + "Done!                                            运行总耗时:" + Main.chartertime + "ms");
            logger.info("Done!运行总耗时:" + Main.chartertime + "ms");
            System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
            logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
        } catch (Exception e) {
            centel(e, true);
            return false;
        }
        return true;

    }

    public static void error() {
        try {
            throw new CannotFindException(1, "It's not right list!");
        } catch (Exception e) {
            centel(e, true);
        }
    }

    public static void centel(Exception e, boolean isInputIntoConsole) {
        StringBuilder sbException = new StringBuilder();
        for (StackTraceElement ele : e.getStackTrace()) {
            sbException.append(MessageFormat.format("\tat {0}.{1}({2}:{3})\n", ele.getClassName(), ele.getMethodName(), ele.getFileName(), ele.getLineNumber()));
        }


        com.util.Main l = new com.util.Main();
        l.Wrin(e.getClass().getName() + ": " + e.getMessage(), sbException);
        if (isInputIntoConsole) {
            System.out.println(e.getClass().getName() + ": " + e.getMessage());
            System.out.println(sbException);
        }
    }

    public static boolean yin_shu() {
        Logger logger = LogManager.getLogger(Default.class);
        try {
//            System.out.println("-------------------声明：此程序处于测试阶段，可能出现问题，预计于2023/9/5正式发布-------------------");
            logger.info("用户控制：运行-因数求解器”");
            com.yinshu.Main m = new com.yinshu.Main();
            m.run_Main();
        } catch (Exception e) {
            centel(e, true);
            return false;
        }
        return true;
    }
}
