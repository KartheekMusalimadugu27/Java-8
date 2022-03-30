package learn.java.matching;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class StreamMatchingDemos {

    public static void main(String[] args) {
        List<Person6> list = new ArrayList<>();
        list.add(new Person6("Dave", 23,"India"));
        list.add(new Person6("Joe", 18,"USA"));
        list.add(new Person6("Ryan", 54,"Canada"));
        list.add(new Person6("Iyan", 5,"India"));
        list.add(new Person6("Ray", 63,"China"));

        boolean anyCanadian = list.stream()
                .anyMatch(p -> p.getCountry().equals("Canada"));

        System.out.println("Is there any resident of Canada: " + anyCanadian);
        
        boolean anyCanadian1 = list.stream()
                .allMatch(p -> p.getCountry().equals("Canada"));
        
        System.out.println("Are all Persons Canadian: "+anyCanadian1);
        
        

        boolean anyRussian = list.stream()
                .noneMatch(p -> p.getCountry().equals("Russia"));

        System.out.println(anyRussian);
        

        Optional<Person6> person = list.stream()               // Creating a Stream of person objects.
                .filter(p -> p.getCountry().equals("India")) // Filter to get only persons living in India.
                .findFirst();                                // Returning the first person encountered.

        if(person.isPresent()){
            System.out.println(person);
        }

    }
}

class Person6 {
    String name;
    int age;
    String country;

    Person6(String name, int age, String country) {
        this.name = name;
        this.age = age;
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public String getCountry() {
        return country;
    }

}


