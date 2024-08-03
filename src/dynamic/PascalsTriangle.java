package dynamic;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PascalsTriangle
{

  public static  List<List<Integer>> generate(int numRows) 
  {
    //       1
    //     1   1
    //   1   2   1
    // 1  3     3  1
    //1  4   6    4  1 
    int val;
    Integer [] subListLastArray = {1};
    List<List<Integer>> list = new ArrayList<>();
    for (int i = 1; i <= numRows; i++) {
      List<Integer> subList = new ArrayList<>();
      for (int j = 1; j <= i; j++) {
        if (j == 1) {
          val = 1;
        } else if (j == i) {
          val = 1;  
        } else {
          val = subListLastArray[j-2] + subListLastArray[j-1];
        }
        subList.add(val);
      }
      subListLastArray = new Integer[subList.size()];
      subList.toArray(subListLastArray); // fill the array
      
      list.add(subList);
    }
    return list;
  }

  public static List<Integer> gen(int r)
  {
    List<Integer> list = new ArrayList<>();
    list.add(1);
    int ans = 1;
    for (int i = 1; i < r; i++) 
    {
      ans = ans * (r - i);
      ans = ans / i;
      list.add(ans);
    }

    return list;
  }

  public static List<List<Integer>> generateOpt(int n) 
  {
    List<List<Integer>> list = new ArrayList<>();
    for(int i = 1; i <= n; i++) {
      list.add(gen(i));
    }

    return list;
  }
  
  public static void readme()
  {
    String str = "Given an integer numRows, return the first numRows of Pascal's triangle.\n\n";

    str += "In Pascal's triangle, each number is the sum of the two numbers directly above it as shown:\n";

    System.out.println(str);
  }

  public static void main()
  {
    PascalsTriangle.readme();

    // numRows = 5 => [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    int numRows = 5;
    System.out.println("generate(" + numRows + ") = ");
    List<List<Integer>> list1 = PascalsTriangle.generate(numRows);
    System.out.println(Arrays.toString(list1.toArray()));

    // numRows = 1 => [[1]]
    numRows = 1;
    System.out.println("generate(" + numRows + ") = ");
    List<List<Integer>> list2 = PascalsTriangle.generate(numRows);
    System.out.println(Arrays.toString(list2.toArray()));

    numRows = 20;
    System.out.println("generateOpt(" + numRows + ") = ");
    List<List<Integer>> list3 = PascalsTriangle.generateOpt(numRows);
    System.out.println(Arrays.toString(list3.toArray()));
  }
}