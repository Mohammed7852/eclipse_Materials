package Assignment1;

 
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.io.Reader;
import java.io.Writer;
import java.nio.channels.FileChannel;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Stack;
import java.util.logging.ConsoleHandler;
import javax.naming.spi.DirectoryManager;


public class Command{
public  Command(){}
protected  Scanner  cin = new Scanner(System.in);
protected static final CopyOption REPLACE_EXISTING = null;
protected  Stack<String> last  = new Stack();
protected static String  directory = "E:/"  , lastdirectory  =null  , defaultdir = "E:/"; 
protected static  String  str1=null , str2=null , str3=null ; 

 
/**
 * @throws IOException 
 * @throws InterruptedException ***********************************/


/**
 * @throws IOException 
 * @throws InterruptedException *****************************************/
/*************************************************/


//********************************************************************/
public static void  more(File f) throws IOException {
	int flag=0,flag2=0;
	  Reader r = new BufferedReader(new InputStreamReader(
	          new FileInputStream(f), "US-ASCII"));
	  try {
	   // StringBuilder resultBuilder = new StringBuilder();
	    String result=new String();
	    int count = 0;
	    int intch;
	    int num=0;
	  Scanner S=new Scanner(System.in);
	    while (((intch = r.read()) != -1))
		 {
	    	result+=""+(char)intch;
	     if(count==120)
	     {
	    	  System.out.println(result);
	    	  num++;
	      flag=1;
	    }
	     if(flag==1){
	     count=0;
	     result=" ";
	     flag=0;}
	     else{
	    		count++;
	    		}//
	   if(num==3){
		 System.out.println();
		 System.out.println("If you want complet read press (1) \tif you want stop press (0)\t Enter choice");
		 int  choice =S.nextInt();
		 if(choice==1){
		  num=0;
		 }else { 
			 flag2=1;
			 break;
			
		 }
	   }
	     
	    } 
	    
	    if(flag2==1){
	    	System.out.println("you Stopped reading");
	    }
	    
	    else
	    {
	   System.out.println("  FILE COMPLECTED ***********!!!!!!!!*********");
	  }
	    }//try
finally {
	    r.close();
	  }
	}

/***************************************************************/

public void  help()
{
	String  str  =""
			+ "ls @command@  list all content of  directory.\n"
			+ "cd @command@  change the current directory.\n"
			+ "cat @command@ print contents of file.\n"
			+ "mv @command@  will move or  rename files or directories.\n"
			+ "cp @command@  copy files or directories.\n"
			+ "date @command@ show the current date and time.\n"
			+ "mkdir @command@ create new directory.\n"
			+ "rmdir @command@ delete empty diectories.\n"
			+ "rm @command@ delete specified files and directories.\n"
			+ "pwd @command@ display the full bath to the  current directory.\n"
			+ "clear @command@  clean consol.\n"
			+ "more @command@ \n"
			+ "less @command@ \n"
			+ "args @command@ \n"
			+ "exit stop all commands .\n"
			+ ""
			+ "";
	System.out.print(str+"\n");
}

/*****************************************************************************/
public void  recu()
{
	
}
public void  find()
{
	

}
/************************************************************/
public void date()
{
	DateFormat df  = new SimpleDateFormat("d/MMM/yyyy   hh:mm:ss");
		Date d = new Date();
		Calendar  c =  Calendar.getInstance();
		System.out.println(df.format(c.getTime())+"\n");
}
/**
 * @throws IOException ********************************************************/


/********************************************************/

public void pwd()
{
	System.out.println(directory);
}


/**
 * @throws IOException ****************************************************/
//
//public void cat() throws IOException
//{
//		if(str2.charAt(0)=='>'&&str2.charAt(1)!='>')
//		{
//			String   string= str2.substring( 1  , str2.length());
//			System.out.println(string);
//			System.out.println(string);
//			
//			if(str3!=null)
//		     {
//				FileWriter fw = new FileWriter (directory+"/"+str3);
//					BufferedWriter bw = new BufferedWriter(fw) ; 
//					
//					String  str =""  , s; 
//					while(true)
//					{
//						s= cin .nextLine();
//						if(s.equals("$"))break;
//						str+=s ;
//					}
//					 bw.write(str);
//					 bw.close();
//				}
//			else if(!string.equals("\\s+"))
//			{
//				FileWriter fw = new FileWriter (directory+"/"+string);
//				BufferedWriter bw = new BufferedWriter(fw) ; 
//				
//				String  str =""  , s; 
//				while(true)
//				{
//					s= cin .nextLine();
//					if(s.equals("$"))break;
//					str+=s ;
//				}
//				 bw.write(str);
//				 bw.close();
//			}
//			else System.out.print("no such file  or directory.\n");
//		}
//		else  if(str2.charAt(0)==('>')&&str2.charAt(1)=='>')
//		{
//			String string   = str2.substring(2, str2.length());
//			System.out.println(string);
//			if(str3!=null)
//		     {
//				FileWriter fw = new FileWriter (directory+"/"+str3 , true);
//					BufferedWriter bw = new BufferedWriter(fw) ; 
//					
//					String  str =""  , s; 
//					while(true)
//					{
//						
//						s= cin .nextLine();
//						if(s.equals("$"))break;
//						str+=s ;
//					}
//					 bw.write(str);
//					 bw.close();
//				}
//			else if(!string.equals("\\+s"))
//			{
//				FileWriter fw = new FileWriter (directory+"/"+string , true);
//				BufferedWriter bw = new BufferedWriter(fw) ; 
//				
//				String  str =""  , s; 
//				while(true)
//				{
//					
//					s= cin .nextLine();
//					if(s.equals("$"))break;
//					str+=s ;
//				}
//				 bw.write(str);
//				 bw.close();
//			}
//			else System.out.print("no such file  or directory.\n");
//	 }
//	else
//	try{ 
//			 FileReader  f = new  FileReader (directory+"\\"+str2);
//			
//   			if(f.ready())  
//   			{
//    			 BufferedReader input = new BufferedReader(f);
//    		        String x = null;  
//    		        while( (x = input.readLine()) != null ) 
//    		        {    
//    		            System.out.println(x); 
//    		        } 
//    		        
//    		        input.close();
//    		        
//   			} else System.out.println("File is  Empty.\n"); 
//	   
//		}catch(IOException x)
//			{
//				System.out.println("No file.\n");
//			}
//		
//}

/**********************************/

public void cat() throws IOException
{
		if(str2.equals(">"))
		{
			if(str3!=null)
		     {
				FileWriter fw = new FileWriter (directory+"/"+str3);
					BufferedWriter bw = new BufferedWriter(fw) ; 
					
					String  str =""  , s; 
					while(true)
					{
 						s= cin .nextLine();
						if(s.equals("$"))break;
						str+=s+"\n" ;
					}
					 bw.write(str);
					 bw.close();
				}
			else System.out.print("no such file  or directory.\n");
			
		}
		else  if(str2.equals(">>"))
		{
			if(str3!=null)
		     {
				FileWriter fw = new FileWriter (directory+"/"+str3 , true);
					BufferedWriter bw = new BufferedWriter(fw) ; 
					
					String  str =""  , s; 
					while(true)
					{
						
						s= cin .nextLine();
						if(s.equals("$"))break;
						str+=s+"\n" ;
					}
					 bw.write(str);
					 bw.close();
				}
			else System.out.print("no such file  or directory.\n");
					}
	else
	try{ 
			 FileReader  f = new  FileReader (directory+"/"+str2);
			
   			if(f.ready())  
   			{
    			 BufferedReader input = new BufferedReader(f);
    		        String x = null;  
    		        while( (x = input.readLine()) != null ) 
    		        {    
    		            System.out.println(x); 
    		        } 
    		        
    		        input.close();
    		        
   			} else System.out.println("File is Empty.\n"); 
	   
		}catch(IOException x)
			{
				System.out.println("No file.\n");
			}
		
}


/**************************************/
//static  void cp(File )



/**
 * @throws IOException *****************************************/

public void mv(File src , File des )
{
	boolean isFileRenamed = src.renameTo(des)  ;
	
	if(isFileRenamed)
	{
		System.out.println("renamed");
	}
	else System.out.println("not  renamed");
	 
}

public static void MV(File sour,File dest)throws IOException {
	
	if(!dest.exists()){
		dest.createNewFile();
	}
	
	FileChannel source=null;
	 FileChannel destination ;
  	    destination=null;
	
	try{
		source = new FileInputStream(sour).getChannel();
		destination = new FileOutputStream(dest).getChannel();
		
		long count=0;
		long size=source.size();
		while((count+=destination.transferFrom(source, count, size-count))<size);
	}
	finally
	{
		if(source!=null){
			source.close();
		}
		if(destination!=null){
			destination.close();
		}
	}
	
}

/***************************************/

public void echo() throws IOException
{
	try{
		   BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
		   String x = null;  
		   while( (x = input.readLine()) != null ) 
		   {    
		       System.out.println(x); 
		   } 
	}catch(Exception e)
	{
		
	}
}

/*************************************************/
public void get(String  s)
{
	File f  = new File(s);
	System.setProperty("user.dir", s);
	
}
/**
 * @throws IOException 
 * @throws InterruptedException ********************************/

public void clear()  
{
	
	for(int  i=0 ;i<19;i++)System.out.println("\n");
	
}
/**************************************/
////////////////////////////////////////
public String getdirectory()
{
	return directory ;
}

public void setdirectory(String  st)
{
	directory=st ;
}


///////////////////////////////////////////////
public void setcurrentdirectory(String  newdir)
{
	if((newdir.charAt(0)=='E'||newdir.charAt(0)=='D')&&(newdir.charAt(1)==':'))
   	{
	    	directory=(newdir);
    	}
   	else 
   	    directory+=("\\"+newdir);
	
}
/********************************************************/
static  void  cp(File  source , File  des) throws IOException
{
	FileChannel input = null ;
	FileChannel output = null ;
	
	try
	{
		input = new  FileInputStream(source).getChannel();
		output = new FileOutputStream(des).getChannel();
	    output.transferFrom(input, 0, input.size());
		
	}finally
	{
		input.close();
		output.close();
	}
	 
	
}
/****************************/
    public static boolean mkdir(String directory_name)
    {
        boolean result = false;  // Boolean indicating whether directory was set
        File    dir;       // Desired current working directory

        dir = new File(directory_name).getAbsoluteFile();
        
       // System.out.println("directory is  :"+directory_name+"\n");
        
        if (dir.exists() || dir.mkdir())
        {
            result = (System.setProperty("user.dir", dir.getAbsolutePath()) != null);
        }

        return result;
    }

