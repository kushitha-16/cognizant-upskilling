import java.sql.Connection;
import java.sql.DriverManager;

public class BasicJDBCConnection {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cognizant_practice";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            System.out.println("Database connected successfully.");

            connection.close();
        } catch (Exception e) {
            System.out.println("Database connection failed.");
            System.out.println(e.getMessage());
        }
    }
}