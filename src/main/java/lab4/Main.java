package lab4;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Map<String, Integer> map = Stream.of("Java", "JAVa", "Scala", "Python")
                .collect(Collectors.toMap(String::toUpperCase, String::length,
                        (v1, v2) -> v1 + v2));
        System.out.println(map);
    }
}
