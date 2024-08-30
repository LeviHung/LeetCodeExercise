package recursion;

import linkedlist.ListNode;
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
public class SwapNodesInPairs
{
  public static ListNode swapPairs(ListNode head) {
      if (head == null || head.next == null) {
          return head;
      }
      ListNode tmp = head;
      head = head.next;
      tmp.next = head.next;
      head.next = tmp;
      tmp.next = swapPairs(tmp.next); 
      return head;
  }

  public static void readme()
  {
    String str = "Given a linked list, swap every two adjacent nodes and return its head. You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)\n";

    System.out.println(str);
  }

  public static void main()
  {
    SwapNodesInPairs.readme();
    ListNode node;
    // Input: head = [1,2,3,4]
    // Output: [2,1,4,3]
    node = new ListNode(4);
    node = new ListNode(3, node);
    node = new ListNode(2, node);
    ListNode list1 = new ListNode(1, node);

    System.out.println("List 1: ");
    list1.show();

    System.out.println("swapPairs(list1): ");
    ListNode list2 = swapPairs(list1);
    list2.show();
    System.out.println("");
    
    // Input: head = []
    // Output: []
    ListNode list3 = new ListNode();

    System.out.println("List 3: ");
    list3.show();

    System.out.println("swapPairs(list3): ");
    ListNode list4 = swapPairs(list3);
    list4.show();
    System.out.println("");

    // Input: head = [1]
    // Output: [1]
    ListNode list5 = new ListNode(1);

    System.out.println("List 5: ");
    list5.show();

    System.out.println("swapPairs(list5): ");
    ListNode list6 = swapPairs(list5);
    list6.show();
    System.out.println("");


  }
}