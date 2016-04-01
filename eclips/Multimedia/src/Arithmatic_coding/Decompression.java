package Arithmatic_coding;

import  java.util.*;
import java.io.*;
import java.math.BigDecimal;

public class Decompression {

	private  Double low=0.0 ,  up =1.0 ; 
	private  String  str1= "" , str2  ,str3  ; 
	private  Double  Result  ; 
    private List<Double> problist = new ArrayList();
	private  List<Character> chars = new ArrayList();
	private  List<Double> lower = new ArrayList();
	private  List<Double> upper  = new ArrayList();
	private  Compression comp = new  Compression();
	private int count = 0  ,counter = 0;
	
	/********************************************************/
	 
	public void decompress() throws IOException{
	   
		Reader r = new FileReader ("output.txt");
		BufferedReader br = new  BufferedReader(r);
		String temp = "" ;
		if(br.ready())
		     temp = br.readLine();
		br.close();
		
		
		
		int  x  = temp.indexOf('|');
		String  count = temp.substring(0 , x);
		//System.out.println("temp="+temp+"    count="+count+"\n");;
		
		Result = Double.parseDouble(count);
		count= temp.substring(x +1 , temp.length());
		//System.out.println(count);
		counter = Integer.parseInt(count);
		
		//System.out.println("Result="+Result+"    count="+count+"   counter="+counter+"\n");;
		
		r  = new FileReader("Dictionary.txt");
		br  = new  BufferedReader(r);
		if(br.ready())
		temp = br.readLine();
		br.close();
		System.out.println("temp ="+temp+""+"   \n");;
		
		
		for(int  i=0 ;i<temp.length();i++){
			if(Character.isAlphabetic(temp.charAt(i))){
 				chars.add(temp.charAt(i));
				i+=2;
				Character ch = temp.charAt(i++);
				String str ="";
				while(ch!=','&&ch!='}'){
					str+=ch;
					ch = temp.charAt(i++);
				}//while
  				problist.add(Double.parseDouble(str));
//				System.out.println(chars);
	//			System.out.println(problist);
 			}
		}
		//here  we  must read probs   , and  chars   ,  and  count  
		
//		problist.add(0.8);
//		problist.add(0.02);
//		problist.add(0.18);
//		chars.add('A');
//		chars.add('B');
//		chars.add('C');
		//counter=4;
		
		List<Double> l = new ArrayList();
		List<Double> u = new ArrayList();
		
		comp.compute_rangs(problist, l, u);
		
		lower = new ArrayList(l);
		upper = new  ArrayList(u);
		 
		//System.out.println("check result ="+check_range(0.99));
		
		
		//System.out.println("prob="+problist+"     \nl="+l+"    \nu="+u+"\n");;
		
		recursive(l, u);
		System.out.println("Result  of  Decompression ::"+str1);
	 }//decompress
	/******************************************************/
	public int  check_range( List<Double> l , List<Double> u ){ 
		  Double res = (Result-low)/(up-low);
		  Double  d  =(Result-low)  / (up - low) ;
  		//System.out.println("res ="+res+"       Result  = "+Result + "    l="+l+ "    u="+u);
  		 int index = -1 ;
  		for(int  i= 0 ;i<lower.size() ;i++){
  			if(res>=lower.get(i)&&res<upper.get(i)){
  				index=i;
  				break ;
  			}else{
  				
  			}
  		}//for 
  		
  		return index ;
	}//check range 
	
	/************************************************************/
	
	public void recursive(List<Double>l , List<Double> u){
		
		if(count>=counter)return ;
		
		int  index  ;
		//if(count==0){
		//System.out.println(l+"\n   u = "+u+"\n");
 		   index  =  check_range(l , u);
		 
		
		str1+=chars.get(index);
	    
		
 
			low= l.get(index);
			up = u.get(index);
 
	    l = new ArrayList();
		u = new  ArrayList();
		
		Double  a  ,b  ; 
		for(int  i=0 ; i<chars.size() ; i++){
			a= low+((up-low)*lower.get(i));
			b= low+((up-low)*upper.get(i));
			l.add(a);
			u.add(b);
		}//for
		count++;
		
		System.out.println("\nlow="+low+"    \nup="+up);
		
		recursive(l, u);
		
		
	}//recursive
	
}//class

