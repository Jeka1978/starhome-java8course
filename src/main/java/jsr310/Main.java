package jsr310;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.TextStyle;
import java.time.temporal.ChronoUnit;
import java.util.Locale;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        LocalDateTime now = LocalDateTime.now();
        LocalDateTime yest = now.minusDays(1);
        System.out.println(yest.getDayOfWeek().getDisplayName(TextStyle.FULL, Locale.JAPANESE));
        System.out.println(yest.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.JAPANESE));
        System.out.println(yest.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.FRANCE));
        System.out.println(yest.getDayOfWeek().getDisplayName(TextStyle.SHORT, Locale.ENGLISH));
        LocalDate eli = LocalDate.of(1971, 7, 12);
        LocalDate jeka = LocalDate.of(1978, 10, 3);
        long between = ChronoUnit.DAYS.between(eli, jeka);
        System.out.println(between);

    }
}
