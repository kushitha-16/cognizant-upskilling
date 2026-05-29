public class FinallyDemo {
    public static void main(String[] args) {
        try {
            int number = 50 / 5;
            System.out.println("Result: " + number);
        } catch (ArithmeticException e) {
            System.out.println("Error occurred");
        } finally {
            System.out.println("Finally block always executes");
        }

        System.out.println("Program ended");
    }
}