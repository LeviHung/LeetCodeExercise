package easy;

public class RemoveLinkedListElements
{
  public static ListNode removeElements(ListNode head, int val) 
  {
    ListNode headParent = head;
    ListNode headOrig = head;

    // How to remove an element in a linked list.
    // Such as a -> b -> c -> null, remove a, b, and c:
    // 1. remove a, 
    while (head != null) {
      if (head.val == val) {
        if (head == headOrig) {
          headOrig = head.next;
        } else {
          headParent.next = head.next;
        }
      } else {
        headParent = head;
      }
      head = head.next;
    }
    
    return headOrig;
  }

  public static ListNode removeElementsR(ListNode head, int val) {
    if (head == null) {
      return head;
    }
    
    head.next = removeElementsR(head.next, val);
    return head.val == val ? head.next : head;
  }

  public static void readme()
  {
    String str = "Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val, and return the new head.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    RemoveLinkedListElements.readme();

    // head = [1,2,6,3,4,5,6], val = 6 => [1,2,3,4,5]
    ListNode node2;
    ListNode node3;
    ListNode node4;
    ListNode node5;
    ListNode node6;
    ListNode node7;
    int val;

    node7 = new ListNode(6);
    node6 = new ListNode(5, node7);
    node5 = new ListNode(4, node6);
    node4 = new ListNode(3, node5);
    node3 = new ListNode(6, node4);
    node2 = new ListNode(2, node3);
    ListNode list1 = new ListNode(1, node2);
    System.out.println("List 1: ");
    list1.show();

    val = 6;
    
    System.out.println("removeElements(list1, " + val + "): ");
    ListNode list2 = RemoveLinkedListElements.removeElements(list1, val);
    System.out.println("List 2: ");
    list2.show();
    System.out.println("");

    // head = [], val = 1 => []

    // head = [7,7,7,7], val = 7 => []
    node4 = new ListNode(7);
    node3 = new ListNode(7, node4);
    node2 = new ListNode(7, node3);
    ListNode list3 = new ListNode(7, node2);
    System.out.println("List 3: ");
    list3.show();

    val = 7;

    System.out.println("removeElements(list3, " + val + "): ");
    ListNode list4 = RemoveLinkedListElements.removeElements(list3, val);
    System.out.println("List 4: ");
    //list4.show();
    System.out.println("");

    // head = [1,2,2,1], val = 2 => [1,1]
    node4 = new ListNode(1);
    node3 = new ListNode(2, node4);
    node2 = new ListNode(2, node3);
    ListNode list5 = new ListNode(1, node2);
    System.out.println("List 5: ");
    list5.show();

    val = 2;

    System.out.println("removeElementsR(list6, " + val + "): ");
    ListNode list6 = RemoveLinkedListElements.removeElementsR(list5, val);
    System.out.println("List 6: ");
    list6.show();
    System.out.println("");

  }
}