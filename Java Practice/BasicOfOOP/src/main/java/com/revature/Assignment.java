package com.revature;

public class Assignment {

    int i = 20;
    int j = 5;
    int k = 50;

    public int add(int x, int y) {
        return x + y;
    }

    public int sub(int x, int y) {
        return x - y;
    }

    public int multi(int x, int y) {
        return x * y;
    }

    public int div(int x, int y) {
        return x / y;
    }

    public void imDaBes(int x, int y, int z) {
        if ((x > y) && (x > z)) {
            System.out.println(x + " is the largest number./n");
        } else if ((y > x) && (y > z)) {
            System.out.println(y + " is the largest number./n");
        } else
            System.out.println(z + " is the largest number./n");

    }

    public void computation() {
        boolean a = true;
        boolean b = false;
        System.out.println(!a);
        System.out.println(a|b);
        System.out.println((!a & b) | (a & !b));
    }
}