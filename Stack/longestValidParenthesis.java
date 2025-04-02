package Stack;

import java.util.ArrayList;
import java.util.Stack;

public class longestValidParenthesis {

    // Brute Force
    static int longestValidParenthesis(String s){
        Stack<Integer> stack = new Stack<>();
        removalOfValid(s, stack);

        if(stack.isEmpty()){
            return s.length();
        }

        ArrayList<Integer> arr = new ArrayList<>();
        formArrayOfStack(arr, stack, s);
        
        int max = 0;
        for(int i=1; i<arr.size(); i++){
           int value = arr.get(i) - arr.get(i-1) - 1;
           max = Math.max(max,value);
        }

        return max;
    }
    
    static void removalOfValid(String s, Stack<Integer> st ){
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '('){
                st.push(i);
            }else{
                if(st.isEmpty() || s.charAt(st.peek()) == ')'){
                    st.push(i);
                }else{
                    st.pop();
                }
            }
        }
    }

    static void formArrayOfStack(ArrayList<Integer> arr , Stack<Integer> st , String s){

        arr.add(0, s.length());

        while(!st.isEmpty()){
           arr.add(0, st.pop());
        }

        arr.add(0, -1);
    }
    


    // Optimal

    static int longestValid(String str){

        Stack<Integer> st = new Stack<>();
        st.push(-1);
        int max = 0;
        for(int i=0; i<str.length(); i++){
            char ch = str.charAt(i);
            if(ch == '('){
                st.push(i);
            }else{
                st.pop();
                if(st.isEmpty()){
                    st.push(i);
                }
            }

            max = Math.max(max, i-st.peek());
        }

        return max;
    }

    public static void main(String[] args) {
        String arr = "(()))";
        int res = longestValid(arr);
        System.out.println(res);
    }
}
