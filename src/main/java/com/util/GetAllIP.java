package com.util;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class GetAllIP implements Runnable {
    private static Set<String> s = new HashSet();
    private String IP;

    public Set<String> GetResult() {
        return s;
    }

    public String toString() {
        return s.stream()
                .map(Object::toString)
                .collect(Collectors.joining("\n"));
    }

    public void Start() throws UnknownHostException {
        InetAddress host = InetAddress.getLocalHost();// 获得本机的InetAddress对象
        String hostAddress = host.getHostAddress();// 获得本机的IP地址
        int pos = hostAddress.lastIndexOf(".");// 获得IP地址中最后一个点的位置
        String wd = hostAddress.substring(0, pos + 1);// 对本机的IP进行截取，获得网段
        for (int i = 1; i <= 255; i++) { // 对局域网的IP地址进行遍历
            String ip = wd + i;// 生成IP地址
            new Thread(new GetAllIP(ip)).start();//创建线程并运行
        }
    }

    private GetAllIP(String IP) {
        this.IP = IP;
    }

    public GetAllIP() {

    }

    @Override
    public void run() {
        // 获得所ping的IP进程，-w 280是等待每次回复的超时时间，-n 1是要发送的回显请求数
        try {
            Process process = Runtime.getRuntime().exec("ping " + IP + " -w 280 -n 1");
            InputStream is = process.getInputStream();// 获得进程的输入流对象
            InputStreamReader isr = new InputStreamReader(is);// 创建InputStreamReader对象
            BufferedReader in = new BufferedReader(isr);// 创建缓冲字符流对象
            StringBuilder sb = new StringBuilder();
            String tmp = null;

            while ((tmp = in.readLine()) != null) {
                sb.append(tmp);
            }
            if (!sb.toString().contains("100%")) {
                s.add(IP);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
