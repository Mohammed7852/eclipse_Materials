package Arithmatic_coding;

import java.io.BufferedReader;
 import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.io.*;
import java.util.*;

public class Compression {
	
	private  Double low=0.0  , up =0.0 ;
	private  int count=0;
	private  List<Double> lower = new  ArrayList();
	private  List<Double> upper= new  ArrayList();
	private  List<Character> chars  = new  ArrayList();
	private  String  string  = "0.1";
	private  Double  compression_result  ;
	private  String str ="" ;
	private List<Double>problist = new ArrayList();
	private  Map<Character , Double> ma  = new  HashMap();
	
	
	/***************************************************/
 
	
	/***************************************************/
	
	public void  compress() throws IOException{
		
		Reader in  = new  FileReader("input.txt");
		BufferedReader br  = new  BufferedReader(in);
		 if(br.ready()){
			str = br.readLine();
		 }
		 br.close();
		System.out.println("you to compress:"+str+"\n");
		//setchars(str);
		calculateprobability();
		
 		List<Double>l =new ArrayList();
		List<Double>u =new ArrayList();
		List<Double>prob=new ArrayList();
		
		
		//prob.add(0.8);
		//prob.add(0.02);
		//prob.add(0.18);
 
		compute_rangs(problist, l, u);
		lower = new ArrayList(l);
		upper = new ArrayList(u);
		//System.out.println(" lower="+l+"    \nupper="+u+""+""+"");
		
		//l =new ArrayList();
		//u =new ArrayList();
		
		recursive(str, l, u);
		System.out.println("result of  compression ="+compression_result+"\n");
		
		
		Writer w  = new FileWriter("output.txt");
		BufferedWriter bw  = new BufferedWriter(w);
		String s =compression_result.toString()+"|"+Integer.toString(count);
		//s+=Integer.toString(count);
		
		bw.write(s); 
		bw.close();
		
	}
/**
 * @throws IOException *****************************************************/
	public void calculateprobability() throws IOException{
  		
		List<Character> list = new ArrayList<Character>();
 		List<Double> L = new ArrayList();

 		Set<Character> s = new HashSet();
         for(Character ch :str.toCharArray()){
        	 list.add(ch);
        	 s.add(ch);
         }
         for(Character ch :s){
        	 chars.add(ch);
         }
         

		for(Character c : chars){
  		    Double x =   (double) (Collections.frequency(list, c) );
  		    Double sz=  (double) str.length() ;
  		    Double res = x/sz ;
  		  //System.out.println("c="+c+"    res= "+res+"");;
  		    //double d = new BigDecimal(res).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
  		     problist.add( res);
  		     ma.put(c, res);
		}
 		//problist =L; 
 		//System.out.println(problist);;
 		
 		Writer w  = new FileWriter("Dictionary.txt");
 		BufferedWriter  bw  = new BufferedWriter(w);
 		bw.write(ma.toString()); 
 		bw.close();
 		
   }//end  of  probabilty  method 
	
	/******************************************/
	public void setchars(String str){
		Set<Character> s = new  HashSet();
		for(Character  ch :str.toCharArray()){
			s.add(ch);
		}
		for(Character ch:s){
			chars.add(ch);
		}
		// System.out.print(chars);
	}//set chars 
	
	/**************************************************/
	public void  getcode(){
		
		while(true){
			int  pow = (int) Math.pow(2,string.length()-2) ;
			//System.out.print (pow+"   ");
			String str = string.substring(2, string.length()) ;
			//System.out.print(str+"   ");
			Double d  = (double) Integer.parseInt(str, 2);
			//System.out.print(d+"     \n");
			double res =  (d/pow) ;
			if(res>low&&res<up){//end of compression  
				 string="0.1";
 				 compression_result=res ;
				break ;
			}
			else if(res>=up){
				 String  str2 = string.substring(0 , string.length()-1);
				 str2+="0";
				 string = str2;
			}else  if(res<low){
			    string+="1";   
			}
		}//while
		
	}
	
	
	
	public void recursive(String str ,List<Double>l  , List<Double> u){
		 
		if(count>=str.length()){
			//System.out.println("low="+low+"   up="+up+""+(low+up)/2.0);;
			compression_result = (low+up)/2 ;
			//getcode();
			return ;
		}
		
 		Character  ch = str.charAt(count++);
		int  index  = chars.indexOf(ch);
		//System.out.println("ch="+ch+"   index="+index+"");;
 
 
			low= l.get(index);
			up = u.get(index);
			//System.out.println("low="+low+"   up="+up+"");;
		 
		
 		l = new ArrayList();
		u=new ArrayList();
		
 		Double  a , b ;
		for(int  i= 0 ;i<chars.size();i++){
			a=low+((up-low)*lower.get(i));
			b=low+((up-low)*upper.get(i));
			l.add(a);
			u.add(b);
		}
		System.out.println("\nlow="+low+"    \nup="+up);

		//recursive(0 , l , u );		
		//System.out.println("chars  = "+chars+"    \nlowers ="+l+"      \nuppers = "+u+"");	
		//System.out.println("low="+low+"   up="+up+"");;
 		recursive(  str , l  ,   u);
 		
	}//compress
	 	
	
	/***************************************************************/
 	
	public void  compute_rangs(List<Double> prob , List<Double>l  , List<Double> u){
 		
		if(count>=prob.size()){
  			//System.out.println("lower="+l+"    upper="+u+"\n\n");
			count= 0 ;
			low=up=0.0;
			return ;
		}
 		low = up ;
		up=prob.get(count++)+low;
 		l.add(low);
		u.add(up);
		compute_rangs(prob, l, u);
	}//compute prob 
	
	
}