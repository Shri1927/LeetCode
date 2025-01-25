public class RotatedSortedArr {
    
    // Finding element in rotataed Sorted array
    static int rotatedsortArr(int arr[], int target){
        int start = 0;
        int ans = -1;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                ans = mid;
            }

            if(arr[start] <= arr[mid]){
                if(target >= arr[start] && target < arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target > arr[mid] && target <= arr[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return ans;
    }
    
    // Finding element in rotataed Sorted array (non unique elements)
    static boolean dupRotatedsortArr(int arr[], int target){
        int start = 0;
        boolean ans = false;
        int end = arr.length - 1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[mid] == target){
                ans = true;
            }

            if(arr[start] == arr[mid] && arr[mid] == arr[end]){
                start++;
                end--;
            }
            else if(arr[start] <= arr[mid]){
                if(target >= arr[start] && target < arr[mid]){
                    end = mid - 1;
                }else{
                    start = mid + 1;
                }
            }else{
                if(target > arr[mid] && target <= arr[end]){
                    start = mid + 1;
                }else{
                    end = mid - 1;
                }
            }
        }
        return ans;
    }

    // Minimum Element in RSA
    static int minInRSA(int arr[]){
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length-1;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                start++;
                end--;
            }
            if(arr[start] <= arr[mid]){
                min = Math.min(min , arr[start]);
                start = mid + 1;
            }else{
                min = Math.min(min, arr[mid]);
                end = end - 1;
            }
        }

        return min;
    }

    // Find number of rotations 
    static int noOfRotartions(int arr[]){
        int min = Integer.MAX_VALUE;
        int start = 0;
        int end = arr.length-1;
        int minIndex = -1;
        while(start <= end){
            int mid = start + (end - start)/2;
            // if(arr[start]==arr[mid] && arr[mid]==arr[end]){
            //     start++;
            //     end--;
            // }
            if(arr[start] <= arr[mid]){
                // min = Math.min(min , arr[start]);
                if(arr[start] < min){
                    min = arr[start];
                    minIndex = start;
                }
                start = mid + 1;
            }else{
                // min = Math.min(min, arr[mid]);
                if(arr[mid] < min){
                    min = arr[mid];
                    minIndex = mid;
                }
                end = end - 1;
            }
        }

        return minIndex;
    }

    
    public static void main(String[] args) {
        int arr[] = {2,5,6,0,0,1,2};
        boolean res = dupRotatedsortArr(arr , 3);
        System.out.println(res);
    }
}