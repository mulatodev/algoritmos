/*
    TO-DO
    Implement SecureRandom
    
    Based on
    https://programandoointentandolo.com/2013/10/como-generar-numeros-aleatorios-en-java.html
*/
package com.arcadia.samples.random;

import java.util.Random;

/**
 *
 * @author ganaranjo
 */
public class RandomNumbers {
 
    int lBase;
    int uBase;
    int totalNumbers;
    int n;
        
    public RandomNumbers(int x, int y, int z){
        lBase = x;
        uBase = y;
        totalNumbers = z;
    }

    public int generateRandomNumbers()[]{
        
        int[] numbers = new int[totalNumbers];
        Random random = new Random();
        
        for (int i=0; i < totalNumbers; i++){
            n = random.nextInt(uBase-lBase-1)+lBase;
            numbers[i] = n;
        }
        
        return numbers;
    }

}
