package th.tranminhhieu.th_bai4_flashquiz;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Controller {
    @FXML
    private Label lblCauHoi;
    @FXML
    private Button btnChooseDapAnA, btnChooseDapAnB, btnChooseDapAnC, btnChooseDapAnD;
    @FXML
    private Button btnToCau1, btnToCau2, btnToCau3, btnToCau4, btnToCau5, btnToCau6, btnToCau7, btnToCau8, btnToCau9, btnToCau10;
    @FXML
    private Button btnKetThuc;
    @FXML
    private TextField txtKetQua;

    private Connection connection;
    private List<Question> questions;
    private int currentQuestionIndex;
    private int score;

    public void initialize() {
        try {
            connectToDatabase();
            loadQuestionsFromDatabase();
            currentQuestionIndex = 0;
            score = 0;
            displayQuestion();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void connectToDatabase() throws SQLException {
        String url = "jdbc:mysql://localhost:3306/flash_quiz";
        String username = "root";
        String password = "";
        connection = DriverManager.getConnection(url, username, password);
    }

    private void loadQuestionsFromDatabase() throws SQLException {
        questions = new ArrayList<>();
        String query = "SELECT cauhoi.id, cauhoi.noiDung, cauhoi.dapAnDung, dapan.noiDung AS dapAn, dapan.kyHieu FROM cauhoi " +
            "JOIN dapan ON cauhoi.id = dapan.cauHoiId ORDER BY cauhoi.id, dapan.kyHieu";
        PreparedStatement statement = connection.prepareStatement(query);
        ResultSet resultSet = statement.executeQuery();

        int currentId = -1;
        Question question = null;

        while (resultSet.next()) {
            int id = resultSet.getInt("id");
            if (id != currentId) {
                if (question != null) questions.add(question);
                question = new Question(id, resultSet.getString("noiDung"), resultSet.getString("dapAnDung").trim());
                currentId = id;
            }
            if (question != null) {
                question.addAnswer(resultSet.getString("dapAn").trim(), resultSet.getString("kyHieu").trim());
            }
        }
        if (question != null) questions.add(question);
    }

    private void displayQuestion() {
        if (currentQuestionIndex >= questions.size()) return;
        Question currentQuestion = questions.get(currentQuestionIndex);
        lblCauHoi.setText(currentQuestion.getContent());
        btnChooseDapAnA.setText(currentQuestion.getAnswers().get("A"));
        btnChooseDapAnB.setText(currentQuestion.getAnswers().get("B"));
        btnChooseDapAnC.setText(currentQuestion.getAnswers().get("C"));
        btnChooseDapAnD.setText(currentQuestion.getAnswers().get("D"));

        // Đặt màu của các nút dựa trên trạng thái của câu hỏi
        resetButtonColors();
        if (currentQuestion.getSelectedAnswer() != null) {
            highlightSelectedAnswer(currentQuestion.getSelectedAnswer(), currentQuestion.isCorrect(currentQuestion.getSelectedAnswer()));
        }
    }

    private void resetButtonColors() {
        btnChooseDapAnA.setStyle("-fx-background-color: #FFFFFF;");
        btnChooseDapAnB.setStyle("-fx-background-color: #FFFFFF;");
        btnChooseDapAnC.setStyle("-fx-background-color: #FFFFFF;");
        btnChooseDapAnD.setStyle("-fx-background-color: #FFFFFF;");
    }

    private void highlightSelectedAnswer(String answer, boolean isCorrect) {
        String color = isCorrect ? "green" : "red";
        if (btnChooseDapAnA.getText().equals(answer)) {
            btnChooseDapAnA.setStyle("-fx-background-color: " + color + ";");
        } else if (btnChooseDapAnB.getText().equals(answer)) {
            btnChooseDapAnB.setStyle("-fx-background-color: " + color + ";");
        } else if (btnChooseDapAnC.getText().equals(answer)) {
            btnChooseDapAnC.setStyle("-fx-background-color: " + color + ";");
        } else if (btnChooseDapAnD.getText().equals(answer)) {
            btnChooseDapAnD.setStyle("-fx-background-color: " + color + ";");
        }
    }

    @FXML
    private void xuLyDapAn(ActionEvent event) {
        if (currentQuestionIndex >= questions.size()) return;

        Button clickedButton = (Button) event.getSource();
        String chosenAnswer = clickedButton.getText().trim(); // Xóa khoảng trắng thừa
        Question currentQuestion = questions.get(currentQuestionIndex);

        // Chỉ xử lý khi người dùng chưa chọn đáp án
        if (currentQuestion.getSelectedAnswer() == null) {
            currentQuestion.setSelectedAnswer(chosenAnswer);

            // Kiểm tra xem đáp án có đúng không
            if (currentQuestion.isCorrect(chosenAnswer)) {
                clickedButton.setStyle("-fx-background-color: green;");
                score += 10;
            } else {
                clickedButton.setStyle("-fx-background-color: red;");
            }
        }
        txtKetQua.setText("");
    }


    @FXML
    private void handleToCauHoi(ActionEvent event) {
        Button clickedButton = (Button) event.getSource();
        String btnId = clickedButton.getId();
        int questionIndex = Integer.parseInt(btnId.replace("btnToCau", "")) - 1;

        currentQuestionIndex = questionIndex;
        displayQuestion();
    }

    @FXML
    private void handleKetThuc() {
        txtKetQua.setText("" + score);
    }

    private static class Question {
        private final int id;
        private final String content;
        private final String correctAnswer;
        private final List<Answer> answers;
        private String selectedAnswer;

        public Question(int id, String content, String correctAnswer) {
            this.id = id;
            this.content = content;
            this.correctAnswer = correctAnswer;
            this.answers = new ArrayList<>();
            this.selectedAnswer = null;
        }

        public void addAnswer(String content, String key) {
            answers.add(new Answer(content, key));
        }

        public String getContent() {
            return content;
        }

        public boolean isCorrect(String answer) {
            return correctAnswer.trim().equalsIgnoreCase(answer.trim());
        }

        public String getSelectedAnswer() {
            return selectedAnswer;
        }

        public void setSelectedAnswer(String selectedAnswer) {
            this.selectedAnswer = selectedAnswer;
        }

        public Map<String, String> getAnswers() {
            Map<String, String> map = new HashMap<>();
            for (Answer answer : answers) {
                map.put(answer.getKey(), answer.getContent());
            }
            return map;
        }

        private static class Answer {
            private final String content;
            private final String key;

            public Answer(String content, String key) {
                this.content = content;
                this.key = key;
            }

            public String getContent() {
                return content;
            }

            public String getKey() {
                return key;
            }
        }
    }
}
