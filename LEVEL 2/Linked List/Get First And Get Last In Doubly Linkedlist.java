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

    // BasicFunctions======================================

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
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

    // getFunctions======================================

    public int getFirst() {
        if(ListIsEmptyException()){
            return -1;
        }
        
        return this.head.data;
    }

    public int getLast() {
        if(ListIsEmptyException()){
            return -1;
        }
        
        return this.tail.data;
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

      str = scn.nextLine();
    }

    System.out.println(dll);
  }
}