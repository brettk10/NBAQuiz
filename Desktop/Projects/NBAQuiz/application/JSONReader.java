package application;

import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JSONReader {
  private HashMap<String, Player> playerList;

  public JSONReader(String filePath) throws IOException, ParseException, org.json.simple.parser.ParseException {
    playerList = new HashMap<>();
    parseFile(filePath);
  }

  private void parseFile(String filePath) {
    try {
      JSONObject file = (JSONObject) new JSONParser().parse(new FileReader(filePath));
      JSONArray players = (JSONArray) file.get("NBAPlayerArray");
      for (Object p : players) {
        JSONObject player = (JSONObject) p;
        String name = (String) player.get("Name");
        String pos = (String) player.get("Pos");
        Long age = (Long) player.get("Age");
        String team = (String) player.get("Tm");
        Long gamesPlayed = (Long) player.get("G");
        Long gamesStarted = (Long) player.get("GS");
        double mp = Double.parseDouble(player.get("MP") + "");
        double FG = Double.parseDouble(player.get("FG") + "");
        double FGA = Double.parseDouble(player.get("FGA") + "");
        double FGPercentage;
        if (player.get("FG%") == null) {
          FGPercentage = 0.0;
        } else {
          FGPercentage = Double.parseDouble(player.get("FG%") + "");
        }
        double threeP = Double.parseDouble(player.get("3P") + "");
        double threePA = Double.parseDouble(player.get("3PA") + "");
        double threePPercentage;
        if (player.get("3P%") == null) {
          threePPercentage = 0.0;
        } else {
          threePPercentage = Double.parseDouble(player.get("3P%") + "");
        }
        double twoP = Double.parseDouble(player.get("2P") + "");
        double twoPA = Double.parseDouble(player.get("2PA") + "");
        double twoPPercentage;
        if (player.get("2P%") == null) {
          twoPPercentage = 0.0;
        } else {
          twoPPercentage = Double.parseDouble(player.get("2P%") + "");
        }
        double eFG;
        if (player.get("eFG%") == null) {
          eFG = 0.0;
        } else {
          eFG = Double.parseDouble(player.get("eFG%") + "");
        }
        double FT = Double.parseDouble(player.get("FT") + "");
        double FTA = Double.parseDouble(player.get("FTA") + "");
        double FTPercentage;
        if (player.get("FT%") == null) {
          FTPercentage = 0.0;
        } else {
          FTPercentage = Double.parseDouble(player.get("FT%") + "");
        }
        double ORB = Double.parseDouble(player.get("ORB") + "");
        double DRB = Double.parseDouble(player.get("DRB") + "");
        double TRB = Double.parseDouble(player.get("TRB") + "");
        double AST = Double.parseDouble(player.get("AST") + "");
        double STL = Double.parseDouble(player.get("STL") + "");
        double BLK = Double.parseDouble(player.get("BLK") + "");
        double TOV = Double.parseDouble(player.get("TOV") + "");
        double PF = Double.parseDouble(player.get("PF") + "");
        double PTS = Double.parseDouble(player.get("PTS") + "");
        Player toBeAdded = new Player(name, pos, age, team, gamesPlayed, gamesStarted, mp, FG, FGA, FGPercentage,
            threeP, threePA, threePPercentage, twoP, twoPA, twoPPercentage, eFG, FT, FTA, FTPercentage, ORB, DRB, TRB,
            AST, STL, BLK, TOV, PF, PTS);
        playerList.put(name, toBeAdded);
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public HashMap<String, Player> getPlayerList() {
    return this.playerList;
  }

  public static void main(String[] args) throws IOException, ParseException, org.json.simple.parser.ParseException {
    JSONReader test = new JSONReader("NBAPlayerArray.json");
    HashMap testMap = test.getPlayerList();
    List<Player> test1 = new ArrayList<Player>(testMap.values());
    List<Player> filteredList = test1.stream().filter(p -> p.PTS >= 20.0).collect(Collectors.toList());
    Player x = (Player) testMap.get("Nikola Jokic");
    System.out.println(x.PTS);
    System.out.println(filteredList.get(0).name);
  }
}
