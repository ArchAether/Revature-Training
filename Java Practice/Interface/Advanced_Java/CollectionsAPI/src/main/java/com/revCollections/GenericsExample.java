package com.revCollections;

class TestGenerics<T,U>{
    T t;
    U u;
    public TestGenerics(T t, U u){
        this.t=t;
        this.u=u;
    
    }
    public void ReadValues(){
        System.out.println(t+" "+u);
    }
    static <T> String compare(T t1, T t2){
        boolean result=t1.equals(t2);
        if(result)
            return "The objects are equal";
        else
            return "Not equal";
    }
    //--If you pass another arg, must mention it in return type: Static <T, U> String Compare(T t1, U t2)
}
class MainClass{
    public static void main(String[] args){
        TestGenerics<Integer, String> myGenericObj=new TestGenerics(123, "Hello Generics");
        TestGenerics<Integer, String> myGenericObj2=new TestGenerics(123, "Hello Generics");

        myGenericObj.ReadValues();

        System.out.println(TestGenerics.compare(myGenericObj, myGenericObj2));

        
    }
}