public class day_05_BinarySearch {

    public static void main(String[] args) {
        // int arr[] = {23,21,11,10,8,4,1};
        // int arr1[] = {1,2,3,4,5,6};
        int arr2[] = {4,4,8,8,8,15,16,23};
        // int first = firsOccurence(arr2, 8 , true);
        // int last = firsOccurence(arr2, 8  , false);
        // // int result1 = oabs(arr1, 44);
        // // int result2 = oabs(arr2, 11);
        // System.out.println(first);
        // System.out.println(last);
        // System.out.println("***********");
        // int ans = (last - first) + 1;
        // System.out.println(ans);
        int ansF = binSearchFloor(arr2, 1);        public class day_05_BinarySearch {
        
            public static void main(String[] args) {
                // int arr[] = {23,21,11,10,8,4,1}; // Example array in descending order
                // int arr1[] = {1,2,3,4,5,6}; // Example array in ascending order
                int arr2[] = {4,4,8,8,8,15,16,23}; // Example array with duplicate elements
                // int first = firsOccurence(arr2, 8 , true); // Find first occurrence of 8
                // int last = firsOccurence(arr2, 8  , false); // Find last occurrence of 8
                // // int result1 = oabs(arr1, 44); // Example binary search call
                // // int result2 = oabs(arr2, 11); // Example binary search call
                // System.out.println(first); // Print first occurrence index
                // System.out.println(last); // Print last occurrence index
                // System.out.println("***********");
                // int ans = (last - first) + 1; // Calculate the number of occurrences
                // System.out.println(ans); // Print the number of occurrences
                int ansF = binSearchFloor(arr2, 1); // Find floor of 1 in arr2
                System.out.println(ansF); // Print the floor value
                int ansC = binSearchCeiling(arr2, 30); // Find ceiling of 30 in arr2
                System.out.println(ansC); // Print the ceiling value
            }
        
            static int binSearchFloor(int arr[], int target){
                int ans = -1; // Initialize answer to -1 (not found)
                int start = 0; // Initialize start index
                int end = arr.length - 1; // Initialize end index
        
                while (start <= end) { // Loop until start index is less than or equal to end index
                    int mid = start + (end - start) / 2; // Calculate mid index
        
                    if (arr[mid] == target) { // If mid element is the target
                        return mid; // Return the target element
                    } else if (arr[mid] < target) { // If mid element is less than the target
                        start = mid + 1; // Move start index to mid + 1
                        ans = arr[mid]; // Update answer to mid element
                    } else { // If mid element is greater than the target
                        end = mid - 1; // Move end index to mid - 1
                    }
                }
                return ans; // Return the floor value
            }
        
            static int binSearchCeiling(int arr[], int target){
                int ans = -1; // Initialize answer to -1 (not found)
                int start = 0; // Initialize start index
                int end = arr.length - 1; // Initialize end index
        
                while (start <= end) { // Loop until start index is less than or equal to end index
                    int mid = start + (end - start) / 2; // Calculate mid index
        
                    if (arr[mid] == target) { // If mid element is the target
                        return mid; // Return the target element
                    } else if (arr[mid] < target) { // If mid element is less than the target
                        start = mid + 1; // Move start index to mid + 1
                    } else { // If mid element is greater than the target
                        ans = arr[mid]; // Update answer to mid element
                        end = mid - 1; // Move end index to mid - 1
                    }
                }
                return ans; // Return the ceiling value
            }
        
            static int oabs(int arr[], int target){
                int start = 0; // Initialize start index
                int end = arr.length - 1; // Initialize end index
        
                if(arr[start] == arr[end]){ // If the array has all identical elements
                    return start; // Return the start index
                }
        
                if(arr[start] <= arr[end]){ // If the array is sorted in ascending order
                    return binarySearch(arr, target); // Perform binary search
                } else { // If the array is sorted in descending order
                    return revSortedbinarySearch(arr, target); // Perform reverse sorted binary search
                }
            }
        
            static int binarySearch(int arr[], int target){
                int start = 0; // Initialize start index
                int end = arr.length - 1; // Initialize end index
        
                while (start <= end) { // Loop until start index is less than or equal to end index
                    int mid = start + (end - start) / 2; // Calculate mid index
        
                    if (arr[mid] == target) { // If mid element is the target
                        return mid; // Return the target element
                    } else if (arr[mid] < target) { // If mid element is less than the target
                        start = mid + 1; // Move start index to mid + 1
                    } else { // If mid element is greater than the target
                        end = mid - 1; // Move end index to mid - 1
                    }
                }
                return -1; // Return -1 if target is not found
            }
        
            static int revSortedbinarySearch(int arr[], int target){
                int start = 0; // Initialize start index
                int end = arr.length - 1; // Initialize end index
        
                while (start <= end) { // Loop until start index is less than or equal to end index
                    int mid = start + (end - start) / 2; // Calculate mid index
        
                    if (arr[mid] == target) { // If mid element is the target
                        return mid; // Return the target element
                    } else if (arr[mid] > target) { // If mid element is greater than the target
                        start = mid + 1; // Move start index to mid + 1
                    } else { // If mid element is less than the target
                        end = mid - 1; // Move end index to mid - 1
                    }
                }
                return -1; // Return -1 if target is not found
            }
        }
        System.out.println(ansF);
        int ansC = binSearchCeiling(arr2, 30);
        System.out.println(ansC);

    }

