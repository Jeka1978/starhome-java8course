package reflections;

/**
 * @author Evgeny Borisov
 */
public class Start {
    public static void main(String[] args) {
        MyService myService = new MyService();
        MainMethodsRunner mainMethodsRunner = new MainMethodsRunner();
        mainMethodsRunner.runAlMainMethods(myService);
    }
}
