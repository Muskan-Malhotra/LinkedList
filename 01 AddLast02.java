import java.io.*;
// ####################### METHOD WITH PARAMETERIZED CONSTRUCTOR ######################
class addLast02 {
  public static class Node {
    int data;
    Node next;

    /// Default constructor coz when we have the para constructor the default is revoked
    Node(){}

    //Parameterized constructor helps as the time of providing values
    Node(int data, Node next){
      // this is the third refernce object of the constructor
      //this keeps the refernce of the object so created via calling constructor

      this.data = data;
      this.next = next;
    }
  }

  public static class LinkedList {
    Node head;
    Node tail;
    int size;

    void addLast(int val) {
      // Write your code here
      Node n = new Node(val,null);
      
      if(size==0){
          head = n;
          tail = n;
          
      }
      else{
        tail.next = n;
        tail = n;
      }
      size++;
    }
    
  }

  public static void testList(LinkedList list) {
    for (Node temp = list.head; temp != null; temp = temp.next) {
      System.out.println(temp.data);
    }
    System.out.println(list.size);

    if (list.size > 0) {
      System.out.println(list.tail.data);
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
      } 
      str = br.readLine();
    }

    testList(list);
  }
}