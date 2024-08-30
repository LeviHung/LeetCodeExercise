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
public class AddTwoNumbers
{
  public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    ListNode res = add(l1, l2, 0);
    return res;
  }

  public static ListNode add(ListNode l1, ListNode l2, int carry) {
    if (l1 == null && l2 == null) {
        if (carry == 1) {
            return new ListNode(1);
        } else {
            return null;
        }
    }

    ListNode node;
    if (l1 == null) {
        node = new ListNode((l2.val + carry) % 10);
        carry = (l2.val + carry) / 10;
        node.next = add(null, l2.next, carry);
        return node;
    } else if (l2 == null) {
        node = new ListNode((l1.val + carry) % 10);
        carry = (l1.val + carry) / 10;
        node.next = add(l1.next, null, carry);
        return node;
    } else {
        node = new ListNode((l1.val + l2.val + carry) % 10);
        carry = (l1.val + l2.val + carry) / 10;
        node.next = add(l1.next, l2.next, carry);
        return node;
    }
  }

  public static void readme()
  {
    String str = "You are given two non-empty linked lists representing two non-negative integers. The digits are stored in reverse order, and each of their nodes contains a single digit. Add the two numbers and return the sum as a linked list.\n\n";

    str += "You may assume the two numbers do not contain any leading zero, except the number 0 itself.\n";

    System.out.println(str);
  }

  public static void main()
  {
    AddTwoNumbers.readme();
    ListNode node;
    
    // Input: l1 = [2,4,3], l2 = [5,6,4]
    // Output: [7,0,8]
    node = new ListNode(3);
    node = new ListNode(4, node);
    ListNode list1 = new ListNode(2, node);

    System.out.println("List 1: ");
    list1.show();

    node = new ListNode(4);
    node = new ListNode(6, node);
    ListNode list2 = new ListNode(5, node);

    System.out.println("List 2: ");
    list2.show();

    System.out.println("addTwoNumbers(list1, list2): ");
    ListNode list3 = addTwoNumbers(list1, list2);
    list3.show();
    System.out.println("");
    
    // Input: l1 = [0], l2 = [0]
    // Output: [0]
    ListNode list4 = new ListNode(0);

    System.out.println("List 4: ");
    list4.show();

    ListNode list5 = new ListNode(0);

    System.out.println("List 5: ");
    list5.show();

    System.out.println("addTwoNumbers(list4, list5): ");
    ListNode list6 = addTwoNumbers(list4, list5);
    list6.show();
    System.out.println("");
    
    // Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
    // Output: [8,9,9,9,0,0,0,1]
    node = new ListNode(9);
    node = new ListNode(9, node);
    node = new ListNode(9, node);
    node = new ListNode(9, node);
    node = new ListNode(9, node);
    node = new ListNode(9, node);
    ListNode list7 = new ListNode(9, node);

    System.out.println("List 7: ");
    list7.show();

    node = new ListNode(9);
    node = new ListNode(9, node);
    node = new ListNode(9, node);
    ListNode list8 = new ListNode(9, node);

    System.out.println("List 8: ");
    list8.show();

    System.out.println("addTwoNumbers(list7, list8): ");
    ListNode list9 = addTwoNumbers(list7, list8);
    list9.show();
    System.out.println("");

  }
}