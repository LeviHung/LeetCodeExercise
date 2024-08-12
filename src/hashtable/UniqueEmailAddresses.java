package hashtable;

import java.util.HashSet;
import java.util.Arrays;

public class UniqueEmailAddresses
{
  private static int numUniqueEmails(String[] emails)
  {
    HashSet<String> set = new HashSet<>();
    for (String email: emails) {    
      set.add(format(email));
    }
    return set.size();
  }

  private static String format(String email) 
  {
    StringBuilder sb = new StringBuilder();
    boolean hasPlus = false;
    for (int i = 0; i < email.length(); i++) {
      char ch = email.charAt(i);
      if (ch == '@') {
        sb.append(email.substring(i));
        break;
      } else if (ch == '.') {

      } else if (ch == '+') {
          hasPlus = true;
      } else if (hasPlus == true) {

      } else {
          sb.append(ch);
      }
    }
    return sb.toString();
  }
  
  public static void readme()
  {
    String str = "Every valid email consists of a local name and a domain name, separated by the '@' sign. Besides lowercase letters, the email may contain one or more '.' or '+'.\n\n";

    str += "For example, in \"alice@leetcode.com\", \"alice\" is the local name, and \"leetcode.com\" is the domain name.\n\n";
    str += "If you add periods '.' between some characters in the local name part of an email address, mail sent there will be forwarded to the same address without dots in the local name. Note that this rule does not apply to domain names.\n\n";
    str += "For example, \"alice.z@leetcode.com\" and \"alicez@leetcode.com\" forward to the same email address.\n\n";
    str += "If you add a plus '+' in the local name, everything after the first plus sign will be ignored. This allows certain emails to be filtered. Note that this rule does not apply to domain names.\n\n";
    str += "For example, \"m.y+name@email.com\" will be forwarded to \"my@email.com\".\n\n";
    str += "It is possible to use both of these rules at the same time.\n\n";
    str += " Given an array of strings emails where we send one email to each emails[i], return the number of different addresses that actually receive mails.\n";

    System.out.println(str);
  }

  public static void main()
  {
    UniqueEmailAddresses.readme();

    // emails = ["test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"] => 2
    String[] emails1 = {"test.email+alex@leetcode.com","test.e.mail+bob.cathy@leetcode.com","testemail+david@lee.tcode.com"};
    System.out.println("numUniqueEmails(" + Arrays.toString(emails1) + 
                       ") = " + numUniqueEmails(emails1));
    System.out.println("");
    
    // emails = ["a@leetcode.com","b@leetcode.com","c@leetcode.com"] => 3
    String[] emails2 = {"a@leetcode.com","b@leetcode.com","c@leetcode.com"};
    System.out.println("numUniqueEmails(" + Arrays.toString(emails2) + 
                       ") = " + numUniqueEmails(emails2));

  }
}