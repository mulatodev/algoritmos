/*
    Based on
    https://www.google.com/url?sa=t&rct=j&q=&esrc=s&source=web&cd=&cad=rja&uact=8&ved=2ahUKEwiD5O_b8PL9AhVtg4QIHdkbAWkQFnoECBAQAQ&url=https%3A%2F%2Fwww.delftstack.com%2Fes%2Fhowto%2Fjava%2Fjava-ascii-to-char%2F&usg=AOvVaw0TidVJkx5N1isIj7gWxbqc
*/
package com.arcadia.samples.security;

import java.util.Random;

/**
 *
 * @author ganaranjo
 */
public class GeneratePassword {

    private final int lBaseUpper = 65;
    private final int uBaseUpper = 90;
    private final int lBaseLower = 97;
    private final int uBaseLower = 122;
    private final int lBaseNumber = 0;
    private final int uBaseNumber = 9;
    private final int uBaseSpecial = 1;
    private final int lBaseSpecial = 2;
    
    private int passwordSize = 0;
    private String password = "";
    
    public GeneratePassword(){
        passwordSize = 8;
    }
    
    public GeneratePassword(int passwordSize){
        this.passwordSize = passwordSize;
    }
    
    public String generatePassword(){
        
        int typeOfSet = 0;
        Random rnd =  new Random();
        
        password = "";
        for(int i=0;i<passwordSize;i++){
            
            typeOfSet = rnd.nextInt(4)+1;

            switch(typeOfSet){
                case 1:{
                    password += Character.toString(rnd.nextInt(uBaseUpper-
                            lBaseUpper-1)+lBaseUpper);
                    break;
                }
                case 2:{
                    password += Character.toString(rnd.nextInt(uBaseLower-
                            lBaseLower-1)+lBaseLower);
                    break;
                }
                case 3:{
                    password += rnd.nextInt(uBaseNumber-
                            lBaseNumber-1)+lBaseNumber;
                    break;
                }
                case 4: {
                    switch((int)(Math.random()*2+1)){
                        case 1:{
                            password += "_";
                        }
                        case 2:{
                            password += ".";
                        }
                    }
                    break;
                }
            }
        }
        
        return password;
    }
    
    /*public String getPassword(){
        return password;
    }*/
}
