package easy;

public class PalindromeNumber 
{
    public static boolean isPalindrome(int x) 
    {
        if (x < 0) {
            return false;
        }

        int tenNum = 1;
        int origNum = x;
        while ((origNum / 10) > 0) {
            tenNum ++;
            origNum /= 10;
        }
       
        int [] array = new int [tenNum];
        for (int i = 0; i < tenNum; i++) {
            array[i] = x % 10;
            x /= 10;
        }

        for (int i = 0, j = tenNum - 1; i < j; i++, j--) {
            if (array[i] != array[j]) {
                return false;
            }
        }
        return true;
    }
}