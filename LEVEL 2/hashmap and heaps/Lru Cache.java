import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
  public static class LRU {
      
      class Node{
          int key,value;
          Node prev , next;
      }
      
      private void addNode(Node node){
          Node nbr = head.next;
          
          node.next = nbr;
          node.prev = head;
          
          nbr.prev = node;
          head.next = node;
      } 
      
      private void removeNode(Node node){
          Node prvNbr = node.prev;
          Node nxtNbr = node.next;
          
          prvNbr.next = nxtNbr;
          nxtNbr.prev = prvNbr;
          
          node.next = node.prev = null;
      }
      
      private void moveToFront(Node node){
          removeNode(node);
          addNode(node);
      }
      
      HashMap<Integer, Node> cache;
      int cap;
      Node head , tail;
      
      LRU(int capacity) {
          cache = new HashMap<>();
          cap = capacity;
          head = new Node();
          tail = new Node();
          
          head.next = tail;
          tail.prev = head;

    }

    public int get(int key) {
        Node node = cache.get(key);
        
        if(node == null){
            return -1;
        } else {
            int v1 = node.value;
            moveToFront(node);
            return v1;
        }
    }

    public void put(int key, int value) {
        Node node = cache.get(key);
        
        if(node == null){
            Node newNode = new Node();
            newNode.key = key;
            newNode.value = value;
            
            if(cache.size() == cap){
                Node LRU_Node = tail.prev;
                cache.remove(LRU_Node.key);
                removeNode(LRU_Node);
            }
            cache.put(key,newNode);
            addNode(newNode);
        } else {
            node.value = value;
            moveToFront(node);
        }
    }
  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    String str = br.readLine();
    LRU obj = new LRU(Integer.parseInt(str.split(" ")[1]));

    while (true) {
      str = br.readLine();
      String inp[] = str.split(" ");
      if (inp.length == 1) {
        break;
      } else if (inp.length == 2) {
        System.out.println(obj.get(Integer.parseInt(inp[1])));
      } else if (inp.length == 3) {
        obj.put(Integer.parseInt(inp[1]), Integer.parseInt(inp[2]));
      }
    }
  }
}