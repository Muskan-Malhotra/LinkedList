import java.io.*;

class RemoveLast {

  public static class Node{
    int data;
    Node next;

    Node(int data,Node next){
      this.data = data;
      this.next = next;
    }
  }

  public static class LinkedList{
    Node head;
    Node tail;
    int size;

    public void addFirst(int val){
      Node n = new Node(val,null);

      if(size == 0){
        head = n;
        tail = n;
      }
      else{
        n.next = head;
        head = n;
      }
      size++;
    }

    public void display(){
      Node temp = head;

      while(temp != null){
        System.out.print(temp.data+" ");
        temp = temp.next;
      }
    }

    public int RemoveLast(){

      Node temp = head;
      //Cases
      if(size == 0){
        System.out.println("List is empty");
      }
      else if(size == 1){
        head = null;
        tail = null;
        size--;
      }else{
        while(temp.next.next != null){
          temp = temp.next;
        }
        temp.next = null;
        tail = temp;
        size--;
      }
      return tail.data;

    }
  }

  public static void main(String[] args) throws IOException{
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LinkedList list = new LinkedList();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("addFirst")){
        int val = Integer.parseInt(str.split(" ")[1]);
        list.addFirst(val);
      }
      else if(str.startsWith("display")){
        list.display();
      }
      else if(str.startsWith("removeLast")){
        int ans  = list.RemoveLast();
        System.out.println("Last element after removal: "+ans);
      }
      
      str = br.readLine();
    }
    

  }
  
}

/**
 * addFirst 10
addFirst 100
addFirst 1000
removeLast
100
display
1000 100 quit
 */