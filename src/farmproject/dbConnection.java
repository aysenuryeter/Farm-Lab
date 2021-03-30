package farmproject;

import java.sql.*;


public class dbConnection {

  
    static final String user= "";
    static final String pass = "";
    static final String host = "";
    static final int port = 3306;
    static String dbname = "";    
    
  

//That method we will use to connect to the database
    public static Connection connectDB() {

        Connection conn = null;
      String url = "jdbc:mysql://" + host + ":" + port + "/" + dbname + "?useUnicode=true&characterEncoding=utf8";
        try {
           Class.forName("com.mysql.jdbc.Driver");
          
             conn = DriverManager.getConnection(url, user, pass);

            return conn;

        } catch (Exception ex) {
            System.out.println("There were errors while connecting to db");
            return null;
        }

    }

}
