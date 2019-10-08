package application;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.text.Text;

public class StartPane extends Application {
  @Override
  public void start(Stage primaryStage) {
    try {
      BorderPane root = new BorderPane();
      Text center = new Text("Welcome to the NBA Quiz");
      root.setCenter(center);
      Image Steph = new Image("/application/Curry.jpg");
      ImageView Curry = new ImageView(Steph);
      root.setTop(Curry);
      Button toQuiz = new Button("Start Quiz");
      root.setBottom(toQuiz);
      BorderPane.setAlignment(toQuiz, Pos.CENTER);
      BorderPane.setAlignment(center, Pos.CENTER);
      BorderPane.setAlignment(Curry, Pos.CENTER);
      toQuiz.setOnAction(actionEvent -> {
        QuizPane now = new QuizPane();
        try {
          now.start(primaryStage);
        } catch (Exception e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      });
      Scene scene = new Scene(root, 1200, 800);
      scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
      primaryStage.setScene(scene);
      primaryStage.show();
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void main(String[] args) {
    launch(args);
  }
}
