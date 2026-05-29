import java.util.ArrayList;

public class ArrayListDemo {
    public static void main(String[] args) {
        ArrayList<String> students = new ArrayList<>();

        students.add("Kushitha");
        students.add("Ravi");
        students.add("Anu");
        students.add("Meena");

        System.out.println("Student List:");
        for (String student : students) {
            System.out.println(student);
        }

        students.remove("Ravi");

        System.out.println("\nAfter removing Ravi:");
        System.out.println(students);

        System.out.println("Total students: " + students.size());
    }
}