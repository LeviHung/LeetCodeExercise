package database;

public class ClassesMoreThanFiveStudents
{
  public static void sqlQuery()
  {
    String query = "SELECT class FROM Courses GROUP BY class Having count(class) >= 5;";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find all the classes that have at least five students.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ClassesMoreThanFiveStudents.readme();

    ClassesMoreThanFiveStudents.sqlQuery();
  }
}