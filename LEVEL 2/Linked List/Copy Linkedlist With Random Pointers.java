import java.util.*;

class Main {
    public static class ListNode {
        int val = 0;
        ListNode next = null;
        ListNode random = null;

        ListNode(int val) {
            this.val = val;
        }
    }

    public static void  copyList(ListNode head) {
        ListNode curr = head;
        while(curr != null){
            ListNode forw = curr.next;
            ListNode node = new ListNode(curr.val);
            curr.next = node;
            node.next = forw;
            
            curr = forw;
        }
    }
    
    public static void copyRandomPointers(ListNode head){
        ListNode curr = head;
        while(curr != null){
            ListNode random = curr.random;
            if(random != null){
                curr.next.random = random.next;
            }
            
            curr = curr.next.next;
        }
    }
    
    public static ListNode extractDeepCopy(ListNode head){
        ListNode dummy = new ListNode(-1);
        ListNode prev = dummy, curr = head;
        
        while(curr != null){
            prev.next = curr.next;
            curr.next = curr.next.next;
            
            prev = prev.next;
            curr = curr.next;
        }
        
        return dummy.next;
    }
    
    public static ListNode copyRandomList(ListNode head) {
        copyList(head);
        copyRandomPointers(head);
        return extractDeepCopy(head);
    }

    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        ListNode[] arr = new ListNode[n];
        ListNode prev = null;

        for (int i = 0; i < n; i++) {
            arr[i] = new ListNode(0);
            if (prev != null)
                prev.next = arr[i];
            prev = arr[i];
        }

        for (int i = 0; i < n; i++) {
            int val = scn.nextInt();
            int idx = scn.nextInt();

            arr[i].val = val;
            if(idx != -1) arr[i].random = arr[idx];
        }

        ListNode head = copyRandomList(arr[0]);
        while (head != null) {
            System.out.print("(" + head.val + ", " + (head.random != null ? head.random.val : -1) + ") ");
            head = head.next;
        }
    }
}