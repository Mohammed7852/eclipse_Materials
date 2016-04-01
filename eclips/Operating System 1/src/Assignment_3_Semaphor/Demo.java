package Assignment_3_Semaphor;

import java.util.*;

class  Demo{
	
	static  Scanner  cin =new  Scanner(System.in);
 	static Reader_Writer rw = new Reader_Writer();
	
 	public static  void  main(String[]args){
 		int  nr =0 ;
		int nw =0 ;
		
		System.out.print("Enter Nr:");
		nr=cin.nextInt();
 		System.out.print("Enter Nw:");
		nw= cin.nextInt();
		
 		System.out.print("\nEnter Writer words:\n");
 		String  str[] =new String[nw];
  		for(int i=1;i<=nw;i++){
 			System.out.print("T"+(nr+i)+"  :");
  			String  s =cin.next();
			str[i-1]=s;
 		}
  		System.out.print("\n\n");
 		Thread TR[] = new Thread[nr];// = new Reader[nr];
		Thread TW [] =new Thread[nw];
 		int  count = 0 ;
		
 		while(count<(nr+nw)){
			
			if(count<nr){
				 String  T="T"+(count+1);
				 TR[count] = new Reader(T , rw);
				// TR[count].start();
			}
			if(count<nw){
				String  T = "T"+(nr+count+1);
				 TW[count] = new Writer(T,str[count] , rw);
				 //TW[count].start();
			}
			count++;
		}//while
 		
		count=0 ;
		while(count<(nr+nw)){
 			if(count<nr){
 				 TR[count].start();
			}
			if(count<nw){
				 TW[count].start();
			}
			count++;
		}//while
		
		
//		 for(int  i=0;i<nr;i++){
//			 String  T="T"+(i+1);
//			 TR[i] = new Reader(T , rw);
//			 TR[i].start();
//		 }
//		 
//		 for(int  i=0;i<nw;i++){
//			 TW[i] = new Writer("T"+(nr+i+1) ,str[i] , rw);
//			 TW[i].start();
//		 }
	
	}//main
	
}//class