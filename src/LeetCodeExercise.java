// Levi Hung
// 06/24/2024
// LeetCode Exercise

import java.util.Scanner;

import easy.TwoSum;

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
                twoSumReadme();
                twoSum();
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

    System.out.println("twoSum([2, 3, 4], 6) = " + 
                       Solution.twoSum(nums, target)[0] +
                       ", " +
                       Solution.twoSum(nums, target)[1]);

  }

  public static void twoSumReadme()
  {
    String str = "Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.\n\n";

    str += "You may assume that each input would have exactly one solution, and you may not use the same element twice.\n\n";

    str += "You can return the answer in any order.\n";
  }
}
