package com.RunMainSoft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;

public class CreateMainFile {
    public File file;
    public static final File conter = new File("data");
    private static final Logger logger = LogManager.getLogger(CreateMainFile.class);

    {
        if (!conter.exists()) {
            conter.mkdir();
        }
    }

    public CreateMainFile(File file) {
        this.file = file;
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                MainS.centel(e, true);
            }
        }
    }

    public void Write(String ServerIP, int ServerPort) {
        String message = ServerIP + " " + ServerPort + "\n";
        FileOutputStream f = null;
        BufferedOutputStream bu = null;
        try {
            f = new FileOutputStream(file, true);
            bu = new BufferedOutputStream(f);
            bu.write(message.getBytes());
            bu.flush();
        } catch (IOException e) {
            MainS.centel(e, true);
        } finally {
            if (f != null) {
                try {
                    f.close();
                } catch (IOException e) {
                    MainS.centel(e, true);
                }
            }
            if (bu != null) {
                try {
                    bu.close();
                } catch (IOException e) {
                    MainS.centel(e, true);
                }
            }
        }
    }

    public static void Read() {
        //....
    }
}
