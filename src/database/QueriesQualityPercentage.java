package database;

public class QueriesQualityPercentage
{
  public static void sqlQuery()
  {
    String query = "select query_name,\n"; 
    query += "cast(sum(rating/position)/count(query_name) as decimal(10,2)) as quality,\n"; 
    query += "cast(AVG(if (rating < 3,1,0))*100 as decimal(10,2)) as poor_query_percentage \n"; 
    query += "from Queries where query_name is not null group by query_name; \"\n"; 
    System.out.println(query);
  }

  public static void sqlQueryEx()
  {
    String query = "SELECT query_name,\n";
    query += "ROUND(AVG(rating / position), 2) AS quality,\n";
    query += "ROUND(AVG(IF(rating < 3, 1, 0)) * 100, 2) AS poor_query_percentage\n";
    query += "FROM Queries\n";
    query += "WHERE query_name IS NOT NULL\n";
    query += "GROUP BY query_name;\"\n";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find each query_name, the quality and poor_query_percentage.\n\n";

    str += "Both quality and poor_query_percentage should be rounded to 2 decimal places.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    QueriesQualityPercentage.readme();

    System.out.println("The query statement: ");

    QueriesQualityPercentage.sqlQuery();

    System.out.println("");

    System.out.println("The extra query statement: ");

    QueriesQualityPercentage.sqlQueryEx();

  }
}