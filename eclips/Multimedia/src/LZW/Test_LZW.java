package LZW;

import  java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import  java.io.*;

public class Test_LZW {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		Scanner  cin = new  Scanner(System.in);
		
		 
		LZW comp = new LZW();
		List<String> l =new ArrayList();
		l.add("Mohammed");
		
		String str  = "ABAABABBAABAABAAAABABBBBBBBB";
 		comp.setoriginal(str);
		comp.Compress();
		comp.Decompress();
 

		int choice  ;
		System.out.println("Enter your choice :\n"
				+ "1)compress only.\n"
				+ "2)decompress only.\n"
				+ "3)both functions.\n");
 		choice =cin.nextInt();
 		while(choice>0)
 		{
 			if(choice==1)
 			{
 				comp = new LZW();
 				System.out.print("\nEnter your String:");
 				str= cin.next();
 				comp.setoriginal(str);
 				comp.Compress();
 			}
 			else if(choice==2)
 			{
 				List<Integer> L = new ArrayList();
 				int sz  ;
 				System.out.print("Enter the size  of  codes  : \n");
 				sz = cin.nextInt();
 				int x  ;
 				System.out.println("Now : Enter your String :\n");
 				
 				for( int  i=0 ;i<sz;i++)
 				{
  					L.add(cin.nextInt());
 				}
 				comp = new LZW();
 				comp.setcodes(L);
 				comp.Decompress();
 			}
 			else if(choice==3)
 			{
 				comp = new LZW();
 				System.out.print("\nEnter your String:");
 				str= cin.next();
 				comp.setoriginal(str);
 				comp.Compress();
 				comp.Decompress();
 			}
 			System.out.println("Enter your choice :\n"
 					+ "1)compress only.\n"
 					+ "2)decompress only.\n"
 					+ "3)both functions.\n");
 	 		choice =cin.nextInt();
 		}
		
 		
		
		
	}

	 
}
