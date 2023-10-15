package com.fileRun;

import javax.swing.JOptionPane;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

@SuppressWarnings("serial")
public class CannotFindException extends Exception {
    private String ExceptionMessage;
    public CannotFindException(int i,String ExceptionMessage) {
        super(ExceptionMessage);
        this.ExceptionMessage=ExceptionMessage;
        Logger logger = LogManager.getLogger(Read.class);
        if (i == 0) {
            logger.error("无效目录，请重试！");
            JOptionPane.showMessageDialog(null, "无效目录，请重试！", "发生异常", JOptionPane.ERROR_MESSAGE);
        } else if (i == 1) {
            logger.error("暂无此产品，请重试！");
            JOptionPane.showMessageDialog(null, "暂无此产品，请重试！", "发生异常", JOptionPane.ERROR_MESSAGE);
        }
    }
}
