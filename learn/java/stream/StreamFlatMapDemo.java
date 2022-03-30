package learn.java.stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/* Stream flatMap() method is used to flatten a stream of collections to a stream of elements combined from all collections.

Basically, flatMap() is used to do following operation:

Stream<String[]> -> flatMap -> Stream<String>

Stream<Set<String>> -> flatMap -> Stream<String>

Stream<List<String>> -> flatMap -> Stream<String>

Now, the question is why do we need to flatten our stream? The reason is that intermediate methods such as filter() and distinct() do not work on streams of Collections.

These methods only work on streams of primitives or objects. So, we need to flatten our stream before using these intermediate functions. */
public class StreamFlatMapDemo {
    public static void main(String[] args) {
        List<List<String>> list = new ArrayList<>();
        list.add(Arrays.asList("a","b","c"));
        list.add(Arrays.asList("d","e","f"));
        list.add(Arrays.asList("g","h","i"));
        list.add(Arrays.asList("j","k","l"));
        //Created a stream from the list.
        Stream<List<String>> stream1 = list.stream();
        // Flattened the stream.
        Stream<String> stream2 = stream1.flatMap(s -> s.stream());
        //Applied filter on flattened stream.
        Stream<String> stream3 = stream2.filter(x -> "a".equals(x));
        
        stream3.forEach(System.out::println);


        list.stream()
                .flatMap(s -> s.stream())
                .filter(x -> "a".equals(x))
                .forEach(System.out::println);
    }
}
