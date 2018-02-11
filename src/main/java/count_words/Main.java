package count_words;

import lombok.SneakyThrows;

import java.io.BufferedReader;
import java.io.FileReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class Main {
    @SneakyThrows
    public static void main(String[] args) {
        Stream<String> lines = Files.lines(Paths.get("data/songs/yest.txt"));
        List<String> listOfWords = lines.flatMap(line -> Arrays.stream(line.split(" "))).
                collect(Collectors.toList());
        int numberOfWords = listOfWords.size();
        int totalCharacters = listOfWords.stream()
                .peek(System.out::println   )
                .mapToInt(word -> word.toCharArray().length).sum();
        System.out.println(totalCharacters/numberOfWords);


    }
}
