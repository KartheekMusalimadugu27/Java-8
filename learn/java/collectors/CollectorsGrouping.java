package learn.java.collectors;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

public class CollectorsGrouping {

	public static void main(String[] args) {
		List<Employeea> employeeList = new ArrayList<>();
		employeeList.add(new Employeea("Alex", 23, 23000, "USA"));
		employeeList.add(new Employeea("Ben", 63, 25000, "China"));
		employeeList.add(new Employeea("Dave", 34, 56000, "India"));
		employeeList.add(new Employeea("Jodi", 43, 67000, "USA"));
		employeeList.add(new Employeea("Ryan", 53, 54000, "China"));

		Map<String, Set<Employeea>> employeeMap = employeeList.stream()
				.collect(Collectors.groupingBy(Employeea::getCountry, Collectors.toSet()));

		System.out.println(employeeMap);

		// The employees are grouped by country and age by using the groupingBy() method
		// twice.
		Map<String, Map<Integer, List<Employeea>>> employeeMap1 = employeeList.stream()
				.collect(Collectors.groupingBy(Employeea::getCountry, Collectors.groupingBy(Employeea::getAge)));

		System.out.println(employeeMap1);

		Map<String, Integer> employeeMap2 = employeeList.stream()
				.collect(Collectors.groupingBy(Employeea::getCountry, Collectors.summingInt(Employeea::getSalary)));

		System.out.println(employeeMap2);

		Map<String, Optional<Employeea>> employeeMap4 = employeeList.stream().collect(Collectors
				.groupingBy(Employeea::getCountry, Collectors.maxBy(Comparator.comparingInt(Employeea::getSalary))));

		System.out.println(employeeMap4);

		// Partitioning the list based on age.
		Map<Boolean, List<Employeea>> employeeMap6 = employeeList.stream()
				.collect(Collectors.partitioningBy(emp -> emp.getAge() > 30));

		System.out.println(employeeMap6);
	}

}

class Employeea {
	String name;
	int age;
	int salary;
	String country;

	Employeea(String name, int age, int salary, String country) {
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.country = country;
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

	public String getCountry() {
		return country;
	}

	@Override
	public String toString() {
		return "Employee{" + "name='" + name + '\'' + ", age=" + age + ", salary=" + salary + '}';
	}
}
