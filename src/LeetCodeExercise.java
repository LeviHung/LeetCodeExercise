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
}
