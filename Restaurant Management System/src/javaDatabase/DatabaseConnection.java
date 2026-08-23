
package javaDatabase;
import java.sql.*;

public class DatabaseConnection {
    public static void main(String[] args) throws ClassNotFoundException, SQLException{
        Class.forName("org.postgresql.Driver");
        
        String url = "jdbc:postgresql://localhost:5432/Festival_Db";
        String username = "postgres";
        String password = "CJ Wilcox";
        
        Connection con = DriverManager.getConnection(
                    url, username, password
            );
        System.out.println("Sucessful");
         
    }
    
}
