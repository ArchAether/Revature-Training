package com.revature;

interface CreditCard {
    double discount(double creditScore); // default abstract and public. CANNOT have a body
}

interface Bank extends CreditCard{ //--Interface can inherit another interface
    double getRateOfInterest();
}

//--Can extend ONE class, but as many interfaces as you'd like
class ChaseBank extends App implements Bank { //--100% Abstraction and Multiple inheritance
    @Override
    public double discount(double creditScore) {
        double discount;
        if(creditScore >  6.8){
            return discount = 15.0;
        }
        else
            return discount = 4.7;
        
    }

    @Override
    public double getRateOfInterest() {
        return 3.2;
    }
    // --Can use ctrl+Space to see what methods to implement.(VSCode)
}