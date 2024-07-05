package easy;

public class EmployeesEarnMoreThanManagers
{
  public static void sqlQuery()
  {
    String query = "SELECT worker.name AS Employee FROM Employee AS worker, Employee AS manager WHERE worker.managerID = manager.Id AND worker.salary > manager.salary;";
    
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find the employees who earn more than their managers.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    EmployeesEarnMoreThanManagers.readme();

    EmployeesEarnMoreThanManagers.sqlQuery();
  }
}