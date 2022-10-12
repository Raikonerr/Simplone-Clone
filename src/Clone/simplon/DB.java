package Clone.simplon;

import java.sql.*;

public class DB {
    final static String url = "jdbc:mysql://localhost:3306/simplon";
    final static String username = "root";
    final static String password = "";
    protected static Connection con;
    protected static Statement stmt;

//connect database mysql
    public void connectDB(){
        try{
            Class.forName("com.mysql.jdbc.Driver");
            con = DriverManager.getConnection(url,username,password);
            stmt = con.createStatement();
            System.out.println("Connected to database");
        }catch(Exception e){
            System.out.println(e);
        }

    }
}
