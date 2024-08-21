package sorting;
import java.util.Arrays;

public class RankTransformOfAnArray
{
  public static int[] arrayRankTransform(int[] arr) {
    int[] res = new int [arr.length];
    int max = Integer.MIN_VALUE;
    int min = Integer.MAX_VALUE;
    for (int val: arr) {
        max = Math.max(val, max);
        min = Math.min(val, min);
    } 

    if (max - min > 200 && arr.length < 10) {
        int [] tmp = arr.clone();
        Arrays.sort(arr);
        int index = 1;
        boolean isRepeat = false;
        for (int i = 0; i < arr.length; i++) {
            int val = arr[i];
            isRepeat = false;
            for (int j = 0; j < tmp.length; j++) {
                if (tmp[j] == val) {
                    if (isRepeat) {
                        i++;
                    }
                    res[j] = index;
                    isRepeat = true;
                }
            }
            index++;
        }
        return res;

    } else {
        int[] nums = new int [max - min + 1];
        for (int i = 0; i < arr.length; i++) {
            nums[arr[i] - min] = 1;
        }

        int rank = 1;
        for (int i = 0; i < max - min + 1; i++) {
            if (nums[i] == 1) {
                nums[i] = rank;
                rank++;
            }
        }

        for (int i = 0; i < arr.length; i++) {
            res[i] = nums[arr[i]-min];
        }

        return res;
    }
  }
  /*
  public int[] arrayRankTransform(int[] arr) {
    int[] res = new int [arr.length];
    Element[] elements = new Element[arr.length];
    for (int i = 0; i < arr.length; i++) {
        elements[i] = new Element(i, arr[i]);
    }

    Arrays.sort(elements);
    int rank = 0;
    int last = Integer.MIN_VALUE;
    for (Element element : elements) {
        if (element.value != last) {
            rank++;
        }
        res[element.index] = rank;
        last = element.value;
    }
    return res;
  }

  class Element implements Comparable<Element> {
    int index, value;

    Element(int index, int value){
        this.index = index;
        this.value = value;
    }

    public int compareTo(Element e) {
        return this.value - e.value;
    }
  }
  */

  public static void readme()
  {
    String str = "Given an array of integers arr, replace each element with its rank.\n\n";

    str += "The rank represents how large the element is. The rank has the following rules:\n\n";
    
    str += "Rank is an integer starting from 1.\n\n";
    
    str += "The larger the element, the larger the rank. If two elements are equal, their rank must be the same.\n\n";

    str += "Rank should be as small as possible.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RankTransformOfAnArray.readme();

    // Input: arr = [40,10,20,30]
    // Output: [4,1,2,3]

    int [] arr1 = {40,10,20,30};
    System.out.println("arrayRankTransform(" + Arrays.toString(arr1) + 
       ") = " +
       Arrays.toString(arrayRankTransform(arr1)));

    // Input: arr = [100,100,100]
    // Output: [1,1,1]

    int [] arr2 = {100,100,100};
    System.out.println("arrayRankTransform(" + Arrays.toString(arr2) + 
                       ") = " +
                       Arrays.toString(arrayRankTransform(arr2)));
                
    // Input: arr = [37,12,28,9,100,56,80,5,12]
    // Output: [5,3,4,2,8,6,7,1,3]
    int [] arr3 = {37,12,28,9,100,56,80,5,12};
    System.out.println("arrayRankTransform(" + Arrays.toString(arr3) + 
                       ") = " +
                       Arrays.toString(arrayRankTransform(arr3)));

  }
}