package array;
import java.util.Arrays;

public class NumberOfLinesWriteString
{
  public static int[] numberOfLines(int[] widths, String s)
  {
    int[] res = new int[2];

    int count = 0;
    int line = 1;
    for (char ch: s.toCharArray()) {
      count += widths[ch - 'a'];
      if (count > 100) {
        count = widths[ch - 'a'];
        line++;
      }
    }
    res[0] = line;
    res[1] = count;

    return res;
  }

  public static void readme()
  {
    String str = "You are given a string s of lowercase English letters and an array widths denoting how many pixels wide each lowercase English letter is. Specifically, widths[0] is the width of 'a', widths[1] is the width of 'b', and so on.\n\n";

    str += "You are trying to write s across several lines, where each line is no longer than 100 pixels. Starting at the beginning of s, write as many letters on the first line such that the total width does not exceed 100 pixels. Then, from where you stopped in s, continue writing as many letters as you can on the second line. Continue this process until you have written all of s.\n\n";
    str += "Return an array result of length 2 where:\n\n";
    str += "result[0] is the total number of lines.\n\n";
    str += "result[1] is the width of the last line in pixels.\n";

    System.out.println(str);
  }

  public static void main()
  {
    NumberOfLinesWriteString.readme();
    String s;
    // widths = [10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "abcdefghijklmnopqrstuvwxyz" => [3,60]
    int [] widths1 = {10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    s = "abcdefghijklmnopqrstuvwxyz";
    System.out.println("numberOfLines(" + Arrays.toString(widths1) + 
                       ", " + s + ") = " +
                       Arrays.toString(numberOfLines(widths1, s)));

    // widths = [4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10], s = "bbbcccdddaaa" => [2,4]
    int [] widths2 = {4,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10,10};
    s = "bbbcccdddaaa";
    System.out.println("numberOfLines(" + Arrays.toString(widths2) + 
                       ", " + s + ") = " +
                       Arrays.toString(numberOfLines(widths2, s)));

  }
}