import java.util.LinkedList;
import java.util.Queue;

public class QueueDemo {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();

        queue.add("User 1");
        queue.add("User 2");
        queue.add("User 3");

        System.out.println("Queue: " + queue);

        System.out.println("Serving: " + queue.poll());

        System.out.println("Queue after serving one user: " + queue);

        System.out.println("Next user: " + queue.peek());
    }
}
