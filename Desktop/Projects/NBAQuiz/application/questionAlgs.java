package application;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

public class questionAlgs {
  public List<Question> listOfQuestions;

  public questionAlgs() {
    listOfQuestions = new ArrayList<Question>();
  }

  public Question ppgAll() throws IOException, ParseException, org.json.simple.parser.ParseException {
    int correctIndex = 0;
    double[] statArray = new double[4];
    JSONReader curr = new JSONReader("NBAPlayerArray.json");
    HashMap playerMap = curr.getPlayerList();
    List<Player> playerList = new ArrayList<Player>(playerMap.values());
    playerList = playerList.stream().filter(p -> p.gamesPlayed >= 10).collect(Collectors.toList());
    List<Player> questionList = new ArrayList<Player>();
    for (int i = 0; i < 4; i++) {
      int p1 = (int) (Math.random() * playerList.size());
      Player option = playerList.get(p1);
      questionList.add(option);
      playerList.remove(p1);
      statArray[i] = option.PTS;
      if (questionList.get(i).PTS > questionList.get(correctIndex).PTS) {
        correctIndex = i;
      }
    }
    String text = "Which of these players averaged the most points per game?";
    Question toReturn = new Question(questionList, correctIndex, text, statArray);
    return toReturn;
  }

  public Question ppg20() throws IOException, ParseException, org.json.simple.parser.ParseException {
    int correctIndex = 0;
    double[] statArray = new double[4];
    JSONReader curr = new JSONReader("NBAPlayerArray.json");
    HashMap playerMap = curr.getPlayerList();
    List<Player> playerList = new ArrayList<Player>(playerMap.values());
    List<Player> filteredList = playerList.stream().filter(p -> p.PTS >= 20.0).collect(Collectors.toList());
    filteredList = filteredList.stream().filter(p -> p.gamesPlayed >= 10).collect(Collectors.toList());
    List<Player> questionList = new ArrayList<Player>();
    for (int i = 0; i < 4; i++) {
      int p1 = (int) (Math.random() * filteredList.size());
      Player option = filteredList.get(p1);
      questionList.add(option);
      filteredList.remove(p1);
      statArray[i] = option.PTS;
      if (questionList.get(i).PTS > questionList.get(correctIndex).PTS) {
        correctIndex = i;
      }
    }
    String text = "Which of the following players who averaged 20+ points averaged the most points?";
    Question toReturn = new Question(questionList, correctIndex, text, statArray);
    return toReturn;
  }

  public Question ast5() throws IOException, ParseException, org.json.simple.parser.ParseException {
    int correctIndex = 0;
    double[] statArray = new double[4];
    JSONReader curr = new JSONReader("NBAPlayerArray.json");
    HashMap playerMap = curr.getPlayerList();
    List<Player> playerList = new ArrayList<Player>(playerMap.values());
    List<Player> filteredList = playerList.stream().filter(p -> p.AST >= 5).collect(Collectors.toList());
    List<Player> questionList = new ArrayList<Player>();
    for (int i = 0; i < 4; i++) {
      int p1 = (int) (Math.random() * filteredList.size());
      Player option = filteredList.get(p1);
      questionList.add(option);
      filteredList.remove(p1);
      statArray[i] = option.AST;
      if (questionList.get(i).AST > questionList.get(correctIndex).AST) {
        correctIndex = i;
      }
    }
    String text = "Which of the following players averaged the most assists?";
    Question toReturn = new Question(questionList, correctIndex, text, statArray);
    return toReturn;
  }

  public Question reb10ppg() throws IOException, ParseException, org.json.simple.parser.ParseException {
    int correctIndex = 0;
    double[] statArray = new double[4];
    JSONReader curr = new JSONReader("NBAPlayerArray.json");
    HashMap playerMap = curr.getPlayerList();
    List<Player> playerList = new ArrayList<Player>(playerMap.values());
    List<Player> filteredList = playerList.stream().filter(p -> p.TRB >= 10).collect(Collectors.toList());
    List<Player> questionList = new ArrayList<Player>();
    for (int i = 0; i < 4; i++) {
      int p1 = (int) (Math.random() * filteredList.size());
      Player option = filteredList.get(p1);
      questionList.add(option);
      filteredList.remove(p1);
      statArray[i] = option.PTS;
      if (questionList.get(i).PTS > questionList.get(correctIndex).PTS) {
        correctIndex = i;
      }
    }
    String text = "Which player who averaged 10+ rebounds averaged the most ppg?";
    Question toReturn = new Question(questionList, correctIndex, text, statArray);
    return toReturn;
  }

  public Question ftPPG25() throws IOException, ParseException, org.json.simple.parser.ParseException {
    int correctIndex = 0;
    double[] statArray = new double[4];
    JSONReader curr = new JSONReader("NBAPlayerArray.json");
    HashMap playerMap = curr.getPlayerList();
    List<Player> playerList = new ArrayList<Player>(playerMap.values());
    List<Player> filteredList = playerList.stream().filter(p -> p.PTS >= 25).collect(Collectors.toList());
    List<Player> questionList = new ArrayList<Player>();
    for (int i = 0; i < 4; i++) {
      int p1 = (int) (Math.random() * filteredList.size());
      Player option = filteredList.get(p1);
      questionList.add(option);
      filteredList.remove(p1);
      statArray[i] = option.FTPercentage * 100;
      if (questionList.get(i).FTPercentage > questionList.get(correctIndex).FTPercentage) {
        correctIndex = i;
      }
    }
    String text = "Which of the following players who averaged 25 or more PPG had the highest Free Throw Percentage?";
    Question toReturn = new Question(questionList, correctIndex, text, statArray);
    return toReturn;
  }

