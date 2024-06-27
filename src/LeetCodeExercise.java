// Levi Hung
// 06/24/2024
// LeetCode Exercise

import java.util.Scanner;
import java.util.Arrays;

import easy.TwoSum;
import easy.PalindromeNumber;
import easy.RomanToInteger;
import easy.LongestCommonPrefix;
import easy.ValidParentheses;
import easy.MergeTwoSortedLists;
import easy.ListNode;
import easy.RemoveDuplicateSortedArray;
import easy.RemoveElement;
import easy.FirstOccurrenceString;
import easy.SearchInsertPosition;
import easy.LengthOfLastWord;
import easy.PlusOne;
import easy.AddBinary;
import easy.Sqrt;
import easy.ClimbingStairs;

class LeetCodeExercise 
{
  public static void main(String[] args)
  {
    int inputKey;
    int subKey;
    boolean result;

    // Create a Scanner object for keyboard input.
    Scanner keyboard = new Scanner(System.in);

    do {
      // Display a console menu. 
      displayMenu();

      // Get the user's input.
      inputKey = keyboard.nextInt();
      keyboard.nextLine();

      switch (inputKey) {
        case 1:
          do {
            displayEasyMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 1:
                twoSum();
                break;
              case 9:
                palindromeNumber();
                break;
              case 13:
                romanToInteger();
                break;
              case 14:
                longestCommonPrefix();
                break;
              case 20:
                validParentheses();
                break;
              case 21:
                mergeTwoSortedLists();
                break;
              case 26:
                removeDuplicateSortedArray();
                break;
              case 27:
                removeElement();
                break;
              case 28:
                findFirstOccurrenceString();
                break;
              case 35:
                searchInsertPosition();
                break;
              case 58:
                lengthOfLastWord();
                break;
              case 66:
                plusOne();
                break;
              case 67:
                addBinary();
                break;
              case 69:
                sqrt();
                break;
              case 70:
                climbingStairs();
                break;
              default:
                if (subKey != 0) {
                  System.out.println("Invalid Input!");
                }
                break;
            }
          } while (subKey != 0);
          break;         
        case 2:
          do {
            displayMediumMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 1:
                break;
              default:
                if (subKey != 0) {
                  System.out.println("Invalid Input!");
                }
                break;
            }
          } while (subKey != 0);
          break;   
        case 3:
          do {
            displayHardMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 1:
                break;
              default:
                if (subKey != 0) {
                  System.out.println("Invalid Input!");
                }
                break;
            }
          } while (subKey != 0);
          break;
        default:
          if (inputKey != 0) {
            System.out.println("Invalid Input!");
          }
          break;
      }
    } while (inputKey != 0);
  }

  /**
    * The displayMenu method displays a console menu.
    */
  public static void displayMenu()
  {
    System.out.println("\n============= Main Menu ================");
    System.out.println("1. Easy");
    System.out.println("2. Medium");
    System.out.println("3. Hard");
    System.out.println("0. Exit");
    System.out.println("========================================");
    System.out.print("Enter a choice: ");
  }

  public static void displayEasyMenu()
  {
    System.out.println("\n--------------- Easy -------------------");
    System.out.println("1. Two Sum");
    System.out.println("9. Palindrome Number");
    System.out.println("13. Roman to Integer");
    System.out.println("14. Longes Common Prefix");
    System.out.println("20. Valid Parentheses");
    System.out.println("21. Merge Two Sorted Lists");
    System.out.println("26. Remove Duplicates from Sorted Array");
    System.out.println("27. Remove Element");
    System.out.println("28. Find the First Occurrence String");
    System.out.println("35. Search Insert Position");
    System.out.println("58. Length of Last Word");
    System.out.println("66. Plus One");
    System.out.println("67. Add Binary");
    System.out.println("69. Sqrt");
    System.out.println("70. Climbing Stairs");
    System.out.println("0. Go Back");
    System.out.println("----------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displayMediumMenu()
  {
    System.out.println("\n--------------- Medium -----------------");
    System.out.println("0. Go Back");
    System.out.println("----------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displayHardMenu()
  {
    System.out.println("\n--------------- Hard -------------------");
    System.out.println("0. Go Back");
    System.out.println("----------------------------------------");
    System.out.print("Enter a choice: ");
  }
  
  public static void twoSum()
  {
    int [] nums = {2, 3, 4};
    int target = 6;

    TwoSum.readme();
    System.out.println("twoSum([2, 3, 4], 6) = " + 
                       TwoSum.twoSum(nums, target)[0] +
                       ", " +
                       TwoSum.twoSum(nums, target)[1]);

  }

  public static void palindromeNumber()
  {
    int num  = 121;

    PalindromeNumber.readme();
    System.out.println("isPalindrome((121)) = " + 
                       PalindromeNumber.isPalindrome(121));

    System.out.println("isPalindrome((123)) = " + 
                       PalindromeNumber.isPalindrome(123));

    System.out.println("isPalindromeOpt((121)) = " + 
       PalindromeNumber.isPalindromeOpt(121));

    System.out.println("isPalindromeOpt((123)) = " + 
       PalindromeNumber.isPalindromeOpt(123));

  }

  public static void romanToInteger()
  {
    RomanToInteger.readme();

    System.out.println("romanToInt(\"XXVII\") = " + 
                       RomanToInteger.romanToInt("XXVII"));
    System.out.println("romanToInt(\"MCMXCIV\") = " + 
                       RomanToInteger.romanToInt("MCMXCIV"));
  }

  public static void longestCommonPrefix()
  {
    LongestCommonPrefix.readme();

    String [] strs = {"flower", "flow", "flight"};

    System.out.println("longestCommonPrefix(" + Arrays.toString(strs) + 
                       ") = " + LongestCommonPrefix.longestCommonPrefix(strs));

    String [] strs2 = {"dog","racecar","car"};

    System.out.println("longestCommonPrefix(" + Arrays.toString(strs2) + 
                      ") = " + LongestCommonPrefix.longestCommonPrefix(strs2));
    
    String [] strs3 = {"ab","a"};

    System.out.println("longestCommonPrefix(" + Arrays.toString(strs3) + 
                   ") = " + LongestCommonPrefix.longestCommonPrefixOpt(strs3));
  }
  
  public static void validParentheses()
  {
    ValidParentheses.readme();

    String str = "()";

    System.out.println("isValid(" + str + ") = " + 
                       ValidParentheses.isValid(str));

    String str2 = "()[]{}";

    System.out.println("isValid(" + str2 + ") = " + 
                       ValidParentheses.isValid(str2));

    String str3 = "(]";

    System.out.println("isValid(" + str3 + ") = " + 
                       ValidParentheses.isValid(str3));

    
    String str4 = "{[]}";

    System.out.println("isValid(" + str4 + ") = " + 
                       ValidParentheses.isValid(str4));

    String str5 = "]";

    System.out.println("isValid(" + str5 + ") = " + 
                       ValidParentheses.isValid(str5));

    String str6 = "{[Str]}";

    System.out.println("isValid(" + str6 + ") = " + 
                       ValidParentheses.isValidOpt(str6));

  }

  public static void mergeTwoSortedLists()
  {
    MergeTwoSortedLists.readme();

    // list1 = [1, 2, 4], list2 = [1, 3, 4]
    ListNode node = new ListNode(4);
    node = new ListNode(2, node);
    ListNode list1 = new ListNode(1, node);

    System.out.println("List 1: ");
    list1.show();

    node = new ListNode(4);
    node = new ListNode(3, node);
    ListNode list2 = new ListNode(1, node);

    System.out.println("List 2: ");
    list2.show();

    System.out.println("mergeTwoLists(list1, list2): ");
    ListNode list3 = MergeTwoSortedLists.mergeTwoLists(list1, list2);
    list3.show();

    System.out.println("mergeTwoListsOpt(list1, list2): ");
ListNode list4 = MergeTwoSortedLists.mergeTwoListsOpt(list1, list2);
    list4.show();
  }

    public static void removeDuplicateSortedArray()
    {
      RemoveDuplicateSortedArray.readme();

      //nums = [1,1,2]
      int [] nums = {1, 1, 2};
      System.out.println("removeDuplicates(" + Arrays.toString(nums) + 
       ") = " + RemoveDuplicateSortedArray.removeDuplicates(nums) + 
       " " + Arrays.toString(nums));

      //[0,0,1,1,1,2,2,3,3,4]
      int [] nums2 = {0,0,1,1,1,2,2,3,3,4};
      System.out.println("removeDuplicates(" + Arrays.toString(nums2) + 
       ") = " + RemoveDuplicateSortedArray.removeDuplicates(nums2) + 
       " " + Arrays.toString(nums2));

    }

  public static void removeElement()
  {
    RemoveElement.readme();

    //nums = [1,1,2]
    int [] nums = {3,2,2,3};
    int val = 3;
    System.out.println("removeElement(" + Arrays.toString(nums) + 
     ", " + val + ") = " + RemoveElement.removeElement(nums, val) + 
     " " + Arrays.toString(nums));

    //[0,0,1,1,1,2,2,3,3,4]
    int [] nums2 = {0,1,2,2,3,0,4,2};
    int val2 = 2;
    System.out.println("removeDuplicates(" + Arrays.toString(nums2) + 
    ", " + val2 + ") = " + RemoveElement.removeElement(nums2, val2) + 
     " " + Arrays.toString(nums2));
  }

  public static void findFirstOccurrenceString()
  {
    FirstOccurrenceString.readme();
    String haystack = "sadbutsad"; 
    String needle = "sad";
    System.out.println("strStr(" + haystack + ", " + needle + 
      ") = " + FirstOccurrenceString.strStr(haystack, needle));

    haystack = "leetcode";
    needle = "leeto";

    System.out.println("strStr(" + haystack + ", " + needle + 
      ") = " + FirstOccurrenceString.strStr(haystack, needle));

    haystack = "mississippi";
    needle = "issip";

    System.out.println("strStr(" + haystack + ", " + needle + 
      ") = " + FirstOccurrenceString.strStr(haystack, needle));

    haystack = "a";
    needle = "a";

    System.out.println("strStr(" + haystack + ", " + needle + 
      ") = " + FirstOccurrenceString.strStr(haystack, needle));

    haystack = "aaa";
    needle = "aaaa";

    System.out.println("strStr(" + haystack + ", " + needle + 
      ") = " + FirstOccurrenceString.strStr(haystack, needle));

    haystack = "mississippi";
    needle = "sipp";

    System.out.println("strStr(" + haystack + ", " + needle + 
      ") = " + FirstOccurrenceString.strStr(haystack, needle));

    haystack = "mississippi";
    needle = "sipp";

    System.out.println("strStrOpt(" + haystack + ", " + needle + 
      ") = " + FirstOccurrenceString.strStrOpt(haystack, needle));

  }

  public static void searchInsertPosition()
  {
    SearchInsertPosition.readme();
    
    // nums = [1,3,5,6], target = 5 => 2
    int [] nums = {2,3,5,6};
    int target = 5;

    System.out.println("searchInsert(" + Arrays.toString(nums) + 
                ", " + target + ") = " + 
                SearchInsertPosition.searchInsert(nums, target));

    // nums = [1,3,5,6], target = 2 => 1
    int [] nums2 = {1,3,5,6};
    int target2 = 2;

    System.out.println("searchInsert(" + Arrays.toString(nums2) + 
                ", " + target2 + ") = " + 
                SearchInsertPosition.searchInsert(nums2, target2));

    // nums = [1,3,5,6], target = 7 => 4
    int [] nums3 = {1,3,5,6};
    int target3 = 7;

    System.out.println("searchInsert(" + Arrays.toString(nums3) + 
                ", " + target3 + ") = " + 
                SearchInsertPosition.searchInsert(nums3, target3));

    // nums = [1], target = 0 => 0
    int [] nums4 = {1};
    int target4 = 2;

    System.out.println("searchInsert(" + Arrays.toString(nums4) + 
                ", " + target4 + ") = " + 
                SearchInsertPosition.searchInsert(nums4, target4));

  }

  public static void lengthOfLastWord()
  {
    LengthOfLastWord.readme();

    // s = "Hello World" => 5
    String s = "Hello World";
    System.out.println("lengthOfLastWord(" + s + ") = " + 
                       LengthOfLastWord.lengthOfLastWord(s));

    // s = "   fly me   to   the moon  " => 4
    s = "   fly me   to   the moon  ";
    System.out.println("lengthOfLastWord(" + s + ") = " + 
     LengthOfLastWord.lengthOfLastWord(s));

    // s = "luffy is still joyboy" => 6
    s = "luffy is still joyboy";
    System.out.println("lengthOfLastWord(" + s + ") = " + 
     LengthOfLastWord.lengthOfLastWord(s));

    s = "a";
    System.out.println("lengthOfLastWord(" + s + ") = " + 
     LengthOfLastWord.lengthOfLastWord(s));

  }

  public static void plusOne()
  {
    PlusOne.readme();
    // digits = [1,2,3] => [1,2,4]
    int[] digits = {1, 2, 3};
    System.out.println("plusOne(" + Arrays.toString(digits) + ") = " + 
                       Arrays.toString(PlusOne.plusOne(digits)));

    // digits = [4,3,2,1] => [4,3,2,2]
    int[] digits2 = {4,3,2,1};
    System.out.println("plusOne(" + Arrays.toString(digits2) + ") = " + 
                       Arrays.toString(PlusOne.plusOne(digits2)));

    // digits = [9] => [1,0]
    int[] digits3 = {9};
    System.out.println("plusOne(" + Arrays.toString(digits3) + ") = " + 
                       Arrays.toString(PlusOne.plusOne(digits3)));

  }

  public static void addBinary()
  {
    AddBinary.readme();

    String a = "11";
    String b = "1";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));

    a = "0";
    b = "0";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));

    a = "0";
    b = "1";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));

    a = "1010";
    b = "1011";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));

    
    a =     "10100000100100110110010000010101111011011001101110111111111101000000101111001110001111100001101";
    b = "110101001011101110001111100110001010100001101011101010000011011011001011101111001100000011011110011";
    System.out.println("addBinaryEx(" + a + ", " + b + ") = " + 
                       AddBinary.addBinaryEx(a, b));

    System.out.println("addBinaryOpt(" + a + ", " + b + ") = " + 
     AddBinary.addBinaryOpt(a, b));
     
    }

  public static void sqrt()
  {
    Sqrt.readme();
    int a = 2147483647;
         // 2147483647
    // x = 4 => 2
    System.out.println("Sqrt(" + a + ") = " + Sqrt.mySqrt(a));

    // x = 8 => 2 (2.8)
  }

  public static void climbingStairs()
  {
    ClimbingStairs.readme();
    int n = 2;
    // n = 2 => 2
    System.out.println("climbStairs(" + n + ") = " + 
                       ClimbingStairs.climbStairs(n));

    n = 3;
    // n = 3 => 3
    System.out.println("climbStairs(" + n + ") = " +       
                       ClimbingStairs.climbStairs(n));

    n = 45;
    // n = 3 => 3
    System.out.println("climbStairs(" + n + ") = " +       
                       ClimbingStairs.climbStairs(n));

  }
}
