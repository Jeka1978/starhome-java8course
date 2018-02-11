package callback_pattern;

/**
 * @author Evgeny Borisov
 */
public interface Equalator<T> {
    boolean equals(T t1, T t);
}
