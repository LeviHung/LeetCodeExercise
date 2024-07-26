package array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;

public class MinimumIndexSumOfTwoArrays
{
  public static String[] findRestaurant(String[] list1, String[] list2)
  {
    HashMap <String, Integer> map = new HashMap<>();
    
    if (list1.length > list2.length) {
      String[] tmp = list1;
      list1 = list2;
      list2 = tmp; 
    }
    
    for (int i = 0; i < list1.length; i++) {
      map.put(list1[i], i);
    }

    int size = 0;
    int minIndex = Integer.MAX_VALUE;
    int index = 0;
    String[] array = new String [Math.max(list1.length, list2.length)];

    for (int i = 0; i < list2.length && i <= minIndex; i++) {
      if (map.containsKey(list2[i])) {
        index = i + map.get(list2[i]);
        if (index < minIndex) {
          minIndex = index;
          size = 0;
          array[size++] = list2[i];
          
        } else if (index == minIndex) {
          array[size++] = list2[i];          
        }
      }
    }
    String [] res = new String[size];
    for (int i = 0; i < size; i++) {
      res[i] = array[i];
    }
    
    return res;
  }

  public String[] findRestaurantOpt(String[] list1, String[] list2) 
  {
    if (list1.length>list2.length) { return findRestaurant(list2,list1);}
    HashMap<String,Integer> map=new HashMap<>();
    for(int i=0;i<list1.length;i++){
        map.put(list1[i],i);
    }
    int min=Integer.MAX_VALUE,sum;
    List<String> str=new ArrayList<>();
    for(int i=0;i<list2.length&&i<=min;i++){
        if(map.containsKey(list2[i])){
            sum=map.get(list2[i])+i;
            if(sum<min){
                min=sum;
                str.clear();
                str.add(list2[i]);
            }
            else if(sum==min){
                str.add(list2[i]);
            }
        }
    }
    return str.toArray(new String[str.size()]);
  }

  public static void readme()
  {
    String str = "Given two arrays of strings list1 and list2, find the common strings with the least index sum.\n\n";

    str += "A common string is a string that appeared in both list1 and list.\n\n";

    str += "A common string with the least index sum is a common string such that if it appeared at list1[i] and list2[j] then i + j should be the minimum value among all the other common strings.\n\n";

    str += "Return all the common strings with the least index sum. Return the answer in any order.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    MinimumIndexSumOfTwoArrays.readme();

    // list1 = ["Shogun","Tapioca Express","Burger King","KFC"], 
    // list2 = ["Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"] => ["Shogun"]
    String [] list1 = {"Shogun","Tapioca Express","Burger King","KFC"};
    String [] list2 = {"Piatti","The Grill at Torrey Pines","Hungry Hunter Steakhouse","Shogun"};
    System.out.println("findRestaurant(" + Arrays.toString(list1) + 
                       ", " + Arrays.toString(list2) + ") = " +
                       Arrays.toString(findRestaurant(list1, list2)));

    // list3 = ["Shogun","Tapioca Express","Burger King","KFC"], list4 = ["KFC","Shogun","Burger King"] => ["Shogun"]
    String [] list3 = {"Shogun","Tapioca Express","Burger King","KFC"};
    String [] list4 = {"KFC","Shogun","Burger King"};
    System.out.println("findRestaurant(" + Arrays.toString(list3) + 
                       ", " + Arrays.toString(list4) + ") = " +
                       Arrays.toString(findRestaurant(list3, list4)));

    // list3 = list1 = ["happy","sad","good"], list2 = ["sad","happy","good"]
    // => ["happy", "sad"]
    String [] list5 = {"happy","sad","good"};
    String [] list6 = {"sad","happy","good"};
    System.out.println("findRestaurant(" + Arrays.toString(list5) + 
                       ", " + Arrays.toString(list6) + ") = " +
                       Arrays.toString(findRestaurant(list5, list6)));

    
  }
}