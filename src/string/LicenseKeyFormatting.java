package string;

import java.util.Arrays;

public class LicenseKeyFormatting
{
  public static String licenseKeyFormatting(String s, int k)
  {    
    StringBuilder sb = new StringBuilder();
    char[] arrayS = s.toCharArray();
    int dash = 0;

    for (int i = arrayS.length - 1; i >= 0; i--) {
      if (arrayS[i] != '-') {
        if (dash >= k) {
          sb.append('-');
          dash = 0;
        }
        
        sb.append(Character.toUpperCase(arrayS[i]));
        dash++;
      }
    }

    return sb.reverse().toString();
  }

  public static String licenseKeyFormattingOpt(String s, int k) 
  {
    char[] chars = s.toCharArray();
    int n = 0;
    for (char aChar : chars) if(aChar!='-') n++;

    int j = n%k;
    if(j==0) j=k;

    char[] res = new char[n + (n-1)/k];

    for(int i=0, h=0; i < chars.length; i++){
        if(chars[i] != '-'){
            if(j==0){
                res[h++] = '-';
                j=k;
            }
            res[h++] = chars[i] < 97? chars[i]: (char)(chars[i] -32);
            j--;
        }
    }
    return new String(res);
  }
  
  public static void readme()
  {
    String str = "You are given a license key represented as a string s that consists of only alphanumeric characters and dashes. The string is separated into n + 1 groups by n dashes. You are also given an integer k.\n\n";

    str += "We want to reformat the string s such that each group contains exactly k characters, except for the first group, which could be shorter than k but still must contain at least one character. Furthermore, there must be a dash inserted between two groups, and you should convert all lowercase letters to uppercase.\n\n";

    str += "Return the reformatted license key.";

    System.out.println(str);
  }

  public static void main()
  {
    LicenseKeyFormatting.readme();

    String s;
    int k;
    // s = "5F3Z-2e-9-w", k = 4 => "5F3Z-2E9W"
    s = "5F3Z-2e-9-w";
    k = 4;
    System.out.println("licenseKeyFormatting(" + s + ", " + k + ") = " + 
                       licenseKeyFormatting(s, k));

    // "2-5g-3-J", k = 2 => "2-5G-3J"
    s = "2-5g-3-J";
    k = 2;
    System.out.println("licenseKeyFormatting(" + s + ", " + k + ") = " + 
                       licenseKeyFormatting(s, k));

    s = "--a-a-a-a--";
    k = 2;
    System.out.println("licenseKeyFormatting(" + s + ", " + k + ") = " + 
                       licenseKeyFormatting(s, k));
  }
}