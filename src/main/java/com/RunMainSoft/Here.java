package com.RunMainSoft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class Here {//如果退出代码小于2则为正常退出，否则为异常退出
    public static final Scanner sc = new Scanner(System.in);
    public static final File PATH = new File("logs\\data\\client.log");
    public static final Logger logger = LogManager.getLogger(Here.class);
    public static boolean div2;

    public static void RunSoft(String IP, int port) {
        try {
            // 创建客户端套接字，连接服务器
            Socket socket = new Socket(IP, port);
            logger.info("连接服务器成功！");

            // 创建读取线程
            Thread readThread = new Thread(new ReadThread(socket));
            readThread.start();

            // 创建发送线程
            Thread sendThread = new Thread(new SendThread(socket));
            sendThread.start();
        } catch (IOException e) {
            MainS.centel(e, true);
            logger.error("服务器已经关闭");
            Default.Connect();
        }
    }

    public static void Write(String level, String message) throws IOException {
        String write = getFirst(level) + message;
        WriteLog(write);
    }

    public static void ReadServerMessage(String message) throws IOException {
        int index = message.indexOf("log");
        if (index >= 0) {
            String[] cache1 = message.split(" ", 2);
            String[] cache2 = cache1[1].split("-", 2);
            //日志信息
            String LogMessage = cache1[1];
            //日志等级
            String level = cache2[1];
            String result = getFirst(level) + LogMessage;
            WriteLog(result);
        } else if (message.startsWith("messageSender")) {
            String[] info = message.split(" ", 2);
            logger.info(info[1]);
            System.out.println(info[1]);
        } else if (message.startsWith("information")) {
            String[] info = message.split(" ", 2);
            logger.info("服务器管理员发送：" + info[1]);
            System.out.println("服务器管理员发送：" + info[1]);
        } else if (message.startsWith("delay")) {
            String[] de = message.split(" ", 2);
            long del = Long.parseLong(de[1]);
            long time = System.currentTimeMillis();
            if (div2) {
                logger.info("服务器与客户端之间的延迟为：" + ((time - del) / 2) + "ms");
                System.out.println("服务器与客户端之间的延迟为：" + ((time - del) / 2) + "ms");
            } else {
                logger.info("服务器与客户端之间的延迟为：" + (time - del) + "ms");
                System.out.println("服务器与客户端之间的延迟为：" + (time - del) + "ms");
            }
            String time1 = "reDelay " + (time - del);
            if (!div2) {
                div2 = true;
                SendThread.out.write(time1.getBytes());
            }else{
                div2 = false;
            }
        } else if (message.equals("exit")) {
            System.out.println("服务器已关闭");
            Default.Connect();
            System.exit(0);
        } else {
            System.out.println(message);
            Write("INFO", message);
            logger.info(message);
        }
    }


    private static String getTime() {
        Date date = new Date();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        return sdf.format(date);
    }

    private static String getFirst(String level) {
        String result = null;
        result = getTime();
        Thread t = Thread.currentThread();
        result += " [" + t.getName() + "/" + level + "]: ";
        return result;

    }

    private static void WriteLog(String message) throws IOException {
        message = message.trim();
        message += "\n";
        FileOutputStream f = null;
        BufferedOutputStream bu = null;
        if (!PATH.exists()) {
            PATH.createNewFile();
        }
        f = new FileOutputStream(PATH, true);
        bu = new BufferedOutputStream(f);
        bu.write(message.getBytes());
        bu.flush();
    }
}

// 读取线程
class ReadThread implements Runnable {
    private final Socket socket;
    private static final Logger logger = LogManager.getLogger(ReadThread.class);

    public ReadThread(Socket socket) {
        this.socket = socket;
    }

    @Override
    public void run() {
        try {
            InputStream in = socket.getInputStream();
            byte[] buffer = new byte[1024];
            while (true) {
                int bytesRead = in.read(buffer);
                if (bytesRead == -1) {
                    break;
                }

                // 处理读取到的字节数据
                String message = new String(buffer, 0, bytesRead);
//                System.out.println(message);
                Here.ReadServerMessage(message);
            }
        } catch (IOException e) {
            MainS.centel(e, true);
            logger.error("读取失败，请重试");
        }

    }
}

// 发送线程
class SendThread implements Runnable {
    private static final Logger logger = LogManager.getLogger(SendThread.class);
    public static OutputStream out = null;
    private static final Scanner sc = new Scanner(System.in);
    private final Socket socket;

    public SendThread(Socket socket) {
        this.socket = socket;
    }
    @Override
    public void run() {
        try {
            while (true) {
                out = socket.getOutputStream();
                // 发送消息给服务器
                String message = sc.nextLine();
                Here.Write("INFO", "用户输入：" + message);
                Here.logger.info("用户输入：" + message);
                if (message.trim().equalsIgnoreCase("$exit")) {
                    out.write("exit".getBytes());
                    out.flush();
                    socket.close();
                    System.exit(1);
                } else if (message.trim().equalsIgnoreCase("delay")) {
                    Here.div2 = true;
                    String cache = "getdelay " + System.currentTimeMillis();
                    out.write(cache.getBytes());
                } else {
                    message = "messageSender " + message;
                    out.write(message.getBytes());
                    out.flush();
                }

            }


        } catch (IOException e) {
            MainS.centel(e, true);
            logger.error("发送失败，请重试~");
            try {
                Here.Write("Error", "用户输入：" + e);
            } catch (IOException ex) {
                MainS.centel(ex, true);
                logger.error("写入失败，请重试~");
            }
        }
    }
}