package com.fileRun;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class Danger extends Exception {
    private final String ExceptionMessage;

    public Danger(String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage = ExceptionMessage;
        Logger logger = LogManager.getLogger(Read.class);
        logger.error("执行失败，可能此文件为只读、无权写入文件，请重试！");
        JOptionPane.showMessageDialog(null, "执行失败，可能此文件为只读、无权写入文件，请重试！", "发生异常", JOptionPane.ERROR_MESSAGE);

    }
}