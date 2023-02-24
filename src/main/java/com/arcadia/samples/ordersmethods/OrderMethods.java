package com.arcadia.samples.ordersmethods;

import java.util.ArrayList;

/**
 *
 * @author ganaranjo
 */
public class OrderMethods {

    int totalNumbers = 0;
    int tempNumber = 0;
    int i = 0;
    int j = 0;
    int[] localArray = new int[totalNumbers];

    public OrderMethods(int array[]) {
        localArray = array;
        totalNumbers = array.length;
    }

    public int BubbleSort () 
        [] {

        for (i = 0; i < totalNumbers; i++) {
            for (j = 0; j < totalNumbers - 1; j++) {
                if (localArray[j] > localArray[j + 1]) {
                    tempNumber = localArray[j];
                    localArray[j] = localArray[j + 1];
                    localArray[j + 1] = tempNumber;
                }
            }
        }

        return localArray;
    }

}
