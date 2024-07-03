package easy;

public class LinkedListCycle
{
  public static boolean hasCycle(ListNode head)  
  {
    int loop = 0;
    if (head == null) {
      return false;
    }

    while (head.next != null && loop ++ < 10000) {
      //System.out.print(head.val + " -> ");
      head = head.next;
    }
    if (loop < 10000) {
      return false;
    } else {
      return true;
    }    
  }

  public static boolean hasCycleOpt(ListNode head) 
  {
     ListNode fast = head;
     ListNode slow = head;
     while (fast != null && fast.next != null) {
      fast = fast.next.next;
      slow = slow.next;
      if (fast == slow) {
          return true;
      }
     }
     return false;
  }

  public static void readme()
  {
    String str = "Given head, the head of a linked list, determine if the linked list has a cycle in it.\n\n";

    str += "There is a cycle in a linked list if there is some node in the list that can be reached again by continuously following the next pointer. Internally, pos is used to denote the index of the node that tail's next pointer is connected to. Note that pos is not passed as a parameter.\n\n";

    str += "Return true if there is a cycle in the linked list. Otherwise, return false.";
    System.out.println(str);
  }
}