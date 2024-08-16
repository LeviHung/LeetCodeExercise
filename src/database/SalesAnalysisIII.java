package database;

public class SalesAnalysisIII
{
  public static void sqlQuery()
  {
    String query = "select distinct p.product_id, p.product_name from product as p, sales as s where s.sale_date >= '20190101' and s.sale_date <= '20190331' and s.product_id not in (select s.product_id from sales as s where s.sale_date < '20190101' or s.sale_date > '20190331')  and p.product_id = s.product_id;";
    
    System.out.println(query);
  }

  public static void sqlQueryEx()
  {
    String query = "SELECT p.product_id, p.product_name FROM Product p JOIN Sales s ON p.product_id = s.product_id GROUP BY p.product_id, p.product_name HAVING MIN(s.sale_date) >= '2019-01-01' AND MAX(s.sale_date) <= '2019-03-31';";
    
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to report the products that were only sold in the first quarter of 2019. That is, between 2019-01-01 and 2019-03-31 inclusive.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    SalesAnalysisIII.readme();

    System.out.println("The query statement: ");

    SalesAnalysisIII.sqlQuery();

    System.out.println("");

    System.out.println("The extra query statement: ");

    SalesAnalysisIII.sqlQueryEx();

  }
}