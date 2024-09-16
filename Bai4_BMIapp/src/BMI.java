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
		float height;
		
		// Nhận bằng bàn phím
		Scanner banPhim = new Scanner(System.in);
		
		//Nhập chiều cao
		do {
			System.out.print("Enter your height(m): ");
			height = banPhim.nextFloat();
			if (height < 1.0 || height > 2.5) {
                System.out.println("Invalid height! (1m -> 2.5m)");
            }
		} 		
		while (height < 1.0 || height > 2.5); //nếu không đáp ứng điều kiện sẽ chạy lại từ lệnh do
		
		
		//Nhập chiều cân nặng
		do {
            System.out.print("Enter your weight (kg): ");
            weight = banPhim.nextFloat();
            if (weight < 20 || weight > 150) {
                System.out.println("Invalid weight! (20 -> 150kg)");
            }
        } while (weight < 20 || weight > 150); //nếu không đáp ứng điều kiện sẽ chạy lại từ lệnh do
		
		
		//Tính BMI
		float BMI = (weight / (height * height));
		
		//Thông báo cho User chỉ số BMI
		System.out.println("Your BMI is: " + BMI);
		if (BMI < 18.5) {      
	         System.out.println("You are underweight");
	      } else if(BMI > 18.5 && BMI < 24.9) {
		      System.out.println("Your BMI is normal");
	      }
	      else if(BMI > 25 && BMI < 29.9) {
		      System.out.println("You are overweight");
	      }
	      else if(BMI > 30 && BMI < 39.9) {
		      System.out.println("You are obese");
	      }
	      else {
		      System.out.println("You are Morbidly Obese");
	      }
	}

}
