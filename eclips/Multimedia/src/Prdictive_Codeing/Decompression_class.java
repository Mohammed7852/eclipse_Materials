package Prdictive_Codeing;

import  java.io.*;
import  java.util.*;

public class Decompression_class {

	private  int  width , highet  ,size  , step  ,w2 ,h2;
	private  List<Integer>[]listsOfQuantization;
	
	private int  [][]dequantized_matrix  ;
	private int  [][]decoded_matrix  ;
	private int  [][]quantized_matrix  ;
	
	
	private List<Integer>Qlist  = new ArrayList();
	private List<Integer> l1 = new ArrayList();
	private  List<Integer> l2  = new  ArrayList();
	String  first , second  ,third ;
	
	public Decompression_class(String  first , String  second  , String  third ) throws IOException {
		System.out.println("\tDecompression\n");
		this.first =first ;
		this.second =second  ;
		this.third =third ;
		
		ReadFiles();
		Reconstruct();
 	}//
	
	public int [][] getmatrix (){
		return decoded_matrix;
	}
	
	public void Reconstruct(){
		w2 =width-1 ;
		h2 =highet-1;
		
		quantized_matrix = new int [h2][w2];
		dequantized_matrix = new  int [h2][w2];
		decoded_matrix = new  int [highet][width];
		
		int c =0 ;
		for(int  i=0 ;i<h2 ;i++){
			for(int j=0 ;j<w2 ;j++){
				quantized_matrix[i][j]=Qlist.get(c++);
			}
		}
 		System.out.println("Quantized diff =\n");
		for(int  i=0 ;i<h2 ;i++){
			for(int j=0 ;j<w2 ;j++){
				System.out.print(quantized_matrix[i][j]+"  ");
			}
			System.out.println();
		}
		//////////////
		c= 0 ;
		for(int i=0 ;i<1 ;i++){
			for(int  j=0 ;j<width ;j++){
				int x =l1.get(c);
				int y =l2.get(c++);
				decoded_matrix[i][j] = x;
				decoded_matrix[j][i] =y;
			}
		}
		
		System.out.println("decoded image =\n");
		for(int  i=0 ;i<highet ;i++){
			for(int j=0 ;j<width ;j++){
				System.out.print(decoded_matrix[i][j]+"  ");
			}
			System.out.println();
		}
		
		/////////////////
		
		for(int  i=0 ;i<h2;i++){
			for(int j=0;j<w2;j++){
				int x = quantized_matrix[i][j] ;
				int  index = listsOfQuantization[0].indexOf(x);
				int y =listsOfQuantization[3].get(index);
				dequantized_matrix[i][j] =y;
			}
		}
		
		System.out.println("dequantized is =\n");
		for(int  i=0 ;i<h2 ;i++){
			for(int j=0 ;j<w2 ;j++){
				System.out.print(dequantized_matrix[i][j]+"  ");
			}
			System.out.println();
		}
		
		////////////Final Image 
		for(int i=1 ;i<highet ;i++){
			for(int j=1 ;j<width ;j++){
				 int  B =decoded_matrix[i-1][j-1];
				 int A =decoded_matrix[i][j-1];
				 int C =decoded_matrix[i-1][j];
				 int R = (A+C-B);
				 
				 int  min =Math.min(A, C);
				 int  max =Math.max(A, C);
				 
				 if(B<=min){
					 R=max;
				 }else if(B>=max){
					 R =min;
				 }
 				 int res = R +dequantized_matrix[i-1][j-1];
				 decoded_matrix[i][j] =res;
 			}
		}//for i
		
		System.out.println("decoded image =\n");
		for(int  i=0 ;i<highet ;i++){
			for(int j=0 ;j<width ;j++){
				System.out.print(decoded_matrix[i][j]+"  ");
			}
			System.out.println();
		}
		
		/////////////
	}//
	
