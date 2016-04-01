package Prdictive_Codeing;

import  java.util.*;
import java.io.*;
import javax.print.attribute.standard.PresentationDirection;;

public   class Compression_class {

	private  int  type  , step , width , highet  ,size , w2 ,h2;
	
	int  [][]origina_matrix  ;
	int  [][]predicted_matrix  ;
	int  [][]diff_matrix  ;
	int  [][]quantized_matrix  ;
	private  int  minimum  , maximum ;
	
	private  List<Integer> l1 = new ArrayList();
	private  List<Integer> l2  = new  ArrayList();
	private  List<Integer> LQ  = new  ArrayList();
	
	private  List<Integer> [] lists  = new  ArrayList[4];// 0 Q 1 lower  2 upper  3 Q-1 
	
	
	public Compression_class( int  type) {
		 //this.step = s ;
		 this.type = type;
		 
		 int  x = (int) Math.pow( 2 , type);
		 this.size = x  ;
		 
		 for(int  i=0 ;i<4 ;i++){
			 lists[i] = new  ArrayList();
		 }
		// Quantizer();
 	}//
	
	public void  setmatrix (int  [][]matrix , int w , int  h) throws IOException{
 		this.width=w;
		this.highet=h ;
		w2 = width-1 ;
		h2 = highet-1;
		origina_matrix =matrix ;
		diff_matrix = new  int  [h2][w2];
		quantized_matrix = new  int  [h2][w2];
		predicted_matrix = new  int  [h2][w2];
		
	    getpredicted();
	    getdifference();
	    Quantizer();
	    getQuantizedDifference();
	    WriteToFile();
	    
	}//set matrix
	
	public void  WriteToFile() throws IOException{
		
		Writer w  = new  FileWriter("first.txt");
		BufferedWriter bw  = new BufferedWriter(w);
		bw.write(LQ.toString());
		bw.close();
		
		w = new FileWriter("second.txt");
		bw  = new BufferedWriter(w);
		
		for(List<Integer> l :lists){
			bw.write(l.toString()+"\n");
		}
		bw.close();
		
		for(int  i=0 ;i<1;i++){
			for(int j=0 ;j<width;j++){
				int  x = origina_matrix[i][j] ;
				int  y  = origina_matrix[j][i];
				l1.add(x);
				l2.add(y);
			}
		}
		
		w = new FileWriter("third.txt") ;
		bw = new   BufferedWriter(w);
		bw.write(highet+"|"+width+"|"+size+"|\n"+l1.toString()+"\n"+l2.toString());
		bw.close();
		
	}//
	
	
	
	public void getQuantizedDifference(){
		for(int i=0 ;i<h2 ;i++){
			for(int  j=0 ;j<w2 ;j++){
				int  x  = diff_matrix[i][j] ;
				int index = 0 ;
				for(int  n=0 ;n<size ;n++){
					if(x<=lists[2].get(n))
						{
							index =n;
							break ;
						}
 				}//for  n
				
				quantized_matrix[i][j]=index ;
				
			}
		}//for  i
		
		System.out.println("Quantized  is  ::\n");
		for(int i=0 ;i<h2 ;i++){
			for(int  j= 0 ;j<w2 ;j++){
				LQ.add(quantized_matrix[i][j]);
				System.out.print(quantized_matrix[i][j]+"  ");
			}
			System.out.println();
		}
		
		
	}
	
	public void getdifference(){
 		int  m = 0 ;
		for(int i=1 ;i<highet ;i++){
			for(int  j=1 ;j<width ;j++){
				diff_matrix[i-1][j-1] = origina_matrix[i][j] - predicted_matrix[i-1][j-1];
				if(origina_matrix[i][j] - predicted_matrix[i-1][j-1] <m){
					m=origina_matrix[i][j] - predicted_matrix[i-1][j-1];
				}
						
			}
		}//for  i
		
		//minimum = m;
		System.out.println("\n\tdiffernce   is  ::\n");
		for(int i=0 ;i<h2 ;i++){
			for(int  j= 0 ;j<w2 ;j++){
				System.out.print(diff_matrix[i][j]+"  ");
				if(diff_matrix[i][j]<minimum){
					minimum=diff_matrix[i][j];
				}
			}
			System.out.println();
		}
		
		
	}
	
	public void  getpredicted(){
 		for(int  i=1 ;i<highet ;i++){
			for(int  j=1 ;j<width;j++){
				int B = origina_matrix[i-1][j-1] ;
				int C = origina_matrix[i-1][j];
				int A =origina_matrix[i][j-1];
				int  R = (A+C-B);
				int  min = Math.min(A, C);
				int  max = Math.max(A, C);
			
 				if(B <=min){
					R = max;
				}else  if(B>=max){
					R = min ;
				}
				
 				predicted_matrix[i-1][j-1] = R ;
 			}
			
		}//for  i
		
		System.out.println("predictive  is  ::\n");
		for(int i=0 ;i<h2 ;i++){
			for(int  j= 0 ;j<w2 ;j++){
				System.out.print(predicted_matrix[i][j]+"  ");
			}
			System.out.println();
		}
   	}//end  predictive 
	
	
	public void  getminandmax(){
		
		minimum = 0;
	    maximum = new Integer(minimum) ;
	    
	    for(int i=0 ;i<h2 ;i++){
	    	for(int j=0 ;j<w2 ;j++){
	    		int x =diff_matrix[i][j] ;
	    		if(x<minimum){
	    			minimum= new  Integer(x);
	    		}
	    		if(x>maximum){
	    			maximum= new Integer(x);
	    		}
	    	}
	    }
	    
	 
	}
	
	public void Quantizer(){
		getminandmax();
		int x  = Math.abs(maximum);
		int y =Math.abs(minimum);
		
		step = (x+y)/size;
		int  start =minimum;
		 
		System.out.println("min="+minimum+"  ,max="+maximum+"  ,step ="+step+"\n\n");
		int  c =0 ;
		
		for(int  i=0 ;  i<size ; i++){
			int  end  = start+step ;
			   lists[c++].add(i);
			   lists[c++].add(start);
			   lists[c++].add(start+step) ;
			   lists[c++].add((start+end)/2);
			   c=0 ;
			   start = end +1 ;
			  
		}//for  i
		
		System.out.println("Quantizer is ::\n");
		for(List<Integer> l :lists){
			System.out.println(l);
		}
		
		
	}//
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}//class 
