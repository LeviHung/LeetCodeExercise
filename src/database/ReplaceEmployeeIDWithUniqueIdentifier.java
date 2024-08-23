package database;

public class ReplaceEmployeeIDWithUniqueIdentifier
{
  public static void sqlQuery()
  {
    String query = "select unique_id, name from Employees as e left join EmployeeUNI as u on u.id = e.id;";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to show the unique ID of each user, If a user does not have a unique ID replace just show null.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ReplaceEmployeeIDWithUniqueIdentifier.readme();

    System.out.println("The query statement: ");

    ReplaceEmployeeIDWithUniqueIdentifier.sqlQuery();

  }
}