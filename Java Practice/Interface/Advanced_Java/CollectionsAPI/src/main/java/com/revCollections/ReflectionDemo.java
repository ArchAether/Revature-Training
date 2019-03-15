package com.revCollections;
import java.lang.reflect.Field; //reads fields
import java.lang.reflect.Method;
import java.lang.reflect.Constructor;

class TestCheck{
    private String msg;
    public TestCheck(){
        msg="Secret";
    }
    public TestCheck(String msg){
        this.msg=msg;
    }
    public void M1(){
        System.out.println("Msg from M1: "+msg);
    }
    public void M2(String msg) {
        System.out.println("Message from M2: "+msg);
    }
    private void M3() {
        System.out.println("Inside Private Method");
    }
}

class ReflectionDemo{
    public static void main(String[] args) {
        TestCheck obj=new TestCheck();

        // Reading instance of Classes
        // Return the instance of Class class. can be used with primitives
        Class clsObj=obj.getClass();
        System.out.println(clsObj.getName());
        
        //--Get Constructors--
        Constructor[] cnstrs=clsObj.getConstructors();
        for (Constructor cnstr : cnstrs) {
            System.out.println(cnstr);
        }
        
        //--Get Methods--
        Method[] methods= clsObj.getMethods();
        for(Method method : methods){
            System.out.println(method.getName()); //Can't access Private Methods...
        }

        Method invokeM3 = clsObj.getDeclaredMethod("M3"); //Somethings missing. 
        invokeM3.setAccessible(true);
        invokeM3.invoke(obj);
    }
    //At Runtime, you can return the method names, fields, etc. Used in Autocompletion. Frameworks, codesnippets
}