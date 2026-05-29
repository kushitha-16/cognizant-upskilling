import java.util.Arrays;
import java.util.List;

public class MethodReferenceDemo {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Kushitha", "Ravi", "Anu", "Meena");

        System.out.println("Names:");

        names.forEach(System.out::println);
    }
}