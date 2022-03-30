package learn.java.optional;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class OptionalPart2Demo {

	Map<Integer, Employee4> empMap = new HashMap<>();
	
	 public void populateEmployee() {
	        empMap.put(123, new Employee4("Alex", 23, 12000));
	    }
	 
	 public Optional<Employee4> getEmployee4(Integer empId) {
		// Before returning the employee object we are wrapping it into an Optional
		 return Optional.ofNullable(empMap.get(empId));
	 }
	 
	 public static void main(String[] args) {
		OptionalPart2Demo demo = new OptionalPart2Demo();
		demo.populateEmployee();
		Optional<Employee4> opEmp = demo.getEmployee4(123);
		opEmp.ifPresent(System.out::println);
		
		// Creating an Optional of Employee object.
        Optional<Employee4> optional2 = Optional.of(new Employee4("Adam", 54, 20000));
        optional2.flatMap(emp -> emp.getSal())
                .filter(sal -> sal > 10000)
                .ifPresent(System.out::println);
	}
	
}

class Employee4 {
    String name;
    int age;
    int salary;

    Employee4(String name) {
        this.name = name;
    }

    Employee4(String name, int age, int salary) {
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
    
    public Optional<Integer> getSal() {
        return Optional.of(salary);
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