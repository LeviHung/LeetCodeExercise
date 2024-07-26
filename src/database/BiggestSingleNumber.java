package database;

public class BiggestSingleNumber
{
  public static void sqlQuery()
  {
    String query = "select MAX(num) as num from MyNumbers where num not in (select num from MyNumbers group by num having count(*) > 1);";
    System.out.println(query);
  }

  public static void sqlQueryEx()
  {
    String query = "select MAX(num) as num from (select num from MyNumbers group by num having count(num)=1) as c;";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "A single number is a number that appeared only once in the MyNumbers table.\n\n";

    str += "Find the largest single number. If there is no single number, report null.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    BiggestSingleNumber.readme();

    System.out.println("The query statement: ");

    BiggestSingleNumber.sqlQuery();

    System.out.println("");

    System.out.println("The extra query statement: ");
    
    BiggestSingleNumber.sqlQueryEx();

  }
}