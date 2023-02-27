package com.arcadia.samples.ordersmethods;

/**
 *
 * @author ganaranjo
 */
public class OrderMethods {

    int totalNumbers = 0;
    int tempNumber = 0;
    int i = 0;
    int j = 0;
    int k = 0; // for bidirectional version
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
        localArray[0] = 5;
        localArray[1] = 1;
        localArray[2] = 3;
        localArray[3] = 2;
        localArray[4] = 4;
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
    
    public int BidirectionalBubbleSort()[] {

        int dynamicTop = 1;
        int dynamicBottom = 0;
        boolean flagTop = false;
        boolean flagBottom = false;
        
        /*Only for testing*/
        localArray[0] = 5;
        localArray[1] = 1;
        localArray[2] = 3;
        localArray[3] = 2;
        localArray[4] = 4;
        /**/

        for (i = 0; i < totalNumbers - 1; i++) {
            flagTop = false;
            flagBottom = false;
            
            // Less to Major
            for (j = dynamicBottom; j < totalNumbers - dynamicTop; j++) {
                if (localArray[j] > localArray[j + 1]) {
                    tempNumber = localArray[j];
                    localArray[j] = localArray[j + 1];
                    localArray[j + 1] = tempNumber;
                    flagTop = true;
                }
            }
            
            // Major to Less
            for (k = totalNumbers - dynamicTop; k > dynamicBottom; k--){
                if (localArray[k] < localArray[k - 1]) {
                    tempNumber = localArray[k - 1];
                    localArray[k - 1] = localArray[k];
                    localArray[k] = tempNumber;
                    flagBottom = true;
                }
            }
            
            if(!flagTop || !flagBottom){
                break;
            }else {
                dynamicTop++;
                dynamicBottom++;
            }
        }

        return localArray;
    }
}
