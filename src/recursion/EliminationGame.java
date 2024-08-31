package recursion;

public class EliminationGame
{
  public static int lastRemaining(int n) {
    // 1, 2, 3, 4, 5, 6, 7, 8, 9,      if isLeft = true, keep head + step (= head),
    // _, 2, _, 4, _, 6, _, 8, _,      if even remain, keep head
    //(_, 2, _, 4, _, 6, _, 8, _, 10)  if odd remian, keep head + step (= head)
    // _, 2, _, _, _, 6, _, _,         step = step * 2,
    // _, _, _, _, _, 6, _, _,         remain = remain / 2
    return remaining(1, 1, n, true);
  }

  public static int remaining(int head, int step, int remain, boolean isLeft) {
    if (remain == 1) {
        return head;
    }
    if (isLeft || (remain % 2 == 1)) {
        head = head + step;
    }
    return remaining(head, step * 2, remain / 2, !isLeft);
  }

  public static int lastRemainingOpt(int n) {
    if(n == 1) {
        return 1;
    }
    return 2*(1+n/2-lastRemaining(n/2));
  }

  public static int lastRemainingOld(int n) {
    int head = 1;
    int step = 1;
    int remain = n;
    boolean isLeft = true;
    while (remain > 1) {
        if (isLeft || (remain % 2 == 1)) {
            head = head + step;
        }
        step = step * 2;
        remain = remain / 2;
        isLeft = !isLeft;
    }
    return head;
  }

  public static void readme()
  {
    String str = "You have a list arr of all integers in the range [1, n] sorted in a strictly increasing order. Apply the following algorithm on arr:\n\n";

    str += "Starting from left to right, remove the first number and every other number afterward until you reach the end of the list.\n\n";
    
    str += "Repeat the previous step again, but this time from right to left, remove the rightmost number and every other number from the remaining numbers.\n\n";

    str += "Keep repeating the steps again, alternating left to right and right to left, until a single number remains.\n\n";
    str += "Given the integer n, return the last number that remains in arr.\n";

    System.out.println(str);
  }

  public static void main()
  {
    EliminationGame.readme();

    int n;
    //Input: n = 9
    // Output: 6
    n = 9;
    System.out.println("lastRemaining(" + n + ") = " + lastRemaining(n));

    //Input: n = 1
    // Output: 1
    n = 1;
    System.out.println("lastRemaining(" + n + ") = " + lastRemaining(n));

  }
}