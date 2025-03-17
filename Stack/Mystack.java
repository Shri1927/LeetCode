package Stack;

import java.util.Stack;

public class Mystack {
    
    int stack[];
    int size;
    int top;

    public Mystack(int stackSize){
        stack = new int[stackSize];
        size = stackSize;
        top = -1;
    }

    public void push(int element){
        if(top >= size-1){
            System.out.println("Stack is Full - Overflow");
            return;
        }
        top++;
        stack[top] = element;
    }

    public boolean isEmpty(){
        return top <=-1;
    }

    public int size(){
        return top+1;
    }

    public int peek(){
        if(isEmpty()){
            System.out.println("Stack is empty - UnderFlow");
            return Integer.MIN_VALUE;
        }
        return stack[top];
    }

    public int pop(){

        int val = peek();
        if(isEmpty()){
            System.out.println("Stack is empty - UnderFlow");
        }
        top--;
        return val;
        
    }


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


    public static void main(String[] args) {
        int n = 5;
        Mystack stack = new Mystack(n);
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        int res = stack.size();
        System.out.println(res);
        System.out.println(stack.peek());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.pop());
        System.out.println(stack.isEmpty());
    }
}
