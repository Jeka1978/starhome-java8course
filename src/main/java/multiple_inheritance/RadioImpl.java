package multiple_inheritance;

/**
 * @author Evgeny Borisov
 */
public class RadioImpl implements Radio {
    @Override
    public void a() {
        System.out.println("aaaaaaa");
    }

    @Override
    public void b() {
        System.out.println("bbbbbbbbbbb");
    }
}
