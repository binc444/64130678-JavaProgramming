
public class Dog implements IAnimal{
	private String category;
	private boolean gender;
	@Override
	public void sound() {
		System.out.println("Meoooo <3");
	}
	/**
	 * @param category
	 * @param gender
	 */
	public Dog(String category, boolean gender) {
		super();
		this.category = category;
		this.gender = gender;
	}
	@Override
	public String toString() {
		return "Dog [category=" + category + ", gender=" + gender + "]";
	}
	
}
