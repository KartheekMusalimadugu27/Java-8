package learn.java.optional;

import java.util.Optional;

public class OptonalExtraMethods {

	public static String getDefaultValue() {
		return "default";
	}

	public static void main(String[] args) {
		
		 Optional<String> optional = Optional.ofNullable(null);
	        // This will throw exception because optional contains a null value.
	        System.out.println(optional.get());
	        
	        // This will return the default value.
	        System.out.println(optional.orElse("default string"));
	        
	     // This will return the default value.
	        System.out.println(optional.orElseGet(OptonalExtraMethods::getDefaultValue));

	        		// This will throw exception
	                try {
	                    System.out.println(optional.orElseThrow(() -> new Exception("Resource not found.")));
	                } catch (Exception e) {
	                    e.printStackTrace();
	                }
	                
    
	}

}
