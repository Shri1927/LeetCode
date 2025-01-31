public class day10 {

    public static void main(String[] args) {
        int arr[] = {1,1,2,2,4,4,5,7,7};
        int res = sigleElinArr(arr);
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
}