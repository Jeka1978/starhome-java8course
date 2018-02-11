package lab1;

import lombok.SneakyThrows;

import java.util.List;

/**
 * @author Evgeny Borisov
 */
public interface ListUtil {
    @SneakyThrows
    static <T> void forEachWithDelay(List<T> list, int delay, Action<T> action) {
        for (T t : list) {
            action.doAction(t);
            Thread.sleep(delay);
        }
    }
}
