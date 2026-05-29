public class MultipleCatchDemo {
    public static void main(String[] args) {
        try {
            int[] numbers = {10, 20, 30};

            System.out.println(numbers[5]);

            int result = 10 / 0;
            System.out.println(result);

        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Error: Array index is out of range");

        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero");

        } catch (Exception e) {
            System.out.println("General error occurred");
        }

        System.out.println("Multiple catch example completed");
    }
}