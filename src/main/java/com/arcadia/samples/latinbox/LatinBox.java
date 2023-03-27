package com.arcadia.samples.latinbox;

/**
 *
 * @author ganaranjo
 */
public class LatinBox {
    
    private int latinBoxSize = 0;
    private final int[] latinBoxNumbers;
    
    public LatinBox(int size){
        
        latinBoxSize = size;
        latinBoxNumbers = new int[latinBoxSize];
    }
    
    public void RunLatinBox(){
        
        String latinBoxRow = "";
        
        for(int k=0; k<latinBoxSize; k++){
            latinBoxNumbers[k] = k+1;
        }
        
        for(int i=0; i<latinBoxSize; i++){
           for(int j=0; j<latinBoxSize; j++){
               latinBoxRow += latinBoxNumbers[j] + " ";
           }
           System.out.println(latinBoxRow);
           
           latinBoxRow = "";
           
           RotateLatinBoxRow();
        }
    }
    
    private void RotateLatinBoxRow(){
        
        int pivotNumber = latinBoxNumbers[latinBoxSize-1];
        
        for(int i=latinBoxSize-1;i>0; i--){
            latinBoxNumbers[i] = latinBoxNumbers[i-1];
        }
        latinBoxNumbers[0] = pivotNumber;
    }
}
