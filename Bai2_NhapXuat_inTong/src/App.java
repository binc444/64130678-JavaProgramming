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
		// Khai bao cac bien can thiet
		int a, b, tong;
		
		// chuan bi nhan du lieu
		Scanner banPhim = new Scanner(System.in);
		
		// Nhap du lieu
		//-in HD cho user
		System.out.println("---------CHUONG TRINH TINH TONG 2 SO NGUYEN--------");
		System.out.print("a = ");
		// nhan du lieu tu User cat vao bien a
		a = banPhim.nextInt();
		
		System.out.print("b = ");
		// nhan du lieu tu User cat vao bien b
		b = banPhim.nextInt();
		
		// Tính tổng
		tong = a + b;
		
		// Xuất kết quả
		System.out.println("-----------------------");
		System.out.print("Tong la: " + tong);
	}

}
