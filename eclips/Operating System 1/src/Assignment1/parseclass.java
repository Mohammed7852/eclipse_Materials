package Assignment1;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class parseclass extends Command{
 
	
	/*************************************************************/

	public void separate(String  line) throws IOException  
	{
		str1=str2=str3=null;
		
		 String  [] arr = line.split("\\s+");
		 
		 int i = 0;
		     
		 if(i++<arr.length)
	   	     str1 = arr[0];
		   
		     if(i++<arr.length)
	    	     str2= arr[1];
			 
		     if(i++<arr.length)
		    	 str3=arr[2];
		     
	   	     //System.out.println(str1+","+str2+"   "); 
	  	 check();
	}

	/**************************************************/
	
	public void  check() throws IOException
	{
		if(str1.equals("cd"))//cd
		{
			if(str2==null)
			{
				directory = defaultdir ;
			}
			else 
			{
				
				File  f1 = new File(str2).getAbsoluteFile();
	 
				boolean b =f1.exists() ; 
				
	 			 //System.out.println(b);
				if(b)
				if(str2.charAt(1)==':')
					setdirectory(str2);
				else
				  setdirectory(directory+"/"+str2);
				
				else System.out.println("No such file or directory.\n");
			}
		}
		else  if(str1.equals("ls"))//ls
		{
		
	 		//if(str2==null)
			{
				File curdir = new  File(directory);
	   	    	ls(curdir);
			}
			
		}
		else if(str1.equals("mkdir"))//mkdir
		{
			if(str2==null)
			{
				System.out.println("mkdir requres file or directory.\n");
			}
			else 
			{
				 mkdir(directory+"/"+str2);
			}
		}
		else if(str1.equals("rmdir"))//rmdir
		{
			if(str2==null)
			{
				System.out.println("rmdir requres directory.\n");
			}
			else 
			{
				File  delete  =  new  File (directory+"/"+str2);
					boolean b = delete.exists();
				
				if(b)
	   			 rmdir(delete);
				else System.out.println("no  directory.\n");
	 		}
		}
		else if(str1.equals("rm"))//rm
		{
			if(str2==null)
			{
				System.out.println("must specify file.\n");
			}
			else 
			{
				File  delete  =  new  File (directory+"/"+str2);
				boolean b = delete.exists();
				
				if(b)
	   			 rm(delete);
				else System.out.println("no file or such directory.\n");
			}
		}
		else if(str1.equals("cat"))//cat
		{
			if(str2==null)
			{
				echo();
			}
			else
			{
				cat();
			}
		}
		else  if(str1.equals("cp"))//copy
		{
			if(str2==null||str3==null)
			{
				System.out.println("write files.\n");
			}
			else
			{
				File From  ,to ;

				if(str2.charAt(1)==':')
					 From = new File(str2);
				else From = new File(directory+"/"+str2);
					
				if(str3.charAt(1)==':')
					 to = new File(str3);
				else to = new File(directory+"/"+str3);
				
				if(to.isDirectory()||!to.exists()||From.isDirectory()||!From.exists())
					System.out.println("cp : cannot  state ~"+str2+" : no such file  or  directory.\n");
				else cp(From , to);
		     }
			
		}
		else if(str1.equals("mv"))//mv
		{
			if(str2==null||str3==null)
			{
				System.out.println("no files specified.\n");
			}
			else
			{
				File From  ,to ;

				if(str2.charAt(1)==':')
					 From = new File(str2);
				else From = new File(directory+"/"+str2);
					
				if(str3.charAt(1)==':')
					 to = new File(str3);
				else to = new File(directory+"/"+str3);
				
				 if(to.isDirectory()||!to.exists()||From.isDirectory()||!From.exists())
				 	System.out.println("mv : cannot  state ~"+str2+" : no such file  or  directory.\n");
				  MV(From , to);
		     }
		}
		else 
			if(str1.equals("pwd"))//pwd
				{
			            pwd();
				}
			else if(str1.equals("date"))//date
			{
				date();
			}
			else if(str1.equals("help"))//help
			{
				help();
			}
			else if(str1.equals("clear"))//clear
			{
				clear();
			}
			else if(str1.equals("exit"))//exit
					{
						 System.exit(1);
					}
			else if(str1.equals("less"))//less
			{
				if(str2==null)
				{
					System.out.println("no file to be used.");
				}else
				{
					File  file  ; 
					if(str2.charAt(1)==':')
						 file = new File(str2);
					else file = new File(directory+"\\"+str2);
					if(!file.exists())System.out.println("No such file or  directory.\n");
						less(file);	
				}
			}
			else  if(str1.equals("more"))//more
			{
				if(str2==null){
					System.out.println("no file to be used.");
				}
				else 
				{
					File  file  ; 
					if(str2.charAt(1)==':')
						 file = new File(str2);
					else file = new File(directory+"\\"+str2);
					if(!file.exists())System.out.println("No such file or  directory.\n");
						more(file);	
				}
			}
			else if(str1.equals("args"))//args
			{
				arg();
			}
			else System.out.println("$@~"+str1+"is not a Command.");

		
	}//

	
}
