import java.io.*;

class GetFLAt {

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

    public int getFirst(){
      //Cases
      if(size == 0){
        System.out.println("List is empty");
        return -1;
      }
      else{
        return head.data;
      }
    }

    public int getLast(){
      if(size == 0){
        System.out.println("List is empty");
        return -1;
      }
      else{
        return tail.data;
      }
    }

    public int getAt(int idx){
      Node temp = head;

      if(size == 0){
        System.out.println("List is empty");
        return -1;
      }else if(idx == 0){
        return getFirst();
      }else if(idx == size-1){
        return getLast();
      }else if(idx<0 || idx>=size){
        System.out.println("Invalid Index");
        return -1;
      }
      else{
        for(int i=0;i<idx;i++){
          temp = temp.next;
        }
        return temp.data;
      }
    }
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
      if(str.startsWith("getFirst")){
        int ans = list.getFirst();
        if(ans != -1)
          System.out.println(ans);
      }
      if(str.startsWith("getLast")){
        int ans = list.getLast();
        if(ans != -1)
          System.out.println(ans);
      }
      if(str.startsWith("getAt")){
        int indx = Integer.parseInt(str.split(" ")[1]);

        int ans = list.getAt(indx);
        if(ans != -1)
          System.out.println(ans);
      }
      else if(str.startsWith("removeFirst")){
        list.RemoveFirst();
      }
      str = br.readLine();
    }
    

  }
  
}

/**
 * Input
 * addFirst 10
addFirst 20
addFirst 200
display
200 20 10       
removeFirst
getAt 0
20
display
20 10 quit
 */