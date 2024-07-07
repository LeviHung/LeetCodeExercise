// Levi Hung
// 06/24/2024
// LeetCode Exercise

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

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
import easy.RemoveDuplicateSortedList;
import easy.MergeSortedArray;
import easy.BinaryTreeInorderTraversal;
import easy.TreeNode;
import easy.SameTree;
import easy.SymmetricTree;
import easy.MaximumDepthBinaryTree;
import easy.SortedArrayToBinarySearchTree;
import easy.BalancedBinaryTree;
import easy.MinimumDepthBinaryTree;
import easy.PathSum;
import easy.PascalsTriangle;
import easy.PascalsTriangleII;
import easy.BestTimeBuySellStock;
import easy.ValidPalindrome;
import easy.SingleNumber;
import easy.LinkedListCycle;
import easy.BinaryTreePreorderTraversal;
import easy.BinaryTreePostorderTraversal;
import easy.IntersectionTwoLinkedLists;
import easy.ExcelSheetColumnTitle;
import easy.MajorityElement;
import easy.ExcelSheetColumnNumber;
import easy.CombineTwoTables;
import easy.EmployeesEarnMoreThanManagers;
import easy.DuplicateEmails;
import easy.CustomersWhoNeverOrder;
import easy.ReverseBits;
import easy.NumberOfOneBits;
import easy.ValidPhoneNumbers;

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
              case 83:
                removeDuplicateSortedList();
                break;
              case 88:
                mergeSortedArray();
                break;
              case 94:
                binaryTreeInorderTraversal();
                break;
              case 100:
                sameTree();
                break;
              case 101:
                symmetricTree();
                break;
              case 104:
                maximumDepthBinaryTree();
                break;
              case 108:
                sortedArrayToBST();
                break;
              case 110:
                balancedBinaryTree();
                break;
              case 111:
                minimumDepthBinaryTree();
                break;
              case 112:
                pathSum();
                break;
              case 118:
                pascalsTriangle();
                break;
              case 119:
                pascalsTriangleII();
                break;
              case 121:
                bestTimeBuySellStock();
                break;
              case 125:
                validPalindrome();
                break;
              case 136:
                singleNumber();
                break;
              case 141:
                linkedListCycle();
                break;
              case 144:
                binaryTreePreorderTraversal();
                break;
              case 145:
                binaryTreePostorderTraversal();
                break;
              case 160:
                IntersectionTwoLinkedLists.main();
                break;
              case 168:
                ExcelSheetColumnTitle.main();
                break;
              case 169:
                MajorityElement.main();
                break;
              case 171:
                ExcelSheetColumnNumber.main();
                break;
              case 175:
                CombineTwoTables.main();
                break;
              case 181:
                EmployeesEarnMoreThanManagers.main();
                break;
              case 182:
                DuplicateEmails.main();
                break;
              case 183:
                CustomersWhoNeverOrder.main();
                break;
              case 190:
                ReverseBits.main();
                break;
              case 191:
                NumberOfOneBits.main();
                break;
              case 193:
                ValidPhoneNumbers.main();
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
            displayEasyPremiumMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 157:
                System.out.println("Subscribe to unlock.");
                break;
              case 163:
                System.out.println("Subscribe to unlock.");
                break;
              case 170:
                System.out.println("Subscribe to unlock.");
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
        case 4:
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
    System.out.println("2. Easy Premium");
    System.out.println("3. Medium");
    System.out.println("4. Hard");
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
    System.out.println("83. Remove Duplicates for Sorted List");
    System.out.println("88. Merge Sorted Array");
    System.out.println("94. Binary Tree Inorder Traversal");
    System.out.println("100. Same Tree");
    System.out.println("101. Symmetric Tree");
    System.out.println("104. Maximum Depth Binary Tree");
    System.out.println("108. Sorted Array To Binary Search Tree");
    System.out.println("110. Balanced Binary Tree");
    System.out.println("111. Minimum Depth Binary Tree");
    System.out.println("112. Path Sum");
    System.out.println("118. PascalsTriangle");
    System.out.println("119. PascalsTriangleII");
    System.out.println("121. Best Time to Buy and Sell Stock");
    System.out.println("125. Valid Palindrome");
    System.out.println("136. Single Number");
    System.out.println("141. Linked List Cycle");
    System.out.println("144. Binary Tree Preorder Traversal");
    System.out.println("145. Binary Tree Postorder Traversal");
    System.out.println("160. Intersection of Two Linked Lists");
    System.out.println("168. Excel Sheet Column Title");
    System.out.println("169. Majority Element");
    System.out.println("171. Excel Sheet Column Number");
    System.out.println("175. Combine Two Tables");
    System.out.println("181. Employees Earn More Than Managers");
    System.out.println("182. Duplicate Emails");
    System.out.println("183. Customers Who Never Order");
    System.out.println("190. Reverse Bits");
    System.out.println("191. Number Of One Bits");
    System.out.println("193. Valid Phone Numbers");      
    System.out.println("0. Go Back");
    System.out.println("----------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displayEasyPremiumMenu()
  {
    System.out.println("\n--------------- Easy Premium -----------");
    System.out.println("157. Read n Characters Given Read4");
    System.out.println("163. Missing Ranges");
    System.out.println("170. Two Sum III Date Structure");
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

  public static void removeDuplicateSortedList()
  {
    RemoveDuplicateSortedList.readme();

    // list1 = [1, 2, 4], list2 = [1, 3, 4]
    ListNode node = new ListNode(2);
    node = new ListNode(1, node);
    ListNode list1 = new ListNode(1, node);

    System.out.println("List 1: ");
    list1.show();

    System.out.println("deleteDuplicates(list1): ");
    ListNode list2 = RemoveDuplicateSortedList.deleteDuplicates(list1);
    list2.show();

    node = new ListNode(3);
    node = new ListNode(3, node);
    node = new ListNode(2, node);
    node = new ListNode(1, node);
    ListNode list3 = new ListNode(1, node);

    System.out.println("List 2: ");
    list3.show();

    System.out.println("deleteDuplicates(list2): ");
    ListNode list4 = RemoveDuplicateSortedList.deleteDuplicates(list3);
    list4.show();
  }

  public static void mergeSortedArray()
  {
    MergeSortedArray.readme();

    //nums1 = [1,2,3,0,0,0], m = 3, nums2 = [2,5,6], n = 3
    int [] nums1 = {1, 2, 3, 0, 0, 0};
    int m = 3;
    int [] nums2 = {2, 5, 6};
    int n = 3;

    System.out.print("merge(" + Arrays.toString(nums1) + ", " + 
                       Arrays.toString(nums2) + ") = ");
    MergeSortedArray.merge(nums1, m, nums2, n);

    System.out.println(Arrays.toString(nums1));

    // nums1 = [1], m = 1, nums2 = [], n = 0
    int [] nums3 = {1};
    m = 1;
    int [] nums4 = {};
    n = 0;

    System.out.print("merge(" + Arrays.toString(nums3) + ", " + 
                       Arrays.toString(nums4) + ") = ");
    MergeSortedArray.merge(nums3, m, nums4, n);

    System.out.println(Arrays.toString(nums3));

    // nums1 = [0], m = 0, nums2 = [1], n = 1
    int [] nums5 = {0};
    m = 0;
    int [] nums6 = {1};
    n = 1;

    System.out.print("merge(" + Arrays.toString(nums5) + ", " + 
                       Arrays.toString(nums6) + ") = ");
    MergeSortedArray.merge(nums5, m, nums6, n);

    System.out.println(Arrays.toString(nums5));

    int [] nums7 = {2, 0};
    m = 1;
    int [] nums8 = {1};
    n = 1;

    System.out.print("merge(" + Arrays.toString(nums7) + ", " + 
                       Arrays.toString(nums8) + ") = ");
    MergeSortedArray.merge(nums7, m, nums8, n);

    System.out.println(Arrays.toString(nums7));

  }


  public static void binaryTreeInorderTraversal()
  {
    BinaryTreeInorderTraversal.readme();

    //  root = [1,null,2,3] => [1,3,2]
    TreeNode node = new TreeNode(3);
    node = new TreeNode(2, node, null);
    TreeNode tree1 = new TreeNode(1, null, node);

    System.out.println("Tree 1: ");
    tree1.show();
    List <Integer> list1 = BinaryTreeInorderTraversal.inorderTraversal(tree1);
    System.out.println(list1);

    //  root = [] => []
    TreeNode tree2 = new TreeNode();

    System.out.println("Tree 2: ");
    tree2.show();
    List <Integer> list2 = BinaryTreeInorderTraversal.inorderTraversal(tree2);
    System.out.println(list2);
    
    // root = [1] => [1]
    TreeNode tree3 = new TreeNode(1);

    System.out.println("Tree 3: ");
    tree3.show();
    List <Integer> list3 = BinaryTreeInorderTraversal.inorderTraversal(tree3);
    System.out.println(list3);

  }

  public static void sameTree()
  {
    SameTree.readme();

    //  root = [1,null,2,3] => [1,3,2]
    TreeNode node2 = new TreeNode(2);
    TreeNode node3 = new TreeNode(3);
    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");
      
    TreeNode node4 = new TreeNode(2);
    TreeNode node5 = new TreeNode(3);
    TreeNode tree2 = new TreeNode(1, node4, node5);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    SameTree.isSameTree(tree1, tree2);

    System.out.println("isSameTree(tree1, tree2) = " +  
                     SameTree.isSameTree(tree1, tree2));


    TreeNode node6 = new TreeNode(2);
    TreeNode tree3 = new TreeNode(1, node6, null);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    TreeNode node7 = new TreeNode(2);
    TreeNode tree4 = new TreeNode(1, null, node7);

    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    SameTree.isSameTree(tree3, tree4);

    System.out.println("isSameTree(tree3, tree4) = " +  
                     SameTree.isSameTree(tree3, tree4));

  }

  public static void symmetricTree()
  {
    SymmetricTree.readme();

    //  root = [1,2,2,3,4,4,3] => true
    TreeNode node4 = new TreeNode(3);
    TreeNode node5 = new TreeNode(4);
    TreeNode node6 = new TreeNode(4);
    TreeNode node7 = new TreeNode(3);
    TreeNode node2 = new TreeNode(2, node4, node5);
    TreeNode node3 = new TreeNode(2, node6, node7);
    TreeNode tree1 = new TreeNode(1, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("isSymmetric(tree1) = " +  
                       SymmetricTree.isSymmetric(tree1));

    // root = [1,2,2,null,3,null,3] => false
    node4 = new TreeNode(3);
    node5 = new TreeNode(3);
    node2 = new TreeNode(2, null, node4);
    node3 = new TreeNode(2, null, node5);
    TreeNode tree2 = new TreeNode(1, node2, node3);
    tree2.show();
    System.out.println("");
    System.out.println("isSymmetric(tree2) = " +  
                       SymmetricTree.isSymmetric(tree2));

  }

  public static void maximumDepthBinaryTree()
  {
    MaximumDepthBinaryTree.readme();

    // root = [3,9,20,null,null,15,7] => 3
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20, node4, node5);
    TreeNode tree1 = new TreeNode(3, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("maxDepth(tree1) = " +  
                       MaximumDepthBinaryTree.maxDepth(tree1));

    // root = [1,null,2] => 2
    node2 = new TreeNode(2);
    TreeNode tree2 = new TreeNode(1, null, node2);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("maxDepth(tree2) = " +  
                       MaximumDepthBinaryTree.maxDepth(tree2));

    // root = [1,null,2] => 2
    node2 = new TreeNode(2);
    TreeNode tree3 = new TreeNode(1, node2, null);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("maxDepth(tree3) = " +  
                       MaximumDepthBinaryTree.maxDepth(tree3));

  }

  public static void sortedArrayToBST()
  {
    SortedArrayToBinarySearchTree.readme();

    //nums1 = [-10,-3,0,5,9], => [0,-3,9,-10,null,5]
    int [] nums1 = {-10,-3,0,5,9};

    System.out.print("sortedArrayToBST(" + Arrays.toString(nums1) + 
                     ") = ");
    TreeNode tree1 = SortedArrayToBinarySearchTree.sortedArrayToBST(nums1);

    tree1.show();
    System.out.println("");

    tree1 = SortedArrayToBinarySearchTree.sortedArrayToBSTOpt(nums1);

    tree1.show();
    System.out.println("");

  }

  public static void balancedBinaryTree()
  {
    BalancedBinaryTree.readme();

    // root = [3,9,20,null,null,15,7] => true
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20, node4, node5);
    TreeNode tree1 = new TreeNode(3, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("isBalanced(tree1) = " +  
                       BalancedBinaryTree.isBalanced(tree1));

    
    // root = [1,2,2,3,3,null,null,4,4] => false
    TreeNode node6 = new TreeNode(4);
    TreeNode node7 = new TreeNode(4);
    node4 = new TreeNode(3, node6, node7);
    node5 = new TreeNode(3);
    node2 = new TreeNode(2, node4,node5);
    node3 = new TreeNode(2);
    TreeNode tree2 = new TreeNode(1, node2, node3);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("isBalanced(tree2) = " +  
                       BalancedBinaryTree.isBalanced(tree2));


    // [1,null,2,null,3]
    node3 = new TreeNode(3);
    node2 = new TreeNode(2, null, node3);
    TreeNode tree3 = new TreeNode(1, null, node2);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("isBalanced(tree3) = " +  
                       BalancedBinaryTree.isBalanced(tree3));

    // [1,2,3,4,5,6,null,8] => true
    //          1
    //      2       3
    //   4    5   6 
    // 8
    node7 = new TreeNode(8);
    node4 = new TreeNode(4, node7, null);
    node5 = new TreeNode(5);
    node2 = new TreeNode(2, node4, node5);
    node6 = new TreeNode(6);
    node3 = new TreeNode(3, node6, null);
    TreeNode tree4 = new TreeNode(1, node2, node3);
    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    System.out.println("isBalanced(tree4) = " +  
                       BalancedBinaryTree.isBalanced(tree4));
  
  }

  public static void minimumDepthBinaryTree()
  {
    MinimumDepthBinaryTree.readme();

    // root = [3,9,20,null,null,15,7] => 3
    TreeNode node4 = new TreeNode(15);
    TreeNode node5 = new TreeNode(7);
    TreeNode node2 = new TreeNode(9);
    TreeNode node3 = new TreeNode(20, node4, node5);
    TreeNode tree1 = new TreeNode(3, node2, node3);

    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("minDepth(tree1) = " +  
                       MinimumDepthBinaryTree.minDepth(tree1));

    // root = [1,null,2] => 2
    node2 = new TreeNode(2);
    TreeNode tree2 = new TreeNode(1, null, node2);

    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("minDepth(tree2) = " +  
                       MinimumDepthBinaryTree.minDepth(tree2));

    // root = [1,null,2] => 2
    node2 = new TreeNode(2);
    TreeNode tree3 = new TreeNode(1, node2, null);

    System.out.print("Tree 3: ");
    tree3.show();
    System.out.println("");

    System.out.println("minDepth(tree3) = " +  
                       MinimumDepthBinaryTree.minDepth(tree3));

    // root = [2,null,3,null,4,null,5,null,6]
    // 2
    //  3
    //   4
    //    5
    //     6
    TreeNode node6 = new TreeNode(6);
    node5 = new TreeNode(5, null, node6);
    node4 = new TreeNode(4, null, node5);
    node3 = new TreeNode(3, null, node4);
    TreeNode tree4 = new TreeNode(2, null, node3);

    System.out.print("Tree 4: ");
    tree4.show();
    System.out.println("");

    System.out.println("minDepth(tree4) = " +  
                       MinimumDepthBinaryTree.minDepth(tree4));

    System.out.println("minDepthOpt(tree4) = " +  
                       MinimumDepthBinaryTree.minDepthOpt(tree4));

  }

  public static void pathSum()
  {
    PathSum.readme();

    // root = [5,4,8,11,null,13,4,7,2,null,null,null,1], targetSum = 22
    //                  5
    //            4            8
    //        11           13      4 
    //      7    2                    1

    TreeNode node7 = new TreeNode(7);
    TreeNode node8 = new TreeNode(2);
    TreeNode node4 = new TreeNode(11, node7, node8);
    TreeNode node2 = new TreeNode(4, node4, null);
    TreeNode node9 = new TreeNode(1);
    TreeNode node6 = new TreeNode(4, null, node9);
    TreeNode node5 = new TreeNode(13);
    TreeNode node3 = new TreeNode(8, node5, node6);
    TreeNode tree1 = new TreeNode(5, node2, node3);
    int targetSum = 22;
    
    System.out.print("Tree 1: ");
    tree1.show();
    System.out.println("");

    System.out.println("minDepth(tree1, " + targetSum + ") = " +  
                       PathSum.hasPathSum(tree1, targetSum));

    // root = [1,2,3], targetSum = 5
    //    1
    //  2   3
    node2 = new TreeNode(2);
    node3 = new TreeNode(3);
    TreeNode tree2 = new TreeNode(1, node2, node3);
    targetSum = 5;
    System.out.print("Tree 2: ");
    tree2.show();
    System.out.println("");

    System.out.println("minDepth(tree2, " + targetSum + ") = " +  
                       PathSum.hasPathSum(tree2, targetSum));

    // Input: root = [], targetSum = 0
    TreeNode tree3 = null;
    targetSum = 0;
    System.out.print("Tree 3: ");
    //tree3.show();
    System.out.println("");

    System.out.println("minDepth(tree3, " + targetSum + ") = " +  
                       PathSum.hasPathSum(tree3, targetSum));

  }


  public static void pascalsTriangle()
  {
    PascalsTriangle.readme();

    // numRows = 5 => [[1],[1,1],[1,2,1],[1,3,3,1],[1,4,6,4,1]]
    int numRows = 5;
    System.out.println("generate(" + numRows + ") = ");
    List<List<Integer>> list1 = PascalsTriangle.generate(numRows);
    System.out.println(Arrays.toString(list1.toArray()));
    
    // numRows = 1 => [[1]]
    numRows = 1;
    System.out.println("generate(" + numRows + ") = ");
    List<List<Integer>> list2 = PascalsTriangle.generate(numRows);
    System.out.println(Arrays.toString(list2.toArray()));

    numRows = 20;
    System.out.println("generateOpt(" + numRows + ") = ");
    List<List<Integer>> list3 = PascalsTriangle.generateOpt(numRows);
    System.out.println(Arrays.toString(list3.toArray()));

  }

  public static void pascalsTriangleII()
  {
    PascalsTriangleII.readme();

    // rowIndex = 3 => [1,3,3,1]
    int rowIndex = 3;
    System.out.print("getRow(" + rowIndex + ") = ");
    List<Integer> list1 = PascalsTriangleII.getRow(rowIndex);
    System.out.println(Arrays.toString(list1.toArray()));

    // rowIndex = 0 => [[1]]
    rowIndex = 1;
    System.out.print("getRow(" + rowIndex + ") = ");
    List<Integer> list2 = PascalsTriangleII.getRow(rowIndex);
    System.out.println(Arrays.toString(list2.toArray()));

    rowIndex = 4;
    System.out.print("getRow(" + rowIndex + ") = ");
    List<Integer> list3 = PascalsTriangleII.getRow(rowIndex);
    System.out.println(Arrays.toString(list3.toArray()));

    rowIndex = 30;
    System.out.print("getRow(" + rowIndex + ") = ");
    List<Integer> list4 = PascalsTriangleII.getRow(rowIndex);
    System.out.println(Arrays.toString(list4.toArray()));
  }

  public static void bestTimeBuySellStock()
  {
    BestTimeBuySellStock.readme();

    
    // prices = [7,1,5,3,6,4] => 5
    int [] prices1 = {7,1,5,3,6,4};

    System.out.println("maxProfit(" + Arrays.toString(prices1) + 
                     ") = " + BestTimeBuySellStock.maxProfit(prices1));

    //prices = [7,6,4,3,1] => 0
    int [] prices2 = {7,6,4,3,1};
    System.out.println("maxProfit(" + Arrays.toString(prices2) + 
     ") = " + BestTimeBuySellStock.maxProfit(prices2));

    
    int [] prices3 = {1,4,1,4,3,1};
    System.out.println("maxProfit(" + Arrays.toString(prices3) + 
          ") = " + BestTimeBuySellStock.maxProfit(prices3));
    
    
    int [] prices4 = {2, 4, 1};
    System.out.println("maxProfit(" + Arrays.toString(prices4) + 
         ") = " + BestTimeBuySellStock.maxProfit(prices4));

    
    int [] prices5 = {3,3,5,0,0,3,1,4};
    System.out.println("maxProfit(" + Arrays.toString(prices5) + 
         ") = " + BestTimeBuySellStock.maxProfit(prices5));
    
  }

  public static void validPalindrome()
  {
    ValidPalindrome.readme();
    // s = "A man, a plan, a canal: Panama"
    String s = "A man, a plan, a canal: Panama"; 
    System.out.println("isPalindrome(" + s + ") = " + 
                        ValidPalindrome.isPalindrome(s));

    // s = "race a car"
    s = "race a car";
    System.out.println("isPalindrome(" + s + ") = " + 
    ValidPalindrome.isPalindrome(s));

    // s = " "
    s = " ";
    System.out.println("isPalindrome(" + s + ") = " + 
    ValidPalindrome.isPalindrome(s));
  }


  public static void singleNumber()
  {
    SingleNumber.readme();

    //nums = [2,2,1] => 1
    int [] nums = {1, 1, 2};
    System.out.println("singleNumber(" + Arrays.toString(nums) + 
     ") = " + SingleNumber.singleNumber(nums));

    //nums = [4,1,2,1,2] => 4
    int [] nums2 = {4,1,2,1,2};
    System.out.println("singleNumber(" + Arrays.toString(nums2) + 
     ") = " + SingleNumber.singleNumber(nums2));

    //nums = [1] => 1
    int [] nums3 = {1};
    System.out.println("singleNumber(" + Arrays.toString(nums3) + 
     ") = " + SingleNumber.singleNumber(nums3));

  }


  public static void linkedListCycle()
  {
    LinkedListCycle.readme();

    // [3,2,0,-4], pos = 1 => true
    ListNode node4;
    ListNode node3;
    ListNode node2 = null;

    node4 = new ListNode(-4);
    node3 = new ListNode(0, node4);
    node2 = new ListNode(2, node3);
    node4.setNext(node2);
    ListNode list1 = new ListNode(3, node2);

    System.out.println("List 1: ");
    list1.show();

    System.out.println("hasCycleOpt(list1) = " + 
                       LinkedListCycle.hasCycleOpt(list1));

    // [1,2]
    node2 = new ListNode(2);
    ListNode list2 = new ListNode(1, node2);
    node2.setNext(list2);

    System.out.println("List 2: ");
    list2.show();

    System.out.println("hasCycle(list2) = " + 
                       LinkedListCycle.hasCycle(list2));

    ListNode list3 = new ListNode(1);

    System.out.println("List 3: ");
    list3.show();

    System.out.println("hasCycle(list3) = " + 
                       LinkedListCycle.hasCycle(list3));

  }

  public static void binaryTreePreorderTraversal()
  {
    BinaryTreePreorderTraversal.readme();

    //  root = [1,null,2,3] => [1,3,2]
    TreeNode node = new TreeNode(3);
    node = new TreeNode(2, node, null);
    TreeNode tree1 = new TreeNode(1, null, node);

    System.out.println("Tree 1: ");
    tree1.show();
    List <Integer> list1 = BinaryTreePreorderTraversal.preorderTraversal(tree1);
    System.out.println(list1);

    //  root = [] => []
    TreeNode tree2 = new TreeNode();

    System.out.println("Tree 2: ");
    tree2.show();
    List <Integer> list2 = BinaryTreePreorderTraversal.preorderTraversal(tree2);
    System.out.println(list2);

    // root = [1] => [1]
    TreeNode tree3 = new TreeNode(1);

    System.out.println("Tree 3: ");
    tree3.show();
    List <Integer> list3 = BinaryTreePreorderTraversal.preorderTraversal(tree3);
    System.out.println(list3);

  }

  public static void binaryTreePostorderTraversal()
  {
    BinaryTreePostorderTraversal.readme();

    //  root = [1,null,2,3] => [1,3,2]
    TreeNode node = new TreeNode(3);
    node = new TreeNode(2, node, null);
    TreeNode tree1 = new TreeNode(1, null, node);

    System.out.println("Tree 1: ");
    tree1.show();
    List <Integer> list1 = BinaryTreePostorderTraversal.postorderTraversal(tree1);
    System.out.println(list1);

    //  root = [] => []
    TreeNode tree2 = new TreeNode();

    System.out.println("Tree 2: ");
    tree2.show();
    List <Integer> list2 = BinaryTreePostorderTraversal.postorderTraversal(tree2);
    System.out.println(list2);

    // root = [1] => [1]
    TreeNode tree3 = new TreeNode(1);

    System.out.println("Tree 3: ");
    tree3.show();
    List <Integer> list3 = BinaryTreePostorderTraversal.postorderTraversal(tree3);
    System.out.println(list3);
  }

  public static void intersectionTwoLinkedLists()
  {
    IntersectionTwoLinkedLists.readme();

    // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], => 8
    ListNode node2;
    ListNode node3;
    ListNode node4;
    ListNode node5;
    ListNode node6;

    
    node6 = new ListNode(5);
    node5 = new ListNode(4, node6);
    node4 = new ListNode(8, node5);
    node2 = new ListNode(1, node4);
    ListNode list1 = new ListNode(4, node2);

    System.out.println("List 1: ");
    list1.show();

    //node6 = new ListNode(5);
    //node5 = new ListNode(4, node6);
    //node4 = new ListNode(8, node5);
    node3 = new ListNode(1, node4);
    node2 = new ListNode(6, node3);
    ListNode list2 = new ListNode(5, node2);

    System.out.println("List 2: ");
    list2.show();

    System.out.println("getIntersectionNodeOpt(list1, list2): ");
    ListNode list3 = IntersectionTwoLinkedLists.getIntersectionNodeOpt(list1, list2);
    System.out.println("List 3: ");
    list3.show();
    System.out.println("");

    // listA = [1,9,1,2,4], listB = [3,2,4],

    node5 = new ListNode(4);
    node4 = new ListNode(2, node5);
    node3 = new ListNode(1, node4);
    node2 = new ListNode(9, node3);
    ListNode list4 = new ListNode(1, node2);
    System.out.println("List 4: ");
    list4.show();

    ListNode list5 = new ListNode(3, node4);
    System.out.println("List 5: ");
    list5.show();
    
    System.out.println("getIntersectionNode(list4, list5): ");
    ListNode list6 = IntersectionTwoLinkedLists.getIntersectionNode(list4, list5);
    System.out.println("List 6: ");
    if (list6 == null) {
      System.out.println("The two lists do not intersect.");
    } else {
      list6.show();
    }
    System.out.println("");
    
    // listA = [2,6,4], listB = [1,5],
    node3 = new ListNode(4);
    node2 = new ListNode(6, node3);
    ListNode list7 = new ListNode(2, node2);
    System.out.println("List 7: ");
    list7.show();

    node2 = new ListNode(5);
    ListNode list8 = new ListNode(1, node2);
    System.out.println("List 8: ");
    list8.show();
    System.out.println("getIntersectionNode(list7, list8): ");
    System.out.println("List 9: ");
    ListNode list9 = IntersectionTwoLinkedLists.getIntersectionNode(list7, list8);
    if (list9 == null) {
      System.out.println("The two lists do not intersect.");
    } else {
      list9.show();
    }
  }
}
