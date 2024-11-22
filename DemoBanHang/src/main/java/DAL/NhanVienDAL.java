package DAL;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Model_DTO.NhanVien;
import Utils.DBUtils;

public class NhanVienDAL {
	// Thêm mới nhân viên
    public boolean AddNew(NhanVien nv) {
        String sql = "INSERT INTO NhanVien (tenDN, matKhau) VALUES (?, ?)";
        try (Connection conn = DBUtils.getConnection(); 
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, nv.getTenDN());
            ps.setString(2, nv.getMatKhau()); // Đảm bảo mật khẩu đã được mã hóa trước khi lưu
            int rowsAffected = ps.executeUpdate();
            return rowsAffected > 0; // Trả về true nếu thêm thành công
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Trả về false nếu có lỗi
        }
    }

    // Kiểm tra đăng nhập
    public boolean Login(String tenDN, String matKhau) {
        String sql = "SELECT * FROM NhanVien WHERE tenDN = ? AND matKhau = ?";
        try (Connection conn = DBUtils.getConnection();
             PreparedStatement ps = conn.prepareStatement(sql)) {
            ps.setString(1, tenDN);
            ps.setString(2, matKhau); // Kiểm tra mật khẩu đã mã hóa
            ResultSet rs = ps.executeQuery();
            return rs.next(); // Nếu có dòng dữ liệu, trả về true
        } catch (SQLException e) {
            e.printStackTrace();
            return false; // Trả về false nếu có lỗi
        }
    }
}
