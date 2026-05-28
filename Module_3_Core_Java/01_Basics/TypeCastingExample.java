public class TypeCastingExample {
    public static void main(String[] args) {
        int number = 100;
        double convertedDouble = number;

        double price = 99.99;
        int convertedInt = (int) price;

        System.out.println("Original integer value: " + number);
        System.out.println("After widening casting int to double: " + convertedDouble);

        System.out.println("Original double value: " + price);
        System.out.println("After narrowing casting double to int: " + convertedInt);
    }
}