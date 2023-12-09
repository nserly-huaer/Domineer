package Windows;

import com.RunMainSoft.CreateMainFile;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dialog extends JDialog {
    private static final String IPv4_REGEX =
            "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final String IPv6_REGEX =
            "^(([0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4})*)|::([0-9a-fA-F]{1,4}(:[0-9a-fA-F]{1,4})*)?)$";
    private JTextField textField1;
    private JTextField textField2;
    private JTextField textField3;
    public Dialog(JFrame j, String title, boolean modal) {
        super(j, title, modal);
        setBounds(300, 250, 713, 260);
        initComponents();
    }

    private void initComponents() {
        JLabel jb = new JLabel("Input Server Information to connect the server...");
        jb.setFont(new Font("Arial", Font.BOLD, 26));
        jb.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel label1 = new JLabel("Server IP:");
        textField1 = new JTextField(RunMain.ServerIP);

        JLabel label2 = new JLabel("Server Port:");
        textField2 = new JTextField(String.valueOf(RunMain.ServerPort));

        JLabel userNameLabel = new JLabel("User Name:");
        textField3 = new JTextField(CreateMainFile.Search(RunMain.c.Read(), "UserName"));

        JButton button = new JButton("OK");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                RunMain.f.setVisible(true);
            }
        });
        button.addActionListener(e -> {
            String serverIP = textField1.getText();
            String serverPort = textField2.getText();
            String userName = textField3.getText();
            if (serverPort.equals("0"))
                serverPort = "24824";
            RunMain.c.WriteNotKeep("UserName", userName);
            if (userName.isEmpty()) {
                JOptionPane.showMessageDialog(Dialog.this, "Invalid Username!", "Error", JOptionPane.ERROR_MESSAGE);
            } else if (validateInput(serverIP, Integer.parseInt(serverPort))) {
                RunMain.ServerIP = serverIP;
                RunMain.ServerPort = Integer.parseInt(serverPort);
                RunMain.UserName = userName;
                setVisible(false);
                RunMain r = new RunMain();
                r.Connect();
                //关闭窗体
                dispose();

            } else {
                JOptionPane.showMessageDialog(Dialog.this, "Invalid server information!", "Error", JOptionPane.ERROR_MESSAGE);
            }
        });

        JPanel panel = new JPanel(new GridLayout(4, 2, 10, 10));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(userNameLabel);
        panel.add(textField3);
        panel.add(new JLabel()); // 占位，保持布局一致
        panel.add(button);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(jb, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);

        setVisible(true);
    }

    private boolean validateInput(String serverIP, int serverPort) {
        Pattern ipv4 = Pattern.compile(IPv4_REGEX);
        Matcher matcherV4 = ipv4.matcher(serverIP);
        boolean isIPv4 = matcherV4.matches();

        Pattern ipv6 = Pattern.compile(IPv6_REGEX);
        Matcher matcherV6 = ipv6.matcher(serverIP);
        boolean isIPv6 = matcherV6.matches();

        boolean isRightPort = (serverPort > 0) && (serverPort <= 65535);

        return (isRightPort && (isIPv4 || isIPv6));
    }
}