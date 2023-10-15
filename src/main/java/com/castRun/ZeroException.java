package com.castRun;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class ZeroException extends Exception {
    private String ExceptionMessage;

    public ZeroException(int i, String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(Main.class);
        if (i == 1) {
            logger.error("输入的除数带有0，请重试！");
            JOptionPane.showMessageDialog(null, "输入的除数带有0，请重试！", "无穷大（除数带0）异常", JOptionPane.ERROR_MESSAGE);
        } else if (i == 2) {
            logger.error("将数转换最简直时错误，请与开发者联系");
            JOptionPane.showMessageDialog(null, "数转换最简直时出错，请与开发者联系", "转换异常", JOptionPane.ERROR_MESSAGE);
        } else {
            logger.error("错误代码无效");
            JOptionPane.showMessageDialog(null, "错误代码无效", "错误代码无效", JOptionPane.ERROR_MESSAGE);
        }
    }
}
