package VectorQuantization;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

 import  java.util.*;

/**
 * @author mohamed ali shabanah
 */

import java.io.IOException;
import  java.util.*;
import java.io.*;

public class Demo2 {

     private  static  Scanner  cin = new Scanner(System.in);
    
 	public static void main(String[] args) throws IOException {
		System.out.println("\tMain");
            		 
		//System.out.println(Integer.toString(5,2));
             
        String  DestinationPath = "C:\\Users\\mohamed ali shabanah\\Desktop\\result2.jpg"; ;
		String  input="input.txt" , output = "output.txt" , dictionary = "Dictionary.txt" ;
 		Reader reader ;
		Writer writer ;
 		BufferedReader  br  ;
		BufferedWriter  bw  ;
		 
		ImageSplitTest is  = new ImageSplitTest();
         int  Highet  , Width  ;
        int  [][]Matrix ;
       
		Decompression decomress  = new  Decompression(output, input  , dictionary  ) ;///***
		decomress.Decompression();
 		int [][] resultmatrix  = decomress.GetMatrix() ;
		//MaxError  MA = new  MaxError(Highet , Width);
		//MA.Caculate_Max_Error(Matrix, resultmatrix);
		
		Highet = decomress.geth();
		Width = decomress.getw();
		//*****
		
 
        /////////////////////////////////
        
        Matrix = decomress.GetMatrix(); 
        
          for(int  i=0 ;i<Highet  ;i++ ){
              for(int j=0 ;j<Width ;j++){
                  System.out.print(Matrix[i][j]+"  ");
               }
              System.out.print("\n");
          } 
         //////////////////////////////////
          
       //int  [][] MaxError = MA.GetMaxError()  ;
        System.out.print("\nError  Matrix  is  ::\n");
        
        for(int  i=0 ;i<Highet ;i++){
            for(int  j=0 ;j<Width ;j++)
            {
               // System.out.print(MaxError[i][j]+"  ");
            }
            System.out.print(" \n");
        }
            // System.out.print("Mean Square  Error : "+MA.Get_MSE()+"\n");
          is.writeImage(Matrix, Width, Highet , DestinationPath);
          
		
    //*****      
          
          
System.out.println("\tfinish");	
        
                
		/*
1 2 7 9 4 11
3 4 6 6 12 12 
4 9 15 14 9 9
10 10 20 18 8 8 
4 3 17 16 1 4 
4 5 18 18 5 6
		 * */
	}//main
}//class

