class MyThread extends Thread {
    public void run() {
        for (int i = 1; i <= 5; i++) {
            System.out.println("Thread running: " + i);

            try {
                Thread.sleep(500);
            } catch (InterruptedException e) {
                System.out.println("Thread interrupted");
            }
        }
    }
}

public class ThreadCreationDemo {
    public static void main(String[] args) {
        MyThread thread = new MyThread();

        thread.start();

        System.out.println("Main thread is running");
    }
}