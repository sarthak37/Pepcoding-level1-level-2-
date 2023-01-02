import java.util.*;

class Main {
  public static Scanner scn = new Scanner(System.in);

  public static class ListNode {
    int val = 0;
    ListNode next = null;

    ListNode(int val) {
      this.val = val;
    }
  }
  
  public static ListNode reverse(ListNode head){
        if(head == null || head.next == null) return head;
        
        ListNode curr = head;
        ListNode prev = null;
        while(curr != null){
            ListNode forw = curr.next;
            curr.next = prev;
            prev = curr;
            curr = forw;
        }
        
        return prev;
    }

  public static ListNode subtractTwoNumbers(ListNode l1, ListNode l2) {
    if(l2 == null) return l1;
    if(l1 == null) {
        l2.val = -l2.val;
        return l2;
    }
    
    l1 = reverse(l1);
    l2 = reverse(l2);
    
    ListNode head = new ListNode(-1);
    ListNode itr = head;
    
    ListNode c1 = l1;
    ListNode c2 = l2;
    
    int borrow = 0;
    while(c1 != null){
        int diff = borrow + c1.val - (c2 != null ? c2.val : 0);
        if(diff < 0){
            borrow = -1;
            diff += 10;
        } else {
            borrow = 0;
        }
        
        itr.next = new ListNode(diff);
        itr = itr.next;
        
        c1 = c1.next;
        if(c2 != null) c2 = c2.next;
    }
    
    return reverse(head.next);
  }

  // InFput_code===================================================

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode makeList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    ListNode head1 = makeList(scn.nextInt());
    ListNode head2 = makeList(scn.nextInt());

    ListNode ans = subtractTwoNumbers(head1, head2);
    printList(ans);
  }

}