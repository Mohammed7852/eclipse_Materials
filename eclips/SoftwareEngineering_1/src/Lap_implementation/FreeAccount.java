package Lap_implementation;

import  java.util.*;

public class FreeAccount {

	private Scanner  cin = new Scanner(System.in);
	private  String  name  ;
	private  String  number  ;
	private  String  type  ;
	private  User user ;
	
	public void  setuser(User us ){
		this.user = us;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getNumber() {
		return number;
	}
	public void setNumber(String number) {
		this.number = number;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	public FreeAccount(String name, String number, String type) {
		 
		this.name = name;
		this.number = number;
		this.type = type;
	}
	
	
	public  String  toString (){
		return "\n\nAccount  information ::"
				+ "Name :"+getName()+"\n"
				+ "Number  ="+getNumber()+"\n"
				+ "Type  ="+getType()+"\n\n"
				+ "";
	}

	public void createaccount() {
		// TODO Auto-generated method stub

        System.out.print("User Account :");;
        System.out.print("Name :");;
        String  Accountname  = cin.nextLine();
        System.out.print("Account number :");;
        String  Accountnumber  = cin.nextLine();
        System.out.print("type :");;
        String  type  = cin.nextLine();
         
		
	}
	
}
