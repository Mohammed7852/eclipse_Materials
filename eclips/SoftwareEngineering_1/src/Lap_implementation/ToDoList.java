package Lap_implementation;

import java.util.*;

public class ToDoList {

	 
	private  List<File> file  = new  ArrayList();
	private  List<Task> task = new  ArrayList();
	
	public ToDoList() {
 	}
	
	public void createtodo(){
		File fi = new File();
		Task ta = new Task();
		fi.createfile();
		ta.createtask();
		file.add(fi);
		task.add(ta);
 	}
	public ToDoList(  File lf  , Task lt){
 		this.file.add(lf)  ;
		this.task .add(lt) ;
	}
	public void settask(Task task){
		this.task.add(task);
	}
	
	public void setfile(File  file){
		this.file .add(file);
	}
	public  List<Task> gettasks(){
		return this.task ;
	}
	
	public void  addtask(Task ta ){
		
	}
	public  List<File> getfile(){
		return this.file;
	}
	public String  toString(){
		return ""
				+ "ToDoList  is  ::\n"
				+ "Tasks :+"+gettasks()
				+ "file ="+getfile()
				;
		
	}
	
	
	
	
	
}
