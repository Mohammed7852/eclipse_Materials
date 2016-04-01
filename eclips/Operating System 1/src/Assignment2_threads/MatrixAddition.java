package Assignment2_threads;

import  java.util.*;
public class MatrixAddition extends Thread{

	private   int ros  , cols  ;
	private  int  [][]Matrix1 ;
	private  int [][]Matrix2 ;
	private  int [][]RMatrix  ;
	
	public MatrixAddition(int ros  , int  cols  , int  [][]first , int [][]second  , int[][]  result){
		this.ros=ros  ;
		this.cols=cols  ;
		this.Matrix1=first ;
		this.Matrix2 =second  ;
		this.RMatrix = result ;
	}//constructor
	public void  run(){
		for(int  i=0 ;i<ros  ;i++){
			RMatrix[i][cols]=Matrix1[i][cols]+Matrix2[i][cols];
		}
	}//run
	
	public static void  main(String []args){
		
		Random rand  = new  Random();
		int  [][]m1=new  int  [3][3] ;
		int  [][]m2 = new  int  [3][3]  ;
		int  [][] R = new  int  [3][3] ;
		for(int  i=0 ;i<3;i++){
			for(int  j=0;j<3;j++){
				m1[i][j] =rand.nextInt(20);
			}
		}
		for(int  i=0 ;i<3;i++){
			for(int  j=0;j<3;j++){
				m2[i][j] =rand.nextInt(20);
			}
		}
		System.out.println("m1="+Arrays.deepToString(m1));
		System.out.println("m2="+Arrays.deepToString(m2));
		
		
		Thread [] thread = new  MatrixAddition[3];
		
		for(int i=0;i<3;i++){
			thread[i]=new MatrixAddition(3 , i , m1  ,m2  ,R );
			thread[i].start();
		}
		boolean finished = false  ;
		
		while(!finished){
			finished  = true  ;
			
			for( int  i=0 ;i<3 ;i++){
				if(thread[i].isAlive()){
					finished =false;
				}
			}
		}
		
		System.out.println("R="+Arrays.deepToString(R));
 	}//main
	
}
