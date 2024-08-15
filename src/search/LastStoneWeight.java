package search;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Collections;

public class LastStoneWeight
{
  public static int lastStoneWeight(int[] stones)
  {
    PriorityQueue<Integer> pQueue = new PriorityQueue<>(Collections.reverseOrder());
    for (int x: stones) {
      pQueue.add(x);
    }

    int first = 0;
    int second = 0;
    int diff = 0;
    while (pQueue.size() > 1) {
      first = pQueue.peek();
      pQueue.poll();
      second = pQueue.peek();
      pQueue.poll();
      diff = first - second;
      if (diff > 0) {
        pQueue.add(diff);
      }
    }
    if (pQueue.size() == 0) {
      return 0;
    } else {
      return pQueue.peek();
    }
  }

  public static void readme()
  {
    String str = "You are given an array of integers stones where stones[i] is the weight of the ith stone.\n\n";

    str += "We are playing a game with the stones. On each turn, we choose the heaviest two stones and smash them together. Suppose the heaviest two stones have weights x and y with x <= y. The result of this smash is:\n\n";
    str += "If x == y, both stones are destroyed, and\n\n";
    str += "If x != y, the stone of weight x is destroyed, and the stone of weight y has new weight y - x.\n\n";
    str += "At the end of the game, there is at most one stone left.\n\n";

    str += "Return the weight of the last remaining stone. If there are no stones left, return 0.\n";

    System.out.println(str);
  }

  public static int lastStoneWeightOpt(int[] stones) 
  {
      int max=0, max_ind=-1, second=-1, second_ind=-1;
      for(int i=0; i<stones.length; i++) {
          if(stones[i]>=max){
              second=max;
              second_ind=max_ind;
              max=stones[i];
              max_ind = i;
          } else if (stones[i]>second){
              second = stones[i];
              second_ind = i;
          }
      }

      if(max_ind == -1) return 0;
      if(second_ind == -1) return stones[0];
      if(second <= 0 )  
          return max;
      stones[second_ind] = 0;
      stones[max_ind] = max-second;
      return lastStoneWeightOpt(stones);

  }
  
  public static void main()
  {
    LastStoneWeight.readme();
    
    // stones = [2,7,4,1,8,1] => 1
    int [] stones1 = {2,7,4,1,8,1};
    System.out.println("lastStoneWeight(" + Arrays.toString(stones1) +") = " +
                       lastStoneWeight(stones1));

    // stones = [1] => 1
    int [] stones2 = {1};
    System.out.println("lastStoneWeight(" + Arrays.toString(stones2) +") = " +
                       lastStoneWeight(stones2));

    System.out.println("lastStoneWeightOpt(" + Arrays.toString(stones2) +") = " +
                       lastStoneWeightOpt(stones2));

  }
}