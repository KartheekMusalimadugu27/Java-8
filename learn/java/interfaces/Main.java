package learn.java.interfaces;

public class Main implements InterfaceA,InterfaceB {
	
	

	public static void main(String[] args) {
		Main main = new Main();
		main.printSomething();
	}

	@Override
	public void printSomething() {
		
		
		//Own impl
		System.out.println("I am in Main Method");
		
		//Call via the Interface like the static variables using super keyword
		InterfaceB.super.printSomething();
		InterfaceA.super.printSomething();
	}
	
}
