package learn.java.predicate;

import java.util.function.Predicate;

public class PredicateAndDemo {
    static boolean isPersonEligibleForMembership(Person1 person, Predicate<Person1> predicate){
        return predicate.test(person);
    }


    public static void main (String args[]){
        Person1 person = new Person1("Alex", 23);

        // Created a predicate. It returns true if age is greater than 18.
        Predicate<Person1> greaterThanEighteen = (p) -> p.age > 18;
        // Created a predicate. It returns true if age is less than 60.
        Predicate<Person1> lessThanSixty = (p) -> p.age < 60;
        
        Predicate<Person1> predicate = greaterThanEighteen.and(lessThanSixty);

        boolean eligible = isPersonEligibleForMembership(person , predicate);
        System.out.println("Person is eligible for membership: " + eligible);
    }
}

class Person1 {
    String name;
    int age;

    Person1(String name, int age){
        this.name = name;
        this.age = age;
    }
}
