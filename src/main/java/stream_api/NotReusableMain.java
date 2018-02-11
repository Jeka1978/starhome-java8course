package stream_api;

import java.util.Optional;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class NotReusableMain {
    public static void main(String[] args) {
        Stream<Integer> integerStream = Stream.of(1, 2, 3);
        integerStream.forEach(System.out::println);
        Optional<Integer> reduce = integerStream.reduce(Integer::sum);
        reduce.ifPresent(System.out::println);
    }
}
