package array;
import java.util.Arrays;

public class AverageSalaryExcludingMinimumMaximumSalary
{
    public static double average(int[] salary) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        int sum = 0;
        for (int val: salary) {
            sum += val;
            max = Math.max(val, max);
            min = Math.min(val, min);
        }
        return (double)(sum - max - min) / (salary.length - 2);
    }

  public static void readme()
  {
    String str = "You are given an array of unique integers salary where salary[i] is the salary of the ith employee.\n\n";

      str += "Return the average salary of employees excluding the minimum and maximum salary. Answers within 10-5 of the actual answer will be accepted.\n";
      
    System.out.println(str);
  }

  public static void main()
  {
    AverageSalaryExcludingMinimumMaximumSalary.readme();

    // Input: salary = [4000,3000,1000,2000]
    // Output: 2500.00000
    int [] salary1 = {4000,3000,1000,2000};
    System.out.println("average(" + Arrays.toString(salary1) + ") = " +
                       average(salary1));

      // Input: salary = [1000,2000,3000]
      // Output: 2000.00000
      int [] salary2 = {1000,2000,3000};
      System.out.println("average(" + Arrays.toString(salary2) + ") = " +
                         average(salary2));

  }
}