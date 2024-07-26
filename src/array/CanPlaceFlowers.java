package array;
import java.util.Arrays;

public class CanPlaceFlowers
{
  public static boolean canPlaceFlowers(int[] flowerbed, int n) 
  {
    if (n == 0) {
      return true;
    }
    if (flowerbed.length == 1) {
      if (flowerbed[0] == 0 && n == 1) {
        return true;
      } else {
        return false;
      }
    }

    int space = 0;
    for (int i = 0; i < flowerbed.length; i++) {
      if (flowerbed[i] == 0) {
        space++;
      }
    }

    if (n * 2 > space + 1) {
      return false;
    }

    int [] array = flowerbed.clone();
    if (array[0] == 0) {
      if (array[1] == 0) {
        n--;
        array[0] = 1;
        if (n == 0) {
          return true;
        }
      }  
    }
    
    for (int i = 1; i < flowerbed.length - 1; i++) {
      if (array[i] == 0) {
        if (array[i - 1] == 0 && array[i + 1] == 0) {
          array[i] = 1;
          n--;
          if (n <= 0) {
            return true;
          }
        }
      }
    }

    if (array[flowerbed.length - 1] == 0 && 
        array[flowerbed.length - 2] == 0) {
      n--;
      if (n <= 0) {
        return true;
      }
    }
    return false;
  }

  public static boolean canPlaceFlowersOpt(int[] flowerbed, int n) 
  {
    for (int i = 0; i < flowerbed.length; i += 2) {
      if (flowerbed[i]==1)
        continue;
      if (i + 1 < flowerbed.length && 
          flowerbed[i+1] == 1) {
        i++;
      } else {
        n--;
      }
      
      if (n <= 0)
        return true;
    }
     
    return n <= 0;
  }

  
  public static void readme()
  {
    String str = "You have a long flowerbed in which some of the plots are planted, and some are not. However, flowers cannot be planted in adjacent plots.\n\n";

    str += "Given an integer array flowerbed containing 0's and 1's, where 0 means empty and 1 means not empty, and an integer n, return true if n new flowers can be planted in the flowerbed without violating the no-adjacent-flowers rule and false otherwise.\n";

    System.out.println(str);
  }

  public static void main()
  {
    CanPlaceFlowers.readme();
    int n;
    
    // flowerbed = [1,0,0,0,1], n = 1 => true
    int [] flowerbed1 = {1,0,0,0,1};
    n = 1;
    System.out.println("canPlaceFlowers(" + Arrays.toString(flowerbed1) + 
                       ", " + n + ") = " +
                       canPlaceFlowers(flowerbed1, n));

    // flowerbed = [1,0,0,0,1], n = 2 => false
    int [] flowerbed2 = {1,0,0,0,1};
    n = 2;
    System.out.println("canPlaceFlowers(" + Arrays.toString(flowerbed2) + 
                       ", " + n + ") = " +
                       canPlaceFlowers(flowerbed2, n));

    // flowerbed = [1,0,1,0,1,0,1], n = 1 => false
    int [] flowerbed3 = {1,0,1,0,1,0,1};
    n = 1;
    System.out.println("canPlaceFlowers(" + Arrays.toString(flowerbed3) + 
                       ", " + n + ") = " +
                       canPlaceFlowers(flowerbed3, n));

    int [] flowerbed4 = {0,0,1,0,0};
    n = 2;
    System.out.println("canPlaceFlowers(" + Arrays.toString(flowerbed4) + 
                       ", " + n + ") = " +
                       canPlaceFlowers(flowerbed4, n));

    int [] flowerbed5 = {1,0,0,0,0,1};
    n = 2;
    System.out.println("canPlaceFlowers(" + Arrays.toString(flowerbed5) + 
                       ", " + n + ") = " +
                       canPlaceFlowers(flowerbed5, n));

    int [] flowerbed6 = {0,0,0};
    n = 2;
    System.out.println("canPlaceFlowers(" + Arrays.toString(flowerbed6) + 
                       ", " + n + ") = " +
                       canPlaceFlowers(flowerbed6, n));

    System.out.println("canPlaceFlowersOpt(" + Arrays.toString(flowerbed6) + 
                       ", " + n + ") = " +
                       canPlaceFlowersOpt(flowerbed6, n));

  }
}