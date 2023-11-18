package Fraction;


import castRun_api.Main;

public class Fraction extends Number {
    private int divisor;//除数
    private int dividend;//被除数

    public void Simplify() {
        Main main = new Main();
        main.cast(dividend, divisor);
        divisor = (int) main.cs;
        dividend = (int) main.bcs;
    }

    public String getFraction() {
        return dividend + "/" + divisor;
    }

    @Override
    public int hashCode() {
        String str = String.valueOf(divisor);
        String str1 = String.valueOf(dividend);
        long a = str.hashCode();
        str = null;
        long b = str1.hashCode() >>> 8;
        str1 = null;
        if ((int) (a + b) <= 0) {
            a += 500;
            b += 500;
        }
        return (int) (a + b);

    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Fraction) {
            Fraction fraction = (Fraction) obj;
            return this.hashCode() == fraction.hashCode();
        }
        return false;
    }

    @Override
    public int intValue() {
        return dividend / divisor;
    }

    @Override
    public long longValue() {
        return dividend / divisor;
    }

    @Override
    public float floatValue() {
        return (float) dividend / divisor;
    }

    @Override
    public double doubleValue() {
        return (double) dividend / divisor;
    }
}
