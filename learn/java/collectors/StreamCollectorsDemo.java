package learn.java.collectors;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class StreamCollectorsDemo {
	public static void main(String args[]) {
		List<Employee8> employeeList = new ArrayList<>();
		employeeList.add(new Employee8("Alex", 23, 23000, "USA"));
		employeeList.add(new Employee8("Ben", 63, 25000, "India"));
		employeeList.add(new Employee8("Dave", 34, 56000, "Bhutan"));
		employeeList.add(new Employee8("Jodi", 43, 67000, "China"));
		employeeList.add(new Employee8("Ryan", 53, 54000, "Libya"));

		// toList
		List<String> empName = employeeList.stream().map(emp -> emp.getName()).collect(Collectors.toList());

		System.out.println(empName);

		// ToSet
		Set<String> empName1 = employeeList.stream().map(emp -> emp.getCountry()).collect(Collectors.toSet());

		System.out.println(empName1);

		// toCollection
		LinkedList<String> empName2 = employeeList.stream().map(emp -> emp.getName())
				.collect(Collectors.toCollection(LinkedList::new));

		System.out.println(empName2);

		List<String> list = new ArrayList<>();
		list.add("done");
		list.add("far");
		list.add("away");
		list.add("again");

		// toMap
		Map<String, Integer> nameMap = list.stream().collect(Collectors.toMap(s -> s, s -> s.length()));

		System.out.println(nameMap);

		Map<String, Integer> nameMap1 = list.stream()
				.collect(Collectors.toMap(s -> s, s -> s.length(), (s1, s2) -> s1));

		System.out.println(nameMap1);

		Map<String, Integer> nameMap2 = list.stream()
				.collect(Collectors.toMap(s -> s, s -> s.length(), (s1, s2) -> s1, HashMap::new));

		System.out.println(nameMap2);
	}

}

class Employee8 {
	String name;
	int age;
	int salary;
	String country;

	Employee8(String name, int age, int salary, String country) {
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

	public Integer getSalary() {
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
