package Windows;

import SendToServer.cross;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;

public class Operating extends JFrame {
    private static final Logger logger = LogManager.getLogger(Operating.class);
    private static JTextField UserInput;
    private static JTextArea Logs;
    private static JTextArea ServerMessage;
    private static JLabel delay;

    static {
        UserInput = new JTextField();
        Logs = new JTextArea();
        Logs.setEditable(false);
        ServerMessage = new JTextArea();
        ServerMessage.setEditable(false);
        delay = new JLabel();
    }


    public static void ChangeUserInput(String message) {
        UserInput.setText(message);
    }

    public static void delay(String ServerDelay) {
        delay.setText("connect delay:" + ServerDelay);
    }

    public static void ServerMessage(String message) {
        String newText = ServerMessage.getText() + message + "\n";
        ServerMessage.setText(newText);
    }

//    private static void Message(String message) {
//        String newText = ServerMessage.getText() + message;
//        ServerMessage.setText(newText);
//    }

    public static void Logs(String logsMessage) {
        String newText = Logs.getText() + logsMessage + "\n";
        Logs.setText(newText);
    }

    public Operating(String title) {


        setDefaultCloseOperation(DO_NOTHING_ON_CLOSE);
        Container con = getContentPane();
        setTitle(title);
//        setBounds(194, 158, 1779, 951);
        //分辨率1781 × 952
        setBounds(56, 28, 1800, 993);
        setLayout(null);

        // 左上方的面板
        JPanel topLeftPanel = new JPanel();
        topLeftPanel.setBounds(0, 0, 322, 50);
        topLeftPanel.setLayout(new BorderLayout());
        JButton j = new JButton("get delay");
        topLeftPanel.add(j, BorderLayout.CENTER);
        con.add(topLeftPanel);

        JPanel topLeftPanel2 = new JPanel();
        topLeftPanel2.setBounds(0, 60, 322, 50);
        topLeftPanel2.setLayout(new BorderLayout());
        JButton clean = new JButton("clean");
        topLeftPanel2.add(clean, BorderLayout.CENTER);
        con.add(topLeftPanel2);

        // 左边的面板
        JPanel leftPanel = new JPanel();
//        leftPanel.setBounds(0, 50, 322, 898);
        leftPanel.setBounds(0, 120, 321, 843);
        leftPanel.setLayout(new BorderLayout());
        delay.setFont(new Font("Arial", Font.PLAIN, 16));
        leftPanel.add(delay, BorderLayout.CENTER);
        con.add(leftPanel);

        // 中间上面的面板
        JPanel middleTopPanel = new JPanel();
        middleTopPanel.setBounds(322, 0, 1038, 897);
        middleTopPanel.setLayout(new BorderLayout());
        JScrollPane serverMessageScrollPane = new JScrollPane(ServerMessage);
        middleTopPanel.add(serverMessageScrollPane, BorderLayout.CENTER);
        con.add(middleTopPanel);

        // 右边的面板
        JPanel rightPanel = new JPanel();
        rightPanel.setBounds(1360, 0, 421, 950);
        rightPanel.setLayout(new BorderLayout());
        JScrollPane logsScrollPane = new JScrollPane(Logs);
        rightPanel.add(logsScrollPane, BorderLayout.CENTER);
        con.add(rightPanel);

        // 下面中间的面板
        JPanel middleBottomPanel = new JPanel();
        middleBottomPanel.setBounds(322, 897, 1038, 53);
        middleBottomPanel.setLayout(new BorderLayout());
        UserInput.setPreferredSize(new Dimension(825, 53));
        middleBottomPanel.add(UserInput, BorderLayout.CENTER);

        Button SendToServer = new Button("send");
        SendToServer.setPreferredSize(new Dimension(213, 53));
        middleBottomPanel.add(SendToServer, BorderLayout.EAST);
        con.add(middleBottomPanel);


        // 下面右边的面板
//        JPanel bottomRightPanel = new JPanel();

//        con.add(bottomRightPanel);

        clean.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ServerMessage.setText("");
                Operating.ChangeUserInput("");
            }
        });
        UserInput.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_ENTER) {
                    String SendMessage = UserInput.getText();
                    if (SendMessage.equals("clean")) {
                        ServerMessage.setText("");
                        Operating.ChangeUserInput("");
                    } else {
                        cross.SendToServer(SendMessage);
                        Operating.ChangeUserInput("");
                        ServerMessage(SendMessage);
                    }
                }
            }
        });
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "确定要关闭窗口吗？", "提示", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    try {
                        cross.SendToServer("$exit");
                        cross.Close();
                        System.exit(1);
                    } catch (IOException ex) {
                        logger.error(e);
                    }
                }
            }
        });

        SendToServer.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String SendMessage = UserInput.getText();
                if (SendMessage.equals("clean")) {
                    ServerMessage.setText("");
                    Operating.ChangeUserInput("");
                } else {
                    cross.SendToServer(SendMessage);
                    Operating.ChangeUserInput("");
                    ServerMessage(SendMessage);
                }
            }
        });

        j.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cross.SendToServer("delay");
            }
        });

        setVisible(true);

    }
}