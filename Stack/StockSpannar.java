package Stack;

import java.util.ArrayList;
import java.util.Stack;

class StockSpanner {

    Stack<Integer> stack;
    ArrayList<Integer> list;

    public StockSpanner() {
        stack = new Stack<>();
        list = new ArrayList<>();
    }
    
    public int next(int price) {
        list.add(price);

        while(!stack.isEmpty() && list.get(stack.peek())<=price){
            stack.pop();
        }

        int previousGreaterIndex = (stack.isEmpty())?-1:stack.peek();
        int currIndex = list.size()-1;
        int ans = currIndex-previousGreaterIndex;
        stack.push(currIndex);
        return ans;
    }
}
