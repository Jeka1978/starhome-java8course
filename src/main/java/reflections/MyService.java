package reflections;

/**
 * @author Evgeny Borisov
 */
public class MyService {
    @Main(repeat = 3)
    @Main(repeat = 2)
    public void doWork() {
        System.out.println("Lets go to eat something...");
    }
    @Main(repeat = 2)
    public void doEat() {
        System.out.println("Lets eat...");
    }

    public void drinkBeer() {
        System.out.println("BEER!!!");
    }
}
