package Windows;

import javax.swing.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class Fram extends JFrame {
    public Fram(String title) {
        setTitle(title);
        setBounds(500, 300, 500, 300);
        setVisible(true);
        setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        setVisible(true);
        addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                int option = JOptionPane.showConfirmDialog(null, "确定要关闭窗口吗？", "提示", JOptionPane.OK_CANCEL_OPTION);
                if (option == JOptionPane.OK_OPTION) {
                    System.exit(1);
                }
            }


        });
    }
}