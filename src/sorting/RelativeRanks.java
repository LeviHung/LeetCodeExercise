package sorting;

import java.util.Arrays;
import java.util.HashMap;

public class RelativeRanks
{
  public static String[] findRelativeRanks(int[] score)
  {
    HashMap<Integer, Integer> map = new HashMap<>();
    
    for (int i = 0; i < score.length; i++) {
      map.put(score[i], i);
    }

    Arrays.sort(score);
    
    String[] answer = new String[score.length];
    if (score.length == 1) {
      answer[map.get(score[0])] = "Gold Medal";

    } else if (score.length == 2) {
      answer[map.get(score[1])] = "Gold Medal";
      answer[map.get(score[0])] = "Silver Medal";

    } else {
      System.out.println("score[0] = " + score[0]);
      answer[map.get(score[score.length - 1])] = "Gold Medal";
      answer[map.get(score[score.length - 2])] = "Silver Medal";
      answer[map.get(score[score.length - 3])] = "Bronze Medal";
      int index = 4;
      for (int i = score.length - 4; i >= 0; i--) {
          answer[map.get(score[i])] = Integer.toString(index++);
      }
    }
      
    return answer;
  }

  public static int find_max(int[] score)
  {
    int max = Integer.MIN_VALUE;
    for(int element : score){
        max = Math.max(max, element);
    }
    return max;
  }
  public static String[] findRelativeRanksOpt(int[] score) {
    int max_val = find_max(score);
    int n = score.length;
    int[] map = new int[max_val + 1];
    for(int i = 0; i < score.length; i ++){
        map[score[i]] = i + 1;
    }
    String[] result = new String[n];
    int rank = 1;
    for(int i = max_val; i >= 0; i --){
        if(map[i] != 0){
            int original_index = map[i] - 1;
            if(rank == 1){
            result[original_index] = "Gold Medal"; 
            }
            else if(rank == 2){
            result[original_index] = "Silver Medal"; 
        }
        else if(rank == 3){
            result[original_index] = "Bronze Medal"; 
        }
        else{
            result[original_index] = Integer.toString(rank);
        }
        rank++;
        }
    }
    return result;

  }
  public static void readme()
  {
    String str = "You are given an integer array score of size n, where score[i] is the score of the ith athlete in a competition. All the scores are guaranteed to be unique.\n\n";

    str += "The athletes are placed based on their scores, where the 1st place athlete has the highest score, the 2nd place athlete has the 2nd highest score, and so on. The placement of each athlete determines their rank:\n\n";

    str += "The 1st place athlete's rank is \"Gold Medal\".\n\n";

    str += "The 2nd place athlete's rank is \"Silver Medal\".\n\n";

    str += "The 3rd place athlete's rank is \"Bronze Medal\".\n\n";

    str += "For the 4th place to the nth place athlete, their rank is their placement number (i.e., the xth place athlete's rank is \"x\").\n\n";

    str += "Return an array answer of size n where answer[i] is the rank of the ith athlete.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RelativeRanks.readme();

    //  score = [5,4,3,2,1] => ["Gold Medal","Silver Medal","Bronze Medal","4","5"]
    int [] score1 = {5,4,3,2,1};
    System.out.println("findRelativeRanks(" + Arrays.toString(score1) + 
                       ") = " +
                       Arrays.toString(findRelativeRanks(score1)));

    // score = [10,3,8,9,4] => ["Gold Medal","5","Bronze Medal","Silver Medal","4"]
    int [] score2 = {10,3,8,9,4};
    System.out.println("findRelativeRanks(" + Arrays.toString(score2) + 
                       ") = " +
                       Arrays.toString(findRelativeRanks(score2)));

    int [] score3 = {10,3,8,9,4};
    System.out.println("findRelativeRanksOpt(" + Arrays.toString(score3) + 
       ") = " +
       Arrays.toString(findRelativeRanksOpt(score3)));

  }
}