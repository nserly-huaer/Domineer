package com.example;

import java.util.ArrayList;
import java.util.Scanner;

public class merry {
    public static void main(String[] args) {
        ArrayList<Double> al = new ArrayList<Double>();
        for (; ; ) {
            Scanner sc = new Scanner(System.in);
            System.out.println("请输入验证数字，输入break跳过");
            String str = sc.nextLine();
            str = str.toLowerCase();
            if (str.equals("break"))
                break;
            else
                al.add(Double.parseDouble(str));
        }
        double[] d = new double[al.size()];
        for (int i = 0; i < al.size(); i++) {
            d[i] = al.get(i);
        }
        System.out.print("排序前(共" + al.size() + "个)：");
        for (double i : d) {
            System.out.print(i + " ");
        }
        for (int i = 0; i < d.length; i++) {
            for (int j = 0; j < d.length - i - 1; j++) {
                if (d[j] > d[j + 1]) {
                    double index = d[j];
                    d[j] = d[j + 1];
                    d[j + 1] = index;
                }
            }
        }
        System.out.print("\n排序后结果：");
        for (double i : d) {
            System.out.print(i + " ");
        }
    }
}
