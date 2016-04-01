package Lap_implementation;

import  java.util.*; 

public class User {

	private  FreeAccount freeAccount  ;
	private  List<ToDoList>  todolist = new  ArrayList();
	
	private  String  name  , mail ;
	
	public User(String  name , String  mail  ){
		this.name = name  ;
		this.mail = mail ;
 		 setToDo();
 		 setfreeaccount();
 	}
	
	public void  setToDo( ){
		ToDoList todo =new ToDoList();
		todo.createtodo();
		this.todolist.add(todo);
	}
	public List<ToDoList>  gettodo(){
		return todolist;
	}
	
	public void  setfreeaccount(  ){
		 freeAccount.setuser(this);
		 freeAccount.createaccount();
	}
	public FreeAccount  getfreeaccount(){
		return freeAccount;
	}
	public  void  setname(String  n){
		this.name = n ;
	}
	
	public  String getname(){
		return name  ;
	}
	
	public void setmail(String m){
		this.mail = m;
	}
	
	public String  toString(){
		return "this  user :"
				+ "\n  Name :="+this.name+""+
				"\nMail ="+this.mail+"\n"
						+ "Has A freeAccount ="+this.freeAccount+"\n"
								+ "and  has  to do this  list ="+todolist+"\n\n";
		
	}
	
	
	
}
