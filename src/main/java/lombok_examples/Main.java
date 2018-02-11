package lombok_examples;

/**
 * @author Evgeny Borisov
 */
public class Main {
    public static void main(String[] args) {
        Person person = Person.builder().age(39).name("Jeka")
                .bonus(12)
                .salary(20000)
                .person("Moshe",33)
                .person("Masha",18)
                .build();

        person = person.withSalary(null);
        System.out.println("person = " + person);
    }
}
