package database;

public class BigCountries
{
  public static void sqlQuery()
  {
    String query = "SELECT name, population, area FROM World WHERE area >= 3000000 OR population >= 25000000;";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "A country is big if:\n\n";

    str += "it has an area of at least three million (i.e., 3000000 km2), or\n\n";
    
    str += "it has a population of at least twenty-five million (i.e., 25000000).\n\n";

    str += "Write a solution to find the name, population, and area of the big countries.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    BigCountries.readme();

    BigCountries.sqlQuery();
  }
}