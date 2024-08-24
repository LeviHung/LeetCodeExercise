package array;
import java.util.Arrays;

public class NumberOfStudentsDoingHomeworkAtAGivenTime
{
    public static int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int res = 0;
        for (int i = 0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                res++;
            }
        }
        return res;
        /*
        boolean [] student = new boolean[startTime.length];
        for (int i = 0; i < student.length; i++) {
            if (startTime[i] <= queryTime) {
                student[i] = true;
            }
        }
        for (int i = 0; i < student.length; i++) {
            if (student[i] == true && endTime[i] >= queryTime) {
                res++;
            }
        }
        return res;
        */
    }

  public static void readme()
  {
    String str = "Given two integer arrays startTime and endTime and given an integer queryTime.\n\n";

    str += "The ith student started doing their homework at the time startTime[i] and finished it at time endTime[i].\n\n";
      
    str += "Return the number of students doing their homework at time queryTime. More formally, return the number of students where queryTime lays in the interval [startTime[i], endTime[i]] inclusive.\n";

    System.out.println(str);
  }

  public static void main()
  {
    NumberOfStudentsDoingHomeworkAtAGivenTime.readme();
    int queryTime;
    // Input: startTime = [1,2,3], endTime = [3,2,7], queryTime = 4
    // Output: 1
    int [] startTime1 = {1,2,3};
    int [] endTime1 = {3,2,7};
    queryTime = 4;
    System.out.println("busyStudent(" + Arrays.toString(startTime1) + "," +
                       Arrays.toString(endTime1) + ", " + queryTime + ") = " +
                       busyStudent(startTime1, endTime1, queryTime));
    System.out.println("");
      
    // Input: startTime = [4], endTime = [4], queryTime = 4
    // Output: 1
    int [] startTime2 = {4};
    int [] endTime2 = {4};
    queryTime = 4;
    System.out.println("busyStudent(" + Arrays.toString(startTime2) + "," +
                       Arrays.toString(endTime2) + ", " + queryTime + ") = " +
                       busyStudent(startTime2, endTime2, queryTime));
    System.out.println("");

  }
}