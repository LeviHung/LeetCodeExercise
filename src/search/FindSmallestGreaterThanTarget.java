package search;
import java.util.Arrays;

public class FindSmallestGreaterThanTarget
{
  public static char nextGreatestLetter(char[] letters, char target) 
  {
    //  ['c','f','j'], 'a'
    //  ['c','f','j'], 'c'
    //  ['c','f','j'], 'd'
    //  ['c','f','j'], 'j'
    //  ['c','f','j'], 'g'
    int l = 0;
    int r = letters.length - 1;
    int m = 0;
    char last = '\0';
    while (l <= r) {
      m = (r - l) / 2 + l;
      if (letters[m] == target) {
        while (m < letters.length) {
          if (letters[m] != target){
            return letters[m];
          }
          m++;
        }
        break;
      } else if (letters[m] > target) {
        r = m - 1;
        last = letters[m];
      } else {
        l = m + 1;
      }
    }

    if ( r < 0 || l > letters.length - 1) {
      return letters[0];
    }

    if (l == letters.length - 1) {
      if (last != '\0') {
        return last;
      }
    }
    
    if (l == r || l > r) {
      if (last != '\0') {
        return last;
      }
    }
    return letters[0];
  }

  public static char nextGreatestLetterOpt(char[] letters, char target) 
  {
    boolean [] array = new boolean [26];
    for (int i = 0; i < letters.length; i++) {
      array[letters[i] - 'a'] = true;
    }
    char ch = (char) ((int)target + 1);
    while (ch <= 'z') {
      if (array[ch - 'a'] == true) {
        return ch;
      }
      ch = (char) ((int) ch + 1);
    }
    return letters[0];
  }

  public static void readme()
  {
    String str = "You are given an array of characters letters that is sorted in non-decreasing order, and a character target. There are at least two different characters in letters.\n\n";

    str += "Return the smallest character in letters that is lexicographically greater than target. If such a character does not exist, return the first character in letters.\n";

    System.out.println(str);
  }

  public static void main()
  {
    BinarySearch.readme();
    char target;
    // letters = ["c","f","j"], target = "a" => "c"
    char [] letters1 = {'c','f','j'};
    target = 'a';
    System.out.println("nextGreatestLetter(" + Arrays.toString(letters1) + ", " +
                       target +") = " +
                       nextGreatestLetter(letters1, target));

    // letters = ["c","f","j"], target = "c" => "f"
    char [] letters2 = {'c','f','j'};
    target = 'c';
    System.out.println("nextGreatestLetter(" + Arrays.toString(letters2) + ", " +
                       target +") = " +
                       nextGreatestLetter(letters2, target));

    // letters = ["x","x","y","y"], target = "z" => "x"
    char [] letters3 = {'x','x','y','y'};
    target = 'z';
    System.out.println("nextGreatestLetter(" + Arrays.toString(letters3) + ", " +
                       target +") = " +
                       nextGreatestLetter(letters3, target));

    char [] letters4 = {'c','f','j'};
    target = 'g';
    System.out.println("nextGreatestLetterOpt(" + Arrays.toString(letters4) + ", " +
                       target +") = " +
                       nextGreatestLetterOpt(letters4, target));

  }
}