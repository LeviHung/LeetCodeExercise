package database;

public class DeleteDuplicateEmails
{
  public static void sqlQuery()
  {
    String query = "DELETE p2 FROM Person p1, Person p2 WHERE p1.email = p2.email AND p1.id < p2.id;\n";

    System.out.println(query);
  }

  public static void sqlQueryOpt()
  {
    String query = "delete p.* from Person as P, ( select Email, min(Id) as minId from Person group by Email having count(*) > 1 ) as q where p.Email = q.Email and Id > q.minId;\n";

    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to delete all duplicate emails, keeping only one unique email with the smallest id.\n\n";

    str += "For SQL users, please note that you are supposed to write a DELETE statement and not a SELECT one.\n";

    str += "After running your script, the answer shown is the Person table. The driver will first compile and run your piece of code and then show the Person table. The final order of the Person table does not matter.\n";
    
    System.out.println(str);
  }

  public static void main() 
  {
    DeleteDuplicateEmails.readme();

    System.out.println("The query statement: ");
    DeleteDuplicateEmails.sqlQuery();

    System.out.println("The optimized query statement: ");
    DeleteDuplicateEmails.sqlQueryOpt();
  }
}