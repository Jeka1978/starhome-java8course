package multiple_inheritance;

/**
 * @author Evgeny Borisov
 */
public class Son implements Father,Mother {
    @Override
    public void talk(String string) {
        Father.super.talk(string);
        Mother.super.talk(string);
    }
}
