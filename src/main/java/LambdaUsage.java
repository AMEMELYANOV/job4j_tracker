import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class LambdaUsage {
    public static void main(String[] args) {
        Comparator<String> cmpDescSize = (left, right) -> {
            System.out.println("compare - " + right.length() + " : " + left.length());
            return Integer.compare(right.length(), left.length());
        };

        List<String> lst = Arrays.asList("C", "BB", "CCCC", "AAA");
        lst.sort(cmpDescSize);
        for (String s : lst) {
            System.out.println(s);
        }
    }
}
