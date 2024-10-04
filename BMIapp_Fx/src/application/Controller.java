package application;

import java.awt.event.ActionEvent;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;

public class Controller {
	@FXML
	private TextField txt_chieuCao;
	@FXML	
    private TextField txt_canNang;
	@FXML
    private TextField txt_ketQua;
 
    public void tinhBMI(ActionEvent event) {
    	double chieuCao = Double.parseDouble(txt_chieuCao.getText());
        double canNang = Double.parseDouble(txt_canNang.getText());
         try {
        	 double bmi = canNang / (chieuCao * chieuCao);
        	 String trangThai;
             if (bmi < 18.5) {
                 trangThai = "Gầy";
             } else if (bmi >= 18.5 && bmi < 24.9) {
                 trangThai = "Bình thường";
             } else if (bmi >= 25 && bmi < 29.9) {
                 trangThai = "Thừa cân";
             } else {
                 trangThai = "Béo phì";
             }

             
             txt_ketQua.setText(String.format("BMI: %.2f - %s", bmi, trangThai));
         }
         catch (NumberFormatException ex) {
             txt_ketQua.setText("Lỗi: Vui lòng nhập số hợp lệ.");
        
         }
    }
}
