package th.tranminhhieu.th_bai5_hashmap;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import java.io.IOException;
import java.util.HashMap;
public class AddNewWordController {
  @FXML
  private TextField txt_addEngWord;

  @FXML
  private TextField txt_phonetic;

  @FXML
  private TextField txt_nghiaTiengViet;

  @FXML
  private Button btn_addThisWord;

  @FXML
  private Button btn_return;

  private HashMap<String, TuDienController.Word> td;

  public void setHashMap(HashMap<String, TuDienController.Word> td) {
    this.td = td;
  }

  @FXML
  public void xuLyThemVaoTuDien() {
    String engWord = txt_addEngWord.getText().trim().toLowerCase();
    String phonetic = txt_phonetic.getText().trim();
    String vietnameseMeaning = txt_nghiaTiengViet.getText().trim();

    if (engWord.isEmpty() || phonetic.isEmpty() || vietnameseMeaning.isEmpty()) {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Cảnh báo");
      alert.setHeaderText("Thêm từ thất bại");
      alert.setContentText("Vui lòng điền đầy đủ thông tin!");
      alert.showAndWait();
      return;
    }

    // Kiểm tra xem `td` có tồn tại không
    if (td == null) {
      Alert alert = new Alert(Alert.AlertType.ERROR);
      alert.setTitle("Lỗi");
      alert.setHeaderText("Từ điển chưa được khởi tạo");
      alert.setContentText("Không thể thêm từ mới vì từ điển chưa được khởi tạo.");
      alert.showAndWait();
      return;
    }

    if (td.containsKey(engWord)) {
      Alert alert = new Alert(Alert.AlertType.WARNING);
      alert.setTitle("Cảnh báo");
      alert.setHeaderText("Thêm từ thất bại");
      alert.setContentText("Từ này đã tồn tại trong từ điển!");
      alert.showAndWait();
      return;
    }

    // Thêm từ vào từ điển
    td.put(engWord, new TuDienController.Word(phonetic, vietnameseMeaning));

    Alert alert = new Alert(Alert.AlertType.INFORMATION);
    alert.setTitle("Thông báo");
    alert.setHeaderText("Thành công");
    alert.setContentText("Đã thêm từ mới vào từ điển!");
    alert.showAndWait();

    // Reset các trường nhập liệu
    txt_addEngWord.clear();
    txt_phonetic.clear();
    txt_nghiaTiengViet.clear();
  }


  @FXML
  public void xuLyTroVe() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("home-view.fxml"));
      Scene homeScene = new Scene(loader.load());

      TuDienController controller = loader.getController();
      controller.setHashMap(td);

      Stage stage = (Stage) btn_return.getScene().getWindow();
      stage.setScene(homeScene);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
