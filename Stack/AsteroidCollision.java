package Stack;

import java.util.Stack;

public class AsteroidCollision {

    public int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        for(int i=0; i<asteroids.length;i++){
            if(stack.isEmpty() || asteroids[i]>0){
                stack.push(asteroids[i]);
            }else{
                while(!stack.isEmpty()){
                    int top = stack.peek();
                    if(top<0){
                        stack.push(asteroids[i]);
                        break;
                    }

                    int modVal = Math.abs(asteroids[i]);
                    if(modVal == top){
                        stack.pop();
                        break;
                    }else if(modVal < top){
                        break;
                    }else{
                        stack.pop();
                        if(stack.isEmpty()){
                            stack.push(asteroids[i]);
                            break;
                        }
                    }
                }
            }
        }

        int ans[] = new int[stack.size()];
        for(int i=ans.length-1; i>=0; i--){
            ans[i] = stack.peek();
            stack.pop();
        }

        return ans;
    }
}
