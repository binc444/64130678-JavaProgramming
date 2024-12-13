package th.tranminhhieu.th_bai5_hashmap;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.HashMap;

public class TuDienController {

  @FXML
  private TextField txt_inputWord;

  @FXML
  private TextField txt_transcription;

  @FXML
  private TextArea txt_meaning;

  @FXML
  private Button btn_search;

  @FXML
  private Button btn_addNewWord;


  private HashMap<String, Word> td = new HashMap<>();

  public TuDienController() {
    // Thêm 10 từ tiếng Anh vào từ điển
    td.put("hello", new Word("/heˈləʊ/", "xin chào"));
    td.put("book", new Word("/bʊk/", "quyển sách"));
    td.put("apple", new Word("/ˈæp.əl/", "quả táo"));
    td.put("computer", new Word("/kəmˈpjuː.tər/", "máy tính"));
    td.put("phone", new Word("/fəʊn/", "điện thoại"));
    td.put("cat", new Word("/kæt/", "con mèo"));
    td.put("dog", new Word("/dɒɡ/", "con chó"));
    td.put("car", new Word("/kɑːr/", "xe hơi"));
    td.put("house", new Word("/haʊs/", "ngôi nhà"));
    td.put("tree", new Word("/triː/", "cây"));
  }

  public void setHashMap(HashMap<String, Word> td) {
    this.td = td;
  }

  @FXML
  public void xuLyTimKiem() {
    String inputWord = txt_inputWord.getText().trim().toLowerCase();

    if (td.containsKey(inputWord)) {
      Word word = td.get(inputWord);
      txt_transcription.setText(word.getTranscription());
      txt_meaning.setText(word.getMeaning());
    } else {
      txt_transcription.setText("");
      txt_meaning.setText("Không tìm thấy từ này, bạn có thể thêm từ này bằng nút bên dưới!");
    }
  }

  @FXML
  public void xuLyThemTuMoi() {
    try {
      FXMLLoader loader = new FXMLLoader(getClass().getResource("addNew-view.fxml"));
      Scene addNewWordScene = new Scene(loader.load());

      AddNewWordController addNewWordController = loader.getController();

      addNewWordController.setHashMap(td);

      Stage stage = (Stage) btn_addNewWord.getScene().getWindow();
      stage.setScene(addNewWordScene);
    } catch (IOException e) {
      e.printStackTrace();
    }
  }


  // Lớp Word để lưu thông tin của mỗi từ
  public static class Word {
    private String transcription;
    private String meaning;

    public Word(String transcription, String meaning) {
      this.transcription = transcription;
      this.meaning = meaning;
    }

    public String getTranscription() {
      return transcription;
    }

    public String getMeaning() {
      return meaning;
    }
  }
}
