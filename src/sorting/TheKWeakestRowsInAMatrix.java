package sorting;

import java.util.Arrays;
import java.util.PriorityQueue;

public class TheKWeakestRowsInAMatrix
{
  public static int[] kWeakestRows(int[][] mat, int k) {
      int [] soldiers = new int [mat.length];
      for (int i = 0; i < mat.length; i++) {
          for (int j = 0; j < mat[0].length; j++) {
              if (mat[i][j] == 1) {
                  soldiers[i]++;
              }
          }
      }
      int[] res = new int [k];
      int[][] freq = new int [mat[0].length + 1][mat.length + 1];
      for (int i = 0; i < soldiers.length; i++) {
          freq[soldiers[i]][0]++;
          freq[soldiers[i]][freq[soldiers[i]][0]] = i;
      }
      int index = 0;
      int digit = 1;
      for (int i = 0; i < freq.length; i++) {
          digit = 1;
          while (freq[i][0] > 0) {
              res[index] = freq[i][digit];
              index++;
              if (index >= k) {
                  return res;
              }
              freq[i][0]--;
              digit++;
          }
      }
      return res;
      // Use one integer to indicate the index (0-31)
      /*
      //soldiers = // [2, 4, 1, 2, 5] [1, 1, 1, 2]
      int [] freq = new int [mat[0].length + 1];
      for (int i = 0; i < soldiers.length; i++) {
          freq[soldiers[i]] += 1 << i;
      }
      //System.out.println("freq = " + Arrays.toString(freq));
      int index = 0;
      int digit = 0;
      for (int i = 0; i < freq.length; i++) {
          digit = 0;
          while (freq[i] > 0) {
              if (freq[i] % 2 == 1) {
                  res[index] = digit;
                  index++;
                  if (index >= k) {
                      return res;
                  }
              }
              freq[i] = freq[i] / 2;
              digit++;
          }
      }
      return res;
      */
    
      // search index one by one
      /*
      int weak = 0;
      int index = 0;
      while (weak <= mat[0].length) {
          for (int i = 0; i < soldiers.length; i++) {
              if (soldiers[i] == weak) {
                  res[index] = i;
                  index++;
                  if (index >= k) 
                      return res;
              }
          }
          weak++; 
      }
      return res;
      */
  }

  public static int[] kWeakestRowsOpt(int[][] mat, int k) {
    int[] res = new int[k];

    // index : soldiers
    // ------
    // 0: 2 soldiers
    // 1: 4 ...
    // 2: 2 ...

    // soldiers : indexes
    // -----
    // 0:
    // 1: 2
    // 2: 0, 3
    // 3:
    // 4: 1

    int[][] indexes = new int[mat[0].length + 1][mat.length];
    for (var arr : indexes) Arrays.fill(arr, -1);

    for (int i = 0; i < mat.length; i++) {
        int soldiers = getSoldiers(mat[i]);
        int freeIndex = getFreeIndex(indexes[soldiers]);
        indexes[soldiers][freeIndex] = i;
    }

    int a = 0;

    // return 2, 0, 3 ... until k
    start:for (int i = 0; i < indexes.length; i++) {
        for (int j = 0; j < indexes[0].length; j++) {
            if (indexes[i][j] != -1) {
                res[a++] = indexes[i][j];
                if (a == k) break start;
            } else {
                break;
            }
        }
    }

    return res;
  }

  static int getSoldiers(int[] arr) {
    int soldiers = 0;
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == 1) soldiers++;
    }
    return soldiers;
  }

  static int getFreeIndex(int[] arr) {
    for (int i = 0; i < arr.length; i++) {
        if (arr[i] == -1) return i;
    }

    return 0;
  }
  // Use heap 
  public static int[] kWeakestRowsEx(int[][] mat, int k) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] != b[0] ? b[0] - a[0] : b[1] - a[1]);
    int[] ans = new int[k];

    for (int i = 0; i < mat.length; i++) {
        pq.offer(new int[] {numOnes(mat[i]), i});
        if (pq.size() > k)
            pq.poll();
    }

    while (k > 0)
        ans[--k] = pq.poll()[1];

    return ans;
  }

  private static int numOnes(int[] row) {
    int lo = 0;
    int hi = row.length;

    while (lo < hi) {
        int mid = lo + (hi - lo) / 2;

        if (row[mid] == 1)
            lo = mid + 1;
        else
            hi = mid;
    }

    return lo;
  }
  
  public static void readme()
  {
    String str = "You are given an m x n binary matrix mat of 1's (representing soldiers) and 0's (representing civilians). The soldiers are positioned in front of the civilians. That is, all the 1's will appear to the left of all the 0's in each row.\n\n";

    str += "A row i is weaker than a row j if one of the following is true:\n\n";
    str += "The number of soldiers in row i is less than the number of soldiers in row j.\n\n";
    str += "Both rows have the same number of soldiers and i < j.\n\n";
    str += "Return the indices of the k weakest rows in the matrix ordered from weakest to strongest.\n";

    System.out.println(str);
  }

  public static void main()
  {
    TheKWeakestRowsInAMatrix.readme();
    int k;
    // Input: mat = 
    // [[1,1,0,0,0],
    // [1,1,1,1,0],
    // [1,0,0,0,0],
    // [1,1,0,0,0],
    // [1,1,1,1,1]], 
    // k = 3
    // Output: [2,0,3]


    int [][] mat1 = {{1,1,0,0,0},{1,1,1,1,0},{1,0,0,0,0},{1,1,0,0,0},{1,1,1,1,1}};
    k = 3;
    System.out.println("kWeakestRows(" + 
                       Arrays.deepToString(mat1) + ", " + k + ") = " +
                       Arrays.toString(kWeakestRows(mat1, k)));

    System.out.println("kWeakestRowsOpt(" + 
                       Arrays.deepToString(mat1) + ", " + k + ") = " +
                       Arrays.toString(kWeakestRowsOpt(mat1, k)));

    System.out.println("kWeakestRowsEx(" + 
                       Arrays.deepToString(mat1) + ", " + k + ") = " +
                       Arrays.toString(kWeakestRowsEx(mat1, k)));

    // Input: mat = 
    // [[1,0,0,0],
    // [1,1,1,1],
    // [1,0,0,0],
    // [1,0,0,0]], 
    // k = 2
    // Output: [0,2]
    int [][] mat2 = {{1,0,0,0},{1,1,1,1},{1,0,0,0},{1,0,0,0}};
    k = 2;
    System.out.println("kWeakestRows(" + 
                       Arrays.deepToString(mat2) + ", " + k + ") = " +
                       Arrays.toString(kWeakestRows(mat2, k)));
                    
  }
}