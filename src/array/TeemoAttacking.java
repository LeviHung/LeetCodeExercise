package array;
import java.util.Arrays;

public class TeemoAttacking
{
  public static int findPoisonedDuration(int[] timeSeries, int duration)
  {
    int totalP = 0;
    totalP = timeSeries.length * duration;
    int overlap = 0;
    int end = timeSeries[0] + duration;
    
    for (int i = 1; i < timeSeries.length; i++) {
      if (end > timeSeries[i]) {
        overlap = end - timeSeries[i];
      }
      end = timeSeries[i] + duration;
    }
    /*
    for (int i = 1; i < timeSeries.length; i++) {
      if ((timeSeries[i] - timeSeries[i-1]) < duration) {
        overlap += duration - (timeSeries[i] - timeSeries[i-1]);
      }      
    }
    */
    return totalP - overlap;
  }

  public static int findPoisonedDurationOpt(int[] timeSeries, int duration) 
  {
      int res = 0;
      int startTime = timeSeries[0];
      int endTime = startTime+duration;
      int time;

      for(int i =1;i<timeSeries.length;i++) {
          time = timeSeries[i];
          if(time > endTime) {
              res += endTime - startTime;
              startTime = time;
          }
          endTime=time+duration;
      }

      return res+(endTime-startTime);
  }
  
  public static void readme()
  {
    String str = "Our hero Teemo is attacking an enemy Ashe with poison attacks! When Teemo attacks Ashe, Ashe gets poisoned for a exactly duration seconds. More formally, an attack at second t will mean Ashe is poisoned during the inclusive time interval [t, t + duration - 1]. If Teemo attacks again before the poison effect ends, the timer for it is reset, and the poison effect will end duration seconds after the new attack.\n\n";

    str += "You are given a non-decreasing integer array timeSeries, where timeSeries[i] denotes that Teemo attacks Ashe at second timeSeries[i], and an integer duration.\n\n";

    str += "Return the total number of seconds that Ashe is poisoned.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    TeemoAttacking.readme();

    // timeSeries = [1,4], duration = 2 => 4
    int [] timeSeries1 = {1,4};
    int duration1 = 2;
    System.out.println("findPoisonedDuration(" + 
                       Arrays.toString(timeSeries1) + 
                       ", " + duration1 + ") = " +
                       findPoisonedDuration(timeSeries1, duration1));

    // timeSeries = [1,2], duration = 2 => 3
    int [] timeSeries2 = {1,2};
    int duration2 = 2;
    System.out.println("findPoisonedDuration(" + 
                       Arrays.toString(timeSeries2) + 
                       ", " + duration2 + ") = " +
                       findPoisonedDuration(timeSeries2, duration2));

    System.out.println("findPoisonedDurationOpt(" + 
                       Arrays.toString(timeSeries2) + 
                       ", " + duration2 + ") = " +
                       findPoisonedDurationOpt(timeSeries2, duration2));
                
  }
}