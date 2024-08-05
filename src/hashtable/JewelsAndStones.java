package hashtable;

import java.util.Arrays;

public class JewelsAndStones
{
  public static int numJewelsInStones(String jewels, String stones) 
  {
    boolean [] set = new boolean ['z' - 'A' + 1];
    for (char ch: jewels.toCharArray()) {
        set[ch - 'A'] = true;
    }

    int count = 0;
    for (char ch: stones.toCharArray()) {
        if (set[ch - 'A']) {
            count++;
        }
    }

    return count;
  }

  public static void readme()
  {
    String str = "You're given strings jewels representing the types of stones that are jewels, and stones representing the stones you have. Each character in stones is a type of stone you have. You want to know how many of the stones you have are also jewels.\n\n";

    str += "Letters are case sensitive, so \"a\" is considered a different type of stone from \"A\".\n";

    System.out.println(str);
  }

  public static void main() 
  {
    JewelsAndStones.readme();

    String jewels;
    String stones;

    // jewels = "aA", stones = "aAAbbbb" => 3
    jewels = "aA";
    stones = "aAAbbbb";
    System.out.println("numJewelsInStones(" + jewels + ", " + stones + ") = " + 
                       numJewelsInStones(jewels, stones));

    // jewels = "z", stones = "ZZ" => 0
    jewels = "z";
    stones = "ZZ";
    System.out.println("numJewelsInStones(" + jewels + ", " + stones + ") = " + 
                       numJewelsInStones(jewels, stones));

  }
}