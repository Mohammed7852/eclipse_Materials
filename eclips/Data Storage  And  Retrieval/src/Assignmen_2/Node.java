package Assignmen_2;

import java.io.Serializable;

public class Node implements Serializable{

	static int Age , Date, ID  ;
	static String Name ;
	private String name  ;
	public static int getAge() {
		return Age;
	}
	public static void setAge(int age) {
		Age = age;
	}
	public static int getDate() {
		return Date;
	}
	public static void setDate(int date) {
		Date = date;
	}
	public static int getID() {
 		return ID;
	}
	public static void setID(int iD) {
		ID = iD;
	}
	public static String getName() {
		return Name;
	}
	public static void setName(String name) {
		Name = name;
	}
	
}
