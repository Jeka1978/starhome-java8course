package reflections;/**
 * @author Evgeny Borisov
 */

import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Retention(RUNTIME)
@Repeatable(Mains.class)
public @interface Main {
    int repeat();
}
