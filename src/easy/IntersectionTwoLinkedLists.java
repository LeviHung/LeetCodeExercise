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
}