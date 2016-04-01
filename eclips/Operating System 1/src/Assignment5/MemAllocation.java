package Assignment5;

import java.util.List;

import java.util.*; 

public class MemAllocation extends  information {
	
	
	private  int  numpartitions  = 0 , size1 , size2 , currentaddress = 0 , allocationtype  ,currentsize = 0;
	public MemAllocation() {
		 
 	}
	 
	private int  maxsize  ; 
	public void  setmaxsize(int s){
		this.maxsize =s ;
	}
	
	private  List<Integer>  Memory  = new ArrayList();
	
	public void setinfo(int  s1 , int  s2  , int type){
		this.size1 = s1 ;/*s2+3*/
		this.size2 = s2 ;
		this.allocationtype = type ;
 		}
	
	
	///////

	public int Allocate(){
		int address = -1 ;
		
		int  sz = Memory.size();
		currentsize=sz;
		if(allocationtype==1){
			System.out.println("---------------First Fit Allocation-----------------------\n");
			 address =firstfit();
			  
			}else  if(allocationtype==2){
				System.out.println("---------------Best  Fit Allocation-----------------------\n");
			address =bestfit();
			 
			}else  if(allocationtype==3){
				System.out.println("---------------Worst Fit  Allocation-----------------------\n");
			address =worstfit();
			 
			}
		
		if(((currentsize+size1)<maxsize)&&address==-1){
			System.out.println("--------------------Allocation to rest of  memory-----------------------\n");
			for(int i=0 ;i<size1 ;i++){
				Memory.add(0);
			}
			numpartitions++ ;
			startingmemoryaddress.add(sz);
			SizeofWholePartition .add(size1);
			SizeofAllocatedMemoryWithinPartition.add(size2);
			diff.add(size1 -size2);
			partitionStatus.add(true);
			
			currentsize +=size1;
			address = sz ;
		}
		
		print();
		return address;
	}
	
	
 	//////////////////////
	
	public void check(){
		
	}
	public int firstfit(){
		int address = -1 ;
		List<Integer> list = new ArrayList();
		int size , index = 0; 
		boolean temp =false;
		
		for(int  i=0 ;i<numpartitions ;i++){
			if(partitionStatus.get(i)==false){
				size= SizeofWholePartition.get(i);
				if(size>=size2){
					index =i;
					temp= true;
					break;
				}
			}
		}
		
		if(!temp)
		 return address ;
		
		partitionStatus.set(index, true);
		SizeofAllocatedMemoryWithinPartition.set(index, size2);
		address =startingmemoryaddress.get(index);
		
		return address ;
	}
	
	public int bestfit(){
		int address = -1 ;
		
		int size , index=0  ,minsize = 0; ; 
		boolean temp =false; 
		int c =0 ;
		
		for(int i=0 ;i<numpartitions ;i++){
			if(partitionStatus.get(i)==false){
				size = SizeofWholePartition.get(i);
				if(size>=size2){
					temp =true;
					
					if(c==0){minsize=size;c++;index = i ;}
					else {
						if(size<minsize){
							minsize=size;
							index=i;
						}
					}
				}
			}
		}
		
		if(!temp)return address; 
		
		partitionStatus.set(index, true);
		SizeofAllocatedMemoryWithinPartition.set(index, size2);
		address  = startingmemoryaddress.get(index);
		
		return address ;
	}
	
	public int  worstfit(){
		int address =-1 ; 
		
		int index  =0 , size  , maxsize=0 ; 
		boolean temp =false; 
		int c = 0 ;
		for(int i=0 ;i<numpartitions ;i++){
			if(partitionStatus.get(i)==false){
				size =SizeofWholePartition.get(i);
				if(size>=size2){
					temp=true;
					if(c==0){index=i;c++;maxsize=size;}
					else {
						if(size>maxsize){
							maxsize =size;
							index=i;
						}
					}
				}
			}
		}
		if(!temp)return address ;
 
		partitionStatus.set(index, true);
		SizeofAllocatedMemoryWithinPartition.set(index, size2);
		address = startingmemoryaddress.get(index);
 		return address ;
	
	}
	
