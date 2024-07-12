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
import easy.TenthLine;
import easy.DeleteDuplicateEmails;
import easy.RisingTemperature;
import easy.HappyNumber;
import easy.RemoveLinkedListElements;
import easy.IsomorphicStrings;
import easy.ReverseLinkedList;
import easy.ContainsDuplicate;
import easy.ContainsDuplicateII;
import easy.CountCompleteTreeNodes;
import easy.StackUsingQueues;
import easy.InvertBinaryTree;
import easy.SummaryRanges;
import easy.PowerOfTwo;
import easy.QueueUsingStacks;
import easy.PalindromeLinkedList;
import easy.ValidAnagram;
import easy.BinaryTreePaths;
import easy.AddDigits;
import easy.UglyNumber;
import easy.MissingNumber;
import easy.FirstBadVersion;
import easy.MoveZeroes;
import easy.WordPattern;
import easy.NimGame;
import easy.RangeSumQuery;
import math.PowerOfThree;

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
                TwoSum.main();
                break;
              case 9:
                PalindromeNumber.main();
                break;
              case 13:
                RomanToInteger.main();
                break;
              case 14:
                LongestCommonPrefix.main();
                break;
              case 20:
                ValidParentheses.main();
                break;
              case 21:
                MergeTwoSortedLists.main();
                break;
              case 26:
                RemoveDuplicateSortedArray.main();
                break;
              case 27:
                RemoveElement.main();
                break;
              case 28:
                FirstOccurrenceString.main();
                break;
              case 35:
                SearchInsertPosition.main();
                break;
              case 58:
                LengthOfLastWord.main();
                break;
              case 66:
                PlusOne.main();
                break;
              case 67:
                AddBinary.main();
                break;
              case 69:
                Sqrt.main();
                break;
              case 70:
                ClimbingStairs.main();
                break;
              case 83:
                RemoveDuplicateSortedList.main();
                break;
              case 88:
                MergeSortedArray.main();
                break;
              case 94:
                BinaryTreeInorderTraversal.main();
                break;
              case 100:
                SameTree.main();
                break;
              case 101:
                SymmetricTree.main();
                break;
              case 104:
                MaximumDepthBinaryTree.main();
                break;
              case 108:
                SortedArrayToBinarySearchTree.main();
                break;
              case 110:
                BalancedBinaryTree.main();
                break;
              case 111:
                MinimumDepthBinaryTree.main();
                break;
              case 112:
                PathSum.main();
                break;
              case 118:
                PascalsTriangle.main();
                break;
              case 119:
                PascalsTriangleII.main();
                break;
              case 121:
                BestTimeBuySellStock.main();
                break;
              case 125:
                ValidPalindrome.main();
                break;
              case 136:
                SingleNumber.main();
                break;
              case 141:
                LinkedListCycle.main();
                break;
              case 144:
                BinaryTreePreorderTraversal.main();
                break;
              case 145:
                BinaryTreePostorderTraversal.main();
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
              case 195:
                TenthLine.main();
                break;
              case 196:
                DeleteDuplicateEmails.main();
                break;
              case 197:
                RisingTemperature.main();
                break;
              case 202:
                HappyNumber.main();
                break;
              case 203:
                RemoveLinkedListElements.main();
                break;
              case 205:
                IsomorphicStrings.main();
                break;
              case 206:
                ReverseLinkedList.main();
                break;
              case 217:
                ContainsDuplicate.main();
                break;
              case 219:
                ContainsDuplicateII.main();
                break;
              case 222:
                CountCompleteTreeNodes.main();
                break;
              case 225:
                StackUsingQueues.main();
                break;
              case 226:
                InvertBinaryTree.main();
                break;
              case 228:
                SummaryRanges.main();
                break;  
              case 231:
                PowerOfTwo.main();
                break;
              case 232:
                QueueUsingStacks.main();
                break;
              case 233:
                PalindromeLinkedList.main();
                break;
              case 242:
                ValidAnagram.main();
                break;
              case 257:
                BinaryTreePaths.main();
                break;
              case 258:
                AddDigits.main();
                break;
              case 263:
                UglyNumber.main();
                break;
              case 268:
                MissingNumber.main();
                break;
              case 278:
                FirstBadVersion.main();
                break;
              case 283:
                MoveZeroes.main();
                break;
              case 290:
                WordPattern.main();
                break;
              case 292:
                NimGame.main();
                break;
              case 303:
                RangeSumQuery.main();
                break;
              case 326:
                PowerOfThree.main();
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
              case 243:
                System.out.println("Subscribe to unlock.");
                break;
              case 246:
                System.out.println("Subscribe to unlock.");
                break;
              case 252:
                System.out.println("Subscribe to unlock.");
                break;
              case 266:
                System.out.println("Subscribe to unlock.");
                break;
              case 270:
                System.out.println("Subscribe to unlock.");
                break;
              case 293:
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
    System.out.println("...");
    /*
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
    System.out.println("195. Tenth Line");    
    System.out.println("196. Delete Duplicate Emails");    
    System.out.println("197. Rising Temperature");  
    System.out.println("202. Happy Number");
    System.out.println("203. Remove Linked List Elements");
    System.out.println("205. Isomorphic Strings");
    System.out.println("206. Reverse Linked List");
    System.out.println("217. Contains Duplicate");
    System.out.println("219. Contains Duplicate II");
    System.out.println("222. Count Complete Tree Nodes");
    System.out.println("225. Implement Stack Using Queues");
    System.out.println("226. Invert Binary Tree");
    System.out.println("228. Summary Ranges");
    System.out.println("231. Power Of Two");
    System.out.println("232. Implelemt Queue Using Stacks");
    System.out.println("233. Palindrome Linked List");
    System.out.println("242. Valid Anagram");
    System.out.println("257. Binary Tree Paths");
    System.out.println("258. Add Digits");
    System.out.println("263. Ugly Number");
    System.out.println("268. Missing Number");
    System.out.println("278. First Bad Version");
    System.out.println("283. Move Zeroes");
    System.out.println("290. Word Pattern");
    System.out.println("292. Nim Game");
    */
    System.out.println("303. Range Sum Query");
    System.out.println("326. Power Of Three");
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
    System.out.println("243. Shortest Word Distance");
    System.out.println("246. Strobogrammatic Number");
    System.out.println("252. Meeting Rooms");
    System.out.println("266. Palindrome Permutation");
    System.out.println("270. Closest Binary Search Tree Value");
    System.out.println("293. Flip Game");
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
}
