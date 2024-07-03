package easy;

public class IntersectionTwoLinkedLists
{
  public static ListNode getIntersectionNode(ListNode headA, ListNode headB)
  {
    boolean isInter = false;
    ListNode inter = null;
    ListNode headBTemp = headB;
    while (headA != null) {
      //if (headA.val == headBTemp.val) {
      if (headA == headBTemp) {
        if (isInter == false) {
          //System.out.println("### inter = " + inter.val);
          inter = headA;
          isInter = true;
        }
        headA = headA.next;
        headBTemp = headBTemp.next;

      } else {
        if (isInter == true) {
          headBTemp = headB;
          isInter = false;
        } else {
          headBTemp = headBTemp.next;
        }
      }
      
      if (headBTemp == null) {
        headBTemp = headB;
        if (isInter == false) { 
          headA = headA.next;
        }
      }
    }
    return inter;
  }

  public static ListNode getIntersectionNodeOpt(ListNode headA, ListNode headB) 
  {
    int ac = 0;
    int bc = 0;
    ListNode a = headA;
    ListNode b = headB;
    while (a != null) {
      ac++;
      a = a.next;
    }

    while (b != null) {
      bc++;
      b = b.next;
    }

    while (ac > bc) {
      ac--;
      headA = headA.next;
    }
    while (bc > ac) {
      bc--;
      headB = headB.next;
    }

    while (headA != headB) {
      headA = headA.next;
      headB = headB.next;
    }
    
    return headA;
  }
  
  public static void readme()
  {
    String str = "Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.\n\n";

    str += "For example, the following two linked lists begin to intersect at node c1:\n\n";
    
    str += "The test cases are generated such that there are no cycles anywhere in the entire linked structure.\n\n";

    str += "Note that the linked lists must retain their original structure after the function returns.\n";

    System.out.println(str);
  }

  public static void main() 
  {
    IntersectionTwoLinkedLists.readme();

    // listA = [4,1,8,4,5], listB = [5,6,1,8,4,5], => 8
    ListNode node2;
    ListNode node3;
    ListNode node4;
    ListNode node5;
    ListNode node6;


    node6 = new ListNode(5);
    node5 = new ListNode(4, node6);
    node4 = new ListNode(8, node5);
    node2 = new ListNode(1, node4);
    ListNode list1 = new ListNode(4, node2);

    System.out.println("List 1: ");
    list1.show();

    //node6 = new ListNode(5);
    //node5 = new ListNode(4, node6);
    //node4 = new ListNode(8, node5);
    node3 = new ListNode(1, node4);
    node2 = new ListNode(6, node3);
    ListNode list2 = new ListNode(5, node2);

    System.out.println("List 2: ");
    list2.show();

    System.out.println("getIntersectionNodeOpt(list1, list2): ");
    ListNode list3 = IntersectionTwoLinkedLists.getIntersectionNodeOpt(list1, list2);
    System.out.println("List 3: ");
    list3.show();
    System.out.println("");

    // listA = [1,9,1,2,4], listB = [3,2,4],

    node5 = new ListNode(4);
    node4 = new ListNode(2, node5);
    node3 = new ListNode(1, node4);
    node2 = new ListNode(9, node3);
    ListNode list4 = new ListNode(1, node2);
    System.out.println("List 4: ");
    list4.show();

    ListNode list5 = new ListNode(3, node4);
    System.out.println("List 5: ");
    list5.show();

    System.out.println("getIntersectionNode(list4, list5): ");
    ListNode list6 = IntersectionTwoLinkedLists.getIntersectionNode(list4, list5);
    System.out.println("List 6: ");
    if (list6 == null) {
      System.out.println("The two lists do not intersect.");
    } else {
      list6.show();
    }
    System.out.println("");

    // listA = [2,6,4], listB = [1,5],
    node3 = new ListNode(4);
    node2 = new ListNode(6, node3);
    ListNode list7 = new ListNode(2, node2);
    System.out.println("List 7: ");
    list7.show();

    node2 = new ListNode(5);
    ListNode list8 = new ListNode(1, node2);
    System.out.println("List 8: ");
    list8.show();
    System.out.println("getIntersectionNode(list7, list8): ");
    System.out.println("List 9: ");
    ListNode list9 = IntersectionTwoLinkedLists.getIntersectionNode(list7, list8);
    if (list9 == null) {
      System.out.println("The two lists do not intersect.");
    } else {
      list9.show();
    }
  }
}