package learn.java.predicate;

import java.util.function.BiPredicate;

public class BiPredicateDemo {


 
    public static void main(String[] args) {
       Person person = new Person("Jishnav", 1);
       boolean eligible = isPersonEligibleForVoting(person,18,(p, minAge)-> {
        return p. age >minAge;
       });
       System.out.println("Person is eligible for voting: " + eligible);
    }

    private static boolean isPersonEligibleForVoting(Person person, Integer minAge,  BiPredicate<Person, Integer> predicate) {
      return predicate.test(person, minAge);
    }
    
}

class Person {
    String name;
    int age;
  
    Person(String name, int age){
      this.name = name;
      this.age = age;
    }
  }
