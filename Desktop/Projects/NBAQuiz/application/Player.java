package application;

public class Player {
  String name;
  String pos;
  Long age;
  String team;
  Long gamesPlayed;
  Long gamesStarted;
  double MPG;
  double FG;
  double FGA;
  double FGPercentage;
  double ThreeP;
  double ThreePA;
  double ThreePPercentage;
  double TwoP;
  double TwoPA;
  double TwoPPercentage;
  double eFG;
  double FT;
  double FTA;
  double FTPercentage;
  double ORB;
  double DRB;
  double TRB;
  double AST;
  double STL;
  double BLK;
  double TOV;
  double PF;
  double PTS;

  public Player(String name, String pos, Long age, String team, Long gamesPlayed, Long gamesStarted, double MPG,
      double FG, double FGA, double FGPercentage, double ThreeP, double ThreePA, double ThreePPercentage, double TwoP,
      double TwoPA, double TwoPPercentage, double eFG, double FT, double FTA, double FTPercentage, double ORB,
      double DRB, double TRB, double AST, double STL, double BLK, double TOV, double PF, double PTS) {
    this.name = name;
    this.pos = pos;
    this.age = age;
    this.team = team;
    this.gamesPlayed = gamesPlayed;
    this.gamesStarted = gamesStarted;
    this.MPG = MPG;
    this.FG = FG;
    this.FGA = FGA;
    this.FGPercentage = FGPercentage;
    this.ThreeP = ThreeP;
    this.ThreePA = ThreePA;
    this.ThreePPercentage = ThreePPercentage;
    this.TwoP = TwoP;
    this.TwoPA = TwoPA;
    this.TwoPPercentage = TwoPPercentage;
    this.eFG = eFG;
    this.FT = FT;
    this.FTA = FTA;
    this.FTPercentage = FTPercentage;
    this.ORB = ORB;
    this.DRB = DRB;
    this.TRB = TRB;
    this.AST = AST;
    this.STL = STL;
    this.BLK = BLK;
    this.TOV = TOV;
    this.PF = PF;
    this.PTS = PTS;
  }

  public double getPTS() {
    return this.PTS;
  }
}
