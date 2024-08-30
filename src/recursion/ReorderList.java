package recursion;

import linkedlist.ListNode;
import java.util.List;
import java.util.ArrayList;

public class ReorderList
{
  public static void reorderList(ListNode head) {
    ListNode tmp = head;
    int size = 0;
    while (tmp != null) {
        size++;
        tmp = tmp.next;
    }
    ListNode[] arr = new ListNode[size];
    tmp = head;
    for (int i = 0; i < size; i++) {
        arr[i] = tmp;
        tmp = tmp.next;
    }

    int n;
    if (size % 2 == 0) {
        n = size/2;
    } else {
        n = size/2 + 1;
    }
    ListNode nextNode = head;
    for (int i = 0; i < n; i++) {
        tmp = arr[i];
        nextNode = arr[size - i - 1];
        if (tmp == nextNode) {
            break;
        }
        nextNode.next = tmp.next;
        tmp.next = nextNode;
    }
    nextNode.next = null;
  }

  public static void reorderListArrayList(ListNode head) {
    List<ListNode> arr = new ArrayList<>();
    ListNode tmp = head;
    while (tmp != null) {
        arr.add(tmp);
        tmp = tmp.next;
    }
    int size = arr.size();
    int n;
    if (size % 2 == 0) {
        n = size/2;
    } else {
        n = size/2 + 1;
    }
    ListNode nextNode = head;
    for (int i = 0; i < n; i++) {
        tmp = arr.get(i);
        nextNode = arr.get(size - i - 1);
        if (tmp == nextNode) {
            break;
        }
        nextNode.next = tmp.next;
        tmp.next = nextNode;
    }
    nextNode.next = null;
  }


  public static void reorderListRecursion(ListNode head) {
    if (head == null) {
        return;
    }

    ListNode lastParent;
    ListNode last;

    lastParent = head;
    last = head.next;
    while (last!= null && last.next != null) {
        lastParent = last;
        last = last.next;
    }

    if (head == lastParent) {
        return;
    }

    last.next = head.next;
    head.next = last;
    lastParent.next = null;
    reorderListRecursion(last.next);
  }

  public static void reorderListOpt(ListNode head) {
    if (head == null || head.next == null || head.next.next == null)
        return;

    reorder(head, head);
  }

  public static ListNode reorder(ListNode slow, ListNode fast) {
    ListNode tail = null;

    if (fast.next == null)  {   // odd number of nodes
        tail = slow.next;
        slow.next = null;
        return tail;
    }
    else if (fast.next.next == null) {  // even number of nodes
        tail = slow.next.next;
        slow.next.next = null;
        return tail;
    }

    tail = reorder(slow.next, fast.next.next);

    ListNode tail2 = tail.next;
    tail.next = slow.next;
    slow.next = tail;

    return tail2;        
  }



  public static void readme()
  {
    String str = "You are given the head of a singly linked-list. The list can be represented as:\n\n";

      str += "L0 → L1 → … → Ln - 1 → Ln\n\n";
      str += "Reorder the list to be on the following form:\n\n";

      str += "L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …\n\n";
      str += "You may not modify the values in the list's nodes. Only nodes themselves may be changed.\n";

    System.out.println(str);
  }

  public static void main()
  {
    ReorderList.readme();
    ListNode node;
    // Input: head = [1,2,3,4]
    // Output: [1,4,2,3]
    node = new ListNode(4);
    node = new ListNode(3, node);
    node = new ListNode(2, node);
    ListNode list1 = new ListNode(1, node);

    System.out.println("List 1: ");
    list1.show();

    System.out.println("reorderList(list1): ");
    reorderList(list1);
    list1.show();
    System.out.println("");

    // Input: head = [1,2,3,4,5]
    // Output: [1,5,2,4,3]

    node = new ListNode(5);
    node = new ListNode(4, node);
    node = new ListNode(3, node);
    node = new ListNode(2, node);
    ListNode list2 = new ListNode(1, node);

    System.out.println("List 2: ");
    list2.show();

    System.out.println("reorderList(list2): ");
    reorderList(list2);
    list2.show();
    System.out.println("");

    node = new ListNode(5);
    node = new ListNode(4, node);
    node = new ListNode(3, node);
    node = new ListNode(2, node);
    ListNode list3 = new ListNode(1, node);

    System.out.println("List 3: ");
    list3.show();

    System.out.println("reorderListOpt(list3): ");
    reorderList(list3);
    list3.show();
    System.out.println("");

  }
}