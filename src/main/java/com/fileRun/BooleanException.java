package com.fileRun;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class BooleanException extends Exception {
    private String ExceptionMessage;

    public BooleanException(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(Read.class);
        logger.error("无法识别项，请重试！");
        JOptionPane.showMessageDialog(null, "无法识别项，请重试！", "发生转换异常", JOptionPane.ERROR_MESSAGE);
    }
}
