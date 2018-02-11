package collectors;

import reduce_lab.Employee;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @author Evgeny Borisov
 */
public class EmployeeUtils {
    public static Map<Seniority, List<Employee>> groupBySeniority(List<Employee> employees) {
       return employees.stream()
                .collect(Collectors.groupingBy(employee->
                        Seniority.detectBySalary(employee.getSalary())));
    }

    public static void main(String[] args) {
        List<Employee> employees = Arrays.asList(new Employee("Jeka", 12000),
                new Employee("Gilad", 34000),
                new Employee("Michael", 8000),
                new Employee("John", 37000));
        Map<Seniority, List<Employee>> map = groupBySeniority(employees);
        System.out.println(map);

    }
}
