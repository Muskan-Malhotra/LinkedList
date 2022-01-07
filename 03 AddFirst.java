import java.io.*;
/**
 * ALGO
 * Create a new node temp
 * if size is 0--> head and tail is temp only
 * if not temp's next  is head
 * head is at temp
 */

class AddFirst {
  public static class Node{
    int data;
    Node next;

    Node(){}

    Node(int data,Node next){
      this.data = data;
      this.next = next;
    }
  }

  public static class LinkedList{
    Node head;
    Node tail;
    int size;

    public void display(){
      if(size==0){
        return;
      }
      Node temp = head;
      while(temp!=null){
        System.out.print(temp.data+" ");
        temp = temp.next;
      }

    }

    public void addFirst(int val){
      Node temp = new Node(val,null);

      if(size == 0){
        head = temp;
        tail = temp;
      }
      else{
        temp.next = head;
        head = temp;
      }
      size++;

    }

  }
  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("addFirst")){
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addFirst(val);
      } else if (str.startsWith("display")) {
        list.display();
      }
      str = br.readLine();
    }
  }
}

/**
 * INPUT
 * addFirst 50
addFirst 40
display
40 50 
addFirst 100
display
100 40 50 quit
 */