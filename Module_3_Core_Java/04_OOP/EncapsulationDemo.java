class Student {
    private String name;
    private int age;

    public void setName(String studentName) {
        name = studentName;
    }

    public String getName() {
        return name;
    }

    public void setAge(int studentAge) {
        if (studentAge > 0) {
            age = studentAge;
        } else {
            System.out.println("Invalid age");
        }
    }

    public int getAge() {
        return age;
    }
}

public class EncapsulationDemo {
    public static void main(String[] args) {
        Student student = new Student();

        student.setName("Kushitha");
        student.setAge(20);

        System.out.println("Student Name: " + student.getName());
        System.out.println("Student Age: " + student.getAge());
    }
}