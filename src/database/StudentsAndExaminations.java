package database;

public class StudentsAndExaminations
{
  public static void sqlQuery()
  {
    String query = "select s.student_id, s.student_name, sub.subject_name,\n"; 
    query += "(\n";
    query += "select count(1) from Examinations as e\n";
    query += "where e.student_id = s.student_id and e.subject_name = sub.subject_name\n";
    query += ") \n";
    query += "as attended_exams\n";
    query += "from Students as s, Subjects as sub \n";
    query += "order by s.student_id, sub.subject_name;\"\n";
    System.out.println(query);
  }

  public static void sqlQueryEx()
  {
    String query = "select st.student_id, st.student_name, sub.subject_name, count(ex.subject_name) as attended_exams\n";
    query += "from Students as st cross join Subjects as sub\n";
    query += "left join Examinations as ex\n";
    query += "on  ex.student_id= st.student_id and sub.subject_name=ex.subject_name\n";
    query += "group by st.student_id, st.student_name, sub.subject_name\n";
    query += "order by st.student_id, sub.subject_name\n";
    System.out.println(query);
  }

  public static void readme()
  {
    String str = "Write a solution to find the number of times each student attended each exam.\n\n";

    str += "Return the result table ordered by student_id and subject_name.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    StudentsAndExaminations.readme();

    System.out.println("The query statement: ");

    StudentsAndExaminations.sqlQuery();

    System.out.println("");

    System.out.println("The extra query statement: ");

    StudentsAndExaminations.sqlQueryEx();

  }
}