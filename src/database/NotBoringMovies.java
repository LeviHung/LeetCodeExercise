package database;

public class NotBoringMovies
{
  public static void sqlQuery()
  {
    String query = "select * from cinema where id % 2 = 1 and description NOT like 'boring' order by rating desc;";
    System.out.println(query);
  }

  public static void sqlQueryEx()
  {
    String query = "select id, movie, description, rating from Cinema where mod(id,2)!=0 and description != 'boring' order by rating desc;";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to report the movies with an odd-numbered ID and a description that is not \"boring\".\n\n";

    str += "Return the result table ordered by rating in descending order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    NotBoringMovies.readme();

    System.out.println("The query statement: ");

    NotBoringMovies.sqlQuery();

    System.out.println("");

    System.out.println("The extra query statement: ");

    NotBoringMovies.sqlQueryEx();

  }
}