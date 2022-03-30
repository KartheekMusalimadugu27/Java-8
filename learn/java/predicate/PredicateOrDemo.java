package learn.java.predicate;

import java.util.function.Predicate;

public class PredicateOrDemo {
    static boolean isPersonEligibleForRetirement(Person2 person, Predicate<Person2> predicate){
        return predicate.test(person);
    }


    public static void main (String args[]){
        Person2 person = new Person2("Alex", 23,10);
        // Created a predicate. It returns true if age is greater than 60.
        Predicate<Person2> greaterThanSixty = (p) -> p.age > 60;
        // Created a predicate. It returns true if year of service is greater than 30.
        Predicate<Person2> serviceMoreThanThirty = (p) -> p.yearsOfService > 30;
        Predicate<Person2> predicate = greaterThanSixty.or(serviceMoreThanThirty);

        boolean eligible = isPersonEligibleForRetirement(person , predicate);
        System.out.println("Person is eligible for membership: " + eligible);
    }
}

class Person2 {
    String name;
    int age;
    int yearsOfService;

    Person2(String name, int age,int yearsOfService){
        this.name = name;
        this.age = age;
        this.yearsOfService = yearsOfService;
    }
}
