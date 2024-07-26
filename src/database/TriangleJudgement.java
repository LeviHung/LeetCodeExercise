package database;

public class TriangleJudgement
{
  public static void sqlQuery()
  {
    String query = "select *, case when x < y + z and y < x + z and z < x + y then 'Yes' else 'No' end as triangle from Triangle;";
    
    System.out.println(query);
  }

  public static void sqlQueryOpt()
  {
    String query = "select *, if(x+y>z and y+z>x and z+x>y,'Yes','No') as triangle from triangle;";

    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Report for every three line segments whether they can form a triangle.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    TriangleJudgement.readme();

    System.out.println("The query statement: ");

    TriangleJudgement.sqlQuery();

    System.out.println("");
    System.out.println("The optimized query statement: ");

    TriangleJudgement.sqlQueryOpt();
  }
}