package com.util;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;

public class Main {
    public void Wrin(String title, StringBuilder Message) {
        File f = new File("logs/data/error.log");
        FileOutputStream f1 = null;
        BufferedOutputStream bu = null;
        byte[] b1 = title.getBytes();
        byte[] b2 = Message.toString().getBytes();
        try {
            f1 = new FileOutputStream(f, true);
            bu = new BufferedOutputStream(f1);
            Date d = new Date();
            String tg1 = String.format("%tT", d);
            String tg2 = String.format("Appeared Exception time:%tF ", d);
            String tg = tg2 + tg1 + "\n";
            byte[] b3 = tg.getBytes();
            String frt = System.getProperty("line.separator");
            try {
                bu.write(frt.getBytes());
                bu.write(b3);
                bu.write(b1);
                bu.write(frt.getBytes());
                bu.write(b2);
                bu.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            if (bu != null) {
                try {
                    bu.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (f1 != null) {
                try {
                    f1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            f = new File("logs/data/all.log");
            FileOutputStream f3 = null;
            BufferedOutputStream bu1 = null;
            try {
                f3 = new FileOutputStream(f, true);
                bu1 = new BufferedOutputStream(f3);
                try {
                    bu1.write(b1);
                    String huanhang = System.getProperty("line.separator");
                    bu1.write(huanhang.getBytes());
                    bu1.write(b2);
                    bu1.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (bu1 != null) {
                    try {
                        bu.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (f3 != null) {
                    try {
                        f1.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }

    public static void filecun(String Message) {
        File f = new File("logs/data/info.log");
        FileOutputStream f1 = null;
        BufferedOutputStream bu = null;
        byte[] b2 = Message.getBytes();
        try {
            f1 = new FileOutputStream(f, true);
            bu = new BufferedOutputStream(f1);

            try {
                bu.write(b2);
                bu.flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } finally {
            // System.out.println(title);
            // System.out.println(Message);
            if (bu != null) {
                try {
                    bu.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            if (f1 != null) {
                try {
                    f1.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            f = new File("logs/data/all.log");
            FileOutputStream f3 = null;
            BufferedOutputStream bu1 = null;
            try {
                f3 = new FileOutputStream(f, true);
                bu1 = new BufferedOutputStream(f3);
                try {
                    bu1.write(b2);
                    bu1.flush();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } finally {
                if (bu1 != null) {
                    try {
                        bu.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if (f3 != null) {
                    try {
                        f3.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

