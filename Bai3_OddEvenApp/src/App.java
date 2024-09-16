/**
 * 
 */
import java.util.Scanner;
/**
 * 
 */
public class App {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Khai báo biến
		int number;
		
		//Chuẩn bị nhận bàn phím
		Scanner banPhim = new Scanner(System.in);
		
		//Nhập vào số nguyên
		System.out.print("Enter an integer: ");
		// nhan du lieu tu User cat vao bien
		number = banPhim.nextInt();
		
		//Tính chẵn lẻ
		if (number % 2 == 0) {      
	         System.out.println(number + " is even");
	         System.out.println("bye");
	      } else {
	    	  System.out.println(number + " is odd");
		         System.out.println("bye");
	      }
	}

}
