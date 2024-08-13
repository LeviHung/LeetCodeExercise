package hashtable;

import java.util.Arrays;

public class FindTownJudge
{
  private static int findJudge(int n, int[][] trust)
  {
    if (n == 1 && trust.length == 0) {
      return 1;
    }

    int [] arrayJ = new int [n + 1];
    int sizeJ = 0;
    boolean [] arrayP = new boolean [n + 1];
    boolean [] array = new boolean [n + 1];
    boolean [] arrayJJ = new boolean [n + 1];
    for (int i = 0; i < trust.length; i++) {
      arrayJJ[trust[i][1]] = true;
    }
    for (int i = 0; i < array.length; i++) {
      if (arrayJJ[i] == true) {
          arrayJ[sizeJ] = i;
          sizeJ++;
      }
    }

    for (int i = 0; i < trust.length; i++) {
      array[trust[i][0]] = true;
    }   

    int res = 0;
    int indexJ = 0;
    while (indexJ < sizeJ) {
      if (array[arrayJ[indexJ]] == true) {
          indexJ++;
          continue;
      }
      boolean isJudge = true;
      for (int i = 0; i < trust.length; i++) {
          if (trust[i][1] == arrayJ[indexJ]) {
              arrayP[trust[i][0]] = true;
          }
      }   
      for (int i = 1; i < arrayP.length; i++) {
          if (i == arrayJ[indexJ]) {
              continue;
          }
          if (arrayP[i] == false) {
              isJudge = false;
              break;                    
          }
      }
      if (isJudge == true) {
          return arrayJ[indexJ];
      }
      indexJ++;
    }

    return -1;
  }

  public static int findJudgeOpt(int n, int[][] trust) 
  {
    int length = trust.length;
    int freq[] = new int[n+1];
    for (int i=0;i<length;i++) {
      freq[trust[i][1]]++;
    }
    
    int answer = 0;
    for( int i=1;i<=n;i++)  {
      if (freq[i]==n-1) 
        answer = i;
    }
    
    for (int i=0;i<length;i++)  {
      if (trust[i][0]==answer) 
        return -1;
    }
    
    return answer == 0 ? -1: answer;
  }

  public static void readme()
  {
    String str = "In a town, there are n people labeled from 1 to n. There is a rumor that one of these people is secretly the town judge.\n\n";

    str += "If the town judge exists, then:\n\n";
    str += "The town judge trusts nobody.\n\n";
    str += "Everybody (except for the town judge) trusts the town judge.\n\n";
    str += "There is exactly one person that satisfies properties 1 and 2.\n\n";
    str += "You are given an array trust where trust[i] = [ai, bi] representing that the person labeled ai trusts the person labeled bi. If a trust relationship does not exist in trust array, then such a trust relationship does not exist.\n\n";
    str += "Return the label of the town judge if the town judge exists and can be identified, or return -1 otherwise.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    FindTownJudge.readme();
    int n;
    // n = 2, trust = [[1,2]] => 2
    int[][] trust1 = {{1,2}};
    n = 2;
    System.out.println("findJudge(" + n + ", " + 
                       Arrays.deepToString(trust1) + ") = " + 
                       findJudge(n, trust1));

    // n = 3, trust = [[1,3],[2,3]] => 3
    int[][] trust2 = {{1,3},{2,3}};
    n = 3;
    System.out.println("findJudge(" + n + ", " + 
                       Arrays.deepToString(trust2) + ") = " + 
                       findJudge(n, trust2));

    // n = 3, trust = [[1,3],[2,3],[3,1]] => -1
    int[][] trust3 = {{1,3},{2,3},{3,1}};
    n = 3;
    System.out.println("findJudge(" + n + ", " + 
                       Arrays.deepToString(trust3) + ") = " + 
                       findJudge(n, trust3));

    System.out.println("findJudgeOpt(" + n + ", " + 
                       Arrays.deepToString(trust3) + ") = " + 
                       findJudgeOpt(n, trust3));

  }

}