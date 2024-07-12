package database;

public class RisingTemperature
{
  public static void sqlQuery()
  {
    String query = "SELECT t.id as id FROM Weather t, Weather y WHERE DATEDIFF(t.Recorddate, y.Recorddate)  = 1 AND t.temperature - y.temperature > 0;\n";

    System.out.println(query);
  }

  public static void sqlQueryOpt()
  {
    String query = "Select w1.id from Weather w1 join Weather w2 on w1.recordDate = date_add(w2.recordDate, interval 1 day) where w1.temperature > w2.temperature;\n";

    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find all dates' Id with higher temperatures compared to its previous dates (yesterday).\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    RisingTemperature.readme();

    System.out.println("The query statement: ");
    RisingTemperature.sqlQuery();

    System.out.println("The optimized query statement: ");
    RisingTemperature.sqlQueryOpt();
  }
}