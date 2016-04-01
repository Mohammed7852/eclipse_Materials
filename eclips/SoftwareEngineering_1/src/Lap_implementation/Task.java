package Lap_implementation;
import java.util.*;

public class Task {

	private Scanner  cin = new Scanner(System.in);
	
	private  String  name  , description , dudate    ;
	private  boolean isDone ;
	
	
	public Task() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	
	
	public  Task(String  name  , String  des  , String  dudate  , boolean isdone ){
		this.name = name  ;
		this.description = des ;
		this.dudate = dudate  ;
		this.isDone = isdone ;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getDudate() {
		return dudate;
	}

	public void setDudate(String dudate) {
		this.dudate = dudate;
	}

	public boolean isDone() {
		return isDone;
	}

	public void setDone(boolean isDone) {
		this.isDone = isDone;
	}
	
	public  boolean getisdone(){
		return isDone;
	}
	
	
	public  String toString (){
		return "\n\nTask ::"
				+ "Name ::"+getName()+"\n"
				+ "Description ="+getDescription()+"\n"
				+ "Dudate ="+getDudate()+"\n"
				+ "is  Done  ="+getisdone()+"\n\n"
				+ "";
	}





	public void createtask() {
		// TODO Auto-generated method stub
		System.out.print("Name :");;
        name = cin.nextLine();
        System.out.print("Description  :");;
        description = cin.nextLine();
        System.out.print("Dudate :");;
        dudate = cin.nextLine();
        isDone =false ;
		
	}
	
	
}
