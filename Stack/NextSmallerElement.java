package Stack;

import java.util.Stack;

public class NextSmallerElement {
    public static int[] help_classmate(int arr[], int n) 
	{ 
	    // Your code goes here
	    Stack<Integer> s =new Stack<>();
	    int smaller[] = new int[n];
        for(int i=arr.length-1; i>=0; i--){

            while(!s.isEmpty() && s.peek() >= arr[i]){
 
                s.pop();
            }
 
            if(s.isEmpty()){
                smaller[i] = -1;
            }else{
                smaller[i] = s.peek();
            }
            s.push(arr[i]);
        }
        
        return smaller;
	} 
}
