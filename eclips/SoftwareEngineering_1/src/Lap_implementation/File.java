package Lap_implementation;

import java.util.*;;
public class File {

	private static Scanner  cin = new Scanner(System.in);

	private  String filename  , fileid  , filepage;

	public File() {
		// TODO Auto-generated constructor stub
	}
	
	
	
	public String  toString(){
		return "this file  has  ::\n"
				+ "name  ="+getFilename()+"\n"
						+ "ID = "+getFileid()+"\n"
						+ "Page "+getFilepage()+"\n"
						+ ""
						+ ""
						+ "";
	}
	public File(String  name  , String  id  ,String page){
		this.filename = name  ;
		this.fileid = id  ;
		this.filepage = page  ;
	}
	
	
	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public String getFileid() {
		return fileid;
	}

	public void setFileid(String fileid) {
		this.fileid = fileid;
	}

	public String getFilepage() {
		return filepage;
	}

	public void setFilepage(String filepage) {
		this.filepage = filepage;
	}



	public void createfile() {
		// TODO Auto-generated method stub
		 System.out.print("\n\nFile  info  :");;
         System.out.print("name   :");;
         filename = cin .nextLine() ;
         System.out.print("File  id  :");;
         fileid = cin.nextLine();
         System.out.print("filepage :");;
        filepage = cin.nextLine() ;
 		
	}
	
	
}
