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
