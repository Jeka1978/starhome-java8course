package callback_pattern;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface ListUtil {
    static <T> int countDuplicates(List<T> list, T t, Equalator<T> equalator) {
        int counter = 0;
        for (T t1 : list) {
            if (equalator.equals(t1, t)) {
                counter++;
            }
        }
        return counter;
    }

}
