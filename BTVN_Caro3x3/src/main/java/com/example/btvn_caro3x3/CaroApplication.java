package com.example.btvn_caro3x3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class CaroApplication extends Application {
  @Override
  public void start(Stage stage) throws IOException {
    FXMLLoader fxmlLoader = new FXMLLoader(CaroApplication.class.getResource("viewCaro.fxml"));
    Scene scene = new Scene(fxmlLoader.load());
    stage.setTitle("Cờ caro");
    stage.setScene(scene);
    stage.show();
  }

  public static void main(String[] args) {
    launch();
  }
}