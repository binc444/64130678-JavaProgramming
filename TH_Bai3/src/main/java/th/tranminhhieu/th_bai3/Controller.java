package th.tranminhhieu.th_bai3;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    // Các nút câu hỏi
    @FXML
    private Button btnCau1, btnCau2, btnCau3, btnCau4, btnCau5, btnCau6, btnCau7, btnCau8, btnCau9, btnCau10;

    // Các nút đáp án
    @FXML
    private Button btnDapAnA, btnDapAnB, btnDapAnC, btnDapAnD;

    // Các nút tùy chọn ABCD
    @FXML
    private Button btnA, bntB, btnC, btnD;

    // Biến để theo dõi câu hỏi hiện tại
    private Button currentCauButton;

    @FXML
    private void xuLyCau1(ActionEvent event) {
        highlightCauButton(btnCau1);
        resetDapAnButtons();
    }

    @FXML
    private void xuLyCau2(ActionEvent event) {
        highlightCauButton(btnCau2);
        resetDapAnButtons();
    }

    @FXML
    private void xuLyCau3(ActionEvent event) {
        highlightCauButton(btnCau3);
        resetDapAnButtons();
    }

    @FXML
    private void xuLyCau4(ActionEvent event) {
        highlightCauButton(btnCau4);
        resetDapAnButtons();
    }

    @FXML
    private void xuLyCau5(ActionEvent event) {
        highlightCauButton(btnCau5);
        resetDapAnButtons();
    }

    @FXML
    private void xuLyCau6(ActionEvent event) {
        highlightCauButton(btnCau6);
        resetDapAnButtons();
    }

    @FXML
    private void xuLyCau7(ActionEvent event) {
        highlightCauButton(btnCau7);
        resetDapAnButtons();
    }

    @FXML
    private void xuLyCau8(ActionEvent event) {
        highlightCauButton(btnCau8);
        resetDapAnButtons();
    }

    @FXML
    private void xuLyCau9(ActionEvent event) {
        highlightCauButton(btnCau9);
        resetDapAnButtons();
    }

    @FXML
    private void xuLyCau10(ActionEvent event) {
        highlightCauButton(btnCau10);
        resetDapAnButtons();
    }

    private void highlightCauButton(Button button) {
        if (currentCauButton != null) {
            currentCauButton.setStyle("-fx-background-color: #529f66; -fx-text-fill: white;");
        }
        button.setStyle("-fx-background-color: #4CAF50; -fx-text-fill: white;");
        currentCauButton = button;
    }

    private void resetDapAnButtons() {
        // Đặt lại màu các nút đáp án
        btnDapAnA.setStyle("-fx-background-color: #4EBCFF; -fx-text-fill: black;");
        btnDapAnB.setStyle("-fx-background-color: #4EBCFF; -fx-text-fill: black;");
        btnDapAnC.setStyle("-fx-background-color: #4EBCFF; -fx-text-fill: black;");
        btnDapAnD.setStyle("-fx-background-color: #4EBCFF; -fx-text-fill: black;");

        // Đặt lại màu các nút tùy chọn
        btnA.setStyle("-fx-background-color: #4EBCFF; -fx-text-fill: black;");
        bntB.setStyle("-fx-background-color: #4EBCFF; -fx-text-fill: black;");
        btnC.setStyle("-fx-background-color: #4EBCFF; -fx-text-fill: black;");
        btnD.setStyle("-fx-background-color: #4EBCFF; -fx-text-fill: black;");
    }
}
