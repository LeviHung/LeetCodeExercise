package linkedlist;

public class MiddleOfLinkedList
{
  public static ListNode middleNode(ListNode head) 
  {
    ListNode current = head;
    int count = 0;
    while (current != null) {
      current = current.next;
      count++;
    }
    count = count/2;
    current = head;
    for (int i = 0; i < count; i++) {
      current = current.next;
    }
    return current;
  }

  public static void readme()
  {
    String str = "Given the head of a singly linked list, return the middle node of the linked list.\n\n";

    str += "If there are two middle nodes, return the second middle node.\n";

    System.out.println(str);
  }

  public static void main()
  {
    MiddleOfLinkedList.readme();

    // head = [1,2,3,4,5] => [3,4,5]
    ListNode node = new ListNode(5);
    node = new ListNode(4, node);
    node = new ListNode(3, node);
    node = new ListNode(2, node);
    ListNode list1 = new ListNode(1, node);

    System.out.println("List 1: ");
    list1.show();

    System.out.println("middleNode(list1): ");
    ListNode list2 = middleNode(list1);
    list2.show();
    System.out.println("");
    
    // head = [1,2,3,4,5,6] => [3,4,5]
    node = new ListNode(6);
    node = new ListNode(5, node);
    node = new ListNode(4, node);
    node = new ListNode(3, node);
    node = new ListNode(2, node);
    ListNode list3 = new ListNode(1, node);

    System.out.println("List 3: ");
    list3.show();

    System.out.println("deleteDuplicates(list3): ");
    ListNode list4 = middleNode(list3);
    list4.show();
  }
}