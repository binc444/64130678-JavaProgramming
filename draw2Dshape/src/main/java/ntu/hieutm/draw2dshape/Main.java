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
    // Vẽ thân hình tròn
    gc.setStroke(Color.BLACK);
    gc.setLineWidth(3); //Độ dày đường viền
    gc.strokeOval(150, 125, 100, 100); //(x,y,width,height)

    // Vẽ tam giác
    gc.setStroke(Color.BLACK);
    gc.setFill(Color.WHITE);    // Màu nền là trắng

    // Vẽ màu nền của tam giác
    gc.fillPolygon(
        new double[]{100, 200, 300}, // x của 3 đỉnh
        new double[]{150, 50, 150},  // y của 3 đỉnh
        3
    );

    gc.strokePolygon(          // Vẽ đường viền của tam giác
        new double[]{100, 200, 300}, // x của 3 đỉnh
        new double[]{150, 50, 150},  // y của 3 đỉnh
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
    gc.strokePolygon(
        new double[]{180, 200, 220}, //x
        new double[]{100, 130, 100}, //y
        3
    );

    // Vẽ 2 hình tròn nhỏ (chân)
    gc.setStroke(Color.BLACK);
    gc.setFill(Color.WHITE);
    gc.fillOval(150, 200, 40, 40);  //màu nền trắng
    gc.strokeOval(150, 200, 40, 40);  //(x,y,width,height)

    gc.fillOval(210, 200, 40, 40); //màu nền trắng
    gc.strokeOval(210, 200, 40, 40);  //(x,y,width,height)

    // Vẽ móng chân
    gc.setStroke(Color.RED);
    gc.strokeOval(155, 215, 20, 20);  //(x,y,width,height)
    gc.strokeOval(225, 215, 20, 20);  //(x,y,width,height)
  }

  public static void main(String[] args) {
    launch(args);
  }
}