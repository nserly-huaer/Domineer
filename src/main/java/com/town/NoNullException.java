package com.town;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class NoNullException extends Exception {
    private String ExceptionMessage;

    public NoNullException(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(NoNullException.class);
        JOptionPane.showMessageDialog(null, "无未知量，请重试", "发生无未知量异常", JOptionPane.ERROR_MESSAGE);
        logger.error("无未知量，请重试");

    }

}
