package bit;

public class HammingDistance
{
  public static int hammingDistance(int x, int y)
  {
    int count = 0;
    int [] arrayX = new int [32];
    int [] arrayY = new int [32];
    boolean isDiff = false;
    
    for (int i = 0; i < 32; i++) {
      if (((x >> i) & 1) == 1) {
        arrayX[i] = 1;
      }
      if (((y >> i) & 1) == 1) {
        arrayY[i] = 1;
      }
    }
    for (int i = 0; i < 32; i++) {
      if (arrayX[i] != arrayY[i]) {
        count++;
      } 
    }

    return count;
  }

  public static int hammingDistanceOpt(int x, int y) 
  {
    int z = x ^ y;
      
    return Integer.bitCount(z);      
  }

  public static void readme()
  {
    String str = "The Hamming distance between two integers is the number of positions at which the corresponding bits are different.\n\n";

    str += "Given two integers x and y, return the Hamming distance between them.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    HammingDistance.readme();

    int x;
    int y;
    // x = 1, y = 4 => 2
    x = 1;
    y = 4;
    System.out.println("hammingDistance(" + x + ", " + y + ") = " +
                        hammingDistance(x, y));
    // x = 3, y = 1 => 1
    x = 3;
    y = 1;
    System.out.println("hammingDistance(" + x + ", " + y + ") = " +
                        hammingDistance(x, y));

    System.out.println("hammingDistanceOpt(" + x + ", " + y + ") = " +
                        hammingDistanceOpt(x, y));
  }
}