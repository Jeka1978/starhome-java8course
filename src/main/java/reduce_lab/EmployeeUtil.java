package reduce_lab;

import java.util.List;
import java.util.Optional;

/**
 * @author Evgeny Borisov
 */
public class EmployeeUtil {
    public static int totalSalary(List<Employee> employees) {
       /* Optional<Integer> reduce = employees.stream().map(Employee::getSalary)
                .reduce(Integer::sum);
        return reduce.orElse(0);*/
       return employees.stream().mapToInt(Employee::getSalary).sum();
    }
}
