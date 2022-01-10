import java.io.*;

class RemoveAt {

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

    // %%%%%%%%%%%%%%%%%%%%  ADD FIRST %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
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
// %%%%%%%%%%%%%%%%%%%%  REMOVE FIRST %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    public void RemoveFirst(){

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
        head = head.next;
        temp.next = null;
        size--;
      }

    }
// %%%%%%%%%%%%%%%%%%%%  REMOVE AT %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
    public void removeAt(int idx){

      Node temp = head;
      // Node idxNode = head;
      
      if(size == 0){
         System.out.println("List is empty"); 
      }
      else if(size == 1){
          head = null;
          tail = null;
          size--;
      }else if(idx < 0 || idx >=size){
        System.out.println("Invalid arguments");
          
      }else if(idx == 0){
          RemoveFirst();
          
      }else if(idx == size-1){
          RemoveLast();
          
      }else if(size >= 3){
          for(int i=0;i<idx-1;i++){
              temp = temp.next;
          }
        //   idxNode = temp.next;
          temp.next = temp.next.next;
        //   idxNode.next = null;
         
          size--;
      }
    }


    // %%%%%%%%%%%%%%%%%%%%  REMOVE LAST %%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
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
      else if(str.startsWith("removeAt")){
        int idx = Integer.parseInt(str.split(" ")[1]);
        list.removeAt(idx);
      }
      
      str = br.readLine();
    }
    

  }
  
}

