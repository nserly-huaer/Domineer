package SendToServer;

import Windows.BlurredGlassDialog;
import Windows.Operating;
import Windows.RunMain;
import com.RunMainSoft.MainS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.io.*;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import static SendToServer.cross.op;

public class cross {//如果退出代码小于2则为正常退出，否则为异常退出
    private static Socket socket;
    public static final Scanner sc = new Scanner(System.in);
    public static final File PATH = new File("logs\\data\\client.log");
    public static final Logger logger = LogManager.getLogger(cross.class);
    public static boolean div2;
    private static OutputStream out;
    public static String IP;
    public static int Port;
    public static Operating op;

    public static void Close() throws IOException {
        socket.close();
        GetDelay.Close();
    }

    public static void RunSoft(String IP, int port) {
        cross.IP = IP;
        cross.Port = port;
        try {
            // 创建客户端套接字，连接服务器
            socket = new Socket(IP, port);
            logger.info("连接服务器成功！");
            UserLogin(RunMain.UserName);
            GetDelay.UserLogin(RunMain.UserName);
            op = new Operating("服务器连接成功~IP地址：" + IP);
            Thread readThread = new Thread(new ReadThread(socket));
            readThread.start();
            // 创建 GetDelay 对象
            GetDelay getDelay = new GetDelay();
            // 启动 GetDelay 线程
            getDelay.start();
        } catch (IOException e) {
            MainS.centel(e, true);
            logger.error("服务器已经关闭");
            BlurredGlassDialog.Show(op, "can't connect the server,please try later!", "Error");
        }
    }

    public static void restart() {
        BlurredGlassDialog.dialog.dispose();
        op.dispose();
        RunMain.Run();
    }

    public static void Write(String level, String message) throws IOException {
        String write = getFirst(level) + message;
        if (level.toLowerCase().equals("error")) {
            BlurredGlassDialog.Show(op, "can't connect the server,please try later!", "Error");
            Operating.ServerMessage(write);
        } else if (level.toLowerCase().equals("warn")) {
            Operating.ServerMessage(write);
        }
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
            Operating.ServerMessage(info[1]);
        } else if (message.startsWith("information")) {
            String[] info = message.split(" ", 2);
            logger.info("服务器管理员发送：" + info[1]);
            Operating.ServerMessage("服务器管理员发送：" + info[1]);
        } else if (message.startsWith("delay")) {
            String[] de = message.split(" ", 2);
            long del = Long.parseLong(de[1]);
            long time = System.currentTimeMillis();
            if (div2) {
                logger.info("服务器与客户端之间的延迟为：" + ((time - del) / 2) + "ms");
                Operating.ServerMessage("服务器与客户端之间的延迟为：" + ((time - del) / 2) + "ms");
            } else {
                logger.info("服务器与客户端之间的延迟为：" + (time - del) + "ms");
                Operating.ServerMessage("服务器与客户端之间的延迟为：" + (time - del) + "ms");
            }
            String time1 = "reDelay " + String.valueOf(time - del);
            if (!div2) {
                div2 = true;
                socket.getOutputStream().write(time1.getBytes());
            } else {
                div2 = false;
            }
        } else if (message.equals("exit")) {
            BlurredGlassDialog.Show(op, "can't connect the server,please try later!", "Error");
            Operating.ServerMessage("服务器已关闭");
        } else {
            Operating.ServerMessage(message);
            Write("INFO", message);
        }
    }

    public static void UserLogin(String Name) {
        try {
            out = socket.getOutputStream();
            out.write(("UserName " + Name).getBytes());
            out.flush();
        } catch (IOException e) {
            BlurredGlassDialog.Show(op, "can't connect the server,please try later!", "Error");
        }
    }

    public static void SendToServer(String message) {
        try {
            out = socket.getOutputStream();
            // 发送消息给服务器
            cross.Write("INFO", "用户输入：" + message);
            logger.info("用户输入：" + message);
            if (message.trim().toLowerCase().equals("$exit")) {
                out.write("exit".getBytes());
                out.flush();
                socket.close();
                System.exit(1);
            } else if (message.trim().toLowerCase().equals("delay")) {
                cross.div2 = true;
                String cache = "getdelay " + System.currentTimeMillis();
                out.write(cache.getBytes());
            } else {
                message = "messageSender " + message;
                out.write(message.getBytes());
                out.flush();
            }
        } catch (IOException e) {
            try {
                Write("Error", e.toString());
            } catch (IOException ex) {
                BlurredGlassDialog.Show(op, "can't connect the server,please try later!", "Error");
            }
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
        Operating.Logs(message);
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
    private Socket socket;
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
//                Operating.ServerMessage(message);
                cross.ReadServerMessage(message);
            }
        } catch (IOException e) {
            MainS.centel(e, true);
            BlurredGlassDialog.Show(op, "can't connect the server,please try later!", "Error");
        }

    }
}

class GetDelay extends Thread {
    private static Socket so;
    private static OutputStream out;
    private boolean isConnect;

    protected static void Close() throws IOException {
        so.close();
    }

    public static void UserLogin(String Name) {
        try {
            so = new Socket(cross.IP, cross.Port);
            out = so.getOutputStream();
            out.write(("UserName " + Name + "\n").getBytes());
            out.flush();
        } catch (IOException e) {
            BlurredGlassDialog.Show(op, "can't connect the server,please try later!", "Error");
        }
    }

    public GetDelay() {
        isConnect = true;
    }

    @Override
    public void run() {
        try {
            byte[] buffer = new byte[1024];
            String message = "";
            InputStream in = so.getInputStream();
            OutputStream out = so.getOutputStream();
            while (true) {
                Thread.sleep(500);
                String cache = "getdelay " + System.currentTimeMillis();
                out.write(cache.getBytes());
                out.flush();
                int bytesRead = in.read(buffer);
                if (bytesRead == -1) {
                    break;
                }


                // 处理读取到的字节数据
                message = new String(buffer, 0, bytesRead);
                if (message.toLowerCase().trim().startsWith("delay")) {
                    String[] see = message.split("delay ");
                    int index = see.length;
                    long del = Long.parseLong(see[index - 1]);
                    long time = System.currentTimeMillis();
                    long charter = time - del;
                    if (charter >= 500)
                        Operating.delay(String.valueOf(charter - 500) + "ms");
                    else
                        Operating.delay(charter + "ms");
                } else if (message.equals("exit")) {
                    Operating.delay("null");
                    JOptionPane.showMessageDialog(null, "Server is Closed", "Error", JOptionPane.ERROR_MESSAGE);
                } else continue;

            }
        } catch (Exception e) {
            BlurredGlassDialog.Show(op, "can't connect the server,please try later!", "Error");
        }
    }
}