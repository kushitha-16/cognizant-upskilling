import java.util.Optional;

public class OptionalDemo {
    public static void main(String[] args) {
        String name = null;

        Optional<String> optionalName = Optional.ofNullable(name);

        System.out.println(optionalName.orElse("Default Name"));

        String city = "Bangalore";

        Optional<String> optionalCity = Optional.ofNullable(city);

        System.out.println("City: " + optionalCity.get());
    }
}