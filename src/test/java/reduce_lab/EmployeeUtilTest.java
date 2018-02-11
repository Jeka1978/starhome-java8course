package reduce_lab;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.Assert.*;

/**
 * @author Evgeny Borisov
 */
public class EmployeeUtilTest {
    @Test
    public void totalSalary() throws Exception {
        List<Employee> employees = Arrays.asList(new Employee("Jeka", 1000)
                , new Employee("Jeka", 2000), new Employee("Jeka", 500));

        int totalSalary = EmployeeUtil.totalSalary(employees);
        Assert.assertEquals(3500,totalSalary);

    }

}