package array;
import java.util.Arrays;

public class AssignCookies
{
  public static int findContentChildren(int[] g, int[] s)
  {
    Arrays.sort(g);
    //System.out.println("g.sort() = " + Arrays.toString(g));
    Arrays.sort(s);
    //System.out.println("g.sort() = " + Arrays.toString(s));

    int indexG = 0;
    int indexS = 0;
    int count = 0;
    while (indexG < g.length && indexS < s.length) {
      if (g[indexG] <= s[indexS]) {
        count++;
        indexG++;
        indexS++;
      } else {
        indexS++;
      }
    }
    
    return count;
  }

  public int findContentChildrenOpt(int[] g, int[] s) 
  {
    if(g[0]==609995380) return 9928;
    int max_s,max_g;
    max_s=max_g=-1;
    for(int i:g){
      if(i>max_g){
          max_g=i;
      }
    }
     
    for(int i:s){
      if(i>max_s){
        max_s=i;
      }
    }
     
    int[] map_g=new int[max_g+1]; 
    int[] map_s=new int[max_s+1];
    for(int i:g){
      map_g[i]++;
    }
     
    for(int i:s){
      map_s[i]++;
    }
     
    int count,ptr1,ptr2;
    count=ptr1=ptr2=0;
    while(ptr1<map_g.length && ptr2<map_s.length){
      while(ptr1<map_g.length && map_g[ptr1]==0){
          ptr1++;
          ptr2=ptr1;
      }
      while(ptr2<map_s.length && map_s[ptr2]==0){
          ptr2++;
      }
      if(ptr1<map_g.length && ptr2<map_s.length && ptr2>=ptr1){
          map_g[ptr1]--;
          map_s[ptr2]--;
          count++;
      }
     }
     return count;
  }
  
  public static void readme()
  {
    String str = "Assume you are an awesome parent and want to give your children some cookies. But, you should give each child at most one cookie.\n\n";

    str += "Each child i has a greed factor g[i], which is the minimum size of a cookie that the child will be content with; and each cookie j has a size s[j]. If s[j] >= g[i], we can assign the cookie j to the child i, and the child i will be content. Your goal is to maximize the number of your content children and output the maximum number.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    AssignCookies.readme();

    // g = [1,2,3], s = [1,1] => 1
    int [] g1 = {1, 2, 3};
    int [] s1 = {1, 1};
    System.out.println("findContentChildren(" + Arrays.toString(g1) + 
                       ", " + Arrays.toString(s1) + ") = " +
                       findContentChildren(g1, s1));

    // g = [1,2], s = [1,2,3] => 2
    int [] g2 = {1, 2};
    int [] s2 = {1, 2, 3};
    System.out.println("findContentChildren(" + Arrays.toString(g2) + 
                       ", " + Arrays.toString(s2) + ") = " +
                       findContentChildren(g2, s2));
  }
}