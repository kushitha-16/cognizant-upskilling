import java.io.FileWriter;
import java.io.IOException;

public class FileWritingDemo {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("student.txt");

            writer.write("Name: Kushitha\n");
            writer.write("Course: Java FSE Upskilling\n");
            writer.write("Module: File Handling\n");

            writer.close();

            System.out.println("Data written to file successfully.");
        } catch (IOException e) {
            System.out.println("An error occurred while writing to the file.");
            e.printStackTrace();
        }
    }
}