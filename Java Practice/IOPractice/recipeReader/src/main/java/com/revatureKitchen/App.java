package com.revatureKitchen;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Reads from a recipe.txt file, then outputs to the console
 */
public class App {
    public static void main(String[] args) throws IOException{
        RecipeReader hungryMan = new RecipeReader();
        //hungryMan.byteStreamMethod();
        //readRecipe();
        hungryMan.readRecipe();
    }
}