	public void  ReadFiles() throws IOException{
		
		Reader  r = new  FileReader(first);
		BufferedReader br  = new BufferedReader(r);
		String  str1  = br.readLine();
		br.close();
		str1=str1.replaceAll("\\s", "");
		//System.out.println("from first ::string="+str1+"\n");

		String temp = "";
		
		for(int  i= 1 ; i<str1.length() ;i++){
			char ch = str1.charAt(i);
			
			if(ch!=','&&ch!=']'){
				temp+=ch;
			}else  
			{
			  Qlist.add(Integer.parseInt(temp));
			  temp="";
			}
			
		}
		//System.out.println("Q="+Qlist+"\n\n");
		
		r = new FileReader("third.txt") ;
		br = new BufferedReader(r);
		
		 str1 = br.readLine() ;
		 str1 = str1.replaceAll("\\s", "");
			//System.out.println("from third  string="+str1+"\n");
			
			int  index ;
		 temp ="";
		 int count =0 ;
			for( char ch :str1.toCharArray()){
 				if(ch!='|'){
					temp+=ch;
				}else  if(ch=='|'){
					if(count==0)
						highet =Integer.parseInt(temp);
					else if(count==1){
						width =Integer.parseInt(temp);
					}else if(count==2){
						size =Integer.parseInt(temp);
					}
					count++;
 					temp="";
				}
			}
			
		 
		 System.out.println("w="+width+"  h="+highet+"  size="+size+"\n\n");
		 
		 ///////////
		 str1 = br.readLine();
		 str1 = str1.replaceAll("\\s", "");
 		 temp="";
		 for(int i=1 ;i<str1.length();i++){
			 char ch = str1.charAt(i);
			 
			 if(ch!=','&&ch!=']'){
				 temp+=ch;
			 }else{
				 l1.add(Integer.parseInt(temp));
				 temp="";
			 }
		 }
		 
		 //////////
		 str1 = br.readLine();
		 br.close();
		 
		 str1 =str1 .replaceAll("\\s", "");
 		 temp="";
		 for(int i=1 ;i<str1.length();i++){
			 char ch = str1.charAt(i);
			 
			 if(ch!=','&&ch!=']'){
				 temp+=ch;
			 }else{
				 l2.add(Integer.parseInt(temp));
				 temp="";
			 }
		 }
		 
		// System.out.println("l1="+l1+"\nl2="+l2+"\n\n");
 	
		 
		 ////////////
		 r =new  FileReader("second.txt");
		 br =new BufferedReader(r);
		 
		 
		 listsOfQuantization = new  ArrayList[size];
		 for(int  i=0 ;i<size;i++){
			 listsOfQuantization[i] = new  ArrayList();
		 }
		 
		 int c =0;
		 while((str1=br.readLine())!=null){
			 str1 =str1.replaceAll("\\s", "");
			 
			 temp ="";
			 for(int  i=1 ;i<str1.length();i++){
				 char ch =str1.charAt(i);
				 if(ch!=','&&ch!=']'){
					 temp+=ch;
				 }else{
					 listsOfQuantization[c].add(Integer.parseInt(temp));
					 temp="";
				 }
			 }//for i
			 c++;
			 
   		 }//while
		 
		 System.out.println("Quantizer is ::\n");
		 for(List<Integer> l :listsOfQuantization){
			 System.out.println(l);
		 } 
		 
	}//
	
	public void ErrorMatrix(int  [][] Original , int  [][] decoded , int h , int w){
		
		int  count =0 ;
		int sum = 0 ;
		int  error [][] = new int [h][w];
		
		for(int i=0 ;i<h ;i++){
			for( int  j=0 ;j<w ;j++){
				count ++  ;
 				error[i][j] = Math.abs((Original[i][j]-decoded[i][j]));
 				sum+=error[i][j];
			}
		}
		
		
		System.out.println("Error image =\n");
		for(int  i=0 ;i<h ;i++){
			for(int j=0 ;j<w ;j++){
				System.out.print(error[i][j]+"  ");
			}
			System.out.println();
		}
		
		System.out.println("Average Error is ::"+(float)(sum/count));
		
	}//
	
	
	
	
}//class 