    // static int binSearchFloor(int arr[], int target){
        
    //     int ans = -1;
    //     int start = 0;
    //     int end = arr.length - 1;

    //     while (start <= end) {
    //         int mid = start + (end - start) / 2; 

    //         if (arr[mid] == target) {
    //             return mid;
    //         } else if (arr[mid] < target) {
    //             start = mid + 1; 
    //             ans = arr[mid];
    //         } else {
    //             end = mid - 1; 
    //         }
    //     }
        
    //     return ans;
    // }

    // static int binSearchCeiling(int arr[], int target){
        
    //     int ans = -1;
    //     int start = 0;
    //     int end = arr.length - 1;

    //     while (start <= end) {
    //         int mid = start + (end - start) / 2; 

    //         if (arr[mid] == target) {
    //             return mid;
    //         } else if (arr[mid] <= target) {
    //             start = mid + 1; 
    //         } else {
    //             end = mid - 1; 
    //             ans = arr[mid];
    //         }
    //     }
        
    //     return ans;
    // }

    // static int firsOccurence(int arr[], int target, boolean isFirst){
        
    //     int ans = -1;
    //     int start = 0;
    //     int end = arr.length - 1;

    //     while (start <= end) {
    //         int mid = start + (end - start) / 2; 

    //         if (arr[mid] == target) {
    //             ans = mid;
    //             if(isFirst){
    //                 end = mid - 1;
    //             }else{
    //                 start = mid + 1;
    //             }
    //         } else if (arr[mid] < target) {
    //             start = mid + 1; 
    //         } else {
    //             end = mid - 1; 
    //         }
    //     }
        
    //     return ans;
    // }
    

    // static int binarySearch(int arr[], int target) {
    //     int start = 0;
    //     int end = arr.length - 1;

    //     while (start <= end) {
    //         int mid = start + (end - start) / 2; // Move mid calculation inside the loop

    //         if (arr[mid] == target) {
    //             return mid; // Target found, return the index
    //         } else if (arr[mid] < target) {
    //             start = mid + 1; // Target is in the right half
    //         } else {
    //             end = mid - 1; // Target is in the left half
    //         }
    //     }

    //     return -1; // Target not found, return -1
    // }

    // static int revSortedbinarySearch(int arr[], int target){

    //     int start = 0;
    //     int end = arr.length - 1;

    //     while (start <= end) {
    //         int mid = start + (end - start) / 2; 

    //         if (arr[mid] == target) {
    //             return mid; 
    //         } else if (arr[mid] < target) {
    //             end = mid - 1; 
    //         } else {
    //             start = mid + 1; 
    //         }
    //     }

    //     return -1;
    // }

    // static int oabs(int arr[], int target){
    //     int start = 0;
    //     int end = arr.length - 1;

    //         if(arr[start] == arr[end]){
    //             return start;
    //         }
    
    //         if(arr[start] <= arr[end]){
    //            return binarySearch(arr, target);
    //         }else{
    //             return revSortedbinarySearch(arr, target);
    //         }
    // }
}
