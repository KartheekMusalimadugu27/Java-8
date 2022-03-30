package learn.java.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalIfPresent {
    Map<Integer, Employee2> empMap = new HashMap<>();

    public void populateEmployee() {
        empMap.put(123, new Employee2("Alex", 23, 12000));
    }

    public Optional<Employee2> getEmployee(Integer employeeId) {
        // Before returning the employee object we are wrapping it into an Optional
        return Optional.ofNullable(empMap.get(employeeId));
    }

    public static void main(String[] args) {
        OptionalIfPresent demo = new OptionalIfPresent();
        demo.populateEmployee();
        Optional<Employee2> emp = demo.getEmployee(123);
        emp.ifPresent(System.out::println);
    }
}

class Employee2 {
    String name;
    int age;
    int salary;

    Employee2(String name) {
        this.name = name;
    }

    Employee2(String name, int age, int salary) {
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