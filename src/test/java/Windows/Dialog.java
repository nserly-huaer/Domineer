package Windows;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Dialog extends JDialog {
    private static final String IPv4_REGEX =
            "^(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)$";
    private static final String IPv6_REGEX =
            "^(?:(?:(?:[0-9A-Fa-f]{1,4}):){6}|(?=(?:[0-9A-Fa-f]{0,4}:){0,6}(?:[0-9A-Fa-f]{0,4}$))(?:(?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?::(?:[0-9A-Fa-f]{1,4}(?::[0-9A-Fa-f]{1,4})*)?))$";
    private JTextField textField1;
    private JTextField textField2;

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
        if (RunMain.ServerPort != 0)
            textField2 = new JTextField(String.valueOf(RunMain.ServerPort));
        else
            textField2 = new JTextField();


        JButton button = new JButton("OK");
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                RunMain.f.setVisible(true);
            }
        });
        button.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String serverIP = textField1.getText();
                String serverPort = textField2.getText();

                if (validateInput(serverIP, Integer.parseInt(serverPort))) {
                    RunMain.ServerIP = serverIP;
                    RunMain.ServerPort = Integer.parseInt(serverPort);
                    setVisible(false);
                    RunMain r = new RunMain();
                    r.Connect();
                    //关闭窗体
                    dispose();

                } else {
                    JOptionPane.showMessageDialog(Dialog.this, "Invalid server information!", "Error", JOptionPane.ERROR_MESSAGE);
                }
            }
        });

        JPanel panel = new JPanel(new GridLayout(3, 2, 10, 10));
        panel.add(label1);
        panel.add(textField1);
        panel.add(label2);
        panel.add(textField2);
        panel.add(button);

        Container contentPane = getContentPane();
        contentPane.setLayout(new BorderLayout());
        contentPane.add(jb, BorderLayout.NORTH);
        contentPane.add(panel, BorderLayout.CENTER);

            setVisible(true);
    }

    private boolean validateInput(String serverIP, int serverPort) {
        // Add your input validation logic here
        // For example, check if serverIP is a valid IP address and serverPort is a valid integer
        Pattern Ipv4 = Pattern.compile(IPv4_REGEX);
        Matcher matcherV4 = Ipv4.matcher(serverIP);
        boolean ipv4 = matcherV4.matches();

        Pattern Ipv6 = Pattern.compile(IPv6_REGEX);
        Matcher matcher = Ipv6.matcher(serverIP);
        boolean ipv6 = matcher.matches();

        boolean isRightPort = (serverPort > 0) && (serverPort <= 65535);

        if (isRightPort && ipv6)
            return true;
        else if (isRightPort && ipv4)
            return true;

        return false; // Return true if input is valid, false otherwise
    }
}