package com.revCollections;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        CreateArrayList();
        //--ctrl + . Will allow you to import packages
    }
        static void CreateArrayList(){
            ArrayList<String> ar=new ArrayList<>();
            ar.add("Pushpinder");
            ar.add("Kaur");
            //ar.add(27);
            ar.add(1,"test");
            ar.remove(1);

            for(String item:ar){
                System.out.println(item);
            }
            System.out.println("Size:"+ar.size());
            System.out.println("Second Element"+ar.get(1));
    }
    static void CreateStack(){
        Stack<String> stack=new Stack<>();
        stack.push("Pushpinder");
        stack.push("Kaur");
        System.out.println(stack.peek());
    }
}
