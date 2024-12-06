package th.tranminhhieu.th_bai1;

import javafx.fxml.FXML;
import javafx.scene.control.*;

public class Controller {
    @FXML
    private TextField txtA;
    @FXML
    private TextField txtB;
    @FXML
    private RadioButton rdoCong;
    @FXML
    private RadioButton rdoTru;
    @FXML
    private RadioButton rdoNhan;
    @FXML
    private RadioButton rdoChia;
    @FXML
    private Button btnTinh;
    @FXML
    private TextArea txtKetQua;

    @FXML
    private void xuLyPhepToan() {
        try {
            // Lấy dữ liệu từ TextField
            double a = Double.parseDouble(txtA.getText());
            double b = Double.parseDouble(txtB.getText());
            double result = 0;
            String operation = "";

            if (rdoCong.isSelected()) {
                result = a + b;
                operation = "Cộng";
            } else if (rdoTru.isSelected()) {
                result = a - b;
                operation = "Trừ";
            } else if (rdoNhan.isSelected()) {
                result = a * b;
                operation = "Nhân";
            } else if (rdoChia.isSelected()) {
                if (b == 0) {
                    txtKetQua.setText("Không thể chia cho 0!");
                    return;
                }
                result = a / b;
                operation = "Chia";
            } else {
                txtKetQua.setText("Vui lòng chọn phép toán!");
                return;
            }

            // Hiển thị kết quả
            txtKetQua.setText(String.format("Kết quả: %.2f", result));
        } catch (NumberFormatException e) {
            txtKetQua.setText("Lỗi: Vui lòng nhập số hợp lệ cho A và B!");
        }
    }
}
