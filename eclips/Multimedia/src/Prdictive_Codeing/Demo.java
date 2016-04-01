package Prdictive_Codeing;

import java.io.IOException;
import  java.util.*;

public class Demo {

	static Scanner cin = new Scanner(System.in);
	public static void main(String[] args) throws IOException{

 
		int  step ; 
		int  quantizer_type;
		
		int  width , highet ;
		System.out.println("Enter width and  highet :");
		width = cin.nextInt();
		highet = cin.nextInt();
		
		int  [][]matrix  = new int  [highet][width];
		System.out.println("Enter Image :");
		for(int  i=0 ;i<highet ;i++){
			for(int  j=0 ;j<width ;j++){
				matrix[i][j] = cin.nextInt();
			}
		}
		
		System.out.println("Enter type  of quantizer  :");
		quantizer_type = cin.nextInt();
//		step = cin.nextInt() ;
		
		Compression_class compress  = new  Compression_class( quantizer_type);
 
		
		compress.setmatrix(matrix, width, highet);
		//System.out.println("your  matrix  is :");
		String  first="first.txt" , second  = "second.txt" , third = "third.txt" ;

		Decompression_class decompress  = new Decompression_class(first ,second  ,third);
 		decompress.ErrorMatrix(matrix, decompress.getmatrix(), highet, width);
		
 		
 		System.out.println("Finish\n");
/*
 
 5 7 8 10 
 6 6 9 11
 7 8 11 13
 9 10 11 14
 
 
 
 */
	}//main
}//class
