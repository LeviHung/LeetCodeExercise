package twopointers;
import java.util.Arrays;

public class DIStringMatch
{
  public static int[] diStringMatch(String s)
  {
    // D    => ID   => DID  => IDID
    // 10   => 021  => 3021 =>  04132
    char[] array = s.toCharArray();
    int [] res =  new int[array.length + 1];
    int max = 0;
    res [array.length] = 0;
    for (int i = array.length - 1; i >= 0; i--) {
      if (array[i] == 'D') {
        res[i] = max + 1;
        max = res[i];
      } else {
        for (int j = i + 1; j < res.length; j++) {
          res[j]++;
        }
        max++;
        res[i] = 0;
      }
    }
    return res;
  }

  public static int[] diStringMatchOpt(String s) 
  {
    char[] array = s.toCharArray();
    int [] res =  new int[array.length + 1];
    int low = 0;
    int high = array.length;
    for (int i = 0; i < array.length; i++) {
      if (array[i] == 'D') {
        res[i] = high;
        high--;
      } else {
        res[i] = low;
        low++;
      }
    }
    res[array.length] = high;
    return res;
  }
  public static void readme()
  {
    String str = "A permutation perm of n + 1 integers of all the integers in the range [0, n] can be represented as a string s of length n where:\n\n";

    str += " s[i] == 'I' if perm[i] < perm[i + 1], and\n\n";
    str += " s[i] == 'D' if perm[i] > perm[i + 1].\n\n";
    str += "Given a string s, reconstruct the permutation perm and return it. If there are multiple valid permutations perm, return any of them.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DIStringMatch.readme();
    String s;
    // s = "IDID" => [0,4,1,3,2]
    s = "IDID";
    System.out.println("diStringMatch(\"" + s + "\") = " +
                       Arrays.toString(diStringMatch(s)));

    // s = "III" => [0,1,2,3]
    s = "III";
    System.out.println("diStringMatch(\"" + s + "\") = " +
                        Arrays.toString(diStringMatch(s)));

    // s = "DDI" => [3,2,0,1]
    s = "DDI";
    System.out.println("diStringMatch(\"" + s + "\") = " +
                        Arrays.toString(diStringMatch(s)));

    System.out.println("diStringMatch(\"" + s + "\") = " +
                        Arrays.toString(diStringMatch(s)));

  }
}