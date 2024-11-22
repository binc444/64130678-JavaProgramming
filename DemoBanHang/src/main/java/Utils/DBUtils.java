package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtils {
	private static final String URL = "jdbc:mysql://localhost:3306/account"; // Tên cơ sở dữ liệu
	private static final String USER = "root"; // Tên đăng nhập MySQL
	private static final String PASSWORD = ""; // Không có mật khẩu

	public static Connection getConnection() throws SQLException {
	    try {
	        Class.forName("com.mysql.cj.jdbc.Driver");
	        return DriverManager.getConnection(URL, USER, PASSWORD);
	    } catch (ClassNotFoundException e) {
	        throw new SQLException("MySQL JDBC Driver not found", e);
	    }
	}
}