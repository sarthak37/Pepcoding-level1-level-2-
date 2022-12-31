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
    
    public static  ListNode[] segregate(ListNode head, int pivotIdx) {
        ListNode small = new ListNode(-1);
        ListNode large = new ListNode(-1);
        
        ListNode curr = head, sp = small, lp = large, pivotNode = head;
        
        while(pivotIdx-- > 0){
            pivotNode = pivotNode.next;
        }
        
        while(curr != null){
            if(curr != pivotNode) {
                if(curr.val <= pivotNode.val) {
                    sp.next = curr;
                    sp = sp.next;
                } else {
                    lp.next = curr;
                    lp = lp.next;
                }
            }
            
            curr = curr.next;
        }
        
        sp.next = null;
        lp.next = null;
        pivotNode.next = null;
        
        return new ListNode[] { small.next, pivotNode, large.next };
    }
    
    public static int length(ListNode node) {
        if(node == null){
            return 0;
        }
        ListNode curr = node;
        int len = 0;
        while (curr != null) {
            len++;
            curr = curr.next;
            
        }
        
        return len;
        
    }
    
    public static ListNode[] mergeSortedLists(ListNode[] leftSortedList, ListNode pivotNode, ListNode[] rightSortedList) {
        ListNode head = null, tail = null;
        if(leftSortedList[0] != null && rightSortedList[0] != null) {
            leftSortedList[1].next = pivotNode;
            pivotNode.next = rightSortedList[0];
            head = leftSortedList[0];
            tail = rightSortedList[1];
        } else if (leftSortedList[0] != null) {
            head = leftSortedList[0];
            leftSortedList[1].next = pivotNode;
            tail = pivotNode;
        } else if (rightSortedList[0] != null) {
            head = pivotNode;
            pivotNode.next = rightSortedList[0];
            tail = rightSortedList[1];
        } else {
            head = tail = pivotNode;
        }
        
        return new ListNode[] { head, tail };
    }
    
    public static ListNode[] quickSort_(ListNode head) {
        if(head == null || head.next == null) {
            return new ListNode[] {head , head };
        }
        
        int len = length(head);
        int pivotIdx = len / 2;
        
        ListNode[] segregatedLists = segregate(head, pivotIdx);
        ListNode[] leftSortedList = quickSort_(segregatedLists[0]);
        ListNode[] rightSortedList = quickSort_(segregatedLists[2]);
        
        return mergeSortedLists(leftSortedList, segregatedLists[1], rightSortedList);
    }

    public static ListNode quickSort(ListNode head) {
       return quickSort_(head)[0]; 
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

        ListNode head = quickSort(h1);
        printList(head);
    }
}