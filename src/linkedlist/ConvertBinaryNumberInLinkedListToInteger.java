package linkedlist;
import java.util.List;
import java.util.ArrayList;

public class ConvertBinaryNumberInLinkedListToInteger
{  
  public static int getDecimalValue(ListNode head) {
      int res = 0;
      while(head != null) {
          res = res * 2 + head.val;
          head = head.next;
      }
      return res;
  }

  public static void readme()
  {
    String str = "Given head which is a reference node to a singly-linked list. The value of each node in the linked list is either 0 or 1. The linked list holds the binary representation of a number.\n\n";

    str += "Return the decimal value of the number in the linked list.\n\n";
    
    str += "The most significant bit is at the head of the linked list.\n";
    
    System.out.println(str);
  }

  public static void main() 
  {
    ConvertBinaryNumberInLinkedListToInteger.readme();

    // Input: head = [1,0,1]
    // Output: 5
    ListNode node2;
    ListNode node3;
    ListNode node4;
    ListNode node5;
    ListNode node6;
    ListNode node7;

    node3 = new ListNode(1);
    node2 = new ListNode(0, node3);
    ListNode list1 = new ListNode(1, node2);
    System.out.println("List 1: ");
    list1.show();

    System.out.println("getDecimalValue(list1) =  " +  getDecimalValue(list1));

    // Input: head = [0]
    // Output: 0
    ListNode list2 = new ListNode(0);
    System.out.println("List 2: ");
    list2.show();

    System.out.println("getDecimalValue(list2) =  " +  getDecimalValue(list2));

  }
}