package com.OpenSoftware;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class Reader {
    File f = null;
    static Logger logger = LogManager.getLogger(Reader.class);
    static final File Cache = new File("data/RunSoftPath.json");

    public void CleanData() {
        try {
            // 创建RandomAccessFile对象，以读写模式打开文件
            RandomAccessFile file = new RandomAccessFile(Cache, "rw");
            // 将文件指针移动到文件开头
            file.seek(0);

            // 清除文件中的数据
            file.setLength(0);

            // 关闭文件
            file.close();
        } catch (IOException e) {
            logger.info("清除缓存失败，请与管理员联系~");
        }
    }

    public Reader(File f) {
        this.f = f;

        if (!new File("data").exists()) {
            new File("data").mkdir();
        }
        if (!Cache.exists()) {
            try {
                Cache.createNewFile();
            } catch (IOException e) {
                logger.error("文件创建失败，请与管理员联系！");
            }
        }
    }

    public String[] Read() {
        FileInputStream f1 = null;
        BufferedInputStream bu = null;
        String[] result = null;
        try {
            f1 = new FileInputStream(Cache);
            bu = new BufferedInputStream(f1);
            byte[] b = new byte[102400];//缓冲区
            int index = bu.read(b);
            String str = new String(b, 0, index);
            result = str.split("\\|");

        } catch (IOException e) {
            logger.error("文件读取失败，请与管理员联系！");
        } finally {
            if (bu != null) {
                try {
                    bu.close();
                } catch (IOException e) {
                    logger.error("对象关闭失败，请与开发者联系~");
                }
            }
            if (f1 != null) {
                try {
                    f1.close();
                } catch (IOException e) {
                    logger.error("对象关闭失败，请与开发者联系~");
                }
            }
        }
        if (result != null) {
            for (int i = 0; i < result.length; i++) {
                result[i] = result[i].trim();
            }
        }
        return result;
    }

    public boolean Write(String Path) {
        FileOutputStream f1 = null;
        BufferedOutputStream bu = null;
        try {
            f1 = new FileOutputStream(Cache, true);
            bu = new BufferedOutputStream(f1);
            byte[] b = (Path + "|\n").getBytes();
            bu.write(b);
            bu.flush();
        } catch (IOException e) {
            logger.error("写入失败，请与管理员联系！");
            return false;
        } finally {
            if (bu != null) {
                try {
                    bu.close();
                } catch (IOException e) {
                    logger.error("对象关闭失败，请与开发者联系~");
                }
            }
            if (f1 != null) {
                try {
                    f1.close();
                } catch (IOException e) {
                    logger.error("对象关闭失败，请与开发者联系~");
                }
            }
        }
        return true;
    }
}
