package easy;

public class Sqrt
{
  public static int mySqrt(int x)
  {    
    int digit = 0;
    long value = 1;
    // 0 1 2 3 4   5  6
    // 1 2 4 8 16 32 64
    // 2147395599
    System.out.println("x = " + x);
    while (x > value) {
      value *= 2;
      digit++;
    }
    digit--;
    boolean found = false;
    digit /= 2;
    value = 1;
    for (int i = 0; i < digit; i++) {
      value *= 2;
    }
    
    while (!found) {
      if (value * value == x) {
        found = true;
      } else if (value * value < x) {
        value++;
      } else if (value * value > x) {
        value--;
        found = true;
      }
    }
    
    return  (int) value;
  }

  public static int mySqrtOpt(int x) 
  {
      int s=0;
      int e=x;
      int ans=-1;
      int mid=s+(e-s)/2;
      while (s<=e){
          if (mid*mid==x){
              return mid;
          }
          else if ((double)mid*mid<(double)x){
              ans=mid;
              s=mid+1;
          }
          else {
              e=mid-1;
          }
          mid=s+(e-s)/2;
      }
      return ans;
  }
  
  public static void readme()
  {
    String str = "Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.\n\n";

    str += "You must not use any built-in exponent function or operator.\n\n";

    str += "For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.\n";

    System.out.println(str);
  }

  public static void main()
  {
    Sqrt.readme();
    int a = 2147483647;
         // 2147483647
    // x = 4 => 2
    System.out.println("Sqrt(" + a + ") = " + Sqrt.mySqrt(a));

    // x = 8 => 2 (2.8)
  }
}