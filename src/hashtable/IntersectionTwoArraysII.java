package hashtable;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class IntersectionTwoArraysII 
{
  public static int[] intersection(int[] nums1, int[] nums2)
  {
    HashMap <Integer, Integer> set = new HashMap<>();
    List <Integer> list = new ArrayList<>();
    for (int i = 0; i < nums1.length; i++) {
      if (set.containsKey(nums1[i])) {
        set.put(nums1[i], set.get(nums1[i]) + 1);
      } else {
        set.put(nums1[i], 1);
      }
    }

    for (int i = 0; i < nums2.length; i++) {
      if (set.containsKey(nums2[i]) == true && set.get(nums2[i]) > 0) {
        list.add(nums2[i]);
        set.put(nums2[i], set.get(nums2[i]) - 1);
      }
    }

    int [] array = new int [list.size()];
    int index = 0;
    for (int i = 0; i < list.size(); i++) {
      array[index++] = list.get(i);
    }

    return array;
  }

  public static int[] intersectionOpt(int[] nums1, int[] nums2) 
  {
    int a[] = new int [1001];
    for (int i: nums1) {
      a[i] += 1;
    }
    
    int b[] = new int[1001];
    int j = 0;
    for (int i: nums2){
      if (a[i] >= 1) {
        b[j++] = i;
        a[i] -= 1;
      }
    }
    
    return Arrays.copyOfRange(b,0,j);
  }

  public static void readme()
  {
    String str = "Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must appear as many times as it shows in both arrays and you may return the result in any order.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    IntersectionTwoArrays.readme();

    // nums1 = [1,2,2,1], nums2 = [2,2] => [2]
    int [] nums1 = {1, 2, 2, 1};
    int [] nums2 = {2, 2};

    System.out.println("intersection(" + Arrays.toString(nums1) + ", " +
                        Arrays.toString(nums2) + ") = " + 
                        Arrays.toString(intersection(nums1, nums2)));

    //nums1 = [4,9,5], nums2 = [9,4,9,8,4]
    int [] nums3 = {4, 9, 5};
    int [] nums4 = {9, 4, 9, 8, 4};

    System.out.println("intersection(" + Arrays.toString(nums3) + ", " +
                        Arrays.toString(nums4) + ") = " + 
                        Arrays.toString(intersection(nums3, nums4)));

    System.out.println("intersectionOpt(" + Arrays.toString(nums3) + ", " +
                        Arrays.toString(nums4) + ") = " + 
                        Arrays.toString(intersectionOpt(nums3, nums4)));

  } 
}