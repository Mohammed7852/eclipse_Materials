package LZ_77;
import java.util.*;
 

/**
 * 
 * @author mohamed ali shabanah
 * @see this class comprise the files  using  LZ77 method  
 */

public class Compression {

	private Scanner cin = new Scanner(System.in);
	/**
	 * these variables for compression 
	 */
	private   int   length = 0, back= 0  , start = 0  ,i=0   ; 
	private String original ,  str1 =""   , next ; 
    /**
     * for decompression 
     */
	private  int count =0 , num1 = 0 , num2 = 0  ;
	private String  str2 ="" , Next  ;
	
	/**
	 * this list will hold the pointer position that found
	 */
	private List<Integer> first =new  ArrayList() ;
	/**
	 * this list holds the length of found string 
	 */
    private List<Integer> second = new ArrayList();
    /**
     * this list holds the next characters 
     */
    private List<String> third = new ArrayList();
    
	
	Compression(){}
	/**
	 * 
	 * @param o takes the  original string  
	 */
	Compression(String  o )
	{
		this.original = o ;	
		length = back = 0 ;
		next = "";
	}
	
	/**
	 * assigns value to original string 
	 * @param o is the original string 
	 */
	public void set_original(String  o )
	{
		this.original = o ;
		System.out.print("original  = "+original+"\n");
		str1="";
	}
	
	/**
	 * check method 
	 * @return  boolean true  if the desired  string  is found  otherwise return false 
	 */
	public boolean check()
	{
		boolean temp = false ;
		
		 int  index = original.lastIndexOf( str1 , start-1 );
		
		 if(index<0)
		{
			temp= false ;
 		}
		else 
			{
				temp =true ;
				back = start - index ;
			}
 		return temp ;
	}
	
	 
	
	/**
	 * recursive function test all codes until reaching to end 
	 */
	public void comprise()
	{
		start = i ;
 
		if(start>=original.length())
			{
			    view();
				return ;
			}
		length = back = 0;
		next="";
		
		str1 +=original.charAt(i++);
		//System.out.println(str1 + "   " +start+"   "+i+ "\n");
	
 		while(check()&&i<original.length())
		{
			//System.out.print(i+"  ");
			str1 +=original.charAt(i++);
 		}
		
 		
 		length = str1.length() - 1 ;
		next +=str1.charAt(length);
 		
		//here if counter ( i ) goes to end of string and the last char is found previously 
		if(i==original.length()&&check())
 		{
 			length = str1.length() ; 
 			next=null;
 		}
 		
		//adding new values to their lists 
 		first.add(back);
 		second.add(length);
 		third.add(next);
 		
 		//System.out.println(str1+"   "+back + "  " + length + "  "+i+"   "+start+"   "+next+"   "+ "\n");
  		str1="";
		
  		
  		comprise();
		
	}//end comprise method
	
	/**
	 * to view the summary of codes 
	 */
	public void view()
	{
		System.out.println("Summary of Codes is  :\n");
		int sz= first.size();
		
		for( int  i=0 ; i< sz ; i++ )
		{
			System.out.print("("+first.get(i)+ " , "+second.get(i) + " , "+ third.get(i)+ " ).\n");
		}
	}//end  view
	
	
	/**
	 * method set codes 
	 */
	public void setcodes(int  sz  )
	{
		System.out.print("you should give us codes to decompress them .\n");
		int  x  ,  y  ;
		String  temp ;
		for( int  i= 0 ;i<sz;i++)
		{
			System.out.println("code ("+(i+1)+")"+":");
			x = cin.nextInt();
			y  = cin.nextInt() ; 
 			temp = cin.next();
			
			first.add(x);
			second.add(y);
			third.add(temp);
		}
	}
	/**
	 * Decompression 
	 * will traverse the  lists of codes 
	 */
	
	public void Decompression()
	{
		 num1 = first.get(count);
		 num2 = second.get(count);
		 Next  =third.get(count++);
		 
		// System.out.println(str2+"  "+num1+"   "+num2+"   "+Next+"\n");
		
		 //this condition if the string in first appearance 
		 if(num1==0&&num2==0)
		 {
			 str2+=Next ;
		 }
		 else  
		 {
			 //back_index : holds the length of string  minus the number we go back 
		    int back_index = str2.length() - num1 ;
		   
		    //res2 ::holds the length we take from res too end of code length 
		    int length = back_index+num2 ;
		   
		    //System.out.println(res2+"   "+str2.length());
		   
		    //holds new substring
		    String temp = "";
		    
		    //if no overlapping 
		    if(length<=str2.length())
		    { 	
			 str2 +=str2.substring(back_index, length) ;
		    }
		    else
		    {
		    	//this while handles overlapping 
		    	//by increasing back_index  by one to take one char and adding it to str2
		    	while(back_index<length)
		    	{
		    		temp = str2.substring(back_index , back_index+1);
		    		str2 +=temp;
		    		back_index++;
		    	}
		    	
		    }
		    
		    //adding  last char to new string 
			 if(Next!=null)str2+=Next ;

		 }
		 //base case break method if the counter reaches to end of lists 
		 if(count<first.size())
		    Decompression();
		 else view2();
	}//end  of  decompression 
 

	/**
	 * show the string after decompression 
	 */
	public void view2()
	{
		System.out.println("\n\n"
				+ "String after Decompression :"+str2+"\n");
	}
	
	public String getcodes()
	{
		String  temp = "";
		int  sz= first.size();
		
		for( int  i=0 ;i<sz;i++)
		{
			temp+="\n("+first.get(i)+" , "+second.get(i)+" , "+third.get(i)+")\n";
		}
		
		
		return temp ;
	}
}
