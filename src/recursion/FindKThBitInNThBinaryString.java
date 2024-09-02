package recursion;

public class FindKThBitInNThBinaryString
{
    public static char findKthBit(int n, int k) {
           char ch = findBit(n).charAt(k-1);
           return ch;
        }

        public static String findBit(int n) {
            if (n == 1) {
                return "0";
            }

            String str = findBit(n-1);
            return str + "1" + reverse_and_invert(str);
        }

        public static String reverseInvert(String str) {
            StringBuilder sb = new StringBuilder();
            for (char ch: str.toCharArray()) {
                if (ch == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            return sb.reverse().toString();
        }

        public static String reverse_and_invert(String s) {
            char[] c = s.toCharArray();

            int i = 0;
            int j = c.length-1;

            while(i < j) {
                Character temp = c[i];
                c[i] = c[j] == '0' ? '1' : '0';
                c[j] = temp == '0' ? '1': '0';

                i++;
                j--;
            }

            if (c.length % 2 == 1) {
                c[i] = c[i] == '0' ? '1' : '0';
            }

            return String.valueOf(c);
        }
        /*
        public char findKthBitOld(int n, int k) {
           char ch = findBit(n, k, "0", 1);
           return ch;
        }

        public char findBit(int n, int k, String str, int start) {
            if (start == n) {
                return str.charAt(k-1);
            }
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            sb.append('1');
            sb.append(reverseInvert(str));

            char ch = findBit(n, k, sb.toString(), start + 1);
            return ch;
        }

        public String reverseInvert(String str) {
            StringBuilder sb = new StringBuilder();
            for (char ch: str.toCharArray()) {
                if (ch == '0') {
                    sb.append('1');
                } else {
                    sb.append('0');
                }
            }
            return sb.reverse().toString();
        }
        */

  public static void readme()
  {
    String str = "Given two positive integers n and k, the binary string Sn is formed as follows:\n\n";

        str += "S1 = \"0\"\n\n";
        str += "Si = Si - 1 + \"1\" + reverse(invert(Si - 1)) for i > 1\n\n";

    str += "Where + denotes the concatenation operation, reverse(x) returns the reversed string x, and invert(x) inverts all the bits in x (0 changes to 1 and 1 changes to 0).\n";

    str += "Return the kth bit in Sn. It is guaranteed that k is valid for the given n.\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindKThBitInNThBinaryString.readme();

    int n;
    int k;
    // Input: n = 3, k = 1
    // Output: "0"
    n = 3;
    k = 1;
    System.out.println("findKthBit(" + n + ", " + k + ") = " + 
                       findKthBit(n, k));

    // Input: n = 4, k = 11
    // Output: "1"
    n = 4;
    k = 11;
      System.out.println("findKthBit(" + n + ", " + k + ") = " + 
                        findKthBit(n, k));

  }
}