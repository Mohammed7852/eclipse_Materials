package Assignment5;

import  java.util.*;
public class Demo {

	static  Scanner  cin = new  Scanner(System.in);
	public static  void  main(String  []args){
		
		System.out.println("-----------------Main-----------------------\n");
		
		int size1  , size2  , choice , allocationtype  ,maxsize; 
		System.out.println("set maxsize :");
		maxsize = cin.nextInt();
		
		
		MemAllocation m = new MemAllocation();
		m.setmaxsize(maxsize);
		System.out.println("Enter your choice  1)Allocation  2)Deallocation  3)Defragmentation  :");
		choice= cin.nextInt();
		while(choice>0){
			
			if(choice==1){//allocation 
				System.out.println("Partition Size =");
				size1  =cin.nextInt();
				System.out.println("Data Size =");
				size2 = cin.nextInt();		
				System.out.print("Allocation Type 1)ff 2)bf 3)wf :");
				allocationtype = cin.nextInt() ;
				
				m.setinfo(size1, size2, allocationtype);
				System.out.println("\n\nAllocation Result="+m.Allocate());
			}else  if(choice==2){//deallocation
				int  sindex ;
				System.out.println("Starting  index  =");
				sindex  = cin.nextInt();
 				System.out.println("\n\ndeallocation Result="+m.Deallocate(sindex));
 			}else  if(choice==3){//fragmentation 
				int type  ;
				System.out.println("external Defragment type = ");
				type =cin.nextInt();
				m.Defragmentation(type);
 			}
			
			System.out.println("Enter your choice  1)Allocation  2)Deallocation  3)Defragmentation  :");
			choice= cin.nextInt();
		}//while loop
		
		
		
		
		
		
		
		System.out.println("\n---------------------Finish-----------------------\n");
		
	}//main
	
}//class
