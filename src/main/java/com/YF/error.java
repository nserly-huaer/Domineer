package com.YF;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fileRun.Read;

@SuppressWarnings("serial")
public class error extends Exception {
    private String ExceptionMessage;

    public error(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(Read.class);
        JOptionPane.showMessageDialog(null, "输入非有效值，请重试！", "发生无未知量异常", JOptionPane.ERROR_MESSAGE);
        logger.error("输入非有效值，请重试！");
    }

}