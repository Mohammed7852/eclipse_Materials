package LZW;

import java.util.*;

public class LZW {

	private Scanner cin = new Scanner(System.in);
	private  int start , end  , length  ,i , j , count , index;
	private  String  str1 ,str2  , original  ,str3 ,str4  ,str=""/*holds decompressed string */ ,temp=""; 
	/**
	 * this list will contains compression dictionary 
	 */
	private  List<String> List = new ArrayList();	
	/**
	 * will include decompression dictionary 
	 */
	private  List<String> List_1 = new ArrayList();
	
	/**
	 * will include compression result codes 
	 */
	private List<Integer>List2 = new ArrayList();
	
	
	public LZW()
	{
		start=end=length=i=count=index=j=0;
		str1 = str2  =original = "";
	}
	
	public LZW(String  o )
	{
		this.original=o;
	//	System.out.println("original is ="+o+"\n\n");
		setDictionary();
	}
	
	public void setoriginal(String o )
	{
		this.original=o;
		//System.out.println("original is ="+o+"\n\n");
		setDictionary();
	}
	
	public void  setDictionary()
	{
		for(int i=0 ;i<128 ;i++)
		{
			String temp = "";
			if(Character.isAlphabetic((char)i))
			  temp+=(char)i;
			List.add(temp);
			List_1.add(temp);
		}
		//System.out.print("\n\n"+List.size()+"\n"+List_1+"\n");
	}
	
	
	public void setcodes(List<Integer>L )
	{
		List2 = L;
		setDictionary();
	}//end of  set codes 
	
	
	public void Compress()
	{
		if(i==original.length()){ view_1();return ;}
  		if(i==0)
		  str1+=original.charAt(i++);
		else str1+=original.charAt(i-1);
  		
  		while(check()&&i<original.length())
		{
			    index=List.indexOf(str1);
 				str1+=original.charAt(i++);	
  		}//end while
  		if(!check()&&i==original.length())
 		{
 			List2.add(index);
 			List.add(str1);
 			str1=""+original.charAt(i-1);
 			index=List.indexOf(str1);
 			List2.add(index);
  		}
 		else if(!check())
		{
		  List.add(str1);
		  List2.add(index);
 		}
 		else  if(i>=original.length())
			{
			  index=List.indexOf(str1);
			  List2.add(index);
 			}
  		str1="";
 		Compress();
	}//end compress
	public boolean check(){return List.contains(str1) ;}//end of  check 

	
	
	public void Decompress()
	{
 		 if(j>=List2.size()){view_2();return ;}
 		 int x;
  		 if(j==0)
		 {	
			 x = List2.get(j++);
			temp=List_1.get(x);
			str+=temp;//desompressed string 
  		 }
			str3=temp;
			str4="";
  		while(check_2()&&j<List2.size())
		{ 
  			x=List2.get(j++);
  			if(x>=List_1.size())
 			{
 				temp=str3+str3.charAt(0);
 			}
 			else temp=List_1.get(x);
  			//System.out.print("j="+j+"  , x="+x+"   , temp="+temp+"   ,  str3="+str3+"  ,  ");
 			str+=temp ;//decompressed string 
   			str4=str3+temp.charAt(0) ;
   			//System.out.print("str4="+str4+"   , list_1 size() ="+List_1.size()+"   ,  ");//System.out.print("str="+str+"\n\n");
  		}//end while
 		List_1.add(str4);
   		Decompress();
 	}//end of decompress
	public boolean check_2(){return List_1.contains(str4);}
	
	
	
	
	public String view_1()
	{	
		// System.out.println("Result of compression is :"+List2.toString()+"\n\n");
		return List2.toString();
	}
	public String view_2()
	{
		// System.out.println("Result of Decompression is :"+str.toString()+"\n\n");

	  	return str  ;
	}
	
}
