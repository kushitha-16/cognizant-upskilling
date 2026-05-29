import java.util.ArrayList;
import java.util.Collections;

public class CollectionsSortingDemo {
    public static void main(String[] args) {
        ArrayList<Integer> marks = new ArrayList<>();

        marks.add(85);
        marks.add(60);
        marks.add(95);
        marks.add(70);
        marks.add(90);

        System.out.println("Before Sorting:");
        System.out.println(marks);

        Collections.sort(marks);

        System.out.println("\nAfter Sorting in Ascending Order:");
        System.out.println(marks);

        Collections.sort(marks, Collections.reverseOrder());

        System.out.println("\nAfter Sorting in Descending Order:");
        System.out.println(marks);
    }
}