package Windows;

import SendToServer.cross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class BlurredGlassDialog extends JDialog {
    public BlurredGlassDialog(JFrame parent, String message, String title) {
        super(parent, title, true);
        setUndecorated(true);
        setOpacity(0.85f); // 设置窗体透明度为0.85

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30)); // 绘制圆角矩形
                g2.dispose();
            }
        };
        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);

        JButton okButton = new JButton("确定");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cross.restart();
            }
        });

        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER));
        buttonPanel.setOpaque(false);
        buttonPanel.add(okButton);
        panel.add(buttonPanel, BorderLayout.SOUTH);

        add(panel);
        pack();
        setLocationRelativeTo(parent);
    }
}