/**
 * 
 */

		import java.util.Scanner;
/**
 * 
 */
public class BMI {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Khai báo biến
		float weight;
		float heigh;
		
		// Nhận bằng bàn phím
		Scanner banPhim = new Scanner(System.in);
		
		//Nhập cân nặng và chiều cao
		System.out.print("Enter your heigh(m): ");
		heigh = banPhim.nextFloat();
		
		System.out.print("Enter your weight(kg): ");
		weight = banPhim.nextFloat();
		
		
		//Tính BMI
		float BMI = (weight / (heigh * heigh));
		
		//Thông báo cho User chỉ số BMI
		System.out.println("Your BMI is: " + BMI);
		if (BMI < 18.5) {      
	         System.out.println("You are underweight");
	      } else if(BMI > 18.5 && BMI < 24.9) {
		      System.out.println("Your weight is normal");
	      }
	      else if(BMI > 25 && BMI < 29.9) {
		      System.out.println("You are overweight");
	      }
	      else if(BMI > 30 && BMI < 39.9) {
		      System.out.println("You are obese");
	      }
	      else {
		      System.out.println("You Morbidly Obese");
	      }
	}

}
