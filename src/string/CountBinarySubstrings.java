package string;

import java.util.Arrays;

public class CountBinarySubstrings
{
  public static int countBinarySubstrings(String s)
  {
    int sum = 0;
    int consZero = 0;
    int consOne = 0;
    char last;
    int consLastZero = 0;
    int consLastOne = 0;
    char[] array = s.toCharArray();
    last = array[0];
    
    if (last == '0') {
      consZero = 1;
    } else {
      consOne = 1;
    }
    
    for (int i = 1; i < array.length; i++) {
      if (array[i] == '0') {
        if (last == '0') {
          consZero++;
        } else {
          consLastOne = consOne;
          consOne = 0;
          consZero = 1;
          sum += Math.min(consLastZero, consLastOne);
        }
        last = '0';

      } else if (array[i] == '1') {
        if (last == '1') {
          consOne++;
        } else {
          consLastZero = consZero;
          consZero = 0;
          consOne = 1;
          sum += Math.min(consLastZero, consLastOne);
        }
        last = '1';
      }
    }
      
    if (last == '0')
      sum += Math.min(consZero, consLastOne);
    else
      sum += Math.min(consOne, consLastZero);
    
    return sum;
  }

  public static int countBinarySubstringsOpt(String s) 
  {
    int count = 0;
    char[]  arr = s.toCharArray();
    if(arr.length == 0) return 0;
    int currentCount = 1;
    int stateCount = 0;
    char state = arr[0];
  
    for (int i = 1; i<arr.length ; i++) {
      if (state==arr[i]) {
        currentCount++;
        if (stateCount>=currentCount) count++;
      } else {
        state=arr[i];
        stateCount = currentCount;
        currentCount = 1;
        count++;
      }      
    }
    
    return count;
  }
  
  public static void readme()
  {
    String str = "Given a binary string s, return the number of non-empty substrings that have the same number of 0's and 1's, and all the 0's and all the 1's in these substrings are grouped consecutively.\n\n";

    str += "Substrings that occur multiple times are counted the number of times they occur.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    CountBinarySubstrings.readme();

    // s = "00110011" => 6
    String s = "00110011";

    System.out.println("countBinarySubstrings(" + s + ") = " + 
                       countBinarySubstrings(s));

    // s = "10101" => 4
    s = "10101";

    System.out.println("countBinarySubstrings(" + s + ") = " + 
                       countBinarySubstrings(s));

    System.out.println("countBinarySubstringsOpt(" + s + ") = " + 
                       countBinarySubstringsOpt(s));

  }
}