package Assignment_4;

import java.util.*;

import javax.print.attribute.PrintRequestAttribute;

import java.io.*;

public class Demo {

	static Scanner cin = new  Scanner(System.in);
	
	public static void  main(String []args) throws FileNotFoundException{
		
		//System.out.println("Mohammed Ali shabanah");
		
		int  numproces  ;
		System.out.println("Enter number  of  processes ::");  
		numproces = cin.nextInt() ;
		int arrivaltime []= new int [numproces]  ;
		String  processname [] = new  String[numproces];
        int  bursttime  [] =new  int  [numproces] ;
        
		
		System.out.println("process name-----Arrival time-----burst time\n");
		String  temp ="";
		// cin.next();
		for(int  i=0 ;i<numproces ;i++){
			cin.nextLine();
			//System.out.print("i="+(i+1));
			
  			temp = cin.nextLine() ;
			processname[i] = temp ;
 			arrivaltime[i] = cin.nextInt() ;
			bursttime[i]=cin.nextInt() ;
			
		}//for
		
		////
		
		for(String  s :processname){
			//System.out.println("name:"+s+"   ");
		}
		
		
		int []arrive = new  int[numproces];
		int []burst = new  int [numproces];
		String []name = new String  [numproces];
		
		for(int  i=0 ;i<numproces;i++){
			arrive[i]=new Integer(arrivaltime[i]);
			burst[i] = new Integer(bursttime[i]);
			name[i]  = new String(processname[i]);
		}
			
		
		System.out.println("\n\tNow:FCFS\n");
		FCFS fc  = new FCFS (new  Integer (numproces), (name) , arrive , burst);
 		/////END   of  FCFS 
		
		

		for(int  i=0 ;i<numproces;i++){
			arrive[i]=new Integer(arrivaltime[i]);
			burst[i] = new Integer(bursttime[i]);
			name[i]  = new String(processname[i]);
		}

		System.out.println("\n\tNow:SJF\n");
	    SJF sj = new SJF(numproces,(name) , arrive , burst);
		
	    

		for(int  i=0 ;i<numproces;i++){
			arrive[i]=new Integer(arrivaltime[i]);
			burst[i] = new Integer(bursttime[i]);
			name[i]  = new String(processname[i]);
		}
		
		//Round Robin
		System.out.println("\n\tNow:Round Robin\n");
		System.out.println("Enter the Time Quantum:");
		int TQ = cin.nextInt();
		RoundRobin RR = new  RoundRobin(numproces, TQ, (name) , arrive , burst);
		
		System.out.println("finish");
		
		
		
		
		
		
		
		
		
		
		
//		PrintWriter pw  = new  PrintWriter(new  File("newfile.txt"));
//		
//		String str = "Mohammed Ali Shabanah\nMohammed";
//		
//		String s ;
// 		pw.append(str);
//		pw.close();
//		
//		Scanner  c = new  Scanner(new  File("newfile.txt"));
//		 s = c.nextLine();
//		 System.out.println(s);
//		 s = c.nextLine();
//		 System.out.println(s);

		
		
		
		
		
		
	}//main
	
	/*
	 Good Example for  SJF
	 5
 
p1
0 5
p2
0 3
p3
2 8
p4
1 2
p5
5 7
	 */
	
	
}//class
