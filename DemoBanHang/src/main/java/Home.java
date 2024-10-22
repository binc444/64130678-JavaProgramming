import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Home {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		String strConn = "jdbc:mysql://localhost:3306/demobanhang";
		//Mở kết nối
		Connection conn = DriverManager.getConnection(strConn, "root", "");
		
		// Select
		String sqlSelect = "select * from SanPham";
		Statement lenh = conn.createStatement();
		ResultSet ketQua = lenh.executeQuery(sqlSelect);
		//Hiện kết quả
		while (ketQua.next()) {
			int id = ketQua.getInt(1); //lấy dữ liệu cột 0
			String tenSP = ketQua.getString(2);
			float giaSP = ketQua.getFloat(3);
			String mota = ketQua.getString(4);
			System.out.print(id + "|" + tenSP + "|" + giaSP + "|" + mota + "\n");
		}
	}

}
