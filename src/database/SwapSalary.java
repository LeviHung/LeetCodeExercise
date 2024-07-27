package database;

public class SwapSalary
{
  public static void sqlQuery()
  {
    String query = "update Salary set sex = case when sex = 'm' then 'f' else 'm' end;";
    System.out.println(query);
  }

  public static void sqlQueryEx()
  {
    String query = "update Salary set sex = if(sex = 'm','f','m');";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to swap all 'f' and 'm' values (i.e., change all 'f' values to 'm' and vice versa) with a single update statement and no intermediate temporary tables.\n\n";

    str += "Note that you must write a single update statement, do not write any select statement for this problem.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    SwapSalary.readme();

    System.out.println("The query statement: ");

    SwapSalary.sqlQuery();

    System.out.println("");

    System.out.println("The extra query statement: ");

    SwapSalary.sqlQueryEx();

  }
}