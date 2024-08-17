package database;

public class ReformatDepartmentTable
{
  public static void sqlQuery()
  {
    String query = "select id, sum(if(month = 'Jan', revenue, null)) as Jan_Revenue,"; 
    query += "sum(if(month = 'Feb', revenue, null)) as Feb_Revenue,\n";
    query += "sum(if(month = 'Mar', revenue, null)) as Mar_Revenue,\n";
    query += "sum(if(month = 'Apr', revenue, null)) as Apr_Revenue,\n";
    query += "sum(if(month = 'May', revenue, null)) as May_Revenue,\n";
    query += "sum(if(month = 'Jun', revenue, null)) as Jun_Revenue,\n";
    query += "sum(if(month = 'Jul', revenue, null)) as Jul_Revenue,\n";
    query += "sum(if(month = 'Aug', revenue, null)) as Aug_Revenue,\n";
    query += "sum(if(month = 'Sep', revenue, null)) as Sep_Revenue,\n";
    query += "sum(if(month = 'Oct', revenue, null)) as Oct_Revenue,\n";
    query += "sum(if(month = 'Nov', revenue, null)) as Nov_Revenue,\n";
    query += "sum(if(month = 'Dec', revenue, null)) as Dec_Revenue\n";
    query += "from Department group by id;\n";
    System.out.println(query);
  }

  public static void sqlQueryEx()
  {
    String query = "select id,";
      query += "sum(case when month='Jan' then revenue else null end) as Jan_Revenue,\n";
    query += "sum(case when month='Feb' then revenue else null end) as Feb_Revenue,\n";
    query += "sum(case when month='Mar' then revenue else null end) as Mar_Revenue,\n";
    query += "sum(case when month='Apr' then revenue else null end) as Apr_Revenue,\n";
    query += "sum(case when month='May' then revenue else null end) as May_Revenue,\n";
    query += "sum(case when month='Jun' then revenue else null end) as Jun_Revenue,\n";
    query += "sum(case when month='Jul' then revenue else null end) as Jul_Revenue,\n";
    query += "sum(case when month='Aug' then revenue else null end) as Aug_Revenue,\n";
    query += "sum(case when month='Sep' then revenue else null end) as Sep_Revenue,\n";
    query += "sum(case when month='Oct' then revenue else null end) as Oct_Revenue,\n";
    query += "sum(case when month='Nov' then revenue else null end) as Nov_Revenue,\n";
    query += "sum(case when month='Dec' then revenue else null end) as Dec_Revenue\n";
    query += "from Department \n";
    query += "group by id;\n";
    
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Reformat the table such that there is a department id column and a revenue column for each month.\n\n";

    str += "Return the result table in any order.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ReformatDepartmentTable.readme();

    System.out.println("The query statement: ");

    ReformatDepartmentTable.sqlQuery();

    System.out.println("");

    System.out.println("The extra query statement: ");

    ReformatDepartmentTable.sqlQueryEx();

  }
}