    /********************************************************/
    public static PrintWriter openOutputFile(String file_name)
    {
        PrintWriter output = null;  // File to open for writing

        try
        {
            output = new PrintWriter(new File(file_name).getAbsoluteFile());
        }
        catch (Exception exception) {}

        return output;
    }

/**
* @throws IOException ******************************************************/

public static String   ls(File currentdir) throws IOException{
        	 String  term  = "";
         	File [] FileList = currentdir.listFiles();

         	if (str2==null)
        	for ( File f  : FileList){
        		if(f.isDirectory()){
        				System.out.println(f.getName());
        				term+=f.getName()+"\n";
        			}
        		 if(f.isFile()){
        			 term+=f.getName()+"\n";
        			 System.out.println(f.getName());
        		 }
        	}
        	else if(str2.equals(">")){
    	    	if(str3!=null){
    	    		
    	    		Writer w  = new FileWriter  (directory+"/"+str3);
    	    		
    	    		BufferedWriter bw  = new BufferedWriter (w);
    	    		
    	    		for ( File f  : FileList){
    	        		bw.write(f.getName()+"\n");
    	        	}
    	    		
    	    		bw.close();
    	    	}
    	    	else System.out.print("no such file  or  directory.\n");
        	}
    	   else if(str2.equals(">>")){
    		   
    		   if(str3!=null){
	    		   Writer w  = new FileWriter  (directory+"/"+str3 , true);
	       		   BufferedWriter bw  = new BufferedWriter (w);
       		   
    		   		for ( File f  : FileList){
    		    		bw.write(f.getName()+"\n");
    		    	}
    		
    	   		bw.close();
    		   }else System.out.print("no such file  or  directory.\n"); 
    	   }

        	return term ;
}

