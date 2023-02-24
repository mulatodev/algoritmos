package com.arcadia.samples;

import com.arcadia.samples.ordersmethods.OrderMethods;
import com.arcadia.samples.random.RandomNumbers;
import com.arcadia.samples.utils.WriteToDisk;

/**
 *
 * @author ganaranjo
 */
public class Samples {

    public static void main(String[] args) {
        
        int totalNumbersBase = 1024;
        int totalNumbersMultiple = 1;

        int lBase = 1;
        int uBase = totalNumbersBase;
        int totalNumbers = totalNumbersBase * totalNumbersMultiple;
        int[] localArray = new int[totalNumbers];
        long startTime;
        long endTime;
        String buffer = "";
        
        WriteToDisk writeToDisk = new WriteToDisk("bubblesort.txt");

        /* Start random process*/
        startTime = System.nanoTime();
        RandomNumbers randomNumbers = new RandomNumbers(lBase,uBase,totalNumbers);
        localArray = randomNumbers.generateRandomNumbers();
        endTime = System.nanoTime();
        System.out.println("Generate random numbers... " + 
                Math.round((endTime - startTime)/1000000000) + " sec");
        
        /* Start file write with unordered string*/
        startTime = System.nanoTime();
        for (int i=0; i<localArray.length; i++){
            buffer += localArray[i] + " ";
        }
        writeToDisk.WriteFileToDisk(buffer, false);
        endTime = System.nanoTime();
        System.out.println("Print random numbers to file... " +
                Math.round((endTime - startTime)/1000000000) + " sec");
        
        /* Start sorting process: bubble sort*/
        startTime = System.nanoTime();
        OrderMethods orderMethods = new OrderMethods(localArray);
        localArray = orderMethods.BubbleSort();
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
}
