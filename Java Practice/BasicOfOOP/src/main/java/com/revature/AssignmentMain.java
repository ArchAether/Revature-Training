package com.revature;

public class AssignmentMain {

    public static void main(String[] args) {
        AssignmentFam cat = new AssignmentFam();
    // If/else condition
        if (4 > 5) {
            System.out.println(cat.add(3, 4));
        } else {
            System.out.println("false");
        }
    // Switch condition
        int j = 0;
        switch (j) {
        case 0:
            System.out.println("It's zero.");
            break;

        case 1:
            System.out.println("I's one.");
            break;
        default:
        System.out.println("I donno what that is...");
            break;
        }

    // While loop
        int a = 0;
        while(a < 10){
            System.out.println("loop"+a);
            a++;
        }
    //Do/While loop
    do{
        System.out.println("Do loop"+a);
        a++;
    }   while(a < 20);
    //For loop---
    for(int d=0; d <= 10; d++){
        System.out.println("for Loop"+d);
    }
    // ---Enhanced Loop---
    int[] array = {5,6,7,8};
    for(int counter:array){
        System.out.println("ENHANCED loop"+counter);
    }
    // ---Break---
    for (int i = 0; i < 5; i++) {
        if(i > 4) break;
        System.out.println("Break Loop"+i);
    }
    // ---Continue---
    for (int i = 0; i < 9; i++) {
        if(i < 5) continue;
        System.out.println("Continue loop"+i);
    }
        System.out.println(cat.sub(5, 2));
        System.out.println(cat.multi(3, 5));
        System.out.println(cat.div(10, 5));
    }
}