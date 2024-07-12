package linkedlist;

public class ListNode {
  int val;
  ListNode next;
  public ListNode() {}
  public ListNode(int val) { this.val = val; }
  public ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  public void show() {
    ListNode node = this;
    if (node == null) {
      System.out.print("This node is null.");
      return;
    }
    int loop = 0;
    while (node.next != null && loop ++ < 100) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
    if (loop < 20) {
      System.out.print(node.val + " -> null\n");
    } else {
      System.out.print(node.val + "\n");
    }
  }
  public void setNext(ListNode next) {
    this.next = next;
  }

}