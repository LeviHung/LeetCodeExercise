package database;

public class ProjectEmployeesI
{
  public static void sqlQuery()
  {
    String query = "select p.project_id, cast(AVG(e.experience_years) as decimal(10,2)) as average_years from Project as p inner join Employee as e on p.employee_id = e.employee_id group by p.project_id;";
    System.out.println(query);
  }

  public static void sqlQueryEx()
  {
    String query = "select p.project_id, round(AVG(e.experience_years),2) as average_years from Project as p inner join Employee as e on p.employee_id = e.employee_id group by p.project_id;";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write an SQL query that reports the average experience years of all the employees for each project, rounded to 2 digits.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ProjectEmployeesI.readme();

    System.out.println("The query statement: ");

    ProjectEmployeesI.sqlQuery();
    
    System.out.println("");
    
    System.out.println("The extra query statement: ");

    ProjectEmployeesI.sqlQueryEx();

  }
}