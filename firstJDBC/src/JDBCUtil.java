import java.sql.Connection;
import java.sql.DriverManager;

public class JDBCUtil {
    public static Connection getConnection(){
        Connection conn = null;
        try {
            //Register the JDBC driver
            Class.forName("com.mysql.jdbc.Driver");

            //Open the connection
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/jdbc",
                    "root", "Hossein9090");

            if (conn == null) {
                System.out.println("Failed to connect.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
