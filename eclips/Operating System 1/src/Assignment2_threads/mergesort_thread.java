package Assignment2_threads;
import  java.util.*;

public class mergesort_thread extends Thread{

int  [] list ;

public mergesort_thread(){}

	public mergesort_thread(int []list) {
		this.list = list ;
 	}
	
	public void  run(){
		mergesort(list);
	}
	
	
	
	public int [] mergesort(int  []list){
		if(list.length<=1)
			return list;
		
		int  []first = new int [list.length/2];
		int []second = new int[list.length-first.length];
		
		System.arraycopy(list, 0, first, 0, first.length);
		System.arraycopy(list, first.length, second, 0, second.length);
		
		mergesort(first);
		mergesort(second);
		
		merge(first , second  , list);
		
		return list ;
	}//merge sort
	
	public void  merge(int []first , int  []second , int []result){
		int  iF=0  , iS =0 , iR=0  ;
		
		while(iF<first.length&&iS<second.length){
			if(first[iF]<second[iS]){
				result[iR]=first[iF];
				iF++;
			}else{
				result[iR]=second[iS];
				iS++;
			}
			iR++;
		}//while
		
		System.arraycopy(first, iF, result, iR, first.length-iF);
		System.arraycopy(second, iS, result, iR, second.length-iS);
		
	}//merge
	
	public static void  main(String []args){
		
 		
		    int  []arr  = {3,4,5,6,7,3,1,2,9,55,1,2,44};
	        
	        Thread []thread = new  mergesort_thread[2];
	        
	        int  []first = new int [arr.length/2];
	        int  []second = new  int [arr.length-first.length];
	        
	        System.arraycopy(arr, 0, first, 0, first.length);
	        System.arraycopy(arr, first.length, second,0, second.length);
	         	        
	        int  []result = new int [arr.length];
 	        
	        thread[0] = new mergesort_thread(first);
	        thread[0].start();
	        thread[1] = new mergesort_thread(second);
	        thread[1].start();
	        
	        boolean finish = false; 
	        while(!finish){
	        	finish=true;
	        	for(int  i=0 ;i<2;i++){
	        		if(thread[i].isAlive())
	        			finish =false;
	        	}
	        }
	        
	        mergesort_thread m = new mergesort_thread() ;
 	        m.merge(first, second, result);
 	         
 	       System.out.print("Sorted Array:\n");
 	        for(int  x:result){
		        System.out.print(x+"  ");
	        }
	}//main
	
}//class
