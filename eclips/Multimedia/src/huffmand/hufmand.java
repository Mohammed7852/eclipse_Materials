package huffmand;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.math.BigDecimal;
import java.util.*;


public class hufmand 
{

	private Set<Character> set = new HashSet<Character>();
	
	private  Scanner cin=new Scanner(System.in);
 	
	private  int size  , max   ; 
  	
 	private Stack<List<Double>> s = new  Stack();
  	private Stack<List<Double>> stack = new  Stack();
   	private Stack<List<String>> string_stack = new Stack();
   	
	private List<String> lcodes= new ArrayList();
	private   List<String> lstring  = new ArrayList();
	private List<String> lstring2 = new ArrayList();
	
   	private  String  s1="0" , s2 = "1" , string , st = "";
	
	private  List<Double> problist = new ArrayList();
	
	private Map<Character,String > map = new HashMap();
	
	private List<String> compressedlist  =new ArrayList();
	
	/**************************************************************************************/
		/**
		 * this method sort doubles  and  their  strings  .
		 */
	public  void  sort_descending(){
		int  sz = problist .size();
		for( int  i = 0 ; i < sz ; i++)
		{
			int  max = i ;
			for(int  j = i+1 ; j<  sz; j++)
			{
				if(problist.get(j) > problist.get(max))
				{
					max =j;
				}
			}
			//here i swap doubles and in same time i swap strings also to same location in other list 
			Double  swap1 = problist.get(i);
			problist.set(i, problist.get(max));
			problist.set(max, swap1);
			
			String  swap2 = lstring.get(i);
			lstring.set(i, lstring.get(max));
			lstring.set(max, swap2);
		}//end for
	}//end sortdescending   method
	
	public void codes()	{
    	
		List<String> l1  =new ArrayList();
  		List<String> l2  =new ArrayList();
  		List<String> ls1   = new ArrayList();
  		List<String> ls2   = new ArrayList();
   	
  		int  i = 0 ;
  		while(!string_stack.isEmpty()){
   			 ls1 = string_stack.pop() ;
  			 l1 = new ArrayList();
    			 if(i==0){
  				 l1.add(s1);
  				 l1.add(s2);
   			 }
  			 else {
  				 String res = "";
  				 int  count = 0 ;
  				 int sz= ls1.size();
  				 int c= 0 ;
  				 for(String  x  : ls1){ 
  					 int  index = ls2.indexOf(x);
   					 c++ ;
  					  if(index!=-1){
    					 l1.add(l2.get(index));
  					 }else{
  						 count++ ;
  						 res  +=  x ;  
  						 if(count==2){
  							 count = 0;
  							 index = ls2.indexOf(res);
							//System.out.print("res="+res+"   "+index+"   \n");
  							 l1.add(l2.get(index)+s1);
  							 l1.add(l2.get(index)+s2);
     					 }
  					 }
  				 }//end for
  			 }//end if
   			l2 = new ArrayList(l1) ;
   			ls2 = new ArrayList(ls1) ;
    		lcodes = new ArrayList(l2);
   			i++;
   		 }//end whil
		System.out.println("\t\tfinally::\n"+ls2+"     ,    "+l2+"\n");
  		 
  	}//end codes  method
  
