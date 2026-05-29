import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class JDBCInsertDemo {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/cognizant_practice";
        String username = "root";
        String password = "root";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);

            String query = "INSERT INTO students(id, name, course) VALUES (?, ?, ?)";

            PreparedStatement statement = connection.prepareStatement(query);

            statement.setInt(1, 1);
            statement.setString(2, "Kushitha");
            statement.setString(3, "Java FSE");

            int rows = statement.executeUpdate();

            System.out.println(rows + " record inserted successfully.");

            statement.close();
            connection.close();
        } catch (Exception e) {
            System.out.println("Insert failed.");
            System.out.println(e.getMessage());
        }
    }
}