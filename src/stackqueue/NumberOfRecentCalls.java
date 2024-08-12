package stackqueue;

public class NumberOfRecentCalls
{
  private int counter;
  private int[] range;
  private int low;
  private int last;
  public NumberOfRecentCalls() 
  {
    counter = 0;
    range = new int [10000];
    low = 0;
    last = 0;
  }

  public int ping(int t) 
  {
    int res = 0;
    int shift = 0;
    boolean hasOver = false;
    range[counter] = t;

    while (range[counter] - range[low] > 3000) {
      low++;
      shift++;
      hasOver = true;
    }
    counter++;
    
    if (hasOver == false)
        res = counter - low;
    else 
        res = last - shift + 1;
    
    last = res;
    return res;
  }

  // ##### Optimized Solution #####
  /*  
  class RecentCounter {
      private static final int[] records = new int[10000];
      private int start;
      private int end;

      public RecentCounter() {
          start = 0;
          end = 0;    
      }

      public int ping(int t) {
          while(start < end && (t-records[start] > 3000)){
              start++;
          }

          records[end++] = t;
          return end - start;
      }
  }
  */
  

  public static void readme()
  {
    String str = "You have a RecentCounter class which counts the number of recent requests within a certain time frame.\n\n";

    str += "Implement the RecentCounter class:\n\n";
    
    str +="RecentCounter() Initializes the counter with zero recent requests.\n\n";
    
    str += "int ping(int t) Adds a new request at time t, where t represents some time in milliseconds, and returns the number of requests that has happened in the past 3000 milliseconds (including the new request). Specifically, return the number of requests that have happened in the inclusive range [t - 3000, t].\n\n";

    str += "It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.\n";

    System.out.println(str);
  }

  public static void main()
  {

    NumberOfRecentCalls.readme();

    // ["RecentCounter", "ping", "ping", "ping", "ping"]
    // [[], [1], [100], [3001], [3002]]
    // [null, 1, 2, 3, 3]

    NumberOfRecentCalls recentCounter = new NumberOfRecentCalls();
    System.out.println("recentCounter.ping(1) = " + recentCounter.ping(1));
    System.out.println("recentCounter.ping(100) = " + recentCounter.ping(100));
    System.out.println("recentCounter.ping(3001) = " + recentCounter.ping(3001));
    System.out.println("recentCounter.ping(3002) = " + recentCounter.ping(3002));

  }
}