package database;

public class GamePlayAnalysisI
{
  public static void sqlQuery()
  {
    String query = "SELECT player_id, MIN(event_date) AS first_login FROM Activity GROUP BY player_id;\n";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "(player_id, event_date) is the primary key (combination of columns with unique values) of this table. This table shows the activity of players of some games. Each row is a record of a player who logged in and played a number of games (possibly 0) before logging out on someday using some device.\n\n";

    str += "Write a solution to find the first login date for each player.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    GamePlayAnalysisI.readme();

    GamePlayAnalysisI.sqlQuery();
  }
}