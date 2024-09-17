import java.lang.System.*;
public class App {

	public static void main(String[] args) {
		Cat c = new Cat("Black cat", false);
		Dog d = new Dog("Alaska", false);
		System.out.print(c.toString());
		System.out.print(d.toString());
		
		IAnimal c1 = new Cat("Black cat", false);
		IAnimal d1 = new Dog("Alaska", false);
		System.out.println(c1.toString());
		System.out.println(d1.toString());
	}
	
}
