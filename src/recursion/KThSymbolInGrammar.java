package recursion;

public class KThSymbolInGrammar
{
  public static int kthGrammar(int n, int k) {
    if (n == 1) {
        return 0;
    }

    int parent = kthGrammar(n-1, (k+1)/2);
    boolean isKOdd = (k % 2 == 1); 
    if (parent == 1) {
        if (isKOdd) {
            return 1;
        } else {
            return 0;
        }
    } else {
        if (isKOdd) {
            return 0;
        } else {
            return 1;
        }
    }
  }

  public static int kthGrammarOld(int n, int k) {
    return getSymbol(n, k, "0");
  }

  public static int getSymbol(int n, int k, String str) {
    if (str.length() >= Math.pow(2, n - 1)) {
        return str.charAt(k - 1) - '0';
    }

    StringBuilder sb = new StringBuilder();
    for (char ch: str.toCharArray()) {
        if (ch == '0') {
            sb.append("01");
        } else {
            sb.append("10");
        }
    }
    return getSymbol(n, k, sb.toString());
  }

  public static void readme()
  {
    String str = "We build a table of n rows (1-indexed). We start by writing 0 in the 1st row. Now in every subsequent row, we look at the previous row and replace each occurrence of 0 with 01, and each occurrence of 1 with 10.\n\n";

    str += "For example, for n = 3, the 1st row is 0, the 2nd row is 01, and the 3rd row is 0110.\n";

    str += "Given two integer n and k, return the kth (1-indexed) symbol in the nth row of a table of n rows.\n";

    System.out.println(str);
  }

  public static void main()
  {
    KThSymbolInGrammar.readme();

    int n;
    int k;
    // Input: n = 1, k = 1
    // Output: 0
    n = 1;
    k = 1;
    System.out.println("kthGrammar(" + n + ", " + k + ") = " + 
                       kthGrammar(n, k));

    // Input: n = 2, k = 1
    // Output: 0
    n = 2;
    k = 1;
    System.out.println("kthGrammar(" + n + ", " + k + ") = " + 
                       kthGrammar(n, k));

    // Input: n = 2, k = 2
    // Output: 1
    n = 2;
    k = 2;
    System.out.println("kthGrammar(" + n + ", " + k + ") = " + 
                       kthGrammar(n, k));

  }
}