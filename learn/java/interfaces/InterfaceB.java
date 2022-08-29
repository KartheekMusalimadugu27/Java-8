package learn.java.interfaces;

public interface InterfaceB {

	default void printSomething() {
		System.out.println("I am in InterfaceB");
	}
	
}
