import java.sql.*;

public class DatabaseConnection {
	 
	public static void main(String []args) throws SQLException{
		//get data connecion to DB
		Connection my_connec;
		try {
			my_connec = DriverManager.getConnection("jdbc:mysql://localhost:3306/shabanah", "mohamed", "mohamed");
			//System.out.println("Sucessfully");

			
			
			
			Statement stmt  = my_connec.createStatement();
			String  sql ="select * from student_table";
			
			 ResultSet result  ;
			 result  = stmt.executeQuery(sql);
			 //or  we  use  exequteupdate 
			System.out.println("Sucessfully");
			
			while(result.next()){
				System.out.println(
						"Name :"+result.getString("name")+
						"    ,ID :"+result.getInt("id")+
						"    ,Age :"+result.getInt("age")+
						"    ,Salary :"+result.getInt("salary"));
 			}
			/**
			 
			 while(result.next()){
				System.out.println(
						"Name :"+result.getString(2)+
						"    ,ID :"+result.getInt(1)+
						"    ,Age :"+result.getInt(3)+
						"    ,Salary :"+result.getInt(4));
 			} 
			 */
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println(e);
		}
		
//		
		
	}
}