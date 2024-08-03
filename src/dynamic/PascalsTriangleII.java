package dynamic;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PascalsTriangleII
{

  public static List<Integer> getRow(int rowIndex)  
  {
    //       1            1      0
    //     1   1          2      1
    //   1   2   1        3      2
    // 1  3     3  1      4      3
    //1  4   6    4  1    5      4
    long val;
    List<Integer> list = new ArrayList<>();
    val = 1;
    list.add((int) (long) val);
    int r = rowIndex + 1;
    for (int i = 1; i < r; i++) {
      val = (val) * (r - i);
      val = val / i;
      list.add((int) (long)val);
    }
    
    return list;
  }

  public static void readme()
  {
    String str = "Given an integer rowIndex, return the rowIndexth (0-indexed) row of the Pascal's triangle.\n\n";

    str += "In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:\n";

    System.out.println(str);
  }

  public static void main()
  {
    PascalsTriangleII.readme();

    // rowIndex = 3 => [1,3,3,1]
    int rowIndex = 3;
    System.out.print("getRow(" + rowIndex + ") = ");
    List<Integer> list1 = PascalsTriangleII.getRow(rowIndex);
    System.out.println(Arrays.toString(list1.toArray()));

    // rowIndex = 0 => [[1]]
    rowIndex = 1;
    System.out.print("getRow(" + rowIndex + ") = ");
    List<Integer> list2 = PascalsTriangleII.getRow(rowIndex);
    System.out.println(Arrays.toString(list2.toArray()));

    rowIndex = 4;
    System.out.print("getRow(" + rowIndex + ") = ");
    List<Integer> list3 = PascalsTriangleII.getRow(rowIndex);
    System.out.println(Arrays.toString(list3.toArray()));

    rowIndex = 30;
    System.out.print("getRow(" + rowIndex + ") = ");
    List<Integer> list4 = PascalsTriangleII.getRow(rowIndex);
    System.out.println(Arrays.toString(list4.toArray()));
  }
}