package com.arcadia.samples;

import com.arcadia.samples.ordersmethods.OrderMethods;
import com.arcadia.samples.random.RandomNumbers;
import com.arcadia.samples.utils.WriteToDisk;
import com.arcadia.samples.stringmethods.StringMethods;
import com.arcadia.samples.security.Password;
import com.arcadia.samples.security.GeneratePassword;
import com.arcadia.samples.latinbox.LatinBox;
/**
 *
 * @author ganaranjo
 */
public class Samples {

    public static void main(String[] args) {

        //testOrderMethods();
        
        //testStringMethods();
        
        //testPassword();
        
        testLatinBox();
    }

    private static void testOrderMethods(){
        
        int totalNumbersBase = 1024;
        int totalNumbersMultiple = 128;

        int lBase = 1;
        int uBase = totalNumbersBase;
        int totalNumbers = totalNumbersBase * totalNumbersMultiple;
        int[] localArrayFixed = new int[totalNumbers];
        int[] localArray = new int[totalNumbers];
        long startTime;
        long endTime;
        String buffer = "";
        
        WriteToDisk writeToDisk = new WriteToDisk("bubblesort.txt");

        /* Start random process*/
        startTime = System.nanoTime();
        RandomNumbers randomNumbers = new RandomNumbers(lBase,uBase,totalNumbers);
        localArrayFixed = randomNumbers.generateRandomNumbers();
        endTime = System.nanoTime();
        System.out.println("Generate random numbers... " + 
                Math.round((endTime - startTime)/1000000000) + " sec");
        
        /* Start file write with unordered string*/
        startTime = System.nanoTime();
        for (int i=0; i<localArrayFixed.length; i++){
            buffer += localArrayFixed[i] + " ";
        }
        writeToDisk.WriteFileToDisk(buffer, false);
        endTime = System.nanoTime();
        System.out.println("Print random numbers to file... " +
                Math.round((endTime - startTime)/1000000000) + " sec");
        
        /* Start sorting process: bubble sort*/
        startTime = System.nanoTime();
        OrderMethods orderMethods = new OrderMethods(localArrayFixed);
        localArray = orderMethods.QuickSort(0, totalNumbers-1);
        endTime = System.nanoTime();
        System.out.println("Ordering ... " + 
                Math.round((endTime - startTime)/1000000000) + " sec");
        
        /* Start file write with sorted string*/
        startTime = System.nanoTime();
        buffer = "";
        for (int i=0; i<localArray.length; i++){
            buffer += localArray[i] + " ";
        }
        writeToDisk.WriteFileToDisk(buffer, true);
        endTime = System.nanoTime();
        System.out.println("Print ordered numbers to file... " +
                Math.round((endTime - startTime)/1000000000) + " sec");        

    }
    
    public static void testStringMethods(){
        
        String reverseString = "";
        
        StringMethods stringMethods = new StringMethods();
        reverseString = stringMethods.ReverseString("naranjo");
        
        System.out.println(reverseString);
    }
    
    public static void testPassword(){
        
        GeneratePassword genPass = new GeneratePassword();
        
        String password = "";
        String message = "";
        Password passwordUser = new Password();

        for(int i=0;i<100;i++){
            password = genPass.generatePassword();
            passwordUser.setPassword(password);
            
            message = "The password is: " + password + " and ";

            if (passwordUser.isStrong()){
               message += "is good";
            } else {
                message += "is bad";
            }
            System.out.println(message);
            password = "";
        }        
    }
    
    public static void testLatinBox(){
        
        LatinBox latinBox = new LatinBox(4);
        latinBox.RunLatinBox();
    }
}
