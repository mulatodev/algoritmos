package com.arcadia.samples.stringmethods;

import java.util.StringTokenizer;

/**
 *
 * @author ganaranjo
 */
public class StringMethods {
    
    public StringMethods(){
        
    }
    
    public String ReverseString(String text){
        String reverseString = "";
        String[] auxString;
        
        //StringTokenizer stringTokenizer = new StringTokenizer(text);
        auxString = text.split("");
        for(int i=auxString.length; i>0;i--){
            reverseString += auxString[i-1];
        }
        
        return reverseString;
    }
}
