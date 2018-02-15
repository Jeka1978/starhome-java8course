package lab3;

import reduce_lab.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
public class EmployeeUtil {
    public static Map<String, List<Employee>> mapByCompany(List<Employee> employees) {
        return employees.stream().collect(
                Collectors.groupingBy(Employee::getCompanyName));
    }

    public static Map<String, Integer> countEmployeesPerCompany(Map<String, List<Employee>> map) {
        return map.entrySet().stream()
                .collect(Collectors.toMap(
                        Map.Entry::getKey,
                        entry -> entry.getValue().size()));
    }

    public static void main(String[] args) {
        List<Employee> list = Arrays.asList(Employee.builder().name("Moshe").companyName("Google").build(),
                Employee.builder().name("Misha").companyName("Google").build(),
                Employee.builder().name("Masha").companyName("Google").build(),
                Employee.builder().name("David").companyName("Ebay").build());

        Map<String, List<Employee>> map = mapByCompany(list);
        System.out.println(map);
        System.out.println();
        System.out.println(countEmployeesPerCompany(map));

    }
}













