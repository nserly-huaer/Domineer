package com.castRun;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class CannotCastException extends Exception {
    private String ExceptionMessage;

    public CannotCastException(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(Main.class);
        logger.error("转换失败，请重试");
        JOptionPane.showMessageDialog(null, "转换失败，请重试", "发生异常", JOptionPane.ERROR_MESSAGE);
    }
}
