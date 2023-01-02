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
    
    private Node removeNodeAt(int index){
        if(index == 0) return removeFirstNode();
        else if(index == this.size - 1) return removeLastNode();
        else {
            Node node = getNodeAt(index);
            Node prev = node.prev;
            Node forw = node.next;
            
            prev.next = forw;
            forw.prev = prev;
            
            node.next = node.prev = null;
            
            this.size--;
            return node;
        }
    }

    public int removeAt(int index) {
      if(ListIsEmptyException()) return -1;
      else if(indexIsInvalidException(index, 0, this.size - 1)){
          return -1;
      }
      
      return removeNodeAt(index).data;
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

      str = scn.nextLine();
    }

    System.out.println(dll);
  }
}