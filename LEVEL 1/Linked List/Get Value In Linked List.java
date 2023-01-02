import java.io.*;
import java.util.*;

public class Main {
  public static class Node {
    int data;
    Node next;
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      Node temp = new Node();
      temp.data = val;
      temp.next = null;

      if (size == 0) {
        head = tail = temp;
      } else {
        tail.next = temp;
        tail = temp;
      }

      size++;
    }

    public int size(){
      return size;
    }

    public void display(){
      for(Node temp = head; temp != null; temp = temp.next){
        System.out.print(temp.data + " ");
      }
      System.out.println();
    }

    public void removeFirst(){
      if(size == 0){
        System.out.println("List is empty");
      } else if(size == 1){
        head = tail = null;
        size = 0;
      } else {
        head = head.next;
        size--;
      }
    }

    public int getFirst(){
      if(size == 0){
          System.out.println("List is empty");
          return -1;
      } else {
          return head.data;
      }
    }

    public int getLast(){
         if(size == 0){
          System.out.println("List is empty");
          return -1;
         } else {
             return tail.data;
         }
    }

    public int getAt(int idx){
        if(size == 0){
          System.out.println("List is empty");
          return -1;
        } else if(idx < 0 || idx >= size){
            System.out.println("Invalid arguments");
            return -1;
        } else {
            Node temp = head;
            for(int i = 0; i < idx;i++){
                temp = temp.next;
            }
            return temp.data;
        }
      
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("addLast")){
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addLast(val);
      } else if(str.startsWith("size")){
        System.out.println(list.size());
      } else if(str.startsWith("display")){
        list.display();
      } else if(str.startsWith("removeFirst")){
        list.removeFirst();
      } else if(str.startsWith("getFirst")){
        int val = list.getFirst();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("getLast")){
        int val = list.getLast();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("getAt")){
        int idx = Integer.parseInt(str.split(" ")[1]);
        int val = list.getAt(idx);
        if(val != -1){
          System.out.println(val);
        }
      }
      str = br.readLine();
    }
  }
}