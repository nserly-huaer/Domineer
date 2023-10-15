package com.usetwoyinshu_api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.util.Scanner;

/**
 * 示例代码：可供程序员学习如何调用方法的示例
 */
public class ExampleClass {
    public static void Example() throws ZeroNumberException, OnlyOneNumberException {
        Logger logger = LogManager.getLogger(ExampleClass.class);
        //创建扫描器
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入要多少个因数");
        logger.info("请输入要多少个因数");
        //在控制台中获取需要多少因数
        int howMany = sc.nextInt();
        logger.info("用户输入:" + howMany);
        StringBuffer str = new StringBuffer();
        //从控制台中获取所有因数
        for (int i = 1; i < howMany + 1; i++) {
            System.out.println("请输入第" + i + "个自然数：");
            logger.info("请输入第" + i + "个自然数：");
            String d = new String(String.valueOf(sc.nextLong()));
            str = str.append(d);
            logger.info("用户输入:" + d);
            str = str.append("、");
        }
        //获取开始时间
        long begintime = System.currentTimeMillis();
        logger.info("开始时间:" + begintime);
        //进行整理StringBuffer类
        int len = str.length() - 1;
        str = str.deleteCharAt(len);
        //将StringBuffer对象换成long数组
        long[] l = ExampleClass.Run(howMany, str);
        StringBuffer sb = new StringBuffer();
        for (long i : l) {
            sb.append(i + "、");
        }
        sb = sb.deleteCharAt(sb.length() - 1);
        String sr = sb.toString();
        System.out.println("结果：公因数为：" + sr);
        logger.info("结果：公因数为：" + sr);

        //获取结束时间
        long endtime = System.currentTimeMillis();
        logger.info("结束时间:" + endtime);
        //获取差值，用于显示运行毫秒数
        System.out.println("总耗时：" + (endtime - begintime) + "ms");
        logger.info("总耗时：" + (endtime - begintime) + "ms");
        //关闭程序
        TwoThread.end();
    }

    public static long[] Run(int howMany, StringBuffer str) throws ZeroNumberException, OnlyOneNumberException {
        //创建对象实例化
        TwoThread tw = new TwoThread(howMany, str);

        //运行主程序
        tw.Run();
        //捕获异常

        //返回结果
        return TwoThread.result;
    }

}
