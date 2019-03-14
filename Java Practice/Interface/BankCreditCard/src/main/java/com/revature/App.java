package com.revature;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        // ChaseBank bank = new ChaseBank();
        // double interestRate =bank.getRateOfInterest();
        // double discount = bank.discount(7.5);
        // System.out.println("Interest Rate: "+interestRate + " \nDiscount: " +
        // discount);

        // --Wrapper classes

        // int -> interger
        // --Conversion from Primitive type to reference type is called 'Boxing'
        // boolean-> Boolean char-> Character

        // int av = 20; Integer w = Integer.valueOf(av); //--Conversion of int to
        // Integer
        // Integer j = av; //--Autoboxing. System.out.println(i);

        // Integer x = new Integer(10); int y=x; //--Unboxing, implictly

        // --Collections: Arrays, Collection Framework/Collection API
        // Arrays: Homogeneous items are placed in contigious memory location.
        // int[] arr1 = {2,3,4}; //declaration
        // arr1 = new int[6]; //initialize with default values
        // arr1[0] =1; arr1[1]=2;
        // for (int i = 0; i < arr1.length; i++) {
        // System.out.println(arr1[i]); } //Arrays are fixed length and cannot be empty.

        // for (int item : arr1) { //--forEach loop //--Will pull every element
        // System.out.println(arr1[item]); }
        // -- 2-D Array -- int row=2, col =3;

        // int[][] twoDArr={{1,2,3},{4,5,6}};
        // twoDArr[0][0] =1;

        // --Jagged Array
        // String[][] ja = new String[2][];
        // Rows don't need to have the same number of rows
        // ja[0] = new String[] { "hello", "all", "world" };// First row with three
        // columns
        // ja[1] = new String[] { "CUNY", "SPS" }; // Second row with 2 columns
        // ja[2] = new String[5]; // Third row with 5 columns.

        // for (int i = 0; i < ja.length; i++) {
        // for (int j = 0; j < ja[i].length; j++) {
        // System.out.println(ja[i][j]);
        // }
        // }
        int a[][] = { { 1, 3, 4 }, { 3, 4, 5 } };
        int b[][] = { { 1, 3, 4 }, { 3, 4, 5 } };
        int c[][] = { { 0, 0, 0 }, { 0, 0, 0 } };
        // matrix addition
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[i].length; j++) {
                c[i][j] = a[i][j] + b[i][j];
                System.out.println("array c: " + c[i][j]);
            }
        }

        int x[][] = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
        int y[][] = { { 1, 1, 1 }, { 2, 2, 2 }, { 3, 3, 3 } };
        int z[][] = { { 0, 0, 0 }, { 0, 0, 0 }, { 0, 0, 0 } };

        for (int k = 0; k < x.length; k++) {
            for (int l = 0; l < x[k].length; l++) {
                z[k][l] = x[k][l] * y[k][l];
                System.out.println(z[k][l]);
            }
        }
    }
}
