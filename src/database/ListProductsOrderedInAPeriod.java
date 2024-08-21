package database;

public class ListProductsOrderedInAPeriod
{
  public static void sqlQuery()
  {
    String query = "select p.product_name, sum(o.unit) as unit\n"; 
    query += "from Products as p, Orders as o \n";
    query += "where p.product_id = o.product_id and order_date between '20200201' and '20200229' \n";
    query += "group by o.product_id having sum(o.unit) >= 100;\"\n";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to get the names of products that have at least 100 units ordered in February 2020 and their amount.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ListProductsOrderedInAPeriod.readme();

    System.out.println("The query statement: ");

    ListProductsOrderedInAPeriod.sqlQuery();

  }
}