package taxi_lab;

/**
 * @author Evgeny Borisov
 */
public class FunctionUtils {
    public static Trip convertLineToTrip(String line) {
        String[] strings = line.split(" ");
       return Trip.builder().id(Integer.parseInt(strings[0]))
                .city(strings[1].toLowerCase())
                .km(Integer.parseInt(strings[2])).build();
    }
}
