package learn.java.optional;

import java.util.Optional;

public class OptionalMapDemo {
    public static void main(String[] args) {

        // Creating an Optional of Employee object.
        Optional<Employee3> optional = Optional.of(new Employee3("Adam", 54, 20000));

        optional
                .map(emp -> emp.getSalary()) // Fetching the salary from employee object.
                .filter(sal -> sal > 10000) // Checking if the salary is greater than 10000.
                .ifPresent(System.out::println);
    }
}

class Employee3 {
    String name;
    int age;
    int salary;

    Employee3(String name) {
        this.name = name;
    }

    Employee3(String name, int age, int salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public int getSalary() {
        return salary;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                '}';
    }
}
