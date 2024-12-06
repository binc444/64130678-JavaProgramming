package th.tranminhhieu.th_bai2;

import javafx.fxml.FXML;
import javafx.scene.control.CheckBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;

public class Controller {
    @FXML
    private TextField txtWeight;

    @FXML
    private TextField txtHeight;

    @FXML
    private CheckBox isAsian;

    @FXML
    private Text txtKetQua;

    @FXML
    void xuLyTinhBMI() {
        try {
            // Lấy cân nặng (kg) và chiều cao (cm) từ giao diện
            double weight = Double.parseDouble(txtWeight.getText());
            double height = Double.parseDouble(txtHeight.getText());

            // Tính chỉ số BMI
            double bmi = weight / (height * height);

            // Kiểm tra tiêu chuẩn (WHO hoặc Asian)
            boolean isAsianSelected = isAsian.isSelected();
            String thongBaoBMI="";

            if (isAsianSelected) {
                if (bmi < 17.5) {
                    thongBaoBMI = "Thiếu cân";
                } else if (bmi < 23) {
                    thongBaoBMI = "Bình thường";
                } else if (bmi < 28) {
                    thongBaoBMI = "Thừa cân";
                } else {
                    thongBaoBMI = "Béo phì";
                }
            } else {
                if (bmi < 18.5) {
                    thongBaoBMI = "Underweight";
                } else if (bmi < 25) {
                    thongBaoBMI = "Normal weight";
                } else if (bmi < 30) {
                    thongBaoBMI = "Overweight";
                } else {
                    thongBaoBMI = "Obese";
                }
            }
            txtKetQua.setText(String.format("Kết quả: BMI = %.2f - %s", bmi, thongBaoBMI));

        } catch (NumberFormatException e) {
            txtKetQua.setText("Vui lòng nhập lại số hợp lệ!");
        }
    }
}