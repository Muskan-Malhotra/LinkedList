import java.io.*;
/**
 * ALGO
 * create a node temp at head(No new node)
 * now while the temp does not reach null loop over the LL
 * print the temp.data
 * increase temp by temp = temp.next 
 */
class Size_Display {

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

    void addLast(int val){   //can't make a function static beocz head,tail and size are not static
      Node n = new Node(val,null);

      if(size == 0){
        head = n;
        tail = n;
      }
      else{
        tail.next = n;
        tail = n;
      }
      size++;
    }
    public int size(){
      int sizeLL = 0;
      Node temp = head;
      while(temp != null){
        sizeLL++;
        temp = temp.next;
      }
      return sizeLL;
    }
    public void display(){

      if(size == 0){
        return;
      }
      Node temp = head;
      while(temp!=null){
        System.out.print(temp.data+" ");
        temp = temp.next;
      }
      System.out.println();
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
      }
      str = br.readLine();
    }
  }
}


//Input
/* 
addLast 10
addLast 20
addLast 30
display
size
addLast 40
addLast 50
display
size
quit */