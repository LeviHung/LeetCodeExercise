package database;

public class SalesPerson
{
  public static void sqlQuery()
  {
    String query = "select name from SalesPerson where sales_id not in (select sales_id from Orders as o, Company as c where o.com_id = c.com_id and c.name = 'RED');";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find the names of all the salespersons who did not have any orders related to the company with the name \"RED\".\n";

    System.out.println(str);
  }

  public static void main() 
  {
    SalesPerson.readme();

    SalesPerson.sqlQuery();
  }
}