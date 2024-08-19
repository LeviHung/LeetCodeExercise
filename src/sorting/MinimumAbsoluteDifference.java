package sorting;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class MinimumAbsoluteDifference
{
  public static List<List<Integer>> minimumAbsDifference(int[] arr) {
    List <List<Integer>> list = new ArrayList<>();
    int minDiff = Integer.MAX_VALUE;
    int diff = 0;
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;
    for (int i = 0; i < arr.length; i++) {
        min = Math.min(arr[i], min);
        max = Math.max(arr[i], max);
    }
    boolean[] number = new boolean[max - min + 1];
    for (int i = 0; i < arr.length; i++) {
        number[arr[i] - min] = true;
    }
    arr[0] = min;
    int index = 1;
    for (int i = 1; i < max - min + 1; i++) { 
        if (number[i] == true) {
            arr[index] = i + min;
            diff = arr[index] - arr[index-1];
            minDiff = Math.min(diff, minDiff); 
            index++;
        }
    }

    for (int i = 0; i < arr.length - 1; i++) {
        diff = arr[i+1] - arr[i];
        if (diff == minDiff) {
            List<Integer> subList = new ArrayList<>();
            subList.add(arr[i]);
            subList.add(arr[i+1]);
            list.add(subList);
        } 
    }
    return list;
  }
  /*
  public static List<List<Integer>> minimumAbsDifference(int[] arr) {
    List <List<Integer>> list = new ArrayList<>();
    Arrays.sort(arr);
    int minDiff = Integer.MAX_VALUE;
    int diff = 0;
    for (int i = 0; i < arr.length - 1; i++) {
        diff = arr[i+1] - arr[i];
        minDiff = Math.min(diff, minDiff);  
    }

    for (int i = 0; i < arr.length - 1; i++) {
        diff = arr[i+1] - arr[i];
        if (diff == minDiff) {
            List<Integer> subList = new ArrayList<>();
            subList.add(arr[i]);
            subList.add(arr[i+1]);
            list.add(subList);
        } 
    }
    return list;
  }
  */

  public static List<List<Integer>> minimumAbsDifferenceOpt(int[] arr) {
      return new java.util.AbstractList<List<Integer>>() {
          int n = arr.length;
          int buffer[] = new int[n];
          int min = Integer.MAX_VALUE;
          int diff, size = 0;
          boolean initialized = false;
          void init() {
              if(initialized) return;
              Arrays.sort(arr);
              for(int i = 1; i < n; i++) {
                  diff = arr[i] - arr[i - 1];
                  if(diff > min) continue;
                  else if(diff < min) {
                      min = diff;
                      size = 0;
                  }
                  buffer[size++] = arr[i - 1];
              }
              initialized = true;
          }
          public List<Integer> get(int ind) {
              init();
              return List.of(buffer[ind], buffer[ind] + min);
          }
          public int size() {
              init();
              return size;
          }

      };

  }

  public static void readme()
  {
    String str = "Given an array of distinct integers arr, find all pairs of elements with the minimum absolute difference of any two elements.\n\n";

    str += "Return a list of pairs in ascending order(with respect to pairs), each pair [a, b] follows\n\n";

    str += "a, b are from arr\n\n";

    str += "a < b\n\n";

    str += "b - a equals to the minimum absolute difference of any two elements in arr\n";

    System.out.println(str);
  }

  public static void main()
  {
    MinimumAbsoluteDifference.readme();

    // Input: arr = [4,2,1,3]
    // Output: [[1,2],[2,3],[3,4]]

    int[] arr1 = {4,2,1,3};
    System.out.println("minimumAbsDifference(" + Arrays.toString(arr1) + ") = ");
    List<List<Integer>> list1 = minimumAbsDifference(arr1);
    System.out.println(Arrays.toString(list1.toArray()));

    // Input: arr = [1,3,6,10,15]
    // Output: [[1,3]]
    int[] arr2 = {1,3,6,10,15};
    System.out.println("minimumAbsDifference(" + Arrays.toString(arr2) + ") = ");
    List<List<Integer>> list2 = minimumAbsDifference(arr2);
    System.out.println(Arrays.toString(list2.toArray()));

    // Input: arr = [3,8,-10,23,19,-4,-14,27]
    // Output: [[-14,-10],[19,23],[23,27]]
    int[] arr3 = {3,8,-10,23,19,-4,-14,27};
    System.out.println("minimumAbsDifference(" + Arrays.toString(arr3) + ") = ");
    List<List<Integer>> list3 = minimumAbsDifference(arr3);
    System.out.println(Arrays.toString(list3.toArray()));

    System.out.println("minimumAbsDifferenceOpt(" + Arrays.toString(arr3) + ") = ");
    List<List<Integer>> list4 = minimumAbsDifferenceOpt(arr3);
    System.out.println(Arrays.toString(list4.toArray()));
    }
}