package Stack;

import java.util.Stack;

public class Histogram {

    // Brute Force

    static int LargestAreaOfHistogram(int arr[]){
        int ns[] = findNextSmaller(arr);
        int ps[] = findPrevSmaller(arr);

        int max = Integer.MIN_VALUE;
        for(int i=0; i<arr.length; i++){
            int height = arr[i];
            int width = ns[i] - ps[i] - 1;

            max = Math.max(max, height*width);
        }

        return max;
    }

     public static int[] findNextSmaller(int arr[]) 
	{ 
	    // Your code goes here
        int n = arr.length;
	    Stack<Integer> s =new Stack<>();
	    int smaller[] = new int[n];
        for(int i=arr.length-1; i>=0; i--){

            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
 
                s.pop();
            }
 
            if(s.isEmpty()){
                smaller[i] = n;
            }else{
                smaller[i] = s.peek();
            }
            s.push(i);
        }
        
        return smaller;
	} 

    public static int[] findPrevSmaller(int arr[]) 
	{ 
	    // Your code goes here
        int n = arr.length;
	    Stack<Integer> s =new Stack<>();
	    int smaller[] = new int[n];
        for(int i=0; i<n; i++){

            while(!s.isEmpty() && arr[s.peek()] >= arr[i]){
 
                s.pop();
            }
 
            if(s.isEmpty()){
                smaller[i] = -1;
            }else{
                smaller[i] = s.peek();
            }
            s.push(i);
        }
        
        return smaller;
	} 


    // Optimized 

    static int largestRectangle(int arr[]){
        Stack<Integer> stack = new Stack<>();
        int n = arr.length-1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<=n; i++){
            int element =(i == n)?0:arr[i];
            while(!stack.isEmpty() && arr[stack.peek()] > element){
                int h = arr[stack.pop()];
                int ps = (stack.isEmpty())?-1:stack.peek();
                int w = i-ps-1;
                max = Math.max(max, h*w);
            }

            stack.push(i);
        }

        return (max==Integer.MIN_VALUE)?0:max;
    }

    // Using Custom Stack

    static int largestRectangle1(int arr[]){
        int n = arr.length;
        int stack[] = new int[n+1];
        int index=-1;
        int max = Integer.MIN_VALUE;

        for(int i=0; i<=n; i++){
            int element =(i == n)?0:arr[i];
            while(index != -1 && arr[stack[index]] > element){
                int h = arr[stack[index--]];
                int ps = (index == -1)?-1:stack[index];
                int w = i-ps-1;
                max = Math.max(max, h*w);
            }

            stack[++index] = i;
        }

        return (max==Integer.MIN_VALUE)?0:max;
    }

    public static void main(String[] args) {
        int arr[] = {2,1,5,6,2,3};
        int res = largestRectangle1(arr);
        System.out.println("Max Area of Histogram is :"+res);
    }
}
