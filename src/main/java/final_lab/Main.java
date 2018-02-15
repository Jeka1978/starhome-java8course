package final_lab;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
public class Main {

    public static void printHorrorYears(int start, int end) {

        LocalDate startDate = LocalDate.of(start, 1, 13);
        LocalDate endDate = LocalDate.of(end, 12, 13);

        Stream.iterate(startDate, date -> date.plusMonths(1))
                .limit(ChronoUnit.MONTHS.between(startDate, endDate))
                .filter(date -> date.getDayOfWeek() == DayOfWeek.FRIDAY)
                .collect(Collectors.groupingBy(LocalDate::getYear, Collectors.counting()))
//                .entrySet().stream().sorted(Comparator.comparingLong(Map.Entry<Integer,Long>::getValue).reversed()))
                .entrySet().stream().sorted((o1, o2) -> (int) (o2.getValue() - o1.getValue())).parallel().forEachOrdered(System.out::println);


    }

    public static void main(String[] args) {
        printHorrorYears(1900,2000);

    }
}
