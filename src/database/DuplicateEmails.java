package database;

public class DuplicateEmails
{
  public static void sqlQuery()
  {
    String query = "SELECT email as 'Email' FROM Person GROUP BY email HAVING COUNT(*) > 1";

    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to report all the duplicate emails. Note that it's guaranteed that the email field is not NULL.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    DuplicateEmails.readme();

    DuplicateEmails.sqlQuery();
  }
}