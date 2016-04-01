package Assignment2_threads;

import  java.util.*;

public class matrix_multiplication  implements Runnable{

	private int [][] m1 ;
	private  int [][]m2;
	private int [][]R ;
	private  int ros ,cols ;
	
	public void setdim(int r ,int c){
		this.ros=r;
		this.cols=c;
		m1 = new int[ros][cols];
		m2 = new int[ros][cols];
		R = new int[ros][cols];
	}
	public void setmat(int  [][] m1  , int  [][]m2){
		this.m1=m1;
		this.m2=m2;
		System.out.println(m1.length+"\n");
	}
	
	public void run(){
		int sum = 0;
		for(int  i=0 ;i<2 ;i++){
			for(int j=0 ;j<2;j++){
				for(int  k =0 ;k<2;k++)
				sum += m1[i][k]*m2[k][j]  ;
				//System.out.println(sum+"  ");
				R[i][j] = sum;
			}
			System.out.print("\n");
			
		}
		
	}
	public  int[][]  getresult(int  [][] m1  , int  [][]m2){
		this.m1=m1;
		this.m2=m2;
		//System.out.println(m1.length+"\n");
		run();
		return R ;
	}
	
	
	public static void main(String[]args){
		matrix_multiplication m=new matrix_multiplication();
		
		System.out.println("mohammed ali");
		Random rand= new Random();
		
		int  [][] M1 = new int  [2][2] ;
		int  [][] M2 = new int [2][2] ;
		int [][]R = new int [2][2];
		
		for(int  i=0 ;i<2;i++){
 			for(int  j=0 ;j<2 ;j++){
				M1[i][j]  = rand.nextInt(10);
  			}
  		}
		for(int  i=0 ;i<2;i++){
 			for(int  j=0 ;j<2 ;j++){
				M2[i][j]  = rand.nextInt(10);
  				R[i][j] = M1[i][j]+M2[i][j] ;
			}
  		}
		
		m.setdim(2, 2);
		
	 int  [][]result = new  int  [2][2];
	 result = m.getresult(M1 ,M2);
	 System.out.println("m1 = "+Arrays.deepToString(M1));
	 System.out.println("m2 = "+Arrays.deepToString(M2));
	 System.out.println("result = "+Arrays.deepToString(result));
	 
			
	}//end  main
}
