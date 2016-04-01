package Tasks;
import  java.util.*;

public class task1 {

	public  static void  main(String[]args){
		Scanner  cin = new Scanner(System.in);
		
		//System.out.println("Mohammed Ali");
		
		String  str1 , str2 , result ="";
 		List<String> l = new  ArrayList();
 		str1 = cin.nextLine();
		str2 = cin.nextLine();
 		System.out.println("str1="+str1+"    str2="+str2+"\n");
		String temp = "";
		int  max=0 ;
		
		for(int  i=0 ;i<=str1.length();i++){
 			for(int  j=i+1;j<str1.length();j++){
 				temp=str1.substring(i , j+1);
  				if(str2.contains(temp)){
					l.add(temp);
					if(l.size()==1) 
						max = temp.length();
					else  if(temp.length()>max){
						max=temp.length();
						result = temp;
					}
				}
			}//for
		}//for
		
		System.out.println("commone  strings are  :"+l);
		System.out.println("maximum string is  :"+result+"\n");
		
	}//main
}
