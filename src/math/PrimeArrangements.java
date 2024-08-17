package math;

public class PrimeArrangements
{
  public static int numPrimeArrangements(int n) {
      int [] primes = new int[] { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97};
      int numP = 0;
      for (int i = 0; i < primes.length; i++) {
          if (n >= primes[i]) {
              numP++;
          }
      }
      int numNotP = n - numP;
      long setP = 1;
      for (int i = 2; i <= numP; i++) {
          setP = (setP * i) % 1000000007;
      }
      long setNotP = 1;
      for (int i = 2; i <= numNotP; i++) {
          setNotP = (setNotP * i) % 1000000007;
      }
      long res = setP * setNotP;

      return (int)(res % 1000000007);
  } 

  public static int numPrimeArrangementsEx(int n) {
    if(n < 2){
        return 1;
    }
    long res = 1;
    int prime = 1;
    int notPrime = 1;
    for(int i = 3; i <= n; i++){
        if(isPrime(i)){
            prime++;
        }else{
            notPrime++;
        }
    }
    for(int i = prime; i > 0; i--){
        res *= i;
        res %= 1000000007;
    }
    for(int i = notPrime; i > 0; i--){
        res *=i;
        res %= 1000000007;
    }
    return (int)res; 
  }
  public static boolean isPrime(int num){
    for(int i = 2; i <= num / 2; i++){
        if(num % i == 0){
            return false;
        }
    }
    return true;
  }
  
  public static void readme()
  {
    String str = "Return the number of permutations of 1 to n so that prime numbers are at prime indices (1-indexed.)\n\n";
    
    str += " (Recall that an integer is prime if and only if it is greater than 1, and cannot be written as a product of two positive integers both smaller than it.)\n\n";
    
    str += "Since the answer may be large, return the answer modulo 10^9 + 7.\n";
    
    System.out.println(str);
  }

  public static void main()
  {
    PrimeArrangements.readme();

    int num;
    // Input: n = 5
    // Output: 12
    num = 5;
    System.out.println("numPrimeArrangements(" + num + ") = " + numPrimeArrangements(num));

    // Input: n = 100
    // Output: 682289015

    num = 100;
    System.out.println("numPrimeArrangements(" + num + ") = " + numPrimeArrangements(num));

    System.out.println("numPrimeArrangementsEx(" + num + ") = " + numPrimeArrangementsEx(num));

  }
}