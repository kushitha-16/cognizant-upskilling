record Student(int id, String name, String course) {
}

public class RecordDemo {
    public static void main(String[] args) {
        Student student = new Student(1, "Kushitha", "Java FSE");

        System.out.println("Student ID: " + student.id());
        System.out.println("Student Name: " + student.name());
        System.out.println("Course: " + student.course());
    }
}