package Assignment_1;
import java.util.*;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Demo {
	static RandomAccessFile file ;
 	static Scanner cin = new Scanner(System.in);
 	public static  void  main(String  [] args)throws Exception{		
  		 RandomAccessFile  file = new RandomAccessFile("newfile.txt", "rw");
		Demo demo = new Demo();
		int choice  ;
		int index ;
		String filename ="newfile.txt";
 		System.out.println("Enter your choice : 1(create)  2(insert) 3(displayall)  4(display one)  5(Replace) :");
		choice = cin.nextInt();
		while(choice>0){
			if(choice==1){
				int  n;
			System.out.println("number of  records =");
			n = cin.nextInt();
			demo = new Demo();
			demo.CreateRecordsFile(filename, n);
 			}else if(choice==2){
			demo = new Demo();
			int  value  ;
			System.out.println("Enter index   value");
			index = cin.nextInt();
			value = cin.nextInt();
			demo .InsertValue(filename, index, value);
			}else  if(choice==3){
				demo = new Demo();
				demo.DisplayAllRecords(filename);
			}else  if(choice==4){
				System.out.println("enter  index ");
				index = cin .nextInt();
				demo = new Demo();
				demo.DisplayARecordValue(filename, index);
			}else if(choice==5){
				demo= new Demo();
				int  findex  ;
				System.out.println("enter first and second  index ");
				findex= cin.nextInt();
				index = cin.nextInt();
				demo.ReplaceVlauesOfTwoRecords(filename, findex, index);
			}
			System.out.println("Enter your choice : 1(create)  2(insert) 3(displayall)  4(display one)  5(Replace) :");
			choice = cin.nextInt();
		}//end while
 	}//end main

 	public void CreateRecordsFile(String filename, int numberOfRecords) throws IOException {
		   file = new RandomAccessFile(filename, "rw");
		 int n = numberOfRecords;
		 for(int i=0 ;i<numberOfRecords ;i++){
			 file.writeInt(i);
			 file.writeInt(0);
  		 }
		 file.close();
	}
 	public void InsertValue (String filename, int RecordIndex, int RecordValue) throws IOException{
		   file = new RandomAccessFile(filename, "rw");
		 file.seek((RecordIndex)*8+4);
		 file.writeInt(RecordValue);
		 file.close();
	}
	public void DisplayAllRecords (String filename) throws IOException{
		 file  = new RandomAccessFile(filename, "rw");
 		int x =(int) (file.length()/4) ;
		file.seek(0);
		for(int  i=0 ;i<x  ;i+=2){
			System.out.print(file.readInt()+","+file.readInt()+"\n");
		}
		file.close();
	}
	public void DisplayARecordValue(String filename, int RecordIndex) throws IOException {
		 file  = new RandomAccessFile(filename, "rw");
		file.seek((RecordIndex)*8+4);
		System.out.println("index ="+RecordIndex+" , value ="+file.readInt());
		file.close();
 	}
	public void ReplaceVlauesOfTwoRecords(String filename, int FirstRecordIndex,int
			SecondRecordIndex)throws IOException{
	    file  = new RandomAccessFile(filename, "rw");
		file.seek((FirstRecordIndex)*8+4);
		int temp = file.readInt();
 		file.seek((SecondRecordIndex)*8+4);
 		int  temp2 = file.readInt();
 		file.seek((FirstRecordIndex)*8+4);
 		file.writeInt(temp2);
 		file.seek((SecondRecordIndex)*8+4);
 		file.writeInt(temp);
 		file.close(); 		
	}

	
	
	
	
	
	
	
	
	public static void operations(){
		List<node> list = new ArrayList();
		node  n = new node();
		n.setindex(0);
		n.setvalue(5);
		list.add(n);
		n = new  node();
		n.setindex(1);
		n.setvalue(6);
		list.add(n);
		
		System.out.println(list);
	}
	
	public static class node {
		int index ;
		int value;
		public void setindex(int in){
			index=in;
		}
		public void setvalue(int v){
			value=v;
		}
		public int getindex(){return index;}
		public int getvalue(){return value;}
		@Override
		public String toString(){
			return "index="+getindex()+" and  value="+getvalue();
		}
		
	}//
	
	
}//