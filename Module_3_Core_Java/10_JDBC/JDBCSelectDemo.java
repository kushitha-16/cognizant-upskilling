import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class JDBCSelectDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cognizant_practice";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT * FROM students");

            while (resultSet.next()) {
                System.out.println(
                    resultSet.getInt("id") + " " +
                    resultSet.getString("name") + " " +
                    resultSet.getString("course")
                );
            }

            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Select failed.");
            System.out.println(e.getMessage());
        }
    }
}