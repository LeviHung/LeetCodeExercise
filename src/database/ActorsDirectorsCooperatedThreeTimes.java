package database;

public class ActorsDirectorsCooperatedThreeTimes
{
  public static void sqlQuery()
  {
    String query = "Select actor_id, director_id from ActorDirector group by director_id, actor_id having count(*) > 2;";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find all the pairs (actor_id, director_id) where the actor has cooperated with the director at least three times.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ActorsDirectorsCooperatedThreeTimes.readme();

    System.out.println("The query statement: ");

    ActorsDirectorsCooperatedThreeTimes.sqlQuery();

  }
}