package BLL;

import DAL.NhanVienDAL;
import Model_DTO.NhanVien;
import Utils.CommonUtils;

public class NhanVienBLL {
	private NhanVienDAL nvDAL = new NhanVienDAL();

    // Thêm nhân viên mới
    public boolean ThemMoi(NhanVien nv) {
        // Mã hóa mật khẩu trước khi lưu
        String matKhauMaHoa = CommonUtils.encodePass(nv.getMatKhau());
        nv.setMatKhau(matKhauMaHoa);
        return nvDAL.AddNew(nv);
    }

    // Kiểm tra đăng nhập
    public boolean checkLogin(String tenDN, String matKhau) {
        // Mã hóa mật khẩu trước khi kiểm tra đăng nhập
        String matKhauMaHoa = CommonUtils.encodePass(matKhau);
        return nvDAL.Login(tenDN, matKhauMaHoa);
    }
}
