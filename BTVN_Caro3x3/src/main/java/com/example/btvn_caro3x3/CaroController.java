package com.example.btvn_caro3x3;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class CaroController {

  @FXML private Button o1, o2, o3, o4, o5, o6, o7, o8, o9;
  @FXML private Button btn_refresh, btn_close;

  private boolean isXTurn = true; // Kiểm tra lượt chơi (X hoặc O)

  @FXML
  private void initialize() {
    // Gán sự kiện cho tất cả các nút
    inGame(o1, o2, o3, o4, o5, o6, o7, o8, o9);
    // Gán sự kiện cho nút "Làm mới"
    btn_refresh.setOnAction(event -> resetGame());
    // Gán sự kiện cho nút "Đóng"
    btn_close.setOnAction(event -> closeApp());
  }

  private void inGame(Button... buttons) {
    for (Button button : buttons) {
      button.setOnAction(event -> {
        if (button.getText().isEmpty()) {
          button.setText(isXTurn ? "X" : "O");
          if (checkWin()) {//kiểm tra nếu x hoặc o thắng
            showAlert((isXTurn ? "X" : "O") +" " +"thắng");
          } else if (isBoardFull()) {
            showAlert("Hòa!");
          }
          isXTurn = !isXTurn; // Đổi lượt chơi
        }
      });
    }
  }

  private boolean checkWin() {
    // Kiểm tra hàng, cột, đường chéo
    return checkLine(o1, o2, o3) || checkLine(o4, o5, o6) || checkLine(o7, o8, o9) ||
        checkLine(o1, o4, o7) || checkLine(o2, o5, o8) || checkLine(o3, o6, o9) ||
        checkLine(o1, o5, o9) || checkLine(o3, o5, o7);
  }

  private boolean checkLine(Button a, Button b, Button c) {
    // kiểm tra hàng ngang, dọc, chéo có cùng một kiểu text(x,o) hay không
    return !a.getText().isEmpty() && a.getText().equals(b.getText()) && a.getText().equals(c.getText());
  }

  //Kiểm tra hòa
  private boolean isBoardFull() {
    return !o1.getText().isEmpty() && !o2.getText().isEmpty() && !o3.getText().isEmpty() &&
        !o4.getText().isEmpty() && !o5.getText().isEmpty() && !o6.getText().isEmpty() &&
        !o7.getText().isEmpty() && !o8.getText().isEmpty() && !o9.getText().isEmpty();
  }

  private void showAlert(String message) {
    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Kết quả");
    alert.setHeaderText(null);
    alert.setContentText(message);
    alert.showAndWait();
  }

  private void resetGame() {
    o1.setText(""); o2.setText(""); o3.setText("");
    o4.setText(""); o5.setText(""); o6.setText("");
    o7.setText(""); o8.setText(""); o9.setText("");
    isXTurn = true;
  }

  private void closeApp() {
    Stage stage = (Stage) btn_close.getScene().getWindow();
    stage.close();
  }
}
