package lombok_examples;

import lombok.*;
import lombok.experimental.Wither;
import lombok.extern.log4j.Log4j;
import org.apache.log4j.spi.LoggerFactory;

import java.util.List;
import java.util.Map;

/**
 * @author Evgeny Borisov
 */

@Log4j
@AllArgsConstructor
@Builder
@Value
@Wither
public class Person {
    private String name;
    private int age;
    @NonNull
    private Integer salary;
    private int bonus;
    @Singular("person")
    private Map<String,Integer> people;




}
