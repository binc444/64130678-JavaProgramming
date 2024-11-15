package ntu.hieutm.draw2dshape;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.io.IOException;

public class Main extends Application {
  @Override
  public void start(Stage primaryStage) {
    Pane root = new Pane();
    Canvas canvas = new Canvas(400, 400); //khung tranh
    GraphicsContext gc = canvas.getGraphicsContext2D();

    drawShape(gc); // Hàm vẽ hình

    root.getChildren().add(canvas);
    Scene scene = new Scene(root, 400, 400);
    primaryStage.setTitle("Ve hinh");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  private void drawShape(GraphicsContext gc) {
    // Vẽ tam giác
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(2);
    gc.strokePolygon(
        new double[]{100, 200, 300}, // x của 3 đỉnh
        new double[]{150, 50, 150},  // y của 3 đỉnh
        3
    );

    // Vẽ tai tam giác bên trái
    gc.strokePolygon(
        new double[]{150, 140, 175 }, //x
        new double[]{100, 50, 75  }, //y
        3
    );

    // Vẽ tai tam giác bên phải (đối xứng)
    gc.strokePolygon(
        new double[]{250, 260, 225 }, // x
        new double[]{100, 50, 75 },    // y
        3
    );
    // Vẽ hình tam giác đỏ bên trong
    gc.setStroke(Color.RED);
    gc.setLineWidth(3);
    gc.strokePolygon(
        new double[]{180, 200, 220},
        new double[]{100, 130, 100},
        3
    );
  }

  public static void main(String[] args) {
    launch(args);
  }
}