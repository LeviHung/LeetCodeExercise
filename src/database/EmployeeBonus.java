package database;

public class EmployeeBonus
{
  public static void sqlQuery()
  {
    String query = "SELECT e.name, b.bonus FROM Employee AS e LEFT JOIN Bonus AS b on e.empId = b.empId WHERE b.bonus < 1000 OR b.bonus IS NULL;\n";

    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to report the name and bonus amount of each employee with a bonus less than 1000.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    EmployeeBonus.readme();

    System.out.println("The query statement: ");
    EmployeeBonus.sqlQuery();
  }
}