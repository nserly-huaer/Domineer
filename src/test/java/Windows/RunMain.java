package Windows;

import SendToServer.cross;
import com.RunMainSoft.CreateMainFile;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RunMain {
    public static CreateMainFile c;
    private static final Logger logger = LogManager.getLogger(RunMain.class);
    public static int ServerPort;
    public static String ServerIP;
    public static String UserName;

    public static Fram f;

    public static void main(String[] args) {
        c = new CreateMainFile("data\\UserInfo.uit");
        Run();
    }

    public static void setVisible(boolean a) {
        f.setVisible(a);
    }

    public static void Run() {
        f = new Fram("client");
        Container c = f.getContentPane();

        JLabel jl = new JLabel("Welcome to connect nserly's server");
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        c.add(jl, BorderLayout.CENTER);

        JButton j = new JButton("Connect");
        c.add(j, BorderLayout.SOUTH);
        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                f.setVisible(false);
                Dialog d = new Dialog(f, "请输入服务器信息", true);
            }
        });

        f.setVisible(true); // 设置窗体为可见状态
    }

    public void Connect() {
        cross.RunSoft(ServerIP, ServerPort);
    }
}