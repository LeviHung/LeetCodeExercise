package linkedlist;
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
public class RemoveDuplicateSortedList
{
  public static ListNode deleteDuplicates(ListNode head)
  {
    ListNode origHead = head;
    while (head != null) {
      if (head.next != null && head.next.val == head.val) {
        head.next = head.next.next;
      } else {
        head = head.next;
      }
    }
    
    return origHead;
  }

  public static void readme()
  {
    String str = "Given the head of a sorted linked list, delete all duplicates such that each element appears only once. Return the linked list sorted as well.\n";

    System.out.println(str);
  }

  public static void main()
  {
    RemoveDuplicateSortedList.readme();

    // list1 = [1, 2, 4], list2 = [1, 3, 4]
    ListNode node = new ListNode(2);
    node = new ListNode(1, node);
    ListNode list1 = new ListNode(1, node);

    System.out.println("List 1: ");
    list1.show();

    System.out.println("deleteDuplicates(list1): ");
    ListNode list2 = RemoveDuplicateSortedList.deleteDuplicates(list1);
    list2.show();

    node = new ListNode(3);
    node = new ListNode(3, node);
    node = new ListNode(2, node);
    node = new ListNode(1, node);
    ListNode list3 = new ListNode(1, node);

    System.out.println("List 2: ");
    list3.show();

    System.out.println("deleteDuplicates(list2): ");
    ListNode list4 = RemoveDuplicateSortedList.deleteDuplicates(list3);
    list4.show();
  }
}