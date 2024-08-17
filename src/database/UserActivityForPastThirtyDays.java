package database;

public class UserActivityForPastThirtyDays
{
  public static void sqlQuery()
  {
    String query = "select activity_date as day, count(distinct user_id) as active_users from activity group by activity_date having activity_date <= '20190727' AND activity_date > '20190627';";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find the daily active user count for a period of 30 days ending 2019-07-27 inclusively. A user was active on someday if they made at least one activity on that day.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    UserActivityForPastThirtyDays.readme();

    System.out.println("The query statement: ");

    UserActivityForPastThirtyDays.sqlQuery();

  }
}