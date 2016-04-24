/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package multimedia.VectorQuantization;
import  java.util.*;

/**
 * @author mohamed ali shabanah
 */

import java.io.IOException;
import  java.util.*;


public class ForTrying {
    
    private  static  Scanner  cin = new Scanner(System.in);
    
 	public static void main(String[] args) throws IOException {
		System.out.println("\tMain");
                
                System.out.print("\n");
            		 System.out.print((int)Math.ceil(Math.log10(25)/Math.log10(2))+"\n");
               
 		
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
  		
                DevideImages Av = new DevideImages();
		Av.SetMatrix(M1, Highet, Width, vhighet, vwidth, num_c_B);
		Av.Devide();
                int  [][] MaxError = Av.GetMaxError()  ;
                System.out.print("\nError  Matrix  is  ::\n");
                
                for(int  i=0 ;i<Highet ;i++){
                    for(int  j=0 ;j<Width ;j++)
                    {
                        System.out.print(MaxError[i][j]+"  ");
                    }
                    System.out.print(" \n");
                }
                     System.out.print("Mean Square  Error : "+Av.Get_MSE()+"\n");
               //M1 =  Av.GetMAtrix();
               // is.writeImage(Matrix, Width,6 6 Highet);
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

