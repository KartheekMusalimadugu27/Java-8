package learn.java.mutablereduction;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

public class StreamReductionDemo {
	public static void main(String[] args) {
		List<Employee7> list = new ArrayList<>();
		list.add(new Employee7("Dave", 23, 20000));
		list.add(new Employee7("Joe", 18, 40000));
		list.add(new Employee7("Ryan", 54, 100000));
		list.add(new Employee7("Iyan", 5, 34000));
		list.add(new Employee7("Ray", 63, 54000));

		// Optional<T> reduce(BinaryOperator<T> accumulator)#
		Optional<Integer> totalSalary = list.stream().map(p -> p.getSalary()) // We are converting the Stream of
																				// Employees to Stream of salaries.
				.reduce((p, q) -> p + q);

		if (totalSalary.isPresent()) {
			System.out.println("The total salary is " + totalSalary.get());

			List<Integer> list1 = new ArrayList<>();
			list1.add(1);
			list1.add(2);
			list1.add(3);
			list1.add(4);
			list1.add(5);
			list1.add(6);

			int totalSum = list1.stream().reduce(5, (partialSum, num) -> partialSum + num);

			System.out.println("Total Sum is " + totalSum);

			int totalSum1 = list1.parallelStream().reduce(0, (partialSum1, num1) -> partialSum1 + num1, Integer::sum);

			System.out.println("Total Sum is " + totalSum1);

			Optional<Integer> max = list1.stream().max(Comparator.naturalOrder());

			System.out.println("Max value is " + max.get());

			Optional<Integer> min = list1.stream().min(Comparator.naturalOrder());

			System.out.println("Min value is " + min.get());
		}
	}
}

class Employee7 {
	String name;
	int age;
	int salary;

	Employee7(String name, int age, int salary) {
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