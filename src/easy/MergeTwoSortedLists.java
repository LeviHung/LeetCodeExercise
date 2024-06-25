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
public class MergeTwoSortedLists
{
  public static ListNode mergeTwoLists(ListNode list1, ListNode list2)
  {
    ListNode head;
    ListNode newList;
    if (list1 == null) {
      return list2;
    } else if (list2 == null) {
      return list1;
    } else {
      if (list1.val < list2.val) {
        head = new ListNode(list1.val);
        list1 = list1.next;
      } else {
        head = new ListNode(list2.val);
        list2 = list2.next;
      }
    }
    newList = head;
    // list1 = [1, 2, 4], list2 = [1, 3, 4]
    ListNode nextNode;
    while (list1 != null && list2 != null) {
      if (list1.val < list2.val) {
        nextNode = new ListNode(list1.val);
        list1 = list1.next;
      } else {
        nextNode = new ListNode(list2.val);
        list2 = list2.next;
      }
      head.next = nextNode;
      head = nextNode;
    }
    if (list1 == null) {
      while (list2 != null) {
        nextNode = new ListNode(list2.val);
        list2 = list2.next;
        head.next = nextNode;
        head = nextNode;
      }
      
    } else {
      while (list1 != null) {
        nextNode = new ListNode(list1.val);
        list1 = list1.next;
        head.next = nextNode;
        head = nextNode;
      }
    }
    
    return newList;
  }

  public static ListNode mergeTwoListsOpt(ListNode list1, ListNode list2) 
  {
    if (list1 == null && list2 == null)
      return null;

    ListNode l1 = list1;
    ListNode l2 = list2;

    ListNode h = new ListNode(-1);
    ListNode t = h;
    while (l1 != null && l2 != null) {
      if (l1.val < l2.val) {
        t.next = l1;
        t = t.next;
        l1 = l1.next;
      } else {
        t.next = l2;
        t = t.next;
        l2= l2.next;
      }
    }

    if (l1 != null) {
      t.next = l1;
    }

    if (l2 != null) {
      t.next = l2;
    }

    return h.next;
  }
  
  public static void readme()
  {
    String str = "You are given the heads of two sorted linked lists list1 and list2.\n\n";

    str += "Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.\n\n";

    str += "Return the head of the merged linked list.\n";

    System.out.println(str);
  }
}