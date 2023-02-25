package com.arcadia.samples.ordersmethods;

import com.arcadia.samples.utils.WriteToDisk;

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

    public int BubbleSort_v1()[] {

        /*String buffer = "";
        WriteToDisk writeToDisk = new WriteToDisk("array.txt");

        buffer = "Paso _._ - ";
        for (i = 0; i < totalNumbers; i++) {
            buffer += localArray[i] + " ";
        }
        writeToDisk.WriteFileToDisk(buffer, false);*/

        for (i = 0; i < totalNumbers; i++) {
            for (j = 0; j < totalNumbers - 1; j++) {
                if (localArray[j] > localArray[j + 1]) {
                    tempNumber = localArray[j];
                    localArray[j] = localArray[j + 1];
                    localArray[j + 1] = tempNumber;
                }
                /*buffer = "Paso " + i + "." + j + " - ";
                for (int z = 0; z < totalNumbers; z++) {
                    buffer += localArray[z] + " ";
                }
                writeToDisk.WriteFileToDisk(buffer, true);*/
            }
        }

        return localArray;
    }

    public int BubbleSort_v2()[] {

        int dynamicTop = 1;
        /*String buffer = "";
        WriteToDisk writeToDisk = new WriteToDisk("array.txt");

        buffer = "Paso _._ - ";
        for (i = 0; i < totalNumbers; i++) {
            buffer += localArray[i] + " ";
        }
        writeToDisk.WriteFileToDisk(buffer, false);*/

        for (i = 0; i < totalNumbers; i++) {
            for (j = 0; j < totalNumbers - dynamicTop; j++) {
                if (localArray[j] > localArray[j + 1]) {
                    tempNumber = localArray[j];
                    localArray[j] = localArray[j + 1];
                    localArray[j + 1] = tempNumber;
                }
                /*buffer = "Paso " + i + "." + j + " - ";
                for (int z = 0; z < totalNumbers; z++) {
                    buffer += localArray[z] + " ";
                }
                writeToDisk.WriteFileToDisk(buffer, true);*/
            }
            dynamicTop++;
        }

        return localArray;
    }
    
    public int BubbleSort_v3()[] {

        boolean flagOk = false;
        int dynamicTop = 1;
        /*String buffer = "";
        WriteToDisk writeToDisk = new WriteToDisk("array.txt");*/

        /*Only for testing*/
        /*localArray[0] = 1;
        localArray[1] = 2;
        localArray[2] = 3;
        localArray[3] = 4;
        localArray[4] = 5;*/
        /**/
        
        /*buffer = "Paso _._ - ";
        for (i = 0; i < totalNumbers; i++) {
            buffer += localArray[i] + " ";
        }
        writeToDisk.WriteFileToDisk(buffer, false);*/

        for (i = 0; i < totalNumbers; i++) {
            flagOk = false;
            for (j = 0; j < totalNumbers - dynamicTop; j++) {
                if (localArray[j] > localArray[j + 1]) {
                    tempNumber = localArray[j];
                    localArray[j] = localArray[j + 1];
                    localArray[j + 1] = tempNumber;
                    flagOk = true;
                }
                
                /*buffer = "Paso " + i + "." + j + " - ";
                for (int z = 0; z < totalNumbers; z++) {
                    buffer += localArray[z] + " ";
                }
                writeToDisk.WriteFileToDisk(buffer, true);*/
            }
            if (!flagOk){
                break; // Nothin to order
            } else {
                dynamicTop++;
            }
        }

        return localArray;
    }
}
