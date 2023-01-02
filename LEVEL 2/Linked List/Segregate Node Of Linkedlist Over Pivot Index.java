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

  public static ListNode segregate(ListNode head, int pivotIdx) {
    if(head == null || head.next == null) return head;
    
    int idx = 0, data = 0;
    ListNode curr = head;
    while(curr != null){
        if(idx == pivotIdx){
            data = curr.val;
            break;
        }
        
        curr = curr.next;
        idx++;
    }
    
    ListNode smaller = new ListNode(-1);
    ListNode sp = smaller;
    ListNode larger = new ListNode(-1);
    ListNode lp = larger;
    
    curr = head;
    ListNode pivot = null;
    idx = 0;
    while(curr != null){
        if(idx == pivotIdx){
            pivot = curr;
        }
        else if(curr.val <= data){
            sp.next = curr;
            sp = sp.next;
        } else {
            lp.next = curr;
            lp = lp.next;
        }
        
        curr = curr.next;
        idx++;
    }
    
    sp.next = pivot;
    pivot.next = larger.next;
    lp.next = null;
    
    return smaller.next;
  }

  public static void printList(ListNode node) {
    while (node != null) {
      System.out.print(node.val + " ");
      node = node.next;
    }
  }

  public static ListNode createList(int n) {
    ListNode dummy = new ListNode(-1);
    ListNode prev = dummy;
    while (n-- > 0) {
      prev.next = new ListNode(scn.nextInt());
      prev = prev.next;
    }

    return dummy.next;
  }

  public static void main(String[] args) {
    int n = scn.nextInt();
    ListNode h1 = createList(n);
    int idx = scn.nextInt();
    h1 = segregate(h1, idx);
    printList(h1);
  }
}