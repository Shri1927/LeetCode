package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class NextGreateElement {
    public ArrayList<Integer> nextLargerElement(int[] arr) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        Stack<Integer> s =new Stack<>();
        for(int i=arr.length-1; i>=0; i--){

            while(!s.isEmpty() && s.peek() <= arr[i]){
 
                s.pop();
            }
 
            if(s.isEmpty()){
                list.add(0,-1);
            }else{
                list.add(0,s.peek());
            }
            s.push(arr[i]);
        }
        
        return list;
    }
}
