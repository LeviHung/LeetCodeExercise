package hashtable;
import java.util.Arrays;

public class NumberOfEquivalentDominoPairs
{
  public static int numEquivDominoPairs(int[][] dominoes) {
    int[][] num = new int [10][10];
    int count = 0;
    for (int i = 0; i < dominoes.length; i++) {
        num[dominoes[i][0]][dominoes[i][1]]++;
    }
    int cnt = 0;
    for (int i = 1; i < 10; i++) {
        for (int j = i; j < 10; j++) {
            cnt = num[i][j] + num[j][i];
            if (i == j) {
                cnt = cnt / 2;
            }
            count = count + cnt * (cnt - 1) / 2;
        }
    }
    return count;
    /*
    int[][] num = new int [10][10];
    int count = 0;
    for (int i = 0; i < dominoes.length; i++) {
        count = count + num[dominoes[i][0]][dominoes[i][1]];
        if (dominoes[i][0] != dominoes[i][1])
            count = count + num[dominoes[i][1]][dominoes[i][0]];
        num[dominoes[i][0]][dominoes[i][1]]++;
    }
    return count;
    */
    /*
    int[] num = new int [101];
    int count = 0;
    for (int i = 0; i < dominoes.length; i++) {
        if (dominoes[i][0] < dominoes[i][1]) {
            if (num[dominoes[i][0] * 10 + dominoes[i][1]] > 0) {
                count = count + num[dominoes[i][0] * 10 + dominoes[i][1]];
            } 
            num[dominoes[i][0] * 10 + dominoes[i][1]]++;

        } else {
            if (num[dominoes[i][1] * 10 + dominoes[i][0]] > 0) {
                count = count + num[dominoes[i][1] * 10 + dominoes[i][0]];                
            } 
            num[dominoes[i][1] * 10 + dominoes[i][0]]++;
        }
    }

    return count;
    */
  }
  
  public static void readme()
  {
    String str = "Given a list of dominoes, dominoes[i] = [a, b] is equivalent to dominoes[j] = [c, d] if and only if either (a == c and b == d), or (a == d and b == c) - that is, one domino can be rotated to be equal to another domino.\n\n";

    str += "Return the number of pairs (i, j) for which 0 <= i < j < dominoes.length, and dominoes[i] is equivalent to dominoes[j].\n";

    System.out.println(str);
  }

  public static void main()
  {
    NumberOfEquivalentDominoPairs.readme();

    // Input: dominoes = [[1,2],[2,1],[3,4],[5,6]]
    // Output: 1

    int [][] dominoes1 = {{1,2},{2,1},{3,4},{5,6}};
    System.out.println("numEquivDominoPairs(" + Arrays.deepToString(dominoes1) +
                       ") = " +
                       numEquivDominoPairs(dominoes1));

    // Input: dominoes = [[1,2],[1,2],[1,1],[1,2],[2,2]]
    // Output: 3

    int [][] dominoes2 = {{1,2},{1,2},{1,1},{1,2},{2,2}};
    System.out.println("numEquivDominoPairs(" + Arrays.deepToString(dominoes2) +
                       ") = " +
                       numEquivDominoPairs(dominoes2));

  }
}