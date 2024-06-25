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

    public static boolean isPalindromeOpt(int x) 
    {
        if (x <= 0 || x % 10 == 0) {
            return false;
        }

        int origNumber = x;
        int reverseNumber = 0;
    
        while (x > 0) {
            int digit = x % 10;
            reverseNumber = reverseNumber * 10 + digit;
            x /= 10;
        }

        if (reverseNumber == origNumber) {
            return true;

        } else {
            return false;
        }
    }

    public static void readme()
    {
        String str = "Given an integer x, return true if x is a palindrome, and false otherwise.\n";

        System.out.println(str);
    }
}