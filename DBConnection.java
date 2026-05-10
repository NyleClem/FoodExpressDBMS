import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    // Database connection details
        static String url = "jdbc:mysql://127.0.0.1:3306/FoodExpress2"; 
        // jdbc:mysql://host:port/databaseName
        
        static String user = "root";     
        // MySQL username
        
        static String password = "Fatika@006"; 
        // Replace with your MySQL root password

 public static  Connection getConn() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");  // Load MySQL driver
        return DriverManager.getConnection(url, user, password);
    }
    
}
