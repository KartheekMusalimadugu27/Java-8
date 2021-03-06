package learn.java.predicate;

import java.util.function.Predicate;

/* The Predicate<T> interface has an abstract method boolean test(T t). 
Basically, a predicate is a function that evaluates the given input and returns true or false. */
public class PredicateDemo {

    static boolean isPersonEligibleForVoting(Person3 person, Predicate<Person3> predicate) {
        return predicate.test(person);
    }

    public static void main(String args[]) {
        Person3 person = new Person3("Alex", 23);
        // Created a predicate. It returns true if age is greater than 18.
        Predicate<Person3> predicate = p -> p.age > 18;

        boolean eligible = isPersonEligibleForVoting(person, predicate);

        System.out.println("Person is eligible for voting: " + eligible);
    }

}

class Person3 {
    String name;
    int age;

    Person3(String name, int age) {
        this.name = name;
        this.age = age;
    }
}
