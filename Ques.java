import java.util.*;
import java.io.*;

class Ques{

  public static ArrayList<Integer> sum_two(ArrayList<Integer> input_array){
      int len= input_array.size();
      ArrayList<Integer> lst= new ArrayList<>();

      for(int i=0,j=len-1;i<=len/2&&j>=len/2;i++,j--){
        if(i!=j){
          int sum= input_array.get(i)+input_array.get(j);
          lst.add(sum);
        }
        else{
          lst.add(input_array.get(len/2));
        }
      }

      if(lst.size()>2){
        lst = sum_two(lst);
      }

      return lst;
  }
  public static void main(String[] args){
    ArrayList<Integer> input_array= new ArrayList<>();
    Scanner scn= new Scanner(System.in);
    System.out.print("Enter length of arraylist:");
    int n = scn.nextInt();
    
    System.out.print("Enter elements of arraylist:");
    
    for(int i=0;i<n;i++){
      int o = scn.nextInt();
      input_array.add(o);
    }

    System.out.println("Entered List is:"+input_array);

    ArrayList<Integer> lst =sum_two(input_array);

    System.out.println(lst);
}
}