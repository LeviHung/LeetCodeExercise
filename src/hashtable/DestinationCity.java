package hashtable;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class DestinationCity
{
  public static String destCity(List<List<String>> paths) {
      HashSet <String> set = new HashSet<>();
      int len = paths.size();
      for (int i = 0; i < len; i++)
          set.add(paths.get(i).get(0));

      for (int i = 0; i < len; i++) {
          String str = paths.get(i).get(1);
          if (!set.contains(str))
              return str;
      }
      return "";
  }

  public static void readme()
  {
    String str = "You are given the array paths, where paths[i] = [cityAi, cityBi] means there exists a direct path going from cityAi to cityBi. Return the destination city, that is, the city without any path outgoing to another city.\n\n";

    str += "It is guaranteed that the graph of paths forms a line without any loop, therefore, there will be exactly one destination city.\n";

    System.out.println(str);
  }

  public static void main()
  {
    DestinationCity.readme();

    int extraCandies;

    // Input: paths = [["London","New York"],["New York","Lima"],["Lima","Sao Paulo"]]
    // Output: "Sao Paulo" 
    List<List<String>> list1 = new ArrayList<>();
    List<String> subList = new ArrayList<>();
    subList.add("London");
    subList.add("New York");
    list1.add(subList);
    subList = new ArrayList<>();
    subList.add("New York");
    subList.add("Lima");
    list1.add(subList);
    subList = new ArrayList<>();
    subList.add("Lima");
    subList.add("Sao Paulo");
    list1.add(subList);

    System.out.println("destCity(" + Arrays.toString(list1.toArray()) + ") = " +
                       destCity(list1));

    // Input: paths = [["B","C"],["D","B"],["C","A"]]
    // Output: "A"

    List<List<String>> list2 = new ArrayList<>();
    subList = new ArrayList<>();
    subList.add("B");
    subList.add("C");
    list2.add(subList);
    subList = new ArrayList<>();
    subList.add("D");
    subList.add("B");
    list2.add(subList);
    subList = new ArrayList<>();
    subList.add("C");
    subList.add("A");
    list2.add(subList);

    System.out.println("destCity(" + Arrays.toString(list2.toArray()) + ") = " +
                       destCity(list2));

    // Input: paths = [["A","Z"]]
    // Output: "Z"

    List<List<String>> list3 = new ArrayList<>();
    subList = new ArrayList<>();
    subList.add("A");
    subList.add("Z");
    list3.add(subList);
   
    System.out.println("destCity(" + Arrays.toString(list3.toArray()) + ") = " +
                       destCity(list3));

  }
}