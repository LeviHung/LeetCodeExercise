package string;

import java.util.StringTokenizer;

public class ReformatTheString
{
    public static String reformat(String s) {
        StringBuilder sb = new StringBuilder();
        char[] arr = s.toCharArray();
        char[] arrA = new char [arr.length];
        char[] arrN = new char [arr.length];
        int indexA = 0;
        int indexN = 0;
        for (char ch: arr) {
            if (ch < 'a') {
                arrN[indexN++] = ch;
            } else {
                arrA[indexA++] = ch;
            }
        }
        /*
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] >= '0' && arr[i] <= '9') {
                arrN[indexN++] = arr[i];
            } else {
                arrA[indexA++] = arr[i];
            }
        }
        */
        if (Math.abs(indexN - indexA) > 1) {
            return "";
        }

        if (indexA > indexN) {
            for (int i = 0; i < indexN; i++) {
                arr[i*2] = arrA[i];
                arr[i*2 + 1] = arrN[i];
            }
            arr[arr.length - 1] = arrA[indexA - 1];
        } else if (indexN > indexA) {
            for (int i = 0; i < indexA; i++) {
                arr[i*2] = arrN[i];
                arr[i*2+1] = arrA[i];
            }
            arr[arr.length - 1] = arrN[indexN - 1];
        } else {
            for (int i = 0; i < indexN; i++) {
                arr[i*2] = arrN[i];
                arr[i*2+1] = arrA[i];
            }
        }
        return new String(arr);
        // 94%
        /*
        if (indexA > indexN) {
            for (int i = 0; i < indexN; i++) {
                sb.append(arrA[i]);
                sb.append(arrN[i]);
            }
            sb.append(arrA[indexA - 1]);
        } else if (indexN > indexA) {
            for (int i = 0; i < indexA; i++) {
                sb.append(arrN[i]);
                sb.append(arrA[i]);
            }
            sb.append(arrN[indexN - 1]);
        } else {
            for (int i = 0; i < indexN; i++) {
                sb.append(arrA[i]);
                sb.append(arrN[i]);
            }
        }
        return sb.toString();
        */
    }

  public static void readme()
  {
    String str = "You are given an alphanumeric string s. (Alphanumeric string is a string consisting of lowercase English letters and digits).\n\n";

    str += "You have to find a permutation of the string where no letter is followed by another letter and no digit is followed by another digit. That is, no two adjacent characters have the same type.\n\n";

    str += "Return the reformatted string or return an empty string if it is impossible to reformat the string.\n";


    System.out.println(str);
  }

  public static void main() 
  {
    ReformatTheString.readme();
    String s;
      
    // Input: s = "a0b1c2"
    // Output: "0a1b2c"
    s = "a0b1c2";
    System.out.println("reformat(" + s + ") = " + reformat(s));
    System.out.println("");

      // Input: s = "leetcode"
      // Output: ""
      s = "leetcode";
      System.out.println("reformat(" + s + ") = " + reformat(s));
      System.out.println("");
    
      // Input: s = "1229857369"
      // Output: ""
      s = "1229857369";
      System.out.println("reformat(" + s + ") = " + reformat(s));
      System.out.println("");
    
  }

}