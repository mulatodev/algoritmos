package com.arcadia.samples.security;

/**
 *
 * @author ganaranjo
 */
public class Password {
    
    private String password;
    private boolean strong = false;
    
    public Password(){
    }
      
    public void setPassword(String password){
        this.password = password;
    }
    
    public boolean isStrong(){
        /*
            Debe validar al minimo 8 caracteres
            Al menos 2 letras mayusculas, 2 minusculas, 1 digito y 
            un punto o guion bajo
        */
        
        byte lowerLetterTokens = 2;
        byte upperLetterTokens = 2;
        byte numberTokens = 1;
        boolean specialCharacter = true;
        
        for(int i=0;i<password.length();i++){
            
            if(Character.isUpperCase(password.charAt(i))){
                if(upperLetterTokens>0){
                    upperLetterTokens--;
                }
            } else if(Character.isLowerCase(password.charAt(i))) {
                if(lowerLetterTokens>0){
                    lowerLetterTokens--;
                }
            } else if(Character.isDigit(password.charAt(i))) {
                if(numberTokens>0){
                    numberTokens--;
                }
            } else if(password.charAt(i) == '_' || password.charAt(i) == '.'){
                if(specialCharacter){
                    specialCharacter = false;
                }
            }
        }
        
        if(upperLetterTokens == 0 && lowerLetterTokens == 0 
                && numberTokens == 0 && specialCharacter ==  false){
                strong = true;
        } else {
            strong = false;
        }
        
        return strong;
    }
    
}
