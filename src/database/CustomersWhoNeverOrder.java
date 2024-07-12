package database;

public class CustomersWhoNeverOrder
{
  public static void sqlQuery()
  {
    String query = "SELECT C.name AS Customers FROM Customers AS C LEFT JOIN Orders AS O ON C.id=O.customerID WHERE O.id is NULL;";

    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find all customers who never order anything.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    CustomersWhoNeverOrder.readme();

    CustomersWhoNeverOrder.sqlQuery();
  }
}