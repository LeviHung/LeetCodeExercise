package easy;
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
}