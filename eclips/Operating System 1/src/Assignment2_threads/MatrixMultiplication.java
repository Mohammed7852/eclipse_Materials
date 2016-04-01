package Assignment2_threads;

import java.util.*;

public class MatrixMultiplication extends  Thread{
	
	private  int  i , j , n ;
	private  int  [][]M1 ; 
	private  int  [][]M2 ;
	private  int  [][]R ; 
	
	public MatrixMultiplication(int i , int  j , int  n , int  [][]m1 ,  int  [][]m2 , int  [][]r) {
		this.i=i;
		this.j=j;
		this.n=n;
		this.M1=m1;
		this.M2=m2  ;
		this.R=r ;
 	}
	
	public void run(){
		for(int k=0 ;k<n ;k++){
			R[i][j]+= M1[i][k]*M2[k][j];
		}
	}//run

	public static void  main(String []args){
		Scanner cin = new Scanner(System.in);
		Random rand = new Random();
		
		int r1 ,r2 ,c1 ,c2 , rr ,rc ;
		
		System.out.println("Enter  ro1 , col1  , r2  , col2  ::");
		 
		 r1=cin.nextInt();
		 c1=cin.nextInt();
		 r2=cin.nextInt();
		 c2=cin.nextInt();
		 
		 rr=r1 ;
		 rc=c2 ;
		 
		if(c1!=r2){
			 System.out.println("cannot  be multiplied.\n\n");;
			 return ;
		 }
		
		int num_threads= rr*rc ;
		
		int [][]m1= new int  [r1][c1] ; 
		int  [][]m2 = new int  [r2][c2] ;
		int  [][]Result = new int [rr][rc];
		
		System.out.print("Enter the  First Matrix :: \n");
		for(int  i=0;i<r1;i++){
			for(int  j=0 ;j<c1 ;j++){
				m1[i][j] =cin.nextInt();
				//System.out.print(m1[i][j]+"  ");
			}
			//System.out.println();
		}
		
		System.out.print("Enter the  Second Matrix :: \n");
		for(int  i=0;i<r2;i++){
			for(int  j=0 ;j<c2 ;j++){
				m2[i][j] = cin.nextInt();
 			}
			//System.out.println();
		}
		
		System.out.println("\n");
	 
		int count = 0 ;
		
		Thread  thread  [] = new MatrixMultiplication[num_threads];
		
		for(int  i=0 ; i<rr ; i++){
			for(int  j=0 ; j<rc ; j++){
 				thread[count] = new MatrixMultiplication(i, j, c1, m1, m2, Result);
				thread[count++].start();
			}
		}
		
 		boolean finish = false ;
 		
 		while(!finish){
			finish = true  ;
			
			for(int  i=0 ; i<num_threads ;i++){
				if(thread[i].isAlive())
					finish =false;
			}
		}
 		
 		System.out.println("num threads = "+num_threads+"\n\n\tResult = \n");
		
 		for(int  i=0;i<rr;i++){
			for(int  j=0 ;j<rc ;j++){
				System.out.print(Result[i][j]+" ");
			}
			System.out.println();
		}
		
		
		//System.out.println("Result="+Arrays.deepToString(Result));
	}//main
}
