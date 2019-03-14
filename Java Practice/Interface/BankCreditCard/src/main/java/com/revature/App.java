package com.revature;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    ChaseBank bank = new ChaseBank();
    double interestRate = bank.getRateOfInterest();
    double discount = bank.discount(7.5);
    System.out.println("Interest Rate: "+interestRate + " \nDiscount: " + discount);
    }
}
