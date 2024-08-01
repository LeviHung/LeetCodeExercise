package search;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

public class KthLargestElement
{
  private PriorityQueue<Integer> pQueue;
  private int k;
  public KthLargestElement(int k, int[] nums) 
  {
    pQueue = new PriorityQueue<>();
    for (int x: nums) {
      add(x);
    }
    this.k = k;
  }

  public int add(int val)
  {
    if (pQueue.size() < k) {
      pQueue.add(val);
    } else if (val > pQueue.peek()) {
      pQueue.poll();
      pQueue.add(val);
    }
    return pQueue.peek();  
    /*
    pQueue.add(val);
    while (pQueue.size() > k) {
        pQueue.remove();
    }
    return pQueue.peek();  
    */
  }
  // Use array
  /*
  private int [] array;
  private int k;
  private int max = Integer.MIN_VALUE;
  private int last = Integer.MIN_VALUE;
  public KthLargestElement(int k, int[] nums) 
  {
    array = new int [20001];
    
    for (int i = 0; i< nums.length; i++) {
      array[nums[i] + 10000]++;
      max = Math.max(max, nums[i]);
    }
    this.k = k;
  }

   // {8, 5, 4, 2}, add 3, 5, 10, 9, 4
  public int add(int val)
  {
    array[val + 10000]++;
    max = Math.max(max, val);
    //System.out.println("last = " + last);
    if (val < last) {
      return last;
    }
    
    int sum = 0;
    int pos = 0;
    for (int i = max + 10000; i>0; i--) {
      sum += array[i];
      if (sum >= k) {
        pos = i;
        break;
      }
    }
    last = pos - 10000;
    return pos - 10000;
  }
  */
  // Use Linked list
  /*
  private static List<Integer> list;
  private static int k;
  private static int total;
  public KthLargestElement(int k, int[] nums) 
  {
    list = new ArrayList<>();
    for (int i = 0; i< nums.length; i++) {
      list.add(nums[i]);
    }

    Collections.sort(list, Collections.reverseOrder());
    total = nums.length;
    this.k = k;
  }

   // {8, 5, 4, 2}, add 3
  public int add(int val)
  {
    int pos = 0;
    while (pos < total) {
       if (list.get(pos) < val) {
         break;
       } 
       pos++;
    }
    list.add(pos, val);
    total++;

    return list.get(k-1);
  }
  */

  // Use array;
  /*
  private static Integer [] array;
  private static int k;
  private static int total;
  public KthLargestElement(int k, int[] nums) 
  {
    array = new Integer [20000];
    for (int i = 0; i < nums.length; i++) {
      array[i] = nums[i];
    } 
    Arrays.sort(array, 0, nums.length, Collections.reverseOrder());
    
    total = nums.length;
    this.k = k;
  }

   // {8, 5, 4, 2}, add 3
  public int add(int val)
  {
    int pos = 0;
    while (pos < total) {
       if (array[pos] < val) {
         for (int i = total; i > pos; i--) {
           array[i] = array[i-1];
         }
         break;
       } 
       pos++;
    }
    array[pos] = val;
    total++;

    return array[k-1];
  }
  */
  
  // Use priority queue
  /*  
  private static PriorityQueue<Integer> pQueue;
  private static int k;
  private static int total;
  private static boolean isDescending;
  public KthLargestElement(int k, int[] nums) 
    {
      total = nums.length;
      if (k < total/2) {
        pQueue = new PriorityQueue<>(Collections.reverseOrder());
        isDescending = true;
      } else {
        pQueue = new PriorityQueue<>();
        isDescending = false;
      }
      for (int x: nums) {
        pQueue.add(x);
      }
      this.k = k;
    }

    public int add(int val)
    {
      pQueue.add(val);
      total++;
      int[] res;
      if (isDescending == true) {
        res = new int [k];
        for (int i = 0; i < k; i++) {
          res[i] = pQueue.poll();
        }
        for (int i = 0; i < k; i++) {
          pQueue.add(res[i]);
        }
        return res[k-1];

      } else {
        res = new int [total - k + 1];

        // {4, 5, 8, 2}, add 3
        for (int i = 0; i < total - k + 1; i++) {
          res[i] = pQueue.poll();
        }
        for (int i = 0; i < total - k + 1; i++) {
          pQueue.add(res[i]);
        }
      }
      return res[total - k];

    }
  */
  
  public static void readme()
  {
    String str = "Design a class to find the kth largest element in a stream. Note that it is the kth largest element in the sorted order, not the kth distinct element.\n\n";

    str += "Implement KthLargest class:\n\n";

    str += "KthLargest(int k, int[] nums) Initializes the object with the integer k and the stream of integers nums.\n\n";

    str += "int add(int val) Appends the integer val to the stream and returns the element representing the kth largest element in the stream.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    KthLargestElement.readme();

    int [] nums = {4, 5, 8, 2};
    int k = 3;
    int val;
    
    KthLargestElement kthLargest = new KthLargestElement(k, nums);

    val = 3;
    System.out.println("kthLargest.add(" + val + ") = " + kthLargest.add(val));

    val = 5;
    System.out.println("kthLargest.add(" + val + ") = " + kthLargest.add(val));

    val = 10;
    System.out.println("kthLargest.add(" + val + ") = " + kthLargest.add(val));

    val = 9;
    System.out.println("kthLargest.add(" + val + ") = " + kthLargest.add(val));

    val = 4;
    System.out.println("kthLargest.add(" + val + ") = " + kthLargest.add(val));


    int [] nums2 = {};
    k = 1;
    KthLargestElement kthLargest2 = new KthLargestElement(k, nums2);

    val = -3;
    System.out.println("kthLargest2.add(" + val + ") = " + kthLargest2.add(val));


  }
}