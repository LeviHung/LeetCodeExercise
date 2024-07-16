package string;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.AbstractList;

public class FizzBuzz
{
  public static List<String> fizzBuzz(int n)
  {
    List <String> list = new ArrayList<>();

    for (int i = 1; i <= n; i++) {
      if (i % 3 == 0 && i % 5 == 0) {
        list.add("FizzBuzz");
      } else if (i % 3 == 0) {
        list.add("Fizz");
      } else if (i % 5 == 0) {
        list.add("Buzz");
      } else {
        list.add(Integer.toString(i));
      }
    }
    return list;
  }

  public static List<String> fizzBuzzOpt(int n) 
  {
      return new AbstractList<String>() {
          @Override
          public String get(int n) {
              n++;
              if (n % 3 == 0) {
                  if (n % 5 == 0) {
                      return "FizzBuzz";
                  }
                  return "Fizz";
              }
              if (n % 5 == 0) {
                  return "Buzz";
              }
              return String.valueOf(n);
          }

          @Override
          public int size() {
              // TODO Auto-generated method stub
              return n;
          }
      };
  }
  public static void readme()
  {
    String str = "Given an integer n, return a string array answer (1-indexed) where:\n\n";

    str += "answer[i] == \"FizzBuzz\" if i is divisible by 3 and 5.\n\n";

    str += "answer[i] == \"Fizz\" if i is divisible by 3.\n\n";

    str += "answer[i] == \"Buzz\" if i is divisible by 5.\n\n";

    str += "answer[i] == i (as a string) if none of the above conditions are true.\n\n";

    System.out.println(str);
  }

  public static void main()
  {
    FizzBuzz.readme();
    // n = 3 => ["1","2","Fizz"]
    int n;
    n = 3; 
    System.out.println("fizzBuzz(" + n + ") = ");
    List list1 = fizzBuzz(n);
    System.out.println(Arrays.toString(list1.toArray()));

    // n = 5 => ["1","2","Fizz","4","Buzz"]
    n = 5; 
    System.out.println("fizzBuzz(" + n + ") = ");
    List list2 = fizzBuzz(n);
    System.out.println(Arrays.toString(list2.toArray()));

    // n = 15 => ["1","2","Fizz","4","Buzz","Fizz","7","8","Fizz",
    //           "Buzz","11","Fizz","13","14","FizzBuzz"]
    n = 15; 
    System.out.println("fizzBuzzOpt(" + n + ") = ");
    List list3 = fizzBuzzOpt(n);
    System.out.println(Arrays.toString(list3.toArray()));

  }
}