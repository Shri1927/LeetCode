public class day11 {
    
    public static void main(String[] args) {
        int arr[] = {1,23,43,54,65,66,76,87,89};
        int res = ternarySearch(arr, 76);
        if(res == -1){
            System.out.println("Eelment not found");
        }else{
            System.out.println("Element Found at index "+res);
        }
    }

    

    static int ternarySearch(int arr[], int target){

        int start = 0;
        int end = arr.length - 1;
        int ans = -1;

        while(start <= end){
            int mid1 = start + (end - start)/3;
            int mid2 = end - (end - start)/3;

            if(target <= arr[mid1]){
                if(target == arr[mid1]){
                    ans = mid1;
                    break;
                }
                end = mid1 - 1;
            }else if(target >= arr[mid2]){
                if(target == arr[mid2]){
                    ans = mid2;
                    break;
                }
                start = mid2 + 1;
            }else{
                start = mid1 + 1;
                end = mid2 - 1;
            }
        }

        return ans;
    }

    static int jumpSearch(int arr[], int target){

        int n = arr.length;
        int blockSize = (int) Math.sqrt(n);
        int start = 0;
        int end = blockSize;

        while(end < n && arr[end] <= target){
                start = end;
                end = end + blockSize;

                if(end > n){
                    end = n;
                }
        }

        for(int i=start; i<end; i++){
            if(arr[i] == target){
                return i;
            }
        }

        return -1;
    }
}
