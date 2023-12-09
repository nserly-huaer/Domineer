package Windows;

import SendToServer.cross;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.RoundRectangle2D;

public class BlurredGlassDialog extends JDialog {
    public static JDialog jd;
    public static BlurredGlassDialog dialog;

    public BlurredGlassDialog(JFrame parent, String message, String title) {
        super(parent, title, false);
        setUndecorated(true);
        setOpacity(0.85f);

        JPanel panel = new JPanel() {
            @Override
            protected void paintComponent(Graphics g) {
                super.paintComponent(g);
                Graphics2D g2 = (Graphics2D) g.create();
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(getBackground());
                g2.fill(new RoundRectangle2D.Double(0, 0, getWidth(), getHeight(), 30, 30));
                g2.dispose();
            }
        };

        JButton okButton = new JButton("Ok");
        okButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jd.dispose();
                cross.restart();
            }
        });

        panel.setOpaque(false);
        panel.setLayout(new BorderLayout());
        JLabel label = new JLabel(message);
        label.setHorizontalAlignment(SwingConstants.CENTER);
        panel.add(label, BorderLayout.CENTER);
        panel.add(okButton, BorderLayout.SOUTH);

        jd = new JDialog(this, "Server is closed", true);
        jd.setUndecorated(true);
        jd.setOpacity(0.85f);
        jd.add(panel);
        jd.pack();
        jd.setSize(572, 195);
        jd.setLocationRelativeTo(this);
    }

    public static void Show(JFrame parent, String message, String title) {
        if (!RunMain.d.isShowing()) {
            dialog = new BlurredGlassDialog(parent, message, title);
            jd.setVisible(true);
            RunMain.f.setVisible(true);
        }
    }
}