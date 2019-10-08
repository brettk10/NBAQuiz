package application;

import java.util.ArrayList;
import java.util.List;

public class Question {
  List<Player> playerList;
  int correctIndex;
  String questionText;
  double[] statArray;

  public Question(List<Player> playerList, int correctIndex, String questionText, double[] statArray) {
    this.playerList = playerList;
    this.correctIndex = correctIndex;
    this.questionText = questionText;
    this.statArray = statArray;
  }
}