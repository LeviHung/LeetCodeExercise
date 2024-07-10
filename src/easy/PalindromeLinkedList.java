package easy;
import java.util.List;
import java.util.ArrayList;

public class PalindromeLinkedList
{  
  public static boolean isPalindrome(ListNode head)
  {
    List <Integer> list = new ArrayList<>();

    ListNode tmp = head;
    while (tmp != null) {
      list.add(tmp.val);
      tmp = tmp.next;
    }
    int check = list.size() / 2 ;
    int index = list.size() - 1;
    tmp = head;
    while (tmp != null && index >= check ) {
      if (tmp.val != list.get(index--)) {
        return false;
      }
      tmp = tmp.next;
    }
    return true;
  }

  static final int [] array1 = new int [100000];
  public static boolean isPalindromeEx(ListNode head)
  {
    // Use array to get better for the runtime.
    //List <Integer> list = new ArrayList<>();

    final int [] array = array1;
    ListNode tmp = head;
    int size = 0;
    while (tmp != null) {
      array[size++] = tmp.val;
      tmp = tmp.next;
    }

    int check = size / 2;
    for (int i = 0; i < check; i ++) {
      if (array[i] != array[--size]) {
        return false;
      }
    }
    return true;
  }
  
  private static final int[] array = new int[100000];
  
  public boolean isPalindromeOpt(ListNode head) 
  {
    if (head == null || head.next == null) {
      return true;
    }
     
    ListNode h = head;
    final int[] array1 = array;
    int size = 0;

     while (h != null) {
       array1[size++] = h.val;
       h = h.next;
     }

     int m = size / 2;
     for (int i = 0; i < m; i++) {
       if (array[i] != array1[--size]) {
         return false;
       }
     }
     return true;
  }
  
  public static void readme()
  {
    String str = "Given the head of a singly linked list, return true if it is a palindrome or false otherwise.\n\n";

    System.out.println(str);
  }

  public static void main() 
  {
    PalindromeLinkedList.readme();

    // head = [1,2,2,1] => true
    ListNode node2;
    ListNode node3;
    ListNode node4;
    ListNode node5;
    ListNode node6;
    ListNode node7;

    node4 = new ListNode(1);
    node3 = new ListNode(2, node4);
    node2 = new ListNode(2, node3);
    ListNode list1 = new ListNode(1, node2);
    System.out.println("List 1: ");
    list1.show();

    System.out.println("isPalindrome(list1) =  " +  PalindromeLinkedList.isPalindrome(list1));

    // head = [1,2] => false
    node2 = new ListNode(2);
    ListNode list2 = new ListNode(1, node2);
    System.out.println("List 2: ");
    list2.show();

    System.out.println("isPalindrome(list2) =  " +  PalindromeLinkedList.isPalindrome(list2));

  }
}