  public Question ThreePT30Age() throws IOException, ParseException, org.json.simple.parser.ParseException {
    int correctIndex = 0;
    double[] statArray = new double[4];
    JSONReader curr = new JSONReader("NBAPlayerArray.json");
    HashMap playerMap = curr.getPlayerList();
    List<Player> playerList = new ArrayList<Player>(playerMap.values());
    List<Player> filteredList = playerList.stream().filter(p -> p.age >= 30).collect(Collectors.toList());
    List<Player> questionList = new ArrayList<Player>();
    for (int i = 0; i < 4; i++) {
      int p1 = (int) (Math.random() * filteredList.size());
      Player option = filteredList.get(p1);
      questionList.add(option);
      filteredList.remove(p1);
      statArray[i] = option.ThreePPercentage * 100;
      if (questionList.get(i).ThreePPercentage > questionList.get(correctIndex).ThreePPercentage) {
        correctIndex = i;
      }
    }
    String text = "Which of the following players who are over 30 had the highest 3PT%?";
    Question toReturn = new Question(questionList, correctIndex, text, statArray);
    return toReturn;
  }

  public Question AstTrv6Ast() throws IOException, ParseException, org.json.simple.parser.ParseException {
    int correctIndex = 0;
    double[] statArray = new double[4];
    JSONReader curr = new JSONReader("NBAPlayerArray.json");
    HashMap playerMap = curr.getPlayerList();
    List<Player> playerList = new ArrayList<Player>(playerMap.values());
    List<Player> filteredList = playerList.stream().filter(p -> p.AST >= 6.0).collect(Collectors.toList());
    List<Player> questionList = new ArrayList<Player>();
    int p1 = (int) Math.random() * filteredList.size();
    for (int i = 0; i < 4; i++) {
      p1 = (int) (Math.random() * filteredList.size());
      Player option = filteredList.get(p1);
      questionList.add(option);
      filteredList.remove(p1);
      statArray[i] = (option.AST) / (option.TOV);
      statArray[i] = Math.round(statArray[i] * 1000.0) / 1000.0;
      if ((option.AST / option.TOV) > (questionList.get(correctIndex).AST / questionList.get(correctIndex).TOV)) {
        correctIndex = i;
      }
    }
    String text = "Which of the following players who averaged more than 6 APG had the best Assist/Turnover ratio?";
    Question toReturn = new Question(questionList, correctIndex, text, statArray);
    return toReturn;
  }

  public Question fgPercentage25ppg() throws IOException, ParseException, org.json.simple.parser.ParseException {
    int correctIndex = 0;
    double[] statArray = new double[4];
    JSONReader curr = new JSONReader("NBAPlayerArray.json");
    HashMap playerMap = curr.getPlayerList();
    List<Player> playerList = new ArrayList<Player>(playerMap.values());
    List<Player> filteredList = playerList.stream().filter(p -> p.PTS >= 25.0).collect(Collectors.toList());
    List<Player> questionList = new ArrayList<Player>();
    for (int i = 0; i < 4; i++) {
      int p1 = (int) (Math.random() * filteredList.size());
      Player option = filteredList.get(p1);
      questionList.add(option);
      filteredList.remove(p1);
      statArray[i] = (option.FGPercentage * 100.0);
      if (option.FGPercentage > questionList.get(correctIndex).FGPercentage) {
        correctIndex = i;
      }
    }
    String text = "Which of the following players who averaged 25 or more PPG had the best FG%?";
    Question toReturn = new Question(questionList, correctIndex, text, statArray);
    return toReturn;
  }

  public Question ageUnder23ppg() throws IOException, ParseException, org.json.simple.parser.ParseException {
    int correctIndex = 0;
    double[] statArray = new double[4];
    JSONReader curr = new JSONReader("NBAPlayerArray.json");
    HashMap playerMap = curr.getPlayerList();
    List<Player> playerList = new ArrayList<Player>(playerMap.values());
    List<Player> filteredList = playerList.stream().filter(p -> p.age <= 23).collect(Collectors.toList());
    List<Player> questionList = new ArrayList<Player>();
    for (int i = 0; i < 4; i++) {
      int p1 = (int) (Math.random() * filteredList.size());
      Player option = filteredList.get(p1);
      questionList.add(option);
      filteredList.remove(p1);
      statArray[i] = option.PTS;
      if (option.PTS > questionList.get(correctIndex).PTS) {
        correctIndex = i;
      }
    }
    String text = "Which of the following players who are under 23 averaged the most PPG?";
    Question toReturn = new Question(questionList, correctIndex, text, statArray);
    return toReturn;
  }

  public List<Question> runAll() {
    try {
      listOfQuestions.add(ppgAll());
      listOfQuestions.add(ppg20());
      listOfQuestions.add(ast5());
      listOfQuestions.add(reb10ppg());
      listOfQuestions.add(ftPPG25());
      listOfQuestions.add(ThreePT30Age());
      listOfQuestions.add(AstTrv6Ast());
      listOfQuestions.add(fgPercentage25ppg());
      listOfQuestions.add(ageUnder23ppg());
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    } catch (org.json.simple.parser.ParseException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    Collections.shuffle(listOfQuestions);
    return listOfQuestions;
  }
}
