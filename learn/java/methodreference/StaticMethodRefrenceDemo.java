package learn.java.methodreference;

import java.util.ArrayList;
import java.util.List;

public class StaticMethodRefrenceDemo {
    public static int getLength(String str) {
        return str.length();
    }

    public int getLen(String str) {
        return str.length();
    }

    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("done");
        list.add("word");
        list.add("practice");
        list.add("fake");

        // Code without using method reference.
        list.stream()
                .mapToInt(str -> StaticMethodRefrenceDemo.getLength(str))
                .forEach(System.out::println);

        // Code with method reference.
        list.stream()
                .mapToInt(StaticMethodRefrenceDemo::getLength)
                .forEach(System.out::println);

        StaticMethodRefrenceDemo demo = new StaticMethodRefrenceDemo();
        // Code without instance method reference.
        list.stream()
                .mapToInt(str -> demo.getLen(str))
                .forEach(System.out::println);

        // Code with instance method reference.
        list.stream()
                .mapToInt(demo::getLen)
                .forEach(System.out::println);

    }
}
