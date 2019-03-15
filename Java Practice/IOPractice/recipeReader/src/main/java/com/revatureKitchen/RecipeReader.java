package com.revatureKitchen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

class RecipeReader {

    static public void readRecipe() throws IOException { //Needs IOException compile time
        List<String> ingredList = new ArrayList<>();
        // FileInputStream in = null;//Declare inputStream (safely)

        try (FileInputStream in = new FileInputStream("recipe.txt")) {
            // in = new FileInputStream("recipe.txt"); //open the InputStream

            int i = 0;
            while (in.read() != -1) { // Write to ingredList
                ingredList.add(i, in.toString());
            }
            for (String element : ingredList) {
                System.out.println(element); // print to console
            }

        } catch (Exception e) {
            // TODO: handle exception
            System.out.println("Help: "+e.getMessage());
        }
    }
    // ==Time for copying==

    static public void byteStreamMethod() throws IOException {
        FileInputStream in = null;
        FileOutputStream out = null;
        try {
            in = new FileInputStream("recipe.txt");
            out = new FileOutputStream("outagain.txt");

            int c;
            while ((c = in.read()) != -1) {
                out.write(c);
            }
        } 
        // finally {
        //     if (in != null) {
        //         in.close();
        //     }
        //     if (out != null) {
        //         out.close();
        //     }
        // }
        catch (IOException e) {
            // TODO: handle exception
            e.getMessage();
            System.out.println("Help");
        }

    }
}
