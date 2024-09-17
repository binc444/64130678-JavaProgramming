/**
 * 
 */

/**
 * 
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Citizen c1 = new Citizen();
		c1.setId("64130678");
		c1.setName("Cillian Murphy ");
		c1.setGender("Male");
		c1.setNation("US");
		c1.setYear((short)2004);
		System.out.print(c1.toString());
		
		Citizen c2 = new Citizen("747543","Hieu",(int) 2030,"UK", "Male");
		System.out.print(c2.toString());
	}

}
