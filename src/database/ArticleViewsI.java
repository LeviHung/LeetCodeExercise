package database;

public class ArticleViewsI
{
  public static void sqlQuery()
  {
    String query = "select author_id as id from views where author_id = viewer_id group by author_id  order by author_id;";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find all the authors that viewed at least one of their own articles.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ArticleViewsI.readme();

    System.out.println("The query statement: ");

    ArticleViewsI.sqlQuery();

  }
}