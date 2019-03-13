// Naming Convention: Packages - small.case, 
// Classes: ProperCase, use Nouns
// Interface: ProperCase
// Variable($,_,1), Methods: camelCase  Methods should use Verbs
// CONSTANTS: UPPERCASE
package com.revature;

import javax.swing.text.html.HTMLDocument.HTMLReader.SpecialAction;

class Greeter{
    private String name;
    public Greeter(String name){
        name = "Stephen Lo"; //NoArgs Constructor
    }
    public String getName(){
        return name;
        // or this.name;
    }
    public void setName(String n){
        this.name = n; //   If you don't use this. keyword, then there is an ambiquity 
    }
}

abstract class Person{
    String name;
    String ssn;
    final String SPECIEID = "HOMOSAPIENS";
    public Person(String name, String ssn){
        this.name = name;
        this.ssn = ssn;
        //SPECIEID = "fdsdfs";  Cannot assign values to constants!
    }
    abstract String getMoreDetails();   //For abstract, method declaration should not be implemented

    String getDetails(){
        return name +' '+ssn + ' '+ SPECIEID;
    }
    // Set to default, which means that it can be accessed where ever in the package
}

class Employee extends Person{
    double salary;

    public Employee(String name, String ssn, double Salary){
        super(name, ssn);
        this.salary=salary;

    }
    @Override
    public String getDetails(){
        return "Name: "+name +" SSN: "+ssn + " Salary: "+salary+ " Specie ID: "+ SPECIEID;
    }
    @Override
    public String getMoreDetails(){
        return "Name: "+name +" SSN: "+ssn + " Salary: "+salary+ " Specie ID: "+ SPECIEID;
    }
}