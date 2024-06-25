package easy;

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

    while (node.next != null) {
      System.out.print(node.val + " -> ");
      node = node.next;
    }
    System.out.print(node.val + " -> null\n");
  }
}