	/**
	 * method calculate chars probability 
	 */
  	public void calculateprobability(){
  		List<Character> list = new ArrayList<Character>();
 		List<Double> L = new ArrayList();
 		for(Character c : string.toCharArray() ){
 			list.add(c);
			set.add(c); 		
		}
		String  st ="";
		for(Character c : set){
  		    Double x =   (double) (Collections.frequency(list, c) );
  		    Double sz=  (double) string.length() ;
  		    Double res = x/sz ;
  		    double d = new BigDecimal(res).setScale(1,BigDecimal.ROUND_HALF_UP).doubleValue();
  		    L.add( d);
   		    st+=c ;
  		    lstring.add(st);
  		    st="";
		}
 		problist =L; 
 		}//end  of  probabilty  method 
  	/**
  	 * Assigns  user string to class string 
  	 * @param str
  	 * @throws IOException 
  	 */
  	public String  Compress(String  str) throws IOException{
  		this.string = str ;
  		calculateprobability();
  		//////
  		s.push(new ArrayList(problist));
 	    string_stack.push(new ArrayList(lstring));
	    sort_descending();
		recursive();//calls method recursive to get all probs 
  		/////////
  		//setlist( );
  		codes();// to get codes for  all chars 
		//print();
		
		int  i= 0 ;
		for(Character c : set){
 			map.put(c ,lcodes.get(i++));
		}
		for(Character c : string.toCharArray()){
			compressedlist.add(map.get(c));
		}
		String temp = "";
		for (String  s :compressedlist){
			temp+=s;
		}
			
		 FileOutputStream out  = new FileOutputStream("Dictionary.txt"  );
		 
		 try {
			 String str2 = map.toString();
			out.write(str2.getBytes());
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally{
			   out.close();
		}
		 
		 
		System.out.println("Compressed files  is  ::\n"+temp+"\n");
		return  temp;
  	}//end  of  compression
  	
  	/**
  	 * prints  prob  and  codes 
  	 */
  	public void print()
  	{
  		System.out.println("\n\tprint:\n"+stack.get(0)+"    "+lcodes+"\n");
  	}
  		 
  	public void setlists(List<Double> l , List<String> ls)
  	{
  		this.problist = new ArrayList<Double>(l);
  		this.lstring = new ArrayList(ls) ;
  		s.push(new ArrayList(problist));
 	    string_stack.push(new ArrayList(lstring));
 	    sort_descending();
		recursive();//calls method recursive to get all probs 
//  		System.out.println("we have this two lists  ::\n"
//  				+ "prob list :"+problist+"\n"
//  						+ "lstring  :"+lstring+"\n");
  	}
	/**
	 * 
	 * @param l
	 */
	void recursive(){
		s.push(new ArrayList(problist));
		stack.push(new ArrayList(problist));
		string_stack.push(lstring);
		
 		if(problist.size()==2){
			return ;
		}
	 	
 		 List<Double> list = new ArrayList();
 		 list = new ArrayList(problist) ;
 		 int sz = list.size();
 		 list.set(sz-2, problist.get(sz-2)+problist.get(sz-1));/*************/
 		 list.remove(sz-1);
 		 
 		 List<String> ls = new ArrayList();
 		 ls = new ArrayList(lstring) ;
 		 ls.set(sz-2 , lstring.get(sz-2)+lstring.get(sz-1));
 		 ls.remove(sz-1);
 		 
 		 lstring  = new ArrayList(ls);
 		 problist = new ArrayList(list);
 		 
 		 sort_descending();
 		 
 		 recursive();//recursive function 
	}//end recursive
	
//////////////////////////////////////////////////////Descompression 
	public List<String> getcodes()
	{
		return lcodes;
	}
	
 	
	public void deconmpress( String str  ) throws IOException{
		
		Map<String , Character > ma = new HashMap();
 		
		/*******************************************/
	   	 Reader in = null;
		try {
			in = new  FileReader("Dictionary.txt");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	      BufferedReader r  = new BufferedReader(in);
	      String   x = null ;
	      Character c1 ;
	       if(r.ready()){
	    	   x = r.readLine();
	       }
	    	
		String temp = "";
    	for(int  i = 0 ; i <x.length() ; i++){
    		Character c = x.charAt(i) ; 
    		temp = "";
    		if(Character.isAlphabetic(c)){
    			i++;
    			while(true){
    				c1 = x.charAt(++i);
    				if(c1=='0'||c1=='1')
    				{
    					temp +=c1;
    				}
    				else break ;
    			}
    			ma.put(temp, c);
    			System.out.println(c + "  "+ temp+"\n");
    		}
    	}
		/*************************************************/
		List<String> result = new ArrayList();
		String resulting_string = "";
		   temp = "";
		
		for( Character c : str.toCharArray()){
			temp+= c;
               	boolean t = ma.containsKey(temp);
               	if(t){
               		Character ch = ma.get(temp);
               		resulting_string+=ch;
               		temp="";
               	}
 		}
 		System.out.println("Your String  is  ::"+resulting_string+"\n\n");
	}
	
	
	
}
