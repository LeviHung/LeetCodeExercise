package database;

public class CustomerPlacingLargestNumberOrders
{
  public static void sqlQuery()
  {
    String query = "select customer_number from orders group by customer_number order by count(*) desc limit 1;\n";

    System.out.println(query);
  }

  public static void sqlQueryEx()
  {
    String query = "SELECT customer_number FROM orders GROUP BY customer_number HAVING COUNT(*) = (SELECT MAX(c.number) FROM (SELECT COUNT(customer_number) as number FROM orders GROUP BY customer_number) AS c);\n";

    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find the customer_number for the customer who has placed the largest number of orders.\n\n";

    str += "The test cases are generated so that exactly one customer will have placed more orders than any other customer.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    CustomerPlacingLargestNumberOrders.readme();

    System.out.println("The query statement: ");
    CustomerPlacingLargestNumberOrders.sqlQuery();

    System.out.println("The extra query statement: ");
    CustomerPlacingLargestNumberOrders.sqlQueryEx();

  }
}