     /****************************************************************************/
     
     public static  void copyfile(File From , File to) throws IOException 
     {
    	 System.out.print("now we copy:\n");
    	 Files.copy(From.toPath() , to.toPath());
     }
 
     
     /***************************************************/
     public static void rmdir(File directory)
     {
    	  
    	 if(directory.isFile())
    	 {
    		 System.out.println("rmdir Does removes files ,, only directories .\n");
    		 return ;
    	 }
    	boolean temp = directory.delete();
    	if(!temp)
    	{
    		System.out.println("this directory is  not empty.\n");
    	}
    	
     }
     
     /********************************************************/
     
     public static void rm(File directory) 
     {
    	 if(directory.isDirectory())
    		 System.out.println("rm:cannot remove '"+directory.getName()+"' is  adirectory.\n");
    	 else
    	    directory.delete();

     }
     /*************************************************************/
     public void arg(){
    	 System.out.println(""
    				+ "cd     arg :: directory like /home/Desktop/...\n"
    				+ "ls     arg :: not have argument \n"
    				+ "clear  arg :: not have argument\n"
    				+ "pwd    arg :: not have argument\n"
    				+ "cp     arg :: source file   destination file  like : $cp /home/myfile.txt /root/myfile.txt\n"
    				+ "mv     arg :: old name of file    new name for file like : $mv /home/myfile.txt /root/myfile.txt\n"
    				+ "rm     arg :: name of deleted file like : $rm  file.txt\n"
    				+ "mkdir  arg :: name of directory like : $mkdir /home/mydir\n"
    				+ "rmdir  arg :: name of empty directory like: $rmdir /home/mydir\n"
    				+ "date   arg :: doesn't have argument\n"
    				+ "echo   arg :: what we print like : $echo Ahmed \n"
    				+ "cat    arg :: name of file like : $cat myfile\n"
    				+ "cat    arg :: name_file_1  name_file_2 like :$cat myfile.txt myfile2.txt\n"
    				+ "more   arg :: name_of_printed_file like : $more myfile.txt\n"
    				+ "less   arg :: name_of_printed_file like : $more myfile.txt\n"
    				+ ">>     arg :: file_name like :$ls >> myfile.txt \n"
    				+ "<      arg :: file_name like : $ls >> myfile.txt \n");
    		
     }
     
