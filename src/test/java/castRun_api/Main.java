package castRun_api;

import com.RunMainSoft.scan;
public class Main {
    // 被除数
    public double bcs;
    // 除数
    public double cs;
    // 乘以个数，数字越大支持越大小数，同时计算速度将减少
    private final static long charter = 10000000000L;

    public void runfirst() {
        Main m = new Main();
        boolean sc = m.scan();
        if (sc) {
            m.cast(bcs, cs);
        } else {
        }
    }

    public boolean scan() {
        System.out.println("请输入被除数");
        double bcs = Double.parseDouble(scan.str());// 被除数
        System.out.println("请输入除数");
        double cs = Double.parseDouble(scan.str());// 除数
        this.bcs = bcs;
        this.cs = cs;
        return cs != 0;
    }

    public void cast(double bcs, double cs) {
        long bcs123 = (long) (bcs * Main.charter);
        long cs123 = (long) (cs * Main.charter);
        Main m = new Main();
//        m.Calaurtor((long) bcs123, (long) cs123);
        a:
        for (int i = 2; i <= Math.min(bcs123, cs123); i++) {
            b:
            for (; ; ) {
                if (bcs123 == cs123) {
                    bcs123 = 1;
                    cs123 = 1;
                    break a;
                } else if ((bcs123 % i == 0) && (cs123 % i == 0)) {
                    bcs123 = bcs123 / i;//
                    cs123 = cs123 / i;//
                } else {
                    break;
                }
            }
        }
        this.bcs = bcs123;
        this.cs = cs123;
    }
}

