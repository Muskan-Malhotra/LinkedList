import java.io.*;



class AtatIndx {

  public class Node{
    int data;
    Node next;

    Node(int data, Node next){
      this.data = data;
      this.next = next;
    }

  }
  public static class LinkedList{
    Node head;
    Node tail;
    int size;

    //At at index with Value
    public void addAt(int idx, int val){
      AtatIndx at = new AtatIndx();
      Node n = at.new Node(val,null);

      Node temp = head;

      if(idx==0){
        addFirst(val);
      }
      else if(idx ==size){
        addLast(val);
      }
      else if(idx<0 || idx > size){
        System.out.println("Invalid arguments");
      }
      else{
        for(int i=1;i<idx;i++){
          temp = temp.next;
        }

        n.next = temp.next;
        temp.next = n;
        size++;
      }

    }

     //Add last
    public void addLast(int val){
      AtatIndx at = new AtatIndx();
      Node n = at.new Node(val, null);

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

     //Add first
     public void addFirst(int val){
      AtatIndx at = new AtatIndx();
      Node n = at.new Node(val, null);

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

    //Display
    public void display(){
      Node temp = head;

      if(size==0){
        return;
      }
      
      while(temp != null){
        System.out.print(temp.data+" ");
        temp = temp.next;
      }
      size++;
    }
  }



public static void main(String[] args) throws IOException{
  BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
  String str = br.readLine();
  LinkedList list = new LinkedList();

  while(str.equals("quit") == false){
    if(str.startsWith("addLast")){
      int val = Integer.parseInt(str.split(" ")[1]);
      list.addLast(val);
    }
    else if(str.startsWith("display")){
      list.display();
    }
    else if(str.startsWith("addAt")){
      int idx = Integer.parseInt(str.split(" ")[1]);
      int val = Integer.parseInt(str.split(" ")[2]);
      list.addAt(idx,val);
    }
    else if(str.startsWith("addFirst")){
      int val = Integer.parseInt(str.split(" ")[1]);
      list.addFirst(val);
    }
    str = br.readLine();
  }

}  
}