     /**************************************************************/
     public static void  less(File f) throws IOException 
     {
		 ArrayList<String> obj=new ArrayList<String>();
	 
		 	int flag=0,flag2=0;
		 	Reader r = new BufferedReader(new InputStreamReader(  new FileInputStream(f) , "US-ASCII"));
		  try {
		   // StringBuilder resultBuilder = new StringBuilder();
		    String result=new String();
		    int count = 0;
		    int intch;
		    int num=0;
		    
		  Scanner S=new Scanner(System.in);
		  
		    while (((intch = r.read()) != -1)) 
		    {
		    	result+=""+(char)intch;
		    	if(count==120)
		    	{
		    	//  System.out.println(result);
		    	    obj.add(result);
		    	    num++;
		           flag=1;
		         }
		    
		  
		       if(flag==1)
		         {
				     count=0;
				     result=" ";
				     flag=0;
			     }
			     else
			     {
			    	 count++;
			     }//
			   
		       if(num==3)
		       {
						  System.out.println();
						  System.out.println("If you want (up read) press (1) \tif youwant to (down read) press (0)\t Enter choice");
						 int  choice =S.nextInt();
					 if(choice==1)
					 {
							 for(int i=0;i<obj.size();i++)
							 {
								 System.out.println(obj.get(i));
						      }
						  num=0;
					 }
					 else 
					 { 
							  
							      System.out.println("\n\n\n\n");
						      
							
							 for(int i=0;i<obj.size()-4;i++)
							 {
								 System.out.println(obj.get(i));
							 }
					 }  
				 
				 }
		  
	 
	 
		    }//end  of while loop
		  }//end of  try 
		  finally
		  {
			  r.close();
		  }
	 }//end  of less function 
     
}//end  of  class command 

     /****************************************************************/
     
     
     
     
     
     
	
