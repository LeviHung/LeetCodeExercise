package twopointers;

public class ReverseStringII
{
  public static String reverseStr(String s, int k) 
  {    
    char[] arrayS = s.toCharArray();
    int l = 0;
    int r = k - 1;
    char tmp = '\0';
    for (int i = 0; i < arrayS.length; i = i + 2 * k) {
      
      l = i;
      if (i + k > arrayS.length) {
        r = arrayS.length - 1;
      } else {
        r = i + k - 1;
      }
      
      while (l < r) {
        tmp = arrayS[l];
        arrayS[l] = arrayS[r];
        arrayS[r] = tmp;
        l++;
        r--;
      }
     
    }
    
    return String.valueOf(arrayS);
  }

  public static String reverseStrOpt(String s, int k) 
  {
    int st = 0;
    char[] ch = s.toCharArray();
    while (st < ch.length) {
        int j = Math.min(st + k - 1, ch.length - 1);
        // Reverse the first k characters
        reverse(ch,st,j);

        // Move the st index to the start of the next segment
        st += 2 * k;
    }
    return new String(ch);
  }

  public static void reverse(char[] ch,int i,int j){
    while (i < j) {
            char temp = ch[i];
            ch[i] = ch[j];
            ch[j] = temp;
            i++;
            j--;
        }
  }
  public static void readme()
  {
    String str = "Given a string s and an integer k, reverse the first k characters for every 2k characters counting from the start of the string.\n\n";

    str += "If there are fewer than k characters left, reverse all of them. If there are less than 2k but greater than or equal to k characters, then reverse the first k characters and leave the other as original.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    ReverseStringII.readme();
    String s;
    int k;
    // s = "abcdefg", k = 2 => "bacdfeg"
    s = "abcdefg";
    k = 2;
    System.out.println("reverseStr(" + s + ", " + k + ") = " + 
                        reverseStr(s, k));

    // s = "abcd", k = 2 => "bacd"
    s = "abcd";
    k = 2;
    System.out.println("reverseStr(" + s + ", " + k + ") = " + 
                        reverseStr(s, k));

    s = "abcdef";
    k = 3;
    System.out.println("reverseStr(" + s + ", " + k + ") = " + 
    reverseStr(s, k));

    s = "a";
    k = 2;
    System.out.println("reverseStr(" + s + ", " + k + ") = " + 
    reverseStr(s, k));

    System.out.println("reverseStrOpt(" + s + ", " + k + ") = " + 
    reverseStrOpt(s, k));

  }

}