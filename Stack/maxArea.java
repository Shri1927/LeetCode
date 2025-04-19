package Stack;

public class maxArea {
    
   static int maximalRectangle(char[][] arr){
        if(arr.length == 0){
            return -1;
        }

        int heights[] = new int[arr[0].length];
        int largest = 0;
        for(int i=0; i<arr.length; i++){
            for(int j=0; j<arr[i].length; j++){
                if(arr[i][j] == 0){
                    heights[j] = 0;
                }else{
                    heights[j] +=( arr[i][j] - '0');
                }
            }
            int maxArea = largestRectangle1(heights);
            if(maxArea > largest){
                largest = maxArea;
            }

        }

        return largest;
   }

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
        char mat[][] = {
            // {'1','0','1','0','0'},
            // {'1','0','1','1','1'},
            // {'1','1','1','1','1'},
            // {'1','0','0','1','0'}
            {'1'}
        };

        int res = maximalRectangle(mat);
        System.out.println(res);
    }
}
