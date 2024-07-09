package easy;

public class ReverseLinkedList
{
  public static ListNode reverseList(ListNode head) 
  {
    ListNode parent = null;
    ListNode child = null;
    // How to reverse a linked list.
    // Such as a -> b -> c -> null becomes c -> b -> a -> null:
    // 1. child = head.next, head.next = parent, parent = head, head = child,
    while (head != null) {
        child = head.next;
        head.next = parent;
        parent = head;
        head = child;
    }

    return parent;
  }

  public static ListNode reverseListOpt(ListNode head) 
  {
    ListNode prev = null;
    
    while (head != null) {
        ListNode next = head.next;
        head.next = prev;
        prev = head;
        head = next;
    }
    return prev;
  }
  
  public static void readme()
  {
    String str = "Given the head of a singly linked list, reverse the list, and return the reversed list.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
      ReverseLinkedList.readme();

    // head = [1,2,3,4,5] => [5,4,3,2,1]
    ListNode node2;
    ListNode node3;
    ListNode node4;
    ListNode node5;
    ListNode node6;
    ListNode node7;

    node5 = new ListNode(5);
    node4 = new ListNode(4, node5);
    node3 = new ListNode(3, node4);
    node2 = new ListNode(2, node3);
    ListNode list1 = new ListNode(1, node2);
    System.out.println("List 1: ");
    list1.show();

    System.out.println("reverseList(list1): ");
    ListNode list2 = ReverseLinkedList.reverseList(list1);
    System.out.println("List 2: ");
    list2.show();
    System.out.println("");

    // head = [] => []

    // head = [1,2] => [2,1]
    node2 = new ListNode(2);
    ListNode list3 = new ListNode(1, node2);
    System.out.println("List 3: ");
    list3.show();

    System.out.println("reverseList(list3): ");
    ListNode list4 = ReverseLinkedList.reverseList(list3);
    System.out.println("List 4: ");
    list4.show();
    System.out.println("");

  }
}