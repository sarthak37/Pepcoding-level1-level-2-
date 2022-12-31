import java.io.*;
import java.util.*;

public class Main {
  public static class MyCircularDeque<T> {
      
      private class Node{
          T data;
          Node next,pre;
          
          Node(){
              data = null;
          }
          Node(T value){
              data = value;
          }
          
          public void delete(){
              pre.next = next;
              next.pre = pre;
          }
      }
      
      final private Node front;
      final private Node rear;
      private int size = 0;

    /** Initialize your data structure here.*/
    public MyCircularDeque() {
        front = new Node();
        rear = new Node();
        front.next = rear;
        rear.pre = front;
    }

    /**
     * Adds an item at the front of Deque.
     */
    public void insertFront(T value) {
        Node n = new Node(value);
        n.pre = front;
        n.next = front.next;
        front.next = n;
        n.next.pre = n;
        size++;
    }

    /**
     * Adds an item at the rear of Deque.
     */
    public void insertLast(T value) {
        Node n =  new Node(value);
        n.next = rear;
        n.pre = rear.pre;
        n.pre.next = n;
        rear.pre = n;
        size++;
    }

    /**
     * Deletes the front item from the Deque and return it's value. If the deque is empty, return null.
     */
    public T deleteFront() {
        if(size == 0)return null;
        Node n = front.next;
        T value = n.data;
        
        n.delete();
        size--;
        return value;
    }

    /**
     * Deletes the last item from Deque and return it's value. If the deque is empty, return null.
     */
    public T deleteLast() {
        if(size == 0)return null;
        Node n = rear.pre;
        T value = n.data;
        
        n.delete();
        size--;
        return value;
    }

    /** Gets the front item from the Deque. If the deque is empty, return null. */
    public T getFront() {
        if(size == 0) return null;
        return front.next.data;
    }

    /** Gets the last item from Deque. If the deque is empty, return null. */
    public T getRear() {
        if(size == 0)return null;
        return rear.pre.data;
    }

    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader read = new BufferedReader(new InputStreamReader(System.in));

    MyCircularDeque<Integer> obj = new MyCircularDeque<>();

    while (read.ready()) {
      String inp[] = read.readLine().split(" ");
      String s = inp[0];

      if (s.equals("insertLast")) {
        obj.insertLast(Integer.parseInt(inp[1]));
      } else if (s.equals("insertFront")) {
        obj.insertFront(Integer.parseInt(inp[1]));
      } else if (s.equals("deleteFront")) {
        System.out.println(obj.deleteFront());
      } else if (s.equals("deleteLast")) {
        System.out.println(obj.deleteLast());
      } else if (s.equals("getFront")) {
        System.out.println(obj.getFront());
      } else if (s.equals("getRear")) {
        System.out.println(obj.getRear());
      } else if (s.equals("isEmpty")) {
        System.out.println(obj.isEmpty());
      }
    }

  }
}