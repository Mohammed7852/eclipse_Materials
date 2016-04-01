package Assignment_4;

import  java.util.*;

import javax.xml.ws.Response;

public class RoundRobin extends Times{

	int  timeQuantum = 0 ;
	
public RoundRobin(int size , int  TQ , String[] names, int  [] arrivals , int  []bursts) {
		
		Number_of_processes = size;
		ArrivalTimes = new int [Number_of_processes];
		BurstTimes = new int  [Number_of_processes];
		Processe_Names = new String[Number_of_processes];
		ArrivalTimes = arrivals ;
		BurstTimes = bursts ;
		Processe_Names = names;
		firsttime = new int [Number_of_processes];
		lasttime = new  int [Number_of_processes];
		waiting = new  int  [Number_of_processes];
		timeQuantum = TQ;
		ResponceTimes = new  int [Number_of_processes];
		
		System.out.println("----------------------------------original----------------------------------\n");
		print();
		SortByArrivals();
		
		System.out.println("----------------------------------Sorted By Arrivals----------------------------------\n");
		print();
 		Calculate();
 	}

//
public  boolean check(){
	boolean temp = true;
	
	for(int  i :BurstTimes){
		if(i>0){//counter example
			temp  =false;
			break;
		}
	}
	
	return temp ;
}
private List<Integer> indexlist ;
public void getindex(){
     indexlist = new ArrayList();
     for(int i=0 ;i<Number_of_processes ;i++){
    	 if(BurstTimes[i]>0){
    		 indexlist.add(i);
    	 }
     }
}
public void  Calculate(){
  	int  first = ArrivalTimes[0], last  =0;
	int  s , e  ;
	int  count =0;
	
	while(true){
		getindex();
 		//count =0;
		//first = ArrivalTimes[count];
 		
		for(int index=0 ;index<indexlist.size();index++){
			int  i  =indexlist.get(index);
			int x  = BurstTimes[i];
			int  y=0 ;
			if(x>=timeQuantum){
				last  = first +timeQuantum ;
				y= timeQuantum;
			}
			else{
				last = first +x;
				y=x;
			}
			BurstTimes[i]-=y;
			if(BurstTimes[i]>=0&&y>0)
			System.out.println("process :"+Processe_Names[i]+"  start="+first+"   end="+last);
			
			waiting[i] +=new Integer(first-ArrivalTimes[i]); 
   			
   			if(count==0){
 				ResponceTimes[i] = first;
 			}
   			first = last ;
 			ArrivalTimes[i]=new  Integer(first);
 			
			//count ++;
 		}
		count++ ;
		if(count==0){
			for(int i :ArrivalTimes){
				//ResponceTimes[count++]=i;
			}
		}
//		System.out.println("burst times  now ::");
//		for(int  b :BurstTimes){
//			System.out.print(b+" , ");
//		}
		
		
		if(check()){
			break;
		}

	}//while true

	int sum1 = 0 , sum2 = 0 ;
	
	System.out.println("waiting times  now ::");
	for(int  i=0  ;i<Number_of_processes ;i++){
		System.out.println(Processe_Names[i]+ "  waits for  "+waiting[i]);
		sum1+=waiting[i];
		}
	
	System.out.println("Response times  now ::");
	for(int  i=0  ;i<Number_of_processes ;i++){
		System.out.println(Processe_Names[i]+ "  response  is "+ResponceTimes[i]);
		sum2+= ResponceTimes[i];
		}
	
	System.out.println("Average waiting Time is :"+(float)(sum1/Number_of_processes)+""
			+ "\nAverage Response Time is :"+(float)(sum2/Number_of_processes)+"\n");
	
}

//
public void SortByArrivals(){
	
	for(int  i=0 ;i<Number_of_processes ;i++){
		int  min = i ;
		for(int  j=i+1 ;j<Number_of_processes ;j++){
			if(ArrivalTimes[j]<ArrivalTimes[min]){
				min= j;
			}
		}
		int  swap1 =ArrivalTimes[min], swap2 = BurstTimes[min] ;
		String  temp  = Processe_Names[min] ;
		ArrivalTimes[min] = ArrivalTimes[i];
		ArrivalTimes[i]=swap1 ;
		
		Processe_Names[min] = Processe_Names[i];
		Processe_Names[i]=temp;
		
		BurstTimes[min] = BurstTimes[i];
		BurstTimes[i]= swap2 ;
	}
	
	//print();
}//
//
public void print(){
		for(int  i=0 ;i<Number_of_processes ;i++){
		System.out.println(Processe_Names[i]+"   "+ArrivalTimes[i]+"    "+BurstTimes[i]+"");
	}
}

}
