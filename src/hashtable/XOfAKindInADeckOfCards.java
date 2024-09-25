package hashtable;

import java.util.Arrays;

public class XOfAKindInADeckOfCards
{
  private static boolean hasGroupsSizeX(int[] deck)
  {
    if (deck.length == 1) {
      return false;
    }

    int maxCard = 0;
    for (int i = 0; i < deck.length; i++) {
      maxCard = Math.max(deck[i], maxCard);
    }
    int maxLen = maxCard + 1;
    int[] groups = new int [maxLen];
    for (int i = 0; i < deck.length; i++) {
      groups[deck[i]]++;
    }

    int min = 10000;
    for (int i = 0; i < maxLen; i++) {
      if (groups[i] > 0) {
          min = Math.min(groups[i], min);
      } 
    }
    if (min == 1) {
      return false;
    }

    Integer[] primes = new Integer[] { 2, 3, 5, 7, 11, 13};
    for (int prime: primes) {
      if (prime <= min) {
          boolean hasGroups = true;
          for (int i = 0; i < maxLen; i++) {
              if (groups[i] > 0 && groups[i] % prime != 0) {
                  hasGroups = false;
              }
          }

          if (hasGroups) {
              return true;
          }
      }
    }
    return false;
    /*
    // [0,0,0,1,1,1,2,2,2]
    // [1,1,1,1,2,2,2,2,2,2]
    int[] groups = new int [10000];
    int numGroup = 0;
    for (int i = 0; i < deck.length; i++) {
      groups[deck[i]]++;
      if (groups[deck[i]] == 1) {
          numGroup++;
      }
    }
    int size = deck.length;
    int min = 10000;
    int [] cards = new int [numGroup];
    int index = 0;
    for (int i = 0; i < 10000 && index < numGroup; i++) {
      if (groups[i] > 0) {
          cards[index++] = groups[i];
          min = Math.min(groups[i], min);
      } 
    }
    if (min == 1) {
      return false;
    }
    boolean hasGroups = false;
    Integer[] primes = new Integer[] { 2, 3, 5, 7, 11, 13};
    for (int prime: primes) {
      if (prime <= min) {
          hasGroups = true;
          for (int i = 0; i < numGroup; i++) {
              if (cards[i] % prime != 0) {
                  hasGroups = false;
              }
          }
          if (hasGroups) {
              return true;
          }
      }
    }
    return false;
    */
  }

  public static boolean hasGroupsSizeXOpt(int[] deck) {
    // Find the maximum value in the deck using iteration
    int maxVal = 0;
    for (int card : deck) {
        if (card > maxVal) {
            maxVal = card;
        }
    }

    // Create a frequency array
    int[] count = new int[maxVal + 1];
    for (int card : deck) {
        count[card]++;
    }

    // Find the GCD of all non-zero counts
    int gcd = -1;
    for (int freq : count) {
        if (freq > 0) {
            if (gcd == -1) {
                gcd = freq;
            } else {
                gcd = gcd(gcd, freq);
            }
        }
    }

    // Check if the GCD is at least 2
    return gcd >= 2;
  }

  // Helper function to compute the GCD of two numbers
  private static int gcd(int a, int b) {
    while (b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
  }

  public static void readme()
  {
    String str = "You are given an integer array deck where deck[i] represents the number written on the ith card.\n\n";

    str += "Partition the cards into one or more groups such that:\n\n";

    str += "Each group has exactly x cards where x > 1, and\n\n";

    str += "All the cards in one group have the same integer written on them.\n\n";

    str += "Return true if such partition is possible, or false otherwise.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    XOfAKindInADeckOfCards.readme();

    // deck = [1,2,3,4,4,3,2,1] => true
    int[] deck1 = {1,2,3,4,4,3,2,1};
    System.out.println("hasGroupsSizeX(" + Arrays.toString(deck1) + 
                       ") = " + hasGroupsSizeX(deck1));

    // deck = [1,1,1,2,2,2,3,3] => false
    int[] deck2 = {1,1,1,2,2,2,3,3};
    System.out.println("hasGroupsSizeX(" + Arrays.toString(deck2) + 
                       ") = " + hasGroupsSizeX(deck2));

    System.out.println("hasGroupsSizeXOpt(" + Arrays.toString(deck2) + 
     ") = " + hasGroupsSizeXOpt(deck2));


  }

}