package database;

public class ProductSalesAnalysisI
{
  public static void sqlQuery()
  {
    String query = "select p.product_name, s.year, s.price from Sales as s inner join product as p on s.product_id = p.product_id;";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to report the product_name, year, and price for each sale_id in the Sales table.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ProductSalesAnalysisI.readme();

    System.out.println("The query statement: ");

    ProductSalesAnalysisI.sqlQuery();

  }
}