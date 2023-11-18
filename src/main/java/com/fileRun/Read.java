package com.fileRun;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import com.RunMainSoft.scan;
import Log4j2Pro.Main;
import com.RunMainSoft.MainS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Read {
    public static String version;

    public void Start(int set, String filepath, int a) throws Danger, CannotFindException, BooleanException {
        Logger logger = LogManager.getLogger(Read.class);
        long begintime = System.currentTimeMillis();
        logger.info("开始时间：" + begintime);
        if (set == 1 && a == 1) {
            Read r = new Read();
            if (!r.read(filepath, begintime)) {
                System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
                logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
                throw new Danger("Cannot access File or Path!");
            } else {
                System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
                logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
            }
        } else if (set == 2) {
            Read r = new Read();
            System.out.println("是否保留原文件内容？（t是;f否）");
            logger.info("是否保留原文件内容？（t是;f否）");
            String isRemWrite1 = scan.str();
            logger.info("用户输入:" + isRemWrite1);

            isRemWrite1 = isRemWrite1.toLowerCase();
            boolean isRemWrite = false;
            boolean isnextY = false;
            String jea = "";
            if (isRemWrite1.equals("t")) {
                isRemWrite = true;
                System.out.println("是否换行？（t是;f否）");
                logger.info("是否换行？");
                String da = scan.str();
                logger.info("用户输入:" + da);
                da = da.toLowerCase();
                if (da.equals("t")) {
                    isnextY = true;
                } else if (da.equals("f")) {
                    isnextY = false;
                } else {
                    throw new BooleanException("Input Number has Error!");
                }
            } else if (isRemWrite1.equals("f")) {
                isRemWrite = false;

            } else {
                throw new BooleanException("Input Number has Error!");
            }
            System.out.println("请输入文件内容");
            logger.info("请输入文件内容：");
            jea = scan.str();
            logger.info("用户输入:" + jea);
            long begintime1 = System.currentTimeMillis();
            logger.info("开始时间" + begintime1);
            if (!r.write(filepath, jea, begintime1, isRemWrite, isnextY)) {
                throw new Danger("Cannot access File or Path!");
            } else {
                System.out.println("写入成功！");
                logger.info("写入完成！");
            }
            System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
            logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
        } else if (set == 3) {
            Read r = new Read();
            r.search(filepath, begintime);
            System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
            logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
        } else if (a == 0) {
            Read r = new Read();
            r.read(filepath, a);
        } else {
            System.err.println("\n仅限个人使用，请勿用于商业用途！！！！\n版本所有权、解释权:nserly(恩瑟莉)");
            logger.info("仅限个人使用，请勿用于商业用途！！！！版本所有权、解释权:nserly(恩瑟莉)");
            throw new CannotFindException(0, "It's not right list!");
        }

    }

    public String cast(long l) {
        Logger logger = LogManager.getLogger(Read.class);
        int i = 0;
        if (l >= 1024) {// KB
            i++;
            l = l / 1024;
            if (l >= 1024) {// MB
                i++;
                l = l / 1024;
                if (l >= 1024) {// GB
                    i++;
                    l = l / 1024;
                    if (l >= 1024) {// TB
                        i++;
                        l = l / 1024;
                        if (l >= 1024) {// PB
                            i++;
                            l = l / 1024;
                            if (l >= 1024) {// EB
                                i++;
                                l = l / 1024;
                                if (l >= 1024) {// ZB
                                    i++;
                                    l = l / 1024;
                                    if (l >= 1024) {// YB
                                        i++;
                                        l = l / 1024;

                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
        if (i == 1) {
            logger.info("转换成功：" + l + "KB");
            return l + "KB";
        } else if (i == 2) {
            logger.info("转换成功：" + l + "MB");
            return l + "MB";
        } else if (i == 3) {
            logger.info("转换成功：" + l + "GB");
            return l + "GB";
        } else if (i == 4) {
            logger.info("转换成功：" + l + "TB");
            return l + "TB";
        } else if (i == 5) {
            logger.info("转换成功：" + l + "PB");
            return l + "PB";
        } else if (i == 6) {
            logger.info("转换成功：" + l + "EB");
            return l + "EB";
        } else if (i == 7) {
            logger.info("转换成功：" + l + "ZB");
            return l + "ZB";
        } else if (i == 8) {
            logger.info("转换成功：" + l + "YB");
            return l + "YB";
        }
        logger.info("转换成功：" + l + "B");
        return l + "B";
    }

    public void search(String filepath, long begintime) {
        Logger logger = LogManager.getLogger(Read.class);
        File f = new File(filepath);
        System.out.println("文件绝对路径：" + "\"" + f.getAbsolutePath() + "\"");
        logger.info("文件绝对路径：" + "\"" + f.getAbsolutePath() + "\"");
        System.out.println("文件名：" + f.getName());
        logger.info("文件名：" + f.getName());
        System.out.println("文件是否存在：" + f.exists());
        logger.info("文件是否存在：" + f.exists());
        long ti = f.lastModified();
        Date date = new Date(ti);
        String strDateFormat = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat sdf = new SimpleDateFormat(strDateFormat);
        if (f.exists()) {
            System.out.println("文件是否被隐藏：" + f.isHidden());
            logger.info("文件是否被隐藏：" + f.isHidden());
            System.out.println("文件是否可读：" + f.canRead());
            logger.info("文件是否可读：" + f.canRead());
            System.out.println("文件是否可写：" + f.canWrite());
            logger.info("文件是否可写：" + f.canWrite());
            long l = f.length();
            Read r = new Read();
            String str = "文件大小：" + r.cast(l);
            System.out.println(str);
            logger.info(str);
            System.out.println("文件最后修改时间：" + sdf.format(date));
            logger.info("文件最后修改时间：" + sdf.format(date));
        } else {
            logger.error("文件信息读取失败，请检查文件是否可以访问且存在此文件!");
        }
        long endtime = System.currentTimeMillis();
        long charter = endtime - begintime;
        System.err.println("\n" + "Done!                                            运行总耗时:" + charter + "ms");
        logger.info("Done!运行总耗时:" + charter + "ms");

    }

    public boolean read(String filepath, long begintime) {
        Logger logger = LogManager.getLogger(Read.class);
        File f = new File(filepath);
        FileInputStream f1 = null;
        BufferedInputStream bu = null;
        try {
            if (f.exists()) {

                f1 = new FileInputStream(f);
                bu = new BufferedInputStream(f1);
                byte[] b = new byte[102400];// 缓存区
                int length = bu.read(b);
                logger.info("文件长度(Byte数组)" + length);
                if (begintime != 0) {
                    System.out.print("--------------------------[文件内容]--------------------------\n" + new String(b, 0, length));
                    System.out.println("\n--------------------------------------------------------------\n");
                    String str = "--------------------------[文件内容]--------------------------\n" + new String(b, 0, length);
                    String str1 = str + "\n--------------------------------------------------------------\n";
                    Main.filecun(str1);
                    long endtime = System.currentTimeMillis();
                    long charter = endtime - begintime;
                    System.err.println("\n\n" + "Done!                                            运行总耗时:" + charter + "ms");
                    logger.info("Done!运行总耗时:" + charter + "ms");
                } else {
                    Read.version = new String(b, 0, length);
                }

            } else {
                logger.error("文件信息读取失败，请检查文件是否可以访问且存在此文件!");
            }
        } catch (IOException e) {
            MainS.centel(e, false);
            return false;
        } finally {

            if (bu != null) {
                try {
                    bu.close();
                    logger.info("已关闭bu对象");
                } catch (IOException e) {
                    MainS.centel(e, false);
                    return false;
                }
            }
            if (f1 != null) {
                try {
                    f1.close();
                    logger.info("已关闭f1对象");
                } catch (IOException e) {
                    MainS.centel(e, true);
                    return false;
                }
            }

        }
        return true;
    }

    public boolean write(String filepath, String jea, long begintime, boolean isRemWrite, boolean nextY) {
        Logger logger = LogManager.getLogger(Read.class);
        File f = new File(filepath);
        FileOutputStream f1 = null;
        BufferedOutputStream bu = null;

        try {
            f1 = new FileOutputStream(f, isRemWrite);
            bu = new BufferedOutputStream(f1);
            if (nextY) {
                String huanhang = System.getProperty("line.separator");
                logger.info("换行输入");
                bu.write(huanhang.getBytes());
                bu.flush();
                logger.info("已写入换行符");
            }
            String str = ("---------------------------文件写入内容---------------------------\n" + jea);
            str += "\n----------------------------------------------------------------\n";
            Main.filecun(str);
            bu.write(jea.getBytes(), 0, jea.getBytes().length);
            bu.flush();
            logger.info("已导出文件内容");
        } catch (IOException e) {
            MainS.centel(e, true);
            return false;
        } finally {
            if (bu != null) {
                try {
                    bu.close();
                    logger.info("已关闭bu对象");
                } catch (IOException e) {
                    MainS.centel(e, false);
                }
            }
            if (f1 != null) {
                try {
                    f1.close();
                    logger.info("已关闭f1对象");
                } catch (IOException e) {
                    MainS.centel(e, false);
                }
                long endtime = System.currentTimeMillis();
                long charter = endtime - begintime;
                System.err.println("\n\n" + "Done!                                            运行总耗时:" + charter + "ms");
                logger.info("Done!运行总耗时:" + charter + "ms");
            }

        }

        return true;
    }
}
