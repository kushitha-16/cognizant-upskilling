import java.util.HashMap;

public class HashMapDemo {
    public static void main(String[] args) {
        HashMap<Integer, String> employees = new HashMap<>();

        employees.put(101, "Kushitha");
        employees.put(102, "Ravi");
        employees.put(103, "Anu");

        System.out.println("Employee Details:");

        for (Integer id : employees.keySet()) {
            System.out.println("ID: " + id + ", Name: " + employees.get(id));
        }

        System.out.println("\nEmployee with ID 102: " + employees.get(102));
    }
}