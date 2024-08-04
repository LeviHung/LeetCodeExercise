package hashtable;

import java.util.Arrays;
import java.util.HashSet;
public class IntersectionTwoArrays 
{
  public static int[] intersection(int[] nums1, int[] nums2)
  {
    HashSet <Integer> set = new HashSet<>();
    // HashSet is better than ArrayList for runtime.
    HashSet <Integer> list = new HashSet<>();
    for (int i = 0; i < nums1.length; i++) {
      set.add(nums1[i]);
    }
    
    for (int i = 0; i < nums2.length; i++) {
      if (set.contains(nums2[i]) == true) {
        list.add(nums2[i]);
      }
    }
        
    int [] array = new int [list.size()];
    int index = 0;
    for (Integer i: list) {
      array[index++] = i;
    }
        
    return array;
  }

  public static int[] intersectionOpt(int[] nums1, int[] nums2) 
  {
    int temp[] = new int[1001];
    for (int i: nums1) {
      temp[i] = 1;
    }
    
    int c = 0;
    for (int i: nums2) {
      if (temp[i] == 1) {
        temp[i] = 2;
        c++;
      }
    }
            
    int j = 0;
    int a[] = new int[c];
    for (int i: nums2) {
      if (temp[i] == 2) {
        temp[i] = 1;
        a[j] = i;
        j++;
      }
    }
    
    return a;
  }
    
  public static void readme()
  {
    String str = "Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.\n\n";

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