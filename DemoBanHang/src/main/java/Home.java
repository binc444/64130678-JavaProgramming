import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BLL.NhanVienBLL;
import Model_DTO.NhanVien;

public class Home {

	public static void main(String[] args) {
        NhanVienBLL nhanVienBLL = new NhanVienBLL();

        // Thêm nhân viên mới
        NhanVien nv = new NhanVien("admin", "123456");
        boolean isAdded = nhanVienBLL.ThemMoi(nv);
        System.out.println("Thêm nhân viên thành công: " + isAdded);

        // Kiểm tra đăng nhập
        boolean isLoginSuccess = nhanVienBLL.checkLogin("admin", "123456");
        System.out.println("Đăng nhập thành công: " + isLoginSuccess);
    }

}
