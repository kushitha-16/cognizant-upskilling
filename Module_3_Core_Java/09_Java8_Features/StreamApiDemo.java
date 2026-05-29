import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class StreamApiDemo {
    public static void main(String[] args) {
        List<Integer> marks = Arrays.asList(45, 78, 90, 32, 88, 60);

        List<Integer> passedMarks = marks.stream()
                .filter(mark -> mark >= 50)
                .collect(Collectors.toList());

        System.out.println("All Marks: " + marks);
        System.out.println("Passed Marks: " + passedMarks);

        int total = marks.stream()
                .mapToInt(Integer::intValue)
                .sum();

        System.out.println("Total Marks: " + total);
    }
}