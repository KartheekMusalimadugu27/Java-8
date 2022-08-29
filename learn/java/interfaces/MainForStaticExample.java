package learn.java.interfaces;

public class MainForStaticExample implements StaticMethodInInterfaceExample{

	  public void printSomething() {
	        System.out.println("In main method");
	    }
	
	public static void main(String[] args) {
		
		MainForStaticExample main = new MainForStaticExample();
		main.printSomething();
		StaticMethodInInterfaceExample.printSomething();
		//Static methods cannot be overridden and gives compilation error
		//main.printSomething();
		
	}
	
}
