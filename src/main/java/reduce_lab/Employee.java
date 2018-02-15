package reduce_lab;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author Evgeny Borisov
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Employee {
    private String name;
    private int salary;
    private String companyName;

    public Employee(String name, int salary) {
        this.name = name;
        this.salary = salary;
    }
}
