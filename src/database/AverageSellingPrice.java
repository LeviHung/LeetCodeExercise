package database;

public class AverageSellingPrice
{
  public static void sqlQuery()
  {
    String query = "select p.product_id,\n";
      query += "ifnull(cast(sum(p.price * s.units )/sum(s.units) as decimal(10,2)), 0) as average_price\n";
      query += "from Prices as p\n";
      query += "left join UnitsSold as s\n";
      query += "on p.product_id = s.product_id and s.purchase_date between p.start_date and p.end_date\n";
      query += "group by product_id;\"\n";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find the average selling price for each product. average_price should be rounded to 2 decimal places.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    AverageSellingPrice.readme();

    System.out.println("The query statement: ");

    AverageSellingPrice.sqlQuery();

  }
}