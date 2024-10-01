import java.io.FileWriter;
import java.io.IOException;

public class App {

	public static void main(String[] args) throws IOException {
		FileWriter fw;
		fw = new FileWriter("songque.txt");
		fw.write("Đầu đường Xây dựng bơm xe\r\n"
				+ "Cuối đường Kinh tế bán chè đậu đen\r\n"
				+ "Ngoại thương mời khách ăn kem\r\n"
				+ "Các anh Nhạc viện thổi kèn đám ma.\r\n"
				+ "");
		fw.flush();
		fw.close();
	}

}
