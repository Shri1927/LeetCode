public class day_07_bitonicArr {

    // Minimum elememnt in Bitonic array
    static int minElementinBitonicArr(int arr[]){
        if(arr[0] < arr[arr.length-1]){
            return arr[0];
        }else{
            return arr[arr.length-1];
        }
    }

    // Validate Bitonic Array
    static Boolean ValidateBitonicArr(int arr[]){
        int index = 0;
        int n = arr.length;
         
        // increasing
        while(index < n-1){
            if(arr[index]<arr[index+1]){
                index++;
            }else{
                break;
            }   
        }

        if(index == 0 || index == n-1){
              return false;
        }

        // Decreasing
        while(index < n-1){
            if(arr[index]>arr[index+1]){
                index++;
            }else{
                break;
            }
        }

        return (index == n-1);
        
    }    

    // Peak element in Bitonic Array
    static int peakInBitonicArr(int arr[]){
        int start = 0;
        int end = arr.length-1;
        int n = arr.length-1;

        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid != 0 && mid != n && arr[mid] > arr[mid+1] && arr[mid] > arr[mid-1]){
                 return arr[mid];
            }else if(mid != 0 && arr[mid]<arr[mid-1]){
                end = mid - 1;
            }else{
                start = mid + 1;
            }
        }

        return -1;
    }

    // Find element in Mountain Array
    static int searchElinMountainArr(int arr[], int target){
        int n = arr.length;
        int start = 0;
        int end = n-1;
        int mid = -1;

        while(start <= end){
            mid = start + (end - start)/2;
            int curr = arr[mid];
            if(mid != 0 && mid != n-1 && curr > arr[mid-1] && curr > arr[mid+1]){
                  if(curr == target){
                    return mid;
                  }
                  break;
            }else if(mid != n-1 && curr < arr[mid+1]){
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        start = 0;
        end = mid -1;
        while (start <= end) {
                    int m = start + (end - start) / 2; 
        
                    if (arr[m] == target) {
                        return m; 
                    } else if (arr[m] < target) {
                        start = m + 1; 
                    } else {
                        end = m - 1;
                    }
        }

        start = mid + 1;
        end = n -1;
        while (start <= end) {
                    int m = start + (end - start) / 2; 
        
                    if (arr[m] == target) {
                        return m; 
                    } else if (arr[m] > target) {
                        end = m - 1; 
                    } else {
                        start = m + 1; 
                    }
        }

        return -1;
    }

    public int mySqrt(int x) {
        int start = 1;
        int end = x;
        while(start <= end){
            int mid = start + (end - start)/2;
            if(mid <= x/mid){
                if(x%mid==0 && mid == x/mid){
                return mid;
                }
                start = mid + 1;
            }else{
                end = mid - 1;
            }
        }

        return end;
    }
    public static void main(String[] args) {
        int arr[] = {1,2,3,4,5,3,1};
        int res = searchElinMountainArr(arr, 3);
        System.out.println(res);
    }
}