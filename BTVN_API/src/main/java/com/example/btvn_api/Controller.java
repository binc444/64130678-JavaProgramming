package com.example.btvn_api;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.awt.event.ActionEvent;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Scanner;

public class Controller {
    @FXML
    private TextField txt_URL;

    @FXML
    private TextArea txt_result;

    @FXML
    private Button btn_search;

    @FXML
    private Button btn_close;

    public void searchAPI(javafx.event.ActionEvent actionEvent) {
        //get URL
        String urlInput = txt_URL.getText();
        if (urlInput.isEmpty()) {
            txt_result.setText("Vui lòng nhập vào URL!!!!");
            return;
        }
        //check response status
        try {
            URL url = new URL(urlInput);
            HttpURLConnection cnect = (HttpURLConnection) url.openConnection();
            cnect.setRequestMethod("GET");
            cnect.connect();

            int code = cnect.getResponseCode();
            if (code != 200) {
                txt_result.setText("Lỗi: Không thể kết nối đến URL. Mã lỗi: " + code);
                return;
            }

            //Hien ket qua
            Scanner scanner = new Scanner(url.openStream());
            StringBuilder result = new StringBuilder();
            while (scanner.hasNext()) {
                result.append(scanner.nextLine()).append("\n");
            }
            scanner.close();

            txt_result.setText(result.toString());
        } catch (IOException e) {
            txt_result.setText("Lỗi: " + e.getMessage());
        }
    }

    public void closeApp(javafx.event.ActionEvent actionEvent) {
        System.exit(0);
    }
}