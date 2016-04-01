/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package VectorQuantization;
import  java.util.*;

/**
 * @author mohamed ali shabanah
 */

import java.io.IOException;
import  java.util.*;
import java.io.*;

public class Demo {

     private  static  Scanner  cin = new Scanner(System.in);
    
 	public static void main(String[] args) throws IOException {
		System.out.println("\tMain");
            		 
		//System.out.println(Integer.toString(5,2));
             
		String  input="input.txt" , output = "output.txt" , dictionary = "Dictionary.txt" ;
 		Reader reader ;
		Writer writer ;
 		BufferedReader  br  ;
		BufferedWriter  bw  ;
		
		ImageSplitTest is  = new ImageSplitTest();
        
		String  SourcePath = "C:\\Users\\mohamed ali shabanah\\Desktop\\temp8.jpg" ;
        String  DestinationPath = "C:\\Users\\mohamed ali shabanah\\Desktop\\lap.jpg"; ;
        
        is.SplitTo2DArray(SourcePath);
        int  Highet = is.gethighet(), Width  = is.getwidth() ;
        int  [][]Matrix  = is.GetMatrix();//-----
       
        System.out.println("Highet="+Highet+"  , width ="+Width+"\n");
 		
        System.out.println("Enter Vector Dimensions (Highet & Width):");
 		int vhighet , vwidth  ;
		vhighet =cin.nextInt() ;
		vwidth = cin.nextInt();
		System.out.println("Enter number of CodeBook:");
		int  num_c_B= cin.nextInt();
 		//------
		
        CompressionClass Av = new CompressionClass();
		Av.SetMatrix(Matrix, Highet, Width, vhighet, vwidth, num_c_B , input  , dictionary);
		Av.Devide();
		
		//*****
		
 		writer  = new  FileWriter(output);
		bw  = new  BufferedWriter(writer);
		bw.write(Highet+"|"+Width+"|"+vhighet+"|"+vwidth+"|"+num_c_B+"|");
		bw.close(); 
		
		Decompression decomress  = new  Decompression(output, input  , dictionary  ) ;///***
		decomress.Decompression();
 		int [][] resultmatrix  = decomress.GetMatrix() ;
		MaxError  MA = new  MaxError(Highet , Width);
		MA.Caculate_Max_Error(Matrix, resultmatrix);
			
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

