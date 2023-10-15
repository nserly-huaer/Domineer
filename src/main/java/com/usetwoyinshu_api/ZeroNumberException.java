package com.usetwoyinshu_api;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import javax.swing.*;

public class ZeroNumberException extends Exception {
    private String ExceptionMessage;

    public ZeroNumberException(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        JOptionPane.showMessageDialog(null, "公因数小于1，请重试！", "无因数异常", JOptionPane.ERROR_MESSAGE);
        Logger logger = LogManager.getLogger(TwoThread.class);
    }
}
