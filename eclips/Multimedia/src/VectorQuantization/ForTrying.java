/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package VectorQuantization;
import  java.util.*;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

/**
 * @author mohamed ali shabanah
 */

import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import  java.util.*;


public class ForTrying {
    
    private  static  Scanner  cin = new Scanner(System.in);
    
 	public static void main(String[] args) throws IOException {
 		float x =30/36;
		System.out.println("\tMain\n"+(x));
                 
		String  input="input.txt" , output = "output.txt" , dictionary = "Dictionary.txt" ;
 
  		Reader reader ;
		Writer writer  ;
 		BufferedReader  br  ;
		BufferedWriter  bw  ;

		//----------

		System.out.println("Enter  Image Dimensions ::");
		int  Highet  , Width   ;
		Width = cin.nextInt();
		Highet = cin.nextInt();
                
                 
                
 		int M1[][] = new  int  [Highet][Width] ;
 		//Enter Matrix1
 		System.out.print("Enter the  Image  ::\n");
  		
 		for(int  i= 0 ;i<Highet;i++)
			for(int  j=0;j<Width;j++)
				M1[i][j] = cin.nextInt();
  		
         System.out.println("Highet="+Highet+"  , width ="+Width+"\n");
 		
         System.out.println("Enter Vector Dimensions (Highet  & Width ):");
		int vhighet , vwidth  ;
		vhighet =cin.nextInt() ;
		vwidth = cin.nextInt();
 		System.out.println("Enter number of CodeBook:");
		int  num_c_B= cin.nextInt();
                
 		//------
  		
		 CompressionClass Av = new CompressionClass();	
		 Av.SetMatrix(M1, Highet, Width, vhighet, vwidth, num_c_B , input , dictionary);
		 Av.Devide();
      
		 //*****
 			writer  = new  FileWriter(output);
			bw  = new  BufferedWriter(writer);
			bw.write(Highet+"|"+Width+"|"+vhighet+"|"+vwidth+"|"+num_c_B+"|");
			bw.close(); 
			
			Decompression decomress  = new  Decompression(output, input  , dictionary  ) ;
			decomress.Decompression();
			
 			int [][] resultmatrix  = decomress.GetMatrix() ;
 			MaxError  MA = new  MaxError(Highet , Width);
 			MA.Caculate_Max_Error(M1, resultmatrix);
 			
 			
	   //*****		
		 
		 
		 
		int  [][] MaxError = MA.GetMaxError()  ;
		
        System.out.print("\nError  Matrix  is  ::\n");
        
        for(int  i=0 ;i<Highet ;i++){
            for(int  j=0 ;j<Width ;j++)
            {
                System.out.print(MaxError[i][j]+"  ");
            }
            System.out.print(" \n");
        }
        
            System.out.print("Mean Square  Error : "+MA.Get_MSE()+"\n");
       
        //is.writeImage(Matrix, Width,6 6 Highet);
 		
        
        
        System.out.println("\tfinish");	
                
                
	/*	
1 2 7 9 4 11
3 4 6 6 12 12 
4 9 15 14 9 9
10 10 20 18 8 8 
4 3 17 16 1 4 
4 5 18 18 5 6 
		 */
	}//main
}//class

