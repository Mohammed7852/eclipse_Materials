package Assignment_4;

import java.util.jar.Attributes.Name;

public class FCFS extends Times {

	
	
	//*****
	public FCFS(int size  , String[] names, int  [] arrivals , int  []bursts) {
		
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
		ResponceTimes = new  int  [Number_of_processes];
		
		System.out.println("----------------------------------original----------------------------------\n");
		print();
		System.out.println("----------------------------------Sorted By Arrivals----------------------------------\n");
		SortByArrivals();
		print();
		calculate_time();
 	}//
	
	/////////////////////////////
	
	
	public void  calculate_time(){
		
		int  first=ArrivalTimes[0]  , last =0;
		int count =0 ;
		
		while(count <Number_of_processes){
		last = first +BurstTimes[count];
		waiting[count] = first-ArrivalTimes[count];
		System.out.println("process :"+Processe_Names[count]+" start ="+first + "  , end  ="+last);
		first = last ;
		count++ ;
		
		if(count<Number_of_processes&&first<ArrivalTimes[count]){
			first = ArrivalTimes[count];
		}
			
		}//while
		int  sum = 0 ;
		ResponceTimes = waiting ;
		System.out.println("waiting  time  ::\n");
		for(int  i=0 ;i<Number_of_processes ;i++){
			sum +=waiting[i];
			System.out.println(Processe_Names[i]+ "  waits  for "+waiting[i]);
		}
		System.out.println("Response times  now ::");
		for(int  i=0  ;i<Number_of_processes ;i++){
			System.out.println(Processe_Names[i]+ "  response  is "+ResponceTimes[i]);
 		}
		
		float res  = (float)sum /Number_of_processes ;
		System.out.println("average  (waitin and  response) time ="+res+"\n");
	}
	
	
	
	/////////////////////////////
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
		
	//	print();
	}//
	
	////////////////////
	public void print(){
		System.out.println("----------------------------------they are  as----------------------------------\n");
		for(int  i=0 ;i<Number_of_processes ;i++){
			System.out.println(Processe_Names[i]+"   "+ArrivalTimes[i]+"    "+BurstTimes[i]+"");
		}
	}
	//*******
	
	public void  Set_Attributes(){
		
	}//
	
	
	
	
	
}//class
