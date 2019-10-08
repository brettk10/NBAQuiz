package application;

import java.util.List;

import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
// import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Text;
import javafx.scene.text.TextAlignment;

public class QuizPane extends Application {
  int correctAnswers = 0;
  Label correct = new Label("");
  questionAlgs qA = new questionAlgs();
  List<Question> questionList = qA.runAll();
  Label questionLabel = new Label("Welcome to the quiz");
  GridPane root = new GridPane();
  Label questionText = new Label();
  Label question = new Label();
  int listSize = questionList.size();
  Label[] statArrayPrint = new Label[4];

  @Override
  public void start(Stage primaryStage) throws Exception {
    // TODO Auto-generated method stub
    try {
      root.setHgap(10);
      root.setVgap(10);
      root.add(questionLabel, 10, 0);
      questionLabel.setStyle("-fx-font-family: Times New Roman;");
      questionLabel.setStyle("-fx-font-size: 48pt;");
      GridPane.setHalignment(questionLabel, HPos.CENTER);
      root.add(correct, 10, 31);
      root.add(questionText, 10, 3);
      root.add(question, 10, 7);
      for (int i = 0; i < 4; i++) {
        statArrayPrint[i] = new Label("");
        root.add(statArrayPrint[i], 20, 10 + i * 5);
      }
      newQuestion(primaryStage, 0);
      Scene scene = new Scene(root, 1200, 800);
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

  private void newQuestion(Stage primaryStage, int index) {
    if (index >= questionList.size()) {
      EndPane end = new EndPane(correctAnswers, listSize);
      try {
        end.start(primaryStage);
        return;
      } catch (Exception e) {
        // TODO Auto-generated catch block
        e.printStackTrace();
      }
    }
    root.getChildren().removeIf(childComponent -> childComponent instanceof RadioButton);
    questionText.setText("Question " + (index + 1) + "/" + listSize);
    GridPane.setHalignment(questionText, HPos.CENTER);
    ToggleGroup questionToggle = new ToggleGroup();
    Question current = questionList.get(index);
    double[] statArray = current.statArray;
    Button next = new Button("Next");
    root.add(next, 30, 30);
    correct.setText("");
    question.setText(current.questionText);
    for (int i = 0; i < 4; i++) {
      RadioButton option = new RadioButton(current.playerList.get(i).name);
      option.setToggleGroup(questionToggle);
      root.add(option, 10, 10 + i * 5);
      int j = i;
      option.setOnAction(actionEvent -> {
        if (j == current.correctIndex) {
          correctAnswers++;
          correct.setText("correct");
        } else {
          correct.setText("incorrect");
        }
        for (int k = 0; k < 4; k++) {
          statArrayPrint[k].setText(statArray[k] + "");
        }
        questionToggle.getToggles().forEach(toggle -> {
          Node node = (Node) toggle;
          node.setDisable(true);
          next.setDisable(false);
        });
      });
    }
    next.setOnAction(actionEvent -> {
      newQuestion(primaryStage, index + 1);
      questionToggle.getToggles().forEach(toggle -> {
        Node node = (Node) toggle;
        node.setDisable(false);
        next.setDisable(true);
        for (int k = 0; k < 4; k++) {
          statArrayPrint[k].setText("");
        }
      });
    });
  }

}
