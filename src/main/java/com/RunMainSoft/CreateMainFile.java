package com.RunMainSoft;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class CreateMainFile {
    public File file;
    public static final File counter = new File("data");
    private static final Logger logger = LogManager.getLogger(CreateMainFile.class);

    static {
        if (!counter.exists()) {
            counter.mkdir();
        }
    }

    public CreateMainFile(final String PATH) {
        File f = new File(PATH);
        if (!f.exists()) {
            try {
                f.createNewFile();
            } catch (IOException e) {
                MainS.centel(e, true);
            }
        }
        this.file = f;
    }

    public CreateMainFile(File file) {
        if (!file.exists()) {
            try {
                file.createNewFile();
            } catch (IOException e) {
                MainS.centel(e, true);
            }
        }
        this.file = file;
    }

    public void WriteNotKeep(String key, String value) {
        String message = key + ":" + value + "\n";
        FileOutputStream f = null;
        BufferedOutputStream bu = null;
        try {
            f = new FileOutputStream(file);
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
    public void Write(String key, String value) {
        String message = key + ":" + value + "\n";
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

    public Map<String, String> Read() {
        FileReader fr = null;
        BufferedReader bu = null;
        Map<String, String> map = new HashMap<>();
        try {
            fr = new FileReader(file);
            bu = new BufferedReader(fr);
            String line;
            while ((line = bu.readLine()) != null) {
                String cache[] = line.split(":", 2);
                map.put(cache[0].trim(), cache[1].trim());
            }
        } catch (IOException e) {
            logger.error(e);
        }
        return map;
    }

    public static String Search(final Map<String, String> map, String key) {
        return map.get(key);
    }
}
