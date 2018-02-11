package collectors;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.Value;

import java.util.Arrays;
import java.util.stream.Stream;

/**
 * @author Evgeny Borisov
 */
@AllArgsConstructor
@Getter
public enum Seniority {
    JUNIOR(0,10000),
    MIDDLE(10001,20000),
    SENIOR(20001,Integer.MAX_VALUE);

    private final int min;
    private final int max;

    public static Seniority detectBySalary(int salary) {
       return Arrays.stream(values())
                .filter(seniority -> seniority.min < salary && salary < seniority.max)
                .findAny().get();
    }


}
