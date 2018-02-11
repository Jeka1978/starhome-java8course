package lab1;

import java.util.Arrays;
import java.util.List;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("Jeka", "Gilad", "Stas", "Eli");
        ListUtil.forEachWithDelay(names,2000,name -> {
            saveToDb(name.toUpperCase());
        } );
    }

    private static void saveToDb(String s) {
        System.out.println(s+" was saved...");
    }
}
