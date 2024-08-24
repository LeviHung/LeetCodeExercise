package database;

public class TopTravellers
{
  public static void sqlQuery()
  {
    String query = "select u.name, ifnull(sum(r.distance), 0) as travelled_distance from Users as u left join Rides as r on u.id = r.user_id group by u.id order by sum(r.distance) desc, u.name;\n";

    System.out.println(query);
  }

  public static void sqlQueryOpt()
  {
    String query = "select u.name,COALESCE(sum(r.distance),0) as travelled_distance from Users u left join Rides r on u.id=r.user_id group by r.user_id order by travelled_distance desc, u.name asc;\n";

    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to report the distance traveled by each user.\n\n";

    str += "Return the result table ordered by travelled_distance in descending order, if two or more users traveled the same distance, order them by their name in ascending order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    TopTravellers.readme();

    System.out.println("The query statement: ");
    TopTravellers.sqlQuery();
    System.out.println("");
    
    System.out.println("The optimized query statement: ");
    TopTravellers.sqlQueryOpt();
  }
}