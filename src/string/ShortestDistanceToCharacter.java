package string;

import java.util.Arrays;

public class ShortestDistanceToCharacter
{
  public static int[] shortestToChar(String s, char c)
  {    
    char[] array = s.toCharArray();
    int[] res = new int [array.length];
    int left = 0;
    int right = 0;
    for (int i = 0; i < array.length; i++) {
      left = i;
      right = i;
      while (true) {
        if (left >= 0 && array[left] == c) {
          res[i] = i - left;
          break;
        } 
        if ((right <= array.length - 1) && array[right] == c) {
          res[i] = right - i;
          break;
        }
        left--;
        right++;
      }
    }
    return res;
  }

  public static int[] shortestToCharOpt(String s, char c) 
  {
      char[] sChars = s.toCharArray();
      int[] result = new int[sChars.length];
      int i;

      for (i = 0; i < sChars.length; i++) {
          if(sChars[i] == c){
              result[i] = 0;
          }else{
              result[i] = sChars.length;
          }
      }

      for(i = 1; i < result.length; i++){
          result[i] = Math.min(result[i-1] + 1, result[i]);
        System.out.println("result[" + i + "] = " + result[i]);
      }

      for(i = i-1; i > 0; i--){
          result[i-1] = Math.min(result[i] +1, result[i-1]);
        System.out.println("result[" + (i - 1) + "] = " + result[i-1]);

      }

      return result;
  }
  public static void readme()
  {
    String str = "Given a string s and a character c that occurs in s, return an array of integers answer where answer.length == s.length and answer[i] is the distance from index i to the closest occurrence of character c in s.\n\n";

    str += "The distance between two indices i and j is abs(i - j), where abs is the absolute value function..\n";

    System.out.println(str);
  }

  public static void main()
  {
    AddStrings.readme();
    String s;
    char c;
    // s = "loveleetcode", c = "e" => [3,2,1,0,1,0,0,1,2,2,1,0]
    s = "loveleetcode";
    c = 'e';
    System.out.println("shortestToChar(" + s + ", " + c + ") = " + 
                       Arrays.toString(shortestToChar(s, c)));

    System.out.println("shortestToCharOpt(" + s + ", " + c + ") = " + 
                       Arrays.toString(shortestToCharOpt(s, c)));

    // s = "aaab", c = "b" => [3,2,1,0]
    s = "aaab";
    c = 'b';
    System.out.println("shortestToChar(" + s + ", " + c + ") = " + 
                       Arrays.toString(shortestToChar(s, c)));

    }
}