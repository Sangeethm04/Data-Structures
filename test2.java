//handeling exceptions in java exercise 2 Data Structures

import java.io.*;
import java.util.*;

public class test2 {


    private int[][] array;
    private int dimension;

    public test2(int n) {
        dimension = n;
        array = new int[n][n];
        try {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    array[i][j] = 0;
                }
            }
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Array Index out of bounds");
        }
    }

    public void writeToFile() throws FileNotFoundException {
        try {
            FileReader file = new FileReader("C:\\Users\\Anurati\\Desktop\\abc.txt");
            BufferedReader fileInput = new BufferedReader(file);
            //fileInput.write(array);
        } catch (Exception e) {
            throw new FileNotFoundException("File not found");
        }
    }
    //Create your own exception for handling when the dimension given to the constructor is >100, printing a message like “dimension number is too big”.
    public static void main(String[] args) {
        try {
            // Throw an object of user defined exception
            test2 ex = new test2(200);
            if(ex.dimension > 100) {
                throw new UserDefinedException("Dimension number is too big");
            }
        } catch (UserDefinedException ex) {
            System.out.println("Caught");

            System.out.println(ex.getMessage());
        }
    }
}