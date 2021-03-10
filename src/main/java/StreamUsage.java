import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }

        @Override
        public String toString() {
            return "Task{"
                    + "name='" + name + '\''
                    + ", spent=" + spent
                    + '}';
        }
    }

    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>(List.of(-1, 1, -2, 2, -3, 3, -4, 4, -5, 5));
        List<Integer> rsl = numbers.stream().filter(
                number -> number > 0
        ).collect(Collectors.toList());
        rsl.forEach(System.out::println);
    }
}