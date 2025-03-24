package Stack;

import java.util.Stack;

public class parenthesis {
    
    // Valid Parenthesis

    public boolean isValid(String s) {
        int n = s.length();
        if(n%2!=0){
            return false;
        }

        Stack<Character> stack = new Stack<>();
        for(int i=0;i<n;i++){
            char ch = s.charAt(i);
            if(ch == '(' || ch == '[' || ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty()){
                    return false;
                }
                char top = stack.peek();
                if(ch == ')' && top != '('){
                    return false;
                }if(ch == ']' && top != '['){
                    return false;
                }if(ch == '}' && top != '{'){
                    return false;
                }else{
                    stack.pop();
                }
            }
        }

        return (stack.size()==0);
    }


    // Countin min reversal to balance

    // Method 1 with O(n+m) complexity & with Stack
    static int countRev (String s)
    {
        // your code here   
        if(s.length()%2 != 0){
            return -1;
        }
        
        Stack<Character> stack = new Stack<>();
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                stack.push(ch);
            }else{
                if(stack.isEmpty() || stack.peek() == '}'){
                    stack.push(ch);
                }else{
                    stack.pop();
                }
            }
        }
        
        int open=0,close=0;
        while(!stack.isEmpty()){
            char top = stack.pop();
            if(top == '{'){
                open++;
            }else{
                close++;
            }
        }
        
       int ans = (int) (Math.ceil(open / 2.0) + Math.ceil(close / 2.0));
        return ans;
    }
    // Method 2 with O(n) complexity & Without Stack

    static int countRev2 (String s)
    {
        // your code here   
        if(s.length()%2 != 0){
            return -1;
        }
        
        int open=0,close=0;
        for(int i=0; i<s.length(); i++){
            char ch = s.charAt(i);
            if(ch == '{'){
                open+=1;
            }else{
                if(open<=0){
                    close++;
                }else{
                    open--;
                }
            }
        }
        
       int ans = (int) (Math.ceil(open / 2.0) + Math.ceil(close / 2.0));
        return ans;
    }

    public static void main(String[] args) {
        String str = "}{{}}{{{";
        int res = countRev(str);
        int res1 = countRev2(str);
        System.out.println(res);
        System.out.println(res1);
    }

}
