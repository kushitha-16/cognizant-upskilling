import java.util.HashSet;

public class HashSetDemo {
    public static void main(String[] args) {
        HashSet<String> cities = new HashSet<>();

        cities.add("Bangalore");
        cities.add("Mysore");
        cities.add("Chennai");
        cities.add("Bangalore");

        System.out.println("Cities in HashSet:");
        for (String city : cities) {
            System.out.println(city);
        }

        System.out.println("\nHashSet does not allow duplicate values.");
    }
}