package com.town;

import java.util.InputMismatchException;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class error extends Exception {
    private String ExceptionMessage;

    public error(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(Da.class);
        logger.error("输入非有效值，请重试！");
        JOptionPane.showMessageDialog(null, "输入非有效值，请重试！", "发生异常", JOptionPane.ERROR_MESSAGE);

    }

}
