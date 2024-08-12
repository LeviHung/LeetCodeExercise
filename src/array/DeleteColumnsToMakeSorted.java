package array;
import java.util.Arrays;

public class DeleteColumnsToMakeSorted
{
  public static int minDeletionSize(String[] strs)
  {
    char [][] array = new char[strs.length][strs[0].length()];
    for (int i = 0; i < strs.length; i++) {
      array[i] = strs[i].toCharArray();
    }
    int res = 0;
    //System.out.println(Arrays.deepToString(array));
    for (int c = 0; c < array[0].length; c++) {
      for (int r = 1; r < array.length; r++) {
        if (array[r][c] < array[r-1][c]) {
          res++;
          break;
        }
      }
    }
    return res;
  }
  
  public static int minDeletionSizeOpt(String[] strs) 
  {
      int res = 0;

      if (strs.length == 1) return res;

      for (int i = 0; i < strs[0].length(); i++) {
          char prev = strs[0].charAt(i);
          for(int j = 1; j < strs.length; j++) {
              char curr = strs[j].charAt(i);
              if ( curr < prev) {
                  res++;
                  break;
              }
              prev = curr;
          }
      }

      return res;
  }
  public static void readme()
  {
    String str = "You are given an array of n strings strs, all of the same length.\n\n";

    str += "The strings can be arranged such that there is one on each line, making a grid.\n\n";

    str += "For example, strs = [\"abc\", \"bce\", \"cae\"] can be arranged as follows:\n\n";

    str += "abc\n\n";

    str += "bce\n\n";

    str += "cae\n\n";

    str += "You want to delete the columns that are not sorted lexicographically. In the above example (0-indexed), columns 0 ('a', 'b', 'c') and 2 ('c', 'e', 'e') are sorted, while column 1 ('b', 'c', 'a') is not, so you would delete column 1.\n\n";
      
    str += "Return the number of columns that you will delete.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DeleteColumnsToMakeSorted.readme();

    // strs = ["cba","daf","ghi"] => 1
    String [] strs1 = {"cba","daf","ghi"};
    System.out.println("minDeletionSize(" + Arrays.toString(strs1) + ") = " +
                       minDeletionSize(strs1));

    // strs = ["a","b"] => 0
    String [] strs2 = {"a","b"};
    System.out.println("minDeletionSize(" + Arrays.toString(strs2) + ") = " +
                       minDeletionSize(strs2));

    // strs = ["zyx","wvu","tsr"] => 3
    String [] strs3 = {"zyx","wvu","tsr"};
    System.out.println("minDeletionSize(" + Arrays.toString(strs3) + ") = " +
                       minDeletionSize(strs3));

    System.out.println("minDeletionSizeOpt(" + Arrays.toString(strs3) + ") = " +
                       minDeletionSizeOpt(strs3));

  }
}