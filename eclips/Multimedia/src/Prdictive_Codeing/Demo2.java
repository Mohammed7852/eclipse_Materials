package Prdictive_Codeing;

import  java.io.*;
import  java.util.*;

public class Demo2 {
	static  Scanner cin = new  Scanner(System.in);
	
	public static void  main(String  []args) throws IOException{
  		
		String  pathin ="C:\\Users\\mohamed ali shabanah\\Desktop\\3.jpg";
		String pathout ="C:\\Users\\mohamed ali shabanah\\Desktop\\3result.jpg";
		
		Split_Write_Image Split  =new Split_Write_Image(pathin);
 		
		int  [][] Matrix  = Split.getmatrix();
		
		int highet =Split.gethighet();
		int width = Split.getwidth();
		
		System.out.println("matrix  is ::\n");
		for(int i=0 ;i<highet ;i++){
			for(int j=0 ;j<width ;j++){
				System.out.print(Matrix[i][j]+"  ");
			}
			System.out.println();
		}
		
		int  step ; 
		int  quantizer_type;
		
		System.out.println("\nh="+highet+"   w="+width+""+"\nEnter type  of quantizer :");
		
		
//		step = cin.nextInt() ;
		quantizer_type = cin.nextInt();

		
		Compression_class compress  = new  Compression_class(quantizer_type);
		compress.setmatrix(Matrix, width, highet);
		String  first="first.txt" , second  = "second.txt" , third = "third.txt" ;
		
 		Decompression_class decompress  = new Decompression_class(first ,second  ,third);
		
 		Split.writeImage(decompress.getmatrix(), width, highet, pathout);
 		decompress.ErrorMatrix(Matrix, decompress.getmatrix(), highet, width);

		
		System.out.println("Finish\n");
		 
	}
}
