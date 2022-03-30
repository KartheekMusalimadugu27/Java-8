package learn.java.optional;

import java.util.Optional;

public class OptionalDemo2 {

    public static String getDefaultValue() {
        return "default";
    }

    public static void main(String[] args) {

        Optional<String> optional = Optional.ofNullable(null);
        // This will throw exception because optional contains a null value.
        //System.out.println(optional.get());

        // This will return the default value.
        System.out.println(optional.orElse("default string"));

        // This will return the default value.
        System.out.println(optional.orElseGet(OptionalDemo2::getDefaultValue));

        // This will throw exception
        try {
            System.out.println(optional.orElseThrow(() -> new Exception("Resource not found.")));
        } catch (Exception e) {
            e.printStackTrace();
        }

        
        Optional<String> optional1 = Optional.ofNullable("orange");
        // Since the filter condition is matched, this will return the optional.
        System.out.println(optional1.filter(str -> str.equals("orange")));

        // Since the filter condition is not matched, this will return empty optional.
        System.out.println(optional1.filter(str -> str.equals("apple")));
    }
}