	public boolean Deallocate(int S){
		System.out.println("---------------Deallocation-----------------------\n");
		boolean temp =false; 
		int index  = 0 ;
		
		for( int i=0  ;i<numpartitions;i++){
			int  ind = startingmemoryaddress.get(i);
			if(ind==S){
				temp=true;
				index=i;
				break;
			}
		}
		if(!temp)return temp ;
		
		partitionStatus.set(index, false);
		
		print();
		return temp ;
	}
	
	/////////////////////////////
	
	public void  Defragmentation(int  t){
		internalfragment();
		System.out.println("---------------Internal DeFragment-----------------------\n");
		print();
		if(t==1)
		externalfragment_Case1();
		else if(t==2)
		externalfragment_Case2();
		
		System.out.println("---------------External DeFragment-----------------------\n");
		print();
	}
	
	public void internalfragment(){
 
		for(int  i=0 ;i<numpartitions ;i++){
			int  x = SizeofWholePartition.get(i);
			int  y = SizeofAllocatedMemoryWithinPartition.get(i);
			int  dif = new Integer(x-y) ;
			if(dif>0){
				partitionStatus.add(i+1, false);
				SizeofWholePartition.set(i, y);
				SizeofWholePartition.add(i+1, dif);
				SizeofAllocatedMemoryWithinPartition.add(i+1 , 0);
                int  adress  = startingmemoryaddress.get(i) + y ;
                startingmemoryaddress.add(i+1, adress);
               // numpartitions++;
			}
		}
	}
	
	public void  externalfragment_Case1(){
		
		int  s = 0 , e = 0 ;
		int sum  = 0 ;

		for(int i=0 ;i<partitionStatus.size() ;i++){
			if(partitionStatus.get(i)==false){
				int j =  new  Integer(i) +1;
				s =i ;
				e=i;
				sum +=SizeofWholePartition.get(i);
				while(partitionStatus.get(j)==false&&(j<numpartitions)){
					sum+=SizeofWholePartition.get(j);
 					partitionStatus.remove(j);
					SizeofAllocatedMemoryWithinPartition.remove(j);
					SizeofWholePartition.remove(j);
					startingmemoryaddress.remove(j);
					numpartitions--;
					e=j;
					j++;
				}
				
 				SizeofWholePartition.set(i,sum);
   			//	i=j-1;
			}
		}
		
	}//

	public void  externalfragment_Case2(){
		
		boolean status  ;
		int s1=0 ;
		int  startindex  ;
		int c=0 ;
		
		for(int i=0 ;i<partitionStatus.size() ;i++){
			if(partitionStatus.get(i)==false){
				startindex = startingmemoryaddress.get(i);
				s1 +=SizeofWholePartition.get(i);
				
				partitionStatus.remove(i);
				SizeofAllocatedMemoryWithinPartition.remove(i);
				SizeofWholePartition.remove(i);
				startingmemoryaddress.remove(i);
				
				
 				int  j=i+1  ;
				while((j)<numpartitions){
					int temp = startingmemoryaddress.get(j);
 					 startingmemoryaddress.set(j++, startindex);
					 startindex =temp;
 				}
				numpartitions--;
 			}
			c = startingmemoryaddress.get(i) + SizeofWholePartition.get(i);
		}
		
		partitionStatus.add(false);
		SizeofWholePartition.add(s1);
		SizeofAllocatedMemoryWithinPartition.add(0);
		startingmemoryaddress.add(c);
		
	}//method
	
	//////////////////////
	public void  print(){
		System.out.println("---------------print-----------------\n");
		
		for(int  i=0 ;i<numpartitions ;i++){
			System.out.println("---------------partition("+(i+1)+")-----------------\n");
			System.out.println("flag ="+partitionStatus.get(i));
			System.out.println("start address ="+startingmemoryaddress.get(i) +  "   "
					+ "end address ="+(startingmemoryaddress.get(i)+SizeofWholePartition.get(i)-1));
			System.out.println("data size ="+SizeofAllocatedMemoryWithinPartition.get(i));
			System.out.println("partiotion size  ="+SizeofWholePartition.get(i));
 		}
	}
}
