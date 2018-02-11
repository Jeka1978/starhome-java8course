package lab2;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        List<String> strings = Arrays.asList("java", "scala", "groovy", "c++");
        strings.sort((o1, o2) -> o1.length()-o2.length());
        strings.forEach(System.out::println);
    }
}
