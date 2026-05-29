import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorCallableDemo {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newSingleThreadExecutor();

        Callable<Integer> task = () -> {
            int sum = 0;

            for (int i = 1; i <= 5; i++) {
                sum += i;
            }

            return sum;
        };

        Future<Integer> result = executor.submit(task);

        System.out.println("Sum from Callable: " + result.get());

        executor.shutdown();
    }
}