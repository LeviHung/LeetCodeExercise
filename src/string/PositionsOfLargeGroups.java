package string;
import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

public class PositionsOfLargeGroups
{
  public static  List<List<Integer>> largeGroupPositions(String s) 
  {
    List <List<Integer>> res = new ArrayList<>();
    char[] array = s.toCharArray();
    int startIdx = 0;
    int endIdx = 0;
    for (int i = 0; i < array.length-2; i++) {
      startIdx = i;
      endIdx = i;
      List<Integer> group = new ArrayList<>();

      if (array[i] == array[i + 1] && 
          array[i] == array[i + 2]) {
        endIdx = i + 3;
        while (endIdx < array.length) {
          if (array[startIdx] == array[endIdx]) {
            endIdx++;
          } else {
            break;
          }
        }
        group.add(startIdx);
        group.add(endIdx - 1);

        i = endIdx - 1;
        res.add(group);
      }
    }

    return res;
  }

  public static List<List<Integer>> largeGroupPositionsOpt(String S) 
  {
      char[] str = S.toCharArray();
      List<List<Integer>> list = new ArrayList<>();
      for(int i=0;i<str.length-2;i++){
          int start =i;
          if(str[i]==str[i+1] && str[i+1]==str[i+2]){
              i+=2;
              while(i<str.length-1){
                  if(str[i]!=str[i+1])
                      break;
                  i++;
              }
              list.add(Arrays.asList(new Integer[]{start,i}));

          }

      }
      return list;
  }

  public static void readme()
  {
    String str = "In a string s of lowercase letters, these letters form consecutive groups of the same character.\n\n";

    str += "For example, a string like s = \"abbxxxxzyy\" has the groups \"a\", \"bb\", \"xxxx\", \"z\", and \"yy\".\\n\n";

    str += "A group is identified by an interval [start, end], where start and end denote the start and end indices (inclusive) of the group. In the above example, \"xxxx\" has the interval [3,6].\n\n";

    str += "A group is considered large if it has 3 or more characters.\n\n";

    str += "Return the intervals of every large group sorted in increasing order by start index.\n";

    System.out.println(str);
  }

  public static void main()
  {
    PositionsOfLargeGroups.readme();
    String s;
    
    // s = "abbxxxxzzy" => [[3,6]]
    s = "abbxxxxzzy";
    System.out.println("largeGroupPositions(" + s + ") = ");
    List<List<Integer>> list1 = largeGroupPositions(s);
    System.out.println(Arrays.toString(list1.toArray()));
    System.out.println("");
    
    // s = "abc" => []
    s = "abc";
    System.out.println("largeGroupPositions(" + s + ") = ");
    List<List<Integer>> list2 = largeGroupPositions(s);
    System.out.println(Arrays.toString(list2.toArray()));

    System.out.println("largeGroupPositionsOpt(" + s + ") = ");
    List<List<Integer>> list3 = largeGroupPositionsOpt(s);
    System.out.println(Arrays.toString(list3.toArray()));
  }
}