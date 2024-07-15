// Levi Hung
// 06/24/2024
// LeetCode Exercise

import java.util.Scanner;
import java.util.Arrays;
import java.util.List;

import array.TwoSum;
import array.RemoveDuplicateSortedArray;
import array.RemoveElement;
import array.MergeSortedArray;
import array.PascalsTriangle;
import array.PascalsTriangleII;
import array.BestTimeBuySellStock;
import array.SingleNumber;
import array.MajorityElement;
import array.ContainsDuplicate;
import array.ContainsDuplicateII;
import array.SummaryRanges;
import array.MissingNumber;
import array.MoveZeroes;
import array.RangeSumQuery;
import array.IntersectionTwoArrays;
import array.IntersectionTwoArraysII;

import string.RomanToInteger;
import string.LongestCommonPrefix;
import string.ValidParentheses;
import string.FirstOccurrenceString;
import string.LengthOfLastWord;
import string.AddBinary;
import string.ValidPalindrome;
import string.ReverseBits;
import string.IsomorphicStrings;
import string.ValidAnagram;
import string.WordPattern;
import string.ReverseString;
import string.ReverseVowelsString;

import math.PalindromeNumber;
import math.PlusOne;
import math.Sqrt;
import math.ClimbingStairs;
import math.ExcelSheetColumnTitle;
import math.ExcelSheetColumnNumber;
import math.NumberOfOneBits;
import math.HappyNumber;
import math.PowerOfTwo;
import math.AddDigits;
import math.UglyNumber;
import math.NimGame;
import math.PowerOfThree;
import math.CountingBits;
import math.PowerOfFour;
import math.ValidPerfectSquare;
import math.GuessNumberHigherLower;

import linkedlist.MergeTwoSortedLists;
import linkedlist.RemoveDuplicateSortedList;
import linkedlist.LinkedListCycle;
import linkedlist.IntersectionTwoLinkedLists;
import linkedlist.RemoveLinkedListElements;
import linkedlist.ReverseLinkedList;
import linkedlist.PalindromeLinkedList;

import tree.BinaryTreeInorderTraversal;
import tree.SameTree;
import tree.SymmetricTree;
import tree.MaximumDepthBinaryTree;
import tree.SortedArrayToBinarySearchTree;
import tree.BalancedBinaryTree;
import tree.MinimumDepthBinaryTree;
import tree.PathSum;
import tree.BinaryTreePreorderTraversal;
import tree.BinaryTreePostorderTraversal;
import tree.CountCompleteTreeNodes;
import tree.InvertBinaryTree;
import tree.BinaryTreePaths;

import stackqueue.StackUsingQueues;
import stackqueue.QueueUsingStacks;

import search.SearchInsertPosition;
import search.FirstBadVersion;

import database.CombineTwoTables;
import database.EmployeesEarnMoreThanManagers;
import database.DuplicateEmails;
import database.CustomersWhoNeverOrder;
import database.DeleteDuplicateEmails;
import database.RisingTemperature;

import shell.ValidPhoneNumbers;
import shell.TenthLine;

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
            displayArrayMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 1:
                TwoSum.main();
                break;
              case 26:
                RemoveDuplicateSortedArray.main();
                break;
              case 27:
                RemoveElement.main();
                break;
              case 88:
                MergeSortedArray.main();
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
              case 136:
                SingleNumber.main();
                break;
              case 169:
                MajorityElement.main();
                break;
              case 217:
                ContainsDuplicate.main();
                break;
              case 219:
                ContainsDuplicateII.main();
                break;
              case 228:
                SummaryRanges.main();
                break;  
              case 268:
                MissingNumber.main();
                break;
              case 283:
                MoveZeroes.main();
                break;
              case 303:
                RangeSumQuery.main();
                break;
              case 349:
                IntersectionTwoArrays.main();
                break;
              case 350:
                IntersectionTwoArraysII.main();
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
            displayStringMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 13:
                RomanToInteger.main();
                break;
              case 14:
                LongestCommonPrefix.main();
                break;
              case 20:
                ValidParentheses.main();
                break;
              case 28:
                FirstOccurrenceString.main();
                break;
              case 58:
                LengthOfLastWord.main();
                break;
              case 67:
                AddBinary.main();
                break;
              case 125:
                ValidPalindrome.main();
                break;
              case 190:
                ReverseBits.main();
                break;
              case 205:
                IsomorphicStrings.main();
                break;
              case 242:
                ValidAnagram.main();
                break;
              case 290:
                WordPattern.main();
                break;
              case 344:
                ReverseString.main();
                break;
              case 345:
                ReverseVowelsString.main();
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
            displayMathMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 9:
                PalindromeNumber.main();
                break;
              case 66:
                PlusOne.main();
                break;
              case 69:
                Sqrt.main();
                break;
              case 70:
                ClimbingStairs.main();
                break;
              case 168:
                ExcelSheetColumnTitle.main();
                break;
              case 171:
                ExcelSheetColumnNumber.main();
                break;
              case 191:
                NumberOfOneBits.main();
                break;
              case 202:
                HappyNumber.main();
                break;
              case 231:
                PowerOfTwo.main();
                break;
              case 258:
                AddDigits.main();
                break;
              case 263:
                UglyNumber.main();
                break;
              case 292:
                NimGame.main();
                break;
              case 326:
                PowerOfThree.main();
                break;
              case 338:
                CountingBits.main();
                break;
              case 342:
                PowerOfFour.main();
                break;
              case 367:
                ValidPerfectSquare.main();
                break;
              case 374:
                GuessNumberHigherLower.main();
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
            displayLinkedListMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 21:
                MergeTwoSortedLists.main();
                break;
              case 83:
                RemoveDuplicateSortedList.main();
                break;
              case 141:
                LinkedListCycle.main();
                break;
              case 160:
                IntersectionTwoLinkedLists.main();
                break;
              case 203:
                RemoveLinkedListElements.main();
                break;
              case 206:
                ReverseLinkedList.main();
                break;
              case 233:
                PalindromeLinkedList.main();
                break;
              default:
                if (subKey != 0) {
                  System.out.println("Invalid Input!");
                }
                break;
            }
          } while (subKey != 0);
          break; 
        case 5:
          do {
            displayTreeMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
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
              case 144:
                BinaryTreePreorderTraversal.main();
                break;
              case 145:
                BinaryTreePostorderTraversal.main();
                break;
              case 222:
                CountCompleteTreeNodes.main();
                break;
              case 226:
                InvertBinaryTree.main();
                break;
              case 257:
                BinaryTreePaths.main();
                break;
              default:
                if (subKey != 0) {
                  System.out.println("Invalid Input!");
                }
                break;
            }
          } while (subKey != 0);
          break; 
        case 6:
          do {
            displayStackQueueMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 225:
                StackUsingQueues.main();
                break;
              case 232:
                QueueUsingStacks.main();
                break;
              default:
                if (subKey != 0) {
                  System.out.println("Invalid Input!");
                }
                break;
            }
          } while (subKey != 0);
          break; 
        case 7:
          do {
            displaySearchMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 35:
                SearchInsertPosition.main();
                break;
              case 278:
                FirstBadVersion.main();
                break;
              default:
                if (subKey != 0) {
                  System.out.println("Invalid Input!");
                }
                break;
            }
          } while (subKey != 0);
          break; 
        case 8:
          do {
            displayDatabaseMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              
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
              case 196:
                DeleteDuplicateEmails.main();
                break;
              case 197:
                RisingTemperature.main();
                break;
              default:
                if (subKey != 0) {
                  System.out.println("Invalid Input!");
                }
                break;
            }
          } while (subKey != 0);
          break; 
        case 9:
          do {
            displayShellMenu();
            subKey = keyboard.nextInt();
            keyboard.nextLine();
            switch (subKey) {
              case 193:
                ValidPhoneNumbers.main();
                break;
              case 195:
                TenthLine.main();
                break;
              default:
                if (subKey != 0) {
                  System.out.println("Invalid Input!");
                }
                break;
            }
          } while (subKey != 0);
          break; 

        case 10:
          do {
            displayPremiumMenu();
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
              case 346:
                System.out.println("Subscribe to unlock.");
                break;
              case 359:
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
    System.out.println("\n============= Main Menu ==============");
    System.out.println("1. Array");
    System.out.println("2. String");
    System.out.println("3. Math");
    System.out.println("4. Linked List");
    System.out.println("5. Tree");
    System.out.println("6. Stack Queue");
    System.out.println("7. Search");
    System.out.println("8. Database");
    System.out.println("9. Shell");
    System.out.println("10. Premium");
    System.out.println("0. Exit");
    System.out.println("======================================");
    System.out.print("Enter a choice: ");
  }

  public static void displayArrayMenu()
  {
    System.out.println("\n--------------- Array ----------------");
    System.out.println("1. Two Sum");
    System.out.println("26. Remove Duplicates from Sorted Array");
    System.out.println("27. Remove Element");
    System.out.println("88. Merge Sorted Array");
    System.out.println("118. PascalsTriangle");
    System.out.println("119. PascalsTriangleII");
    System.out.println("121. Best Time to Buy and Sell Stock");
    System.out.println("136. Single Number");
    System.out.println("169. Majority Element");
    System.out.println("217. Contains Duplicate");
    System.out.println("219. Contains Duplicate II");
    System.out.println("228. Summary Ranges");
    System.out.println("268. Missing Number");
    System.out.println("283. Move Zeroes");
    System.out.println("303. Range Sum Query");
    System.out.println("349. Intersection Two Arrays");
    System.out.println("350. Intersection Two ArraysII");
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }
  
  public static void displayStringMenu()
  {
    System.out.println("\n--------------- String ---------------");
    System.out.println("13. Roman to Integer");
    System.out.println("14. Longes Common Prefix");
    System.out.println("20. Valid Parentheses");
    System.out.println("28. Find the First Occurrence String");
    System.out.println("58. Length of Last Word");
    System.out.println("67. Add Binary");
    System.out.println("125. Valid Palindrome");
    System.out.println("190. Reverse Bits");
    System.out.println("205. Isomorphic Strings");
    System.out.println("242. Valid Anagram");
    System.out.println("290. Word Pattern");
    System.out.println("344. Reverse String");
    System.out.println("345. Reverse Vowels String");
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displayMathMenu()
  {
    System.out.println("\n--------------- Math -----------------");
    System.out.println("9. Palindrome Number");
    System.out.println("66. Plus One");
    System.out.println("69. Sqrt");
    System.out.println("70. Climbing Stairs");
    System.out.println("168. Excel Sheet Column Title");
    System.out.println("171. Excel Sheet Column Number");
    System.out.println("191. Number Of One Bits");
    System.out.println("202. Happy Number");
    System.out.println("231. Power Of Two");
    System.out.println("258. Add Digits");
    System.out.println("263. Ugly Number");
    System.out.println("292. Nim Game");
    System.out.println("326. Power Of Three");
    System.out.println("338. Counting Bits");
    System.out.println("342. Power Of Four");
    System.out.println("367. Valid Perfect Square");
    System.out.println("374. Guess Number Higher or Lower");
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displayLinkedListMenu()
  {
    System.out.println("\n--------------- Linked List ----------");
    System.out.println("21. Merge Two Sorted Lists");
    System.out.println("83. Remove Duplicates for Sorted List");
    System.out.println("141. Linked List Cycle");
    System.out.println("160. Intersection of Two Linked Lists");
    System.out.println("203. Remove Linked List Elements");
    System.out.println("206. Reverse Linked List");
    System.out.println("233. Palindrome Linked List");
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displayTreeMenu()
  {
    System.out.println("\n--------------- Tree -----------------");
    System.out.println("94. Binary Tree Inorder Traversal");
    System.out.println("100. Same Tree");
    System.out.println("101. Symmetric Tree");
    System.out.println("104. Maximum Depth Binary Tree");
    System.out.println("108. Sorted Array To Binary Search Tree");
    System.out.println("110. Balanced Binary Tree");
    System.out.println("111. Minimum Depth Binary Tree");
    System.out.println("112. Path Sum");
    System.out.println("144. Binary Tree Preorder Traversal");
    System.out.println("145. Binary Tree Postorder Traversal");
    System.out.println("222. Count Complete Tree Nodes");
    System.out.println("226. Invert Binary Tree");
    System.out.println("257. Binary Tree Paths");
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displayStackQueueMenu()
  {
    System.out.println("\n--------------- Stack Queue ----------");
    System.out.println("225. Implement Stack Using Queues");
    System.out.println("232. Implelemt Queue Using Stacks");
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displaySearchMenu()
  {
    System.out.println("\n--------------- Search ---------------");
    System.out.println("35. Search Insert Position");
    System.out.println("278. First Bad Version");
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displayDatabaseMenu()
  {
    System.out.println("\n--------------- Database -------------");
    System.out.println("175. Combine Two Tables");
    System.out.println("181. Employees Earn More Than Managers");
    System.out.println("182. Duplicate Emails");
    System.out.println("183. Customers Who Never Order");
    System.out.println("196. Delete Duplicate Emails");    
    System.out.println("197. Rising Temperature");  
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }

  public static void displayShellMenu()
  {
    System.out.println("\n--------------- Shell ----------------");
    System.out.println("193. Valid Phone Numbers");    
    System.out.println("195. Tenth Line");
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }
  public static void displayPremiumMenu()
  {
    System.out.println("\n--------------- Premium --------------");
    System.out.println("157. Read n Characters Given Read4");
    System.out.println("163. Missing Ranges");
    System.out.println("170. Two Sum III Date Structure");
    System.out.println("243. Shortest Word Distance");
    System.out.println("246. Strobogrammatic Number");
    System.out.println("252. Meeting Rooms");
    System.out.println("266. Palindrome Permutation");
    System.out.println("270. Closest Binary Search Tree Value");
    System.out.println("293. Flip Game");
    System.out.println("346. Moving Average From Data Stream");
    System.out.println("359. Logger Rate Limiter");
    System.out.println("0. Go Back");
    System.out.println("--------------------------------------");
    System.out.print("Enter a choice: ");
  }
}
