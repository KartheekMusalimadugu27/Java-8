package learn.java.slicing;

import java.util.ArrayList;
import java.util.List;

public class StreamSlicingDemos {
	public static void main(String[] args) {
        List<String> countries = new ArrayList<>();
        countries.add("India");
        countries.add("USA");
        countries.add("China");
        countries.add("India");
        countries.add("UK");
        countries.add("China");

        //distinct(). It returns a stream consisting of the distinct elements (according to Object.equals(Object)) of this stream.
        countries.stream()
                .distinct()
                .forEach(System.out::println);
        
        //This is also an intermediate function. It returns a stream consisting of the elements of this 
        //stream, truncated to be no longer than maxSize in length.
        countries.stream()
                .distinct()
                .limit(3)
                .forEach(System.out::println);
        
        //Like distinct() and limit(), skip() is also an intermediate method. It returns a stream consisting of the 
        //remaining elements of this stream after discarding the first n elements of the stream.
        countries.stream()
        .distinct()
        .skip(2)
        .forEach(System.out::println);
    }
}
