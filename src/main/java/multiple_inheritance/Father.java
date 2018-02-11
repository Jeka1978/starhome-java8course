package multiple_inheritance;

/**
 * @author Evgeny Borisov
 */
public interface Father {
    default void talk(String string){
        System.out.println(string);
    }
}
