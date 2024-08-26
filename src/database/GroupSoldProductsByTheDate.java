package database;

public class GroupSoldProductsByTheDate
{
  public static void sqlQuery()
  {
    String query = "select sell_date, count(distinct product) as num_sold, \n";    
    query += "group_concat(distinct product order by product) as products\n";
    query += "from Activities\n";
    query += "group by sell_date\n";
    query += "order by sell_date;\n";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find for each date the number of different products sold and their names.\n\n";

    str += "The sold products names for each date should be sorted lexicographically.\n\n";
    
    str += "Return the result table ordered by sell_date.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    GroupSoldProductsByTheDate.readme();

    System.out.println("The query statement: ");

    GroupSoldProductsByTheDate.sqlQuery();

  }
}