import java.util.*;

class Main {

  public static class DoublyLinkedList {
    private class Node {
      int data = 0;
      Node prev = null;
      Node next = null;

      Node(int data) {
        this.data = data;
      }

    }

    private Node head = null;
    private Node tail = null;
    private int size = 0;

    public String toString() {
      StringBuilder sb = new StringBuilder();
      Node curr = this.head;
      sb.append("[");
      while (curr != null) {
        sb.append(curr.data);
        if (curr.next != null)
          sb.append(", ");
        curr = curr.next;
      }
      sb.append("]");

      return sb.toString();
    }

    // Exceptions========================================

    private boolean ListIsEmptyException() {
      if (this.size == 0) {
        System.out.print("ListIsEmpty: ");
        return true;
      }
      return false;
    }

    private boolean indexIsInvalidException(int index, int leftRange, int rightRange) {
      if (index < leftRange || index > rightRange) {
        System.out.print("IndexIsInValid: ");
        return true;
      }
      return false;
    }

    // BasicFunctions======================================

    public int size() {
      return this.size;
    }

    public boolean isEmpty() {
      return this.size == 0;
    }

    public void displayForw() {
      // write your code nul
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      
      Node curr = this.head;
      while(curr != null){
          sb.append(curr.data);
          if(curr.next != null){
              sb.append(", ");
          }
          curr = curr.next;
      }
      
      sb.append("]");
      System.out.println(sb.toString());
    }

    public void displayBack() {
      // write your code
      StringBuilder sb = new StringBuilder();
      sb.append("[");
      
      Node curr = this.tail;
      while(curr != null){
          sb.append(curr.data);
          if(curr.prev != null){
              sb.append(", ");
          }
          curr = curr.prev;
      }
      
      sb.append("]");
      System.out.println(sb.toString());
    }

    // AddFunctions======================================

    private void addFirstNode(Node node) {
      if (this.size == 0)
        this.head = this.tail = node;
      else {
        node.next = this.head;
        this.head.prev = node;
        this.head = node;
      }
      this.size++;
    }

    public void addFirst(int val) {
      Node node = new Node(val);
      addFirstNode(node);
    }

    private void addLastNode(Node node) {
      if (this.size == 0)
        this.head = this.tail = node;
      else {
        this.tail.next = node;
        node.prev = this.tail;
        this.tail = node;
      }
      this.size++;
    }

    public void addLast(int val) {
      Node node = new Node(val);
      addLastNode(node);
    }

    private void addNodeAt(int index, Node node) {
      if (index == 0)
        addFirstNode(node);
      else if (index == this.size)
        addLastNode(node);
      else {
        Node forw = getNodeAt(index);
        Node prev = forw.prev;

        prev.next = node;
        node.prev = prev;

        node.next = forw;
        forw.prev = node;

        this.size++;
      }
    }

    public void addAt(int index, int data) {
      if (indexIsInvalidException(index, 0, this.size))
        System.out.println(-1);
      else {
        Node node = new Node(data);
        addNodeAt(index, node);
      }
    }

    public void addBefore(Node refNode, int data) {
      Node node = new Node(data);
      Node prev = refNode.prev;

      if (prev == null) {
        node.next = refNode;
        refNode.prev = node;
        this.head = node;
      } else {
        prev.next = node;
        node.prev = prev;

        node.next = refNode;
        refNode.prev = node;
      }

      this.size++;
    }

    public void addBefore(int idx, int data) {
      Node node = getNodeAt(idx);
      addBefore(node, data);
    }

    public void addAfter(Node refNode, int data) {
      Node node = new Node(data);
      Node forw = refNode.next;

      if (forw == null) {
        refNode.next = node;
        node.prev = refNode;
        this.tail = node;
      } else {
        forw.prev = node;
        node.next = forw;

        node.prev = refNode;
        refNode.next = node;
      }

      this.size++;
    }

    public void addAfter(int idx, int data) {
      Node node = getNodeAt(idx);
      addAfter(node, data);
    }

    // RemoveFunctions======================================

    private Node removeFirstNode() {
      Node node = this.head;
      if (this.size == 1)
        this.head = this.tail = null;
      else {
        Node nextNode = this.head.next;
        nextNode.prev = null;
        node.next = null;

        this.head = nextNode;
      }

      this.size--;
      return node;
    }

    public int removeFirst() {
      if (ListIsEmptyException())
        return -1;
      Node node = removeFirstNode();
      return node.data;
    }

    private Node removeLastNode() {
      Node node = this.tail;
      if (this.size == 1)
        this.head = this.tail = null;
      else {
        Node prevNode = this.tail.prev;
        prevNode.next = null;
        node.prev = null;

        this.tail = prevNode;
      }

      this.size--;
      return node;
    }

    public int removeLast() {
      if (ListIsEmptyException())
        return -1;
      Node node = removeLastNode();
      return node.data;
    }

    private Node removeAtNode(int index) {
      if (index == 0)
        return removeFirstNode();
      else if (index == this.size - 1)
        return removeLastNode();
      else {
        Node node = getNodeAt(index);
        Node prev = node.prev;
        Node forw = node.next;

        prev.next = forw;
        forw.prev = prev;

        node.next = null;
        node.prev = null;

        this.size--;
        return node;
      }
    }

    public int removeAt(int index) {
      if (ListIsEmptyException())
        return -1;
      if (indexIsInvalidException(index, 0, this.size - 1))
        return -1;

      Node node = removeAtNode(index);
      return node.data;
    }

    private Node removeAfterNode(Node refNode) {
      Node forw = refNode.next;
      if (forw.next == null) {
        refNode.next = null;
        forw.prev = null;
        this.tail = refNode;
      } else {
        refNode.next = forw.next;
        forw.next.prev = refNode;

        forw.next = null;
        forw.prev = null;
      }
      this.size--;
      return forw;
    }

    public int removeAfter(Node refNode) {
      if (refNode.next == null) {
        System.out.println("LocationIsInvalid: ");
        return -1;
      }
      return removeAfterNode(refNode).data;
    }

    public int removeAfter(int idx) {
      Node node = getNodeAt(idx);
      return removeAfter(node);
    }

    private Node removeBeforeNode(Node refNode) {
      Node prevNode = refNode.prev;
      if (prevNode.prev == null) {
        refNode.prev = null;
        prevNode.next = null;
        this.head = refNode;
      } else {
        refNode.prev = prevNode.prev;
        prevNode.prev.next = refNode;

        prevNode.next = null;
        prevNode.prev = null;
      }
      this.size--;
      return prevNode;
    }

    public int removeBefore(Node refNode) {
      if (refNode.prev == null) {
        System.out.println("LocationIsInvalid: ");
        return -1;
      }
      return removeBeforeNode(refNode).data;
    }

    public int removeBefore(int idx) {
      Node node = getNodeAt(idx);
      return removeBefore(node);
    }

    public int removeNode(Node refNode) {
        Node prev = refNode.prev;
        Node forw = refNode.next;
        if(this.size == 1)
            this.head = this.tail = null;
        else if(prev == null) 
           this.head = forw;
        else if(forw == null)
           this.tail = prev;
        else{
            prev.next = forw;
            forw.prev = prev;
        }
      
        refNode.prev = refNode.next = this.head.prev = this.tail.next = null;
        this.size--;
        return refNode.data;
    }
    public int removeNode(int idx) {
      Node node = getNodeAt(idx);
      return removeBefore(node);
    }

    // getFunctions======================================

    public int getFirst() {
      if (ListIsEmptyException())
        return -1;

      return this.head.data;
    }

    public int getLast() {
      if (ListIsEmptyException())
        return -1;

      return this.tail.data;
    }

    private Node getNodeAt(int index) {
      Node curr = this.head;
      while (index-- > 0)
        curr = curr.next;

      return curr;
    }

    public int getAt(int index) {
      if (ListIsEmptyException())
        return -1;
      else if (indexIsInvalidException(index, 0, this.size - 1))
        return -1;

      Node node = getNodeAt(index);
      return node.data;
    }

  }

  public static void main(String[] args) {
    Scanner scn = new Scanner(System.in);
    DoublyLinkedList dll = new DoublyLinkedList();

    String str = scn.nextLine();
    while (!str.equals("stop")) {
      String[] s = str.split(" ");
      if (s[0].equals("addFirst"))
        dll.addFirst(Integer.parseInt(s[1]));
      else if (s[0].equals("addLast"))
        dll.addLast(Integer.parseInt(s[1]));
      else if (s[0].equals("removeFirst"))
        System.out.println(dll.removeFirst());
      else if (s[0].equals("removeLast"))
        System.out.println(dll.removeLast());
      else if (s[0].equals("getFirst"))
        System.out.println(dll.getFirst());
      else if (s[0].equals("getLast"))
        System.out.println(dll.getLast());
      else if (s[0].equals("size"))
        System.out.println(dll.size());
      else if (s[0].equals("isEmpty"))
        System.out.println(dll.isEmpty());
      else if (s[0].equals("getAt"))
        System.out.println(dll.getAt(Integer.parseInt(s[1])));
      else if (s[0].equals("addAt"))
        dll.addAt(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
      else if (s[0].equals("removeAt"))
        dll.removeAt(Integer.parseInt(s[1]));
      else if (s[0].equals("addBefore"))
        dll.addBefore(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
      else if (s[0].equals("addAfter"))
        dll.addAfter(Integer.parseInt(s[1]), Integer.parseInt(s[2]));
      else if (s[0].equals("removeAfter"))
        System.out.println(dll.removeAfter(Integer.parseInt(s[1])));
      else if (s[0].equals("removeBefore"))
        System.out.println(dll.removeBefore(Integer.parseInt(s[1])));
      else if (s[0].equals("removeNode"))
        System.out.println(dll.removeNode(Integer.parseInt(s[1])));
      else if (s[0].equals("displayForw"))
        dll.displayForw();
      else if (s[0].equals("displayBack"))
        dll.displayBack();

      str = scn.nextLine();
    }

    System.out.println(dll);
  }
}