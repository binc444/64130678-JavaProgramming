package com.example.mavenjavafx;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Iterator;

public class ThemSV_Controller {

    @FXML
    private TextField txt_MSSV;
    @FXML
    private TextField txt_hoTen;
    @FXML
    private TextField txt_ngaySinh;
    @FXML
    private TextArea txtare_result;
    @FXML
    private Button btn_them;
    @FXML
    private Button btn_luu;
    @FXML
    private Button btn_tai;

    private JSONArray danhSachSinhVien = new JSONArray();

    @FXML
    private void addSV() {
        // Lấy thông tin từ các textfield
        String mssv = txt_MSSV.getText();
        String hoTen = txt_hoTen.getText();
        String ngaySinh = txt_ngaySinh.getText();

        // Tạo đối tượng JSON cho sinh viên
        JSONObject sv = new JSONObject();
        sv.put("MSSV", mssv);
        sv.put("HoTen", hoTen);
        sv.put("NgaySinh", ngaySinh);

        // Thêm sinh viên vào danh sách
        danhSachSinhVien.add(sv);

        // Hiển thị thông tin ra TextArea
        txtare_result.appendText("MSSV: " + mssv + ", Họ và tên: " + hoTen + ", Ngày sinh: " + ngaySinh + "\n");

        // Xóa các textfield sau khi thêm
        txt_MSSV.clear();
        txt_hoTen.clear();
        txt_ngaySinh.clear();
    }

    @FXML
    private void saveSV() {
        try (FileWriter file = new FileWriter("sinhvien.json")) {
            file.write(danhSachSinhVien.toJSONString());
            file.flush();
            txtare_result.appendText("Đã lưu danh sách sinh viên vào sinhvien.json\n");
        } catch (IOException e) {
            e.printStackTrace();
            txtare_result.appendText("Lỗi khi lưu tệp\n");
        }
    }

    @FXML
    private void loadSV() {
        danhSachSinhVien.clear();
        txtare_result.clear();
        try (FileReader reader = new FileReader("sinhvien.json")) {
            // Đọc dữ liệu JSON từ tệp
            JSONArray svArray = (JSONArray) org.json.simple.JSONValue.parse(reader);
            if (svArray != null) {
                for (int i = 0; i < svArray.size(); i++) {
                    JSONObject sv = (JSONObject) svArray.get(i);
                    String mssv = (String) sv.get("MSSV");
                    String hoTen = (String) sv.get("HoTen");
                    String ngaySinh = (String) sv.get("NgaySinh");

                    // Hiển thị thông tin ra TextArea
                    txtare_result.appendText("MSSV: " + mssv + ", Họ và tên: " + hoTen + ", Ngày sinh: " + ngaySinh + "\n");

                    // Thêm sinh viên vào danh sách
                    danhSachSinhVien.add(sv);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            txtare_result.appendText("Lỗi khi tải tệp\n");
        }
    }

}