package math;

public class ValidPerfectSquare
{
  public static boolean isPerfectSquare(int num)
  {
    int s = 0;
    int e = num;
    int ans = -1;
    int mid = s + (e - s) / 2;
    while (s <= e) {
        if (mid * mid == num) {
            return true;
        }
        else if ((double)mid * mid < (double)num) {
            ans = mid;
            s = mid + 1;
        }
        else {
            e = mid - 1;
        }
        mid = s + (e - s) / 2;
    }
    return false;
  }

  public static void readme()
  {
    String str = "Given a positive integer num, return true if num is a perfect square or false otherwise.\n\n";

    str += "A perfect square is an integer that is the square of an integer. In other words, it is the product of some integer with itself.\n\n";

    str += "You must not use any built-in library function, such as sqrt.";
    
    System.out.println(str);
  }

  public static void main()
  {
    ValidPerfectSquare.readme();

    int num;
    // num = 16 => true
    num = 16;
    System.out.println("isPerfectSquare(" + num + ") = " + isPerfectSquare(num));

    // num = 14 => false
    num = 14;
    System.out.println("isPerfectSquare(" + num + ") = " + isPerfectSquare(num));
  }
}