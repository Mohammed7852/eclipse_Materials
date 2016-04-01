/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package  project1 ;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class ConnectionDB {
    public static final String url = "jdbc:mysql://localhost:3306/first";
    public static final String user = "root";
    public static final String password = "mohamed_7852" ;
    
    public ConnectionDB()
    {
        
    }
    public Connection connect() throws SQLException, InstantiationException, IllegalAccessException
    {
        //Connection con = null ;
        try {
               Class.forName("com.mysql.jdbc.Driver");
               Connection conn = null;
               conn = DriverManager.getConnection(url,user,password);
//               conn.close();
             //  conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/Drivers");
               System.out.println("Successfully Connection");
            
            return conn  ;
        }  catch (ClassNotFoundException e) {
            System.out.println("F Connection");
            e.printStackTrace();
        }
        return null ;
    }
}
