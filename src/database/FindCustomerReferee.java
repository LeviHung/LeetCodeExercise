package database;

public class FindCustomerReferee
{
  public static void sqlQuery()
  {
    String query = "SELECT name FROM Customer WHERE referee_id <> 2 || referee_id is NULL;\n";

    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Find the names of the customer that are not referred by the customer with id = 2.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    FindCustomerReferee.readme();

    System.out.println("The query statement: ");
    FindCustomerReferee.sqlQuery();
  }
}