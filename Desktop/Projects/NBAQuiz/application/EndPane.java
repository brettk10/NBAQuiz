package application;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class EndPane {
  private int numberCorrect;
  private int totalQuestions;

  public EndPane(int numberCorrect, int totalQuestions) {
    this.numberCorrect = numberCorrect;
    this.totalQuestions = totalQuestions;
  }

  public void start(Stage primaryStage) throws Exception {
    // TODO Auto-generated method stub
    try {
      BorderPane root = new BorderPane();
      Text title = new Text(
          "Thank you for taking the quiz \n You finished " + this.numberCorrect + "/" + this.totalQuestions);
      root.setCenter(title);
      Button startOver = new Button("Start Over");
      BorderPane.setAlignment(startOver, Pos.CENTER);
      startOver.setOnAction(actionEvent -> {
        StartPane start = new StartPane();
        start.start(primaryStage);
      });
      root.setBottom(startOver);
      Scene scene = new Scene(root, 1200, 800);
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }

  }

}
