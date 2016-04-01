package first;

import java.util.*;
import java.util.logging.Logger;
import java.io.*;
import java.nio.file.CopyOption;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;



public class FileUtils
{
	
private static final CopyOption REPLACE_EXISTING = null;

static String  directory = ""  ; 
    public static boolean mkdir(String directory_name)
    {
        boolean result = false;  // Boolean indicating whether directory was set
        File    directory;       // Desired current working directory

        directory = new File(directory_name).getAbsoluteFile();
        if (directory.exists() || directory.mkdirs())
        {
            result = (System.setProperty("user.dir", directory.getAbsolutePath()) != null);
        }

        return result;
    }

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

     static void  getallfiles(File currentdir)
    {
    	File [] FileList = currentdir.listFiles();
    	
    	for ( File f  : FileList)
    	{
    		if(f.isDirectory())
    			System.out.println(f.getName());
    		 if(f.isFile())
    			 System.out.println(f.getName());
    	}
    }
    
     public static  void copyfile(File From , File to) throws IOException 
     {
    	 System.out.print("now we copy:\n");
    	 Files.copy(From.toPath() , to.toPath());
     }
     ///////////////////
    /***************************************************/
     public static void deleteDirectory(File directory)
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
    	 
//    	 
//    	 if(directory.exists())
//    	 {
//    	       
//    		 File[] files = directory.listFiles();
//    	       
//    		 if(null!=files)
//    	        {
//    	            for(int i=0; i<files.length; i++) 
//    	            {
//    	                if(files[i].isDirectory()) 
//    	                {
//    	                    deleteDirectory(files[i]);
//    	                }
//    	                else
//    	                {
//    	                    files[i].delete();
//    	                }
//    	            }
//    	        }
//    	    }
//    	    return(directory.delete());
   	}
     
     public static void deletefiles(File directory) 
     {
    	 
    	 if(directory.isDirectory())
    	 {
    		 System.out.println("rm cannot remove directories,,only files.\n\n");
    		 return ;
    	 }
    	 
    	 directory.delete();
    	 
//    	 
//    	 if(directory.exists()&&directory.isFile()){
//    	        File[] files = directory.listFiles();
//    	        if(null!=files){
//    	            for(int i=0; i<files.length; i++) {
//    	                if(files[i].isDirectory()) {
//    	                    deleteDirectory(files[i]);
//    	                }
//    	                else {
//    	                    files[i].delete();
//    	                }
//    	            }
//    	        }
//    	    }
//    	    return(directory.delete());
  	}
     /*************************************************************/
     
     
     
     
     
     
     
     
     public static void main(String[] anything) throws Exception
    {
    	Scanner cin =new Scanner(System.in);
     	
    	 
    	
    	int choice =5; 
    	directory ="E:\\try";

    	System.out.print("\n\t1)change directory.\n\t2)mkdir.\n\t3)ls.\n\t4)rmdir.\n\t5)clean.\n\t6)help."
    			+ "\n\t7)copy.\n\t8)mv.\n\t9)cat.\n\t10)rm.\n\t11)PWD.\n\t12)args.\n\t13)date."
    			+ "\nEnter your choice::");
    	choice= cin.nextInt();
    	while(choice>0)
    	{
    		if(choice==1)//change 
    		{
    			String  newdir  ="";
    			
    			System.out.println("Enter new directory ::");
    			
    			cin.nextLine();
    			newdir = cin.nextLine();
    			
   			if((newdir.charAt(0)=='E'||newdir.charAt(0)=='D')&&(newdir.charAt(1)==':'))
    	    	{
        	    	directory=(newdir);
     	    	}
    	    	else 
    	    	    directory+=("\\"+newdir);
    		}
    		else if(choice==2)//mkdir
    		{
    			String str  = "";
    	    	String  newdir ;
    	    	System.out.println("Enter File name  :");
    	    	cin.nextLine();
    	    	newdir = cin.nextLine();
    	    	
    	   }
    		else  if(choice==3)//ls
    		{
    			
    			File curdir = new  File(directory);
    	    	FileUtils.getallfiles(curdir);
     		}
    		else  if(choice==4)//rmdir 
    		{
    			String  newdir  ; 
    			System.out.println("Enter the  directory you want :");
    			
    			cin.nextLine();
    			newdir = cin.nextLine();
//    			if((newdir.charAt(0)=='E'||newdir.charAt(0)=='D')&&(newdir.charAt(1)==':'))
//    	    	{
//    				File  delete  =  new  File (newdir);
//        			deleteDirectory(delete);
//    	    	}
//    	    	else 
//    	    	{
//    	    		
//    	    	}
    			File  delete  =  new  File (directory+"\\"+newdir);
    			deleteDirectory(delete);
    			
    		}
    		else  if(choice==5)
    		{
    		
    			for(int i= 0 ;i<20;i++)
    				System.out.println("\n");
    		}
    		else  if(choice==6)
    		{
    			
    		}
    		else  if(choice==7)//copy
    		{
     			
    			String  from  , to ;
    		        from = "";
    		        to= directory+"\\2";
    		        
    		        File dirfrom  = new File(from);
    		        File dirto =new File(to);
    		        
    		        try
    		        {
    		        	 copyfile(dirfrom, dirto);
    		        }
    		        catch(IOException x)
    		        {
    		        	System.out.println("cannot copy . \n\n");
     		         }
    		        
    		}
    		else  if(choice==8)//move
    		{
 
    		}
    		else  if(choice==9)//cat 
    		{
    			System.out.println("Enter directory :");
    			String  newdir  , dir  ;
    			
    			cin.nextLine();
    			newdir = cin.nextLine();
    			
       			try{ 
	       			FileReader  f = new  FileReader (directory+"\\"+newdir);
		    			
	       			if(f.ready())  
	       			{
		    			 BufferedReader input = new BufferedReader(f);
		    		        String x = null;  
		    		        while( (x = input.readLine()) != null ) 
		    		        {    
		    		            System.out.println(x); 
		    		        } 
	       			} else System.out.println("cannot  find  this  file.\n"); 
	       	    }catch(IOException x)
       			{
       				System.out.println("no file.\n");
       			}
       			
    		}
    		else if(choice==10)//rm 
    		{
    			String  newdir  ; 
    			System.out.println("Enter the  directory you want :");
    			
    			cin.nextLine();
    			newdir = cin.nextLine();
//    			if((newdir.charAt(0)=='E'||newdir.charAt(0)=='D')&&(newdir.charAt(1)==':'))
//    	    	{
//    				File  delete  =  new  File (newdir);
//        			deleteDirectory(delete);
//    	    	}
//    	    	else 
//    	    	{
//    	    		
//    	    	}
    			File  delete  =  new  File (directory+"\\"+newdir);
    			deletefiles(delete);
    			
    			
    		}
    		else  if(choice==11)
    		{
    			System.out.println(directory+"\n");
    		}
    		else  if(choice==12)
    		{
    			
     			 BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
 		        String x = null;  
 		        while( (x = input.readLine()) != null ) 
 		        {    
 		            System.out.println(x); 
 		            
 		        } 
 		        
 
    		}
    		else  if(choice==13)
    		{
    			DateFormat df  = new SimpleDateFormat("d/MMM/yyyy   hh:mm:ss");
    			Date d = new Date();
    			Calendar  c =  Calendar.getInstance();
     			System.out.println(df.format(c.getTime())+"\n");
     		}
    		else  if(choice==14)
    		{
    			
    		}
    		
    		System.out.print("\n\t1)change directory.\n\t2)mkdir.\n\t3)ls.\n\t4)rmdir.\n\t5)clean.\n\t6)help."
        			+ "\n\t7)copy.\n\t8)mv.\n\t9)cat.\n\t10)rm.\n\t11)PWD.\n\t12)args.\n\t13)date."
        			+ "\nEnter your choice::");
    		 
                       choice = cin.nextInt();
    		 
    		
    	}

    	
        
       

    }



}

