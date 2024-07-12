package database;

public class CombineTwoTables
{
  public static void sqlQuery()
  {
    String query = "SELECT Person.firstName, Person.lastName, Address.city, Address.state FROM Person LEFT JOIN Address on Person.personId = Address.personId";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to report the first name, last name, city, and state of each person in the Person table. If the address of a personId is not present in the Address table, report null instead.\n\n";

    str += "Return the result table in any order.\n";
    
    System.out.println(str);
  }

  public static void main() 
  {
    CombineTwoTables.readme();

    CombineTwoTables.sqlQuery();
  }
}