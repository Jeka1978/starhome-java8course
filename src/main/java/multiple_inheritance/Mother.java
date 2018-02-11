package multiple_inheritance;

/**
 * @author Evgeny Borisov
 */
public interface Mother {
    default void talk(String string) {
        System.out.println(string.toLowerCase());
        System.out.println(string.toUpperCase());
    }
}
