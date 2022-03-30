package learn.java.collectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorsAggregation {
	public static void main(String args[]) {
		List<E> employeeList = new ArrayList<>();
		employeeList.add(new E("Alex", 23, 23000));
		employeeList.add(new E("Ben", 63, 25000));
		employeeList.add(new E("Dave", 34, 56000));
		employeeList.add(new E("Jodi", 43, 67000));
		employeeList.add(new E("Ryan", 53, 54000));

		long count = employeeList.stream().filter(emp -> emp.getAge() > 30).collect(Collectors.counting()); // Using the
																											// counting()
																											// method to
																											// get count
																											// of
																											// employees.

		System.out.println(count);

		// Using summingInt() method to get the sum of salaries of all employees.
		int count1 = employeeList.stream().collect(Collectors.summingInt(emp -> emp.getSalary()));

		System.out.println(count1);

		// Using averagingInt() method to get the average of salaries of all employees.
		double average = employeeList.stream().collect(Collectors.averagingInt(emp -> emp.getSalary()));

		System.out.println(average);

		// Using minBy() method to get the employee with min salary.
		Optional<E> employee = employeeList.stream().collect(Collectors.minBy(Comparator.comparing(E::getSalary)));

		System.out.println(employee.get().getName());

		// Using maxBy() method to get the employee with max salary.
		Optional<E> employee1 = employeeList.stream().collect(Collectors.maxBy(Comparator.comparing(E::getSalary)));

		System.out.println(employee1.get().getName());

		IntSummaryStatistics summarizingInt = Stream.of("1", "2", "3")
				.collect(Collectors.summarizingInt(Integer::parseInt));
		System.out.println(summarizingInt);
	}
}

class E {
	String name;
	int age;
	int salary;

	E(String name) {
		this.name = name;
	}

	E(String name, int age, int salary) {
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
		return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", salary=" + salary + '}';
	}
}
