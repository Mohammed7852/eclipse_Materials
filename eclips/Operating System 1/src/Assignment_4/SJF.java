package Assignment_4;

public class SJF extends  Times{


	private  int  first , last  ;

	public SJF(int size  , String[] names, int  [] arrivals , int  []bursts) {
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
		ResponceTimes = new  int [Number_of_processes];
		
		System.out.println("----------------------------------original----------------------------------\n");
		print();
		SortByArrivals();
		//calculate_time();
 	    
		int  f ,e ;
		for(int  i=0 ;i<Number_of_processes ;i++ ){
			f= i ;e=i ;
			for(int  j=i+1 ;j<Number_of_processes;j++){
				if(ArrivalTimes[j]==ArrivalTimes[i]){
					e=j;
				}else break;
			}
			if(e!=f){
				SortByBurstTime(new  Integer(f), new  Integer(e+1));
				i=e;
			}
		}//for  i
		System.out.println("----------------------------------Sorted by arrival time----------------------------------\n");
	  print();	
	  Calculate();
	}//
	

	public void  Calculate(){
		
		System.out.println("----------------------------------Calculate----------------------------------\n");
		first = ArrivalTimes[0] ;
		last = 0 ;
			
		int  count =  0 ;
		while(count<Number_of_processes){
			last =first+BurstTimes[count];
			waiting[count] =first - ArrivalTimes[count] ;
 			int  s = count+1  ,e =count+1 ;
 			
 			System.out.println(Processe_Names[count]+"  start="+first+ "  end="+last +"  "+waiting[count]);
 			
 			for(int i=s ;i<Number_of_processes ;i++){
				if(ArrivalTimes[i]<=last){
					e=i;
				}else break;
			}
			if(s!=e){
				SortByBurstTime(s, e+1);
 			}
			first = last;
			count++ ;
 		}//while
 
		ResponceTimes = waiting;
		System.out.println("----------------------------------waiting times  now ----------------------------------");
		for(int  i=0  ;i<Number_of_processes ;i++){
			System.out.println(Processe_Names[i]+ "  waits for "+waiting[i]);
 		}
		System.out.println("Response times  now ::");
		for(int  i=0  ;i<Number_of_processes ;i++){
			System.out.println(Processe_Names[i]+ "  response  is "+ResponceTimes[i]);
 		}
		
		int  sum = 0 ;
		for(int  num :waiting)
			sum+=num;
		float res =(float )sum / Number_of_processes ;
		System.out.println("average (waitin  and response ) time ="+res+"\n\n");
	}
	//*************************
	
	public void SortByBurstTime(int f  , int  e){
				
		for(int  i=f  ;i<e  ;i++){
			int  min = i ;
			for(int  j=i+1 ;j<e;j++){
				if(BurstTimes[j]<BurstTimes[min]){
					min=j;
				}
			}
			String  tempname  = Processe_Names[min] ;
			int  swap1 = ArrivalTimes[min] , swap2 = BurstTimes[min];
			
			BurstTimes[min]=BurstTimes[i];
			BurstTimes[i] = swap2;
			
			ArrivalTimes[min] = ArrivalTimes[i];
			ArrivalTimes[i] = swap1;
			
			Processe_Names[min] =Processe_Names[i];
			Processe_Names[i] = tempname;
 		}
		
	}
	//************************
	
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
	
	////////////////////
	public void print(){
 		for(int  i=0 ;i<Number_of_processes ;i++){
			System.out.println(Processe_Names[i]+"   "+ArrivalTimes[i]+"    "+BurstTimes[i]+"");
		}
	}
	//*******
	
	public void  Set_Attributes(){
		
	}//
	
	
}//class

