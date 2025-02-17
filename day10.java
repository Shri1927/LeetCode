public class day10 {

    public static void main(String[] args) {
        int arr[] = {1,4,9,16,25};
        int res = countSqrt(9 , arr);
        System.out.println(res);
    }

    static int sigleElinArr(int nums[]){

        int start = 0;
        int end = nums.length - 1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(nums[mid] == nums[mid^1]){
                start = mid + 1;
            }else{
                end = end - 1;
            }
        }

        return nums[start]; 
    }

    static int sqrt(int n , int arr[]){
        int start = 1;
        int end = n;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid >= n/mid){
                if(n % mid == 0 && mid == n/mid){
                    return mid;
                }
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }
           return end;
        }

        static int mySqrt(int s, int arr[]){
            int start = 1;
            int end = s;

            while(start <= end){
                int mid = start + (end - start)/2;
                if(mid <= s/mid){
                    if(s % mid == 0 && mid == s/mid){
                        return mid;
                    }
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }

            return start;
        }

        static int countSqrt(int n, int arr[]){

            int sqroot = mySqrt(n, arr);
            return sqroot - 1;
        }
    }