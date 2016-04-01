package Assignment1;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Demo {

	private static Scanner cin =new Scanner(System.in);
	static  String  directory = "E:/"; 
	
	public static void main(String[] args) throws IOException, InterruptedException {
		// TODO Auto-generated method stub

		 
		//String  string= "   this is  the  string" ;
 		//string  = cin.nextLine();
 		//string = string.replaceAll("\\W", "");
		//System.out.println(","+string+ ","+string.trim()+"\n");
		
   	   Command command = new Command();
   	   parseclass  pc  = new parseclass ();
   	  
   	  command.setdirectory(directory);
   	  
   	  String  []arr ; 
   	  
   	  
   	  
   	  
   	  int count =0 ;
   while(count<1000)
   {
	    command.get(command.getdirectory());
	    directory = command.getdirectory() ;
	    
   	   String  temp = "" ;
    	   System.out.print("Windows@Windows :~/"+""+""+command.getdirectory()+"$");
    	   temp += cin.nextLine();
 
    	   arr= temp.split(";");
    	   
    	   for(String s :arr)  
   	         {
    		     pc.separate(s.trim());
                 command.get(command.getdirectory());
   	         }
    	   
   	   count++;

   }//end  of  while 
   
   
	}//end  main
	
}//end  class 


