package string;

import java.util.StringTokenizer;

public class DefangingIPAddress
{
  public static String defangIPaddr(String address) {
      StringBuilder sb = new StringBuilder();
      String[] tokens = address.split("\\.");
      sb.append(tokens[0]);
      for (int i = 1; i < tokens.length; i++) {
          sb.append("[.]");
          sb.append(tokens[i]);
      }
      return sb.toString();
      /*
      String res = address.replace(".", "[.]");
      return res;
      */
  }

  public static void readme()
  {
    String str = "Given a valid (IPv4) IP address, return a defanged version of that IP address.\n\n";
    
    str += "A defanged IP address replaces every period \".\" with \"[.]\".\n";

    System.out.println(str);
  }

  public static void main() 
  {
    DefangingIPAddress.readme();
    String address;
    // Input: address = "1.1.1.1"
    // Output: "1[.]1[.]1[.]1"


    address = "1.1.1.1";
    System.out.println("defangIPaddr(" + address + ") = " + 
                       defangIPaddr(address));
    System.out.println("");

    // Input: address = "255.100.50.0"
    // Output: "255[.]100[.]50[.]0"

    address = "255.100.50.0";
    System.out.println("defangIPaddr(" + address + ") = " + 
                       defangIPaddr(address));

  }

}