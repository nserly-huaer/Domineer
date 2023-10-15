package com.town;


import javax.swing.JOptionPane;

import com.RunMainSoft.MainS;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class loser {
    public static void main() throws InterruptedException {
        Logger logger = LogManager.getLogger(loser.class);
        System.err.println("                此软件会用到“四舍五入”算法，保留14位小数。\n");
        logger.info("此软件会用到“四舍五入”算法，保留14位小数。");
        try {
            Da.demo();

        } catch (error e) {
            MainS.centel(e, true);
            Thread.sleep(500);
        } catch (ArithmeticException e) {
            MainS.centel(e, true);
            Thread.sleep(500);
            JOptionPane.showMessageDialog(null, "除数不能为零，请重试！", "发生算数异常", JOptionPane.ERROR_MESSAGE);
        }

        Finally f = new Finally();
        f.finallyt();

    }
}
