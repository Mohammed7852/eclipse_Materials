package project1;



 
import  java.sql.*;

import java.util.*;

import javax.naming.spi.DirStateFactory.Result;
import javax.swing.*;


public class User_model {
        
    private int Id ;
    
 /*   public static  void  main(String []args) throws SQLException, InstantiationException, IllegalAccessException{
        
            String  host = "jdbc:mysql://localhost:3306/hameed1";   
            String pass ="hameed";
            String name ="root" ;        
            Connection connect  = DriverManager.getConnection(host , name  , pass);
            String str ="alter table user "
                + "add User_Email VARCHAR(255) not  NULL" ;
         
            String  sql="insert into user values("
                    + "'Hameed Muneef',"
                    + "20130356,"
                    + "'hameed',"
                    + "'hameedmuneef@gmail.com',"
                    + "'premuim user')"
                    + ""
                    + ""
                    + "";
            
            Statement stm = connect.createStatement();
            
            stm.executeUpdate(sql);
          
            User_model obj = new User_model();
            
            obj.delateUser(1);
            
            //Statement stm  = connect.createStatement();
            //ResultSet res =   stm.executeQuery(str);
 

//          while(res.next()){
//              String  s = res.getString("name");
//              int  i = res.getInt("id");
//          System.out.print(s+"   "+i+"\n");
//          
//          
//          }
//          
          
          
          
    }//
    **/

    
    private String Uname;
    private String password ;
    private String type;
    private String Email;
    private boolean active=false;
    private  List<User_model>userslist = new  ArrayList();
    private List<TasteModel>  taste = new ArrayList() ;
    private Map<String, User_model> friendshipnotifications= new HashMap();
    private Map<String, User_model>Likenotifications  =new  HashMap();
    private  Map<String , User_model> messagenotifications = new  HashMap();
    private List<User_model> friendslist = new  ArrayList();
    
    public List<User_model> getfriends(){
        return  userslist;
    }
    
    public void addfriend(User_model um){
        this.friendslist.add(um);
    }
    public void addfriendntification(String  notify , User_model sender){
        friendshipnotifications.put(notify , sender);
    }
    
    public Map<String, User_model> getfriendntification(){
        return friendshipnotifications ;
    }
    
     public User_model(){
    }
    public void addlikenotification(String notify , User_model um ){
        Likenotifications.put(notify  ,um);
    }
    public  Map<String  , User_model>getlikenotification(){
        return Likenotifications;
    }
            
            
    public void addmessagenotification(String notify , User_model um){
        messagenotifications.put(notify , um);
    }
    public Map<String, User_model> getmessagenotification(){
        return messagenotifications ;
    }
    
   public void addNewTaste(TasteModel tas){
        taste.add(tas);
    }
   
    public List<TasteModel>  getTaste(){
        return taste;
    }
    
    public void setActive(boolean t){
        active=t;
    }
    
    public boolean getActive(){
        return active;
    }
    
    public void set_ID(int id){
        Id=id;
    }
    public void set_Uname(String name){
        Uname=name;
    } 
  public void set_password(String pass){
        password=pass;
    }
   public void set_type(String  t){
        type=t;
    }
   public void set_mail(String m){
        Email=m;
    }
public int get_ID(){
    return Id;
}
public String  get_type(){
    return type;
}
public String get_Uname(){
    return Uname;
}
public String get_password(){
    return password;
}
public String get_Email(){
    return Email;
}

public void AddNewUser(User_model user){
    
}

public User_model getUser(int id){
    
    for(int i=0;i<userslist.size();i++){
    
        if(userslist.get(i).Id==id)
            break;
            return userslist.get(i);
    }
    return null;
}

public String forgetpassWord(String Email){
    
    for(int i=0;i<userslist.size();i++){
        if(userslist.get(i).get_Email().equals(Email))
            return userslist.get(i).get_password();
    }
    
    return "not found  ";
}

public void delateUser(int id) throws SQLException{
      String  host = "jdbc:mysql://localhost:3306/hameed1";   
            String pass ="hameed";
            String name ="root" ;        
            Connection connect  = DriverManager.getConnection(host , name  , pass);
            
    String st="DELETE FROM user\n" +
    "WHERE User_id = id ";
    
    Statement stm = connect.createStatement();
    
    stm.executeUpdate(st);
   
        
    
    for(int i=0;i<userslist.size();i++){
        if(userslist.get(i).Id==id)
            userslist.remove(i);
    }
}

public void updetUser(User_model user,int id){
    for(int i=0;i<userslist.size();i++){
        if(userslist.get(i).Id==id){
            userslist.add(i, user);
            break;
        }
}
}

/***********************************************/

public void readmotification(String note,int id){
    
    for(int i=0;i<userslist.size();i++){
        if(userslist.get(i).Id==id){
    System.out.println("you recieved notification from "+userslist.get(i).get_Uname());
}
    }
}


}//class
