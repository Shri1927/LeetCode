public class day_04_LinearSearch {

    static void multOccurences(int arr[], int target) {
        // Initialize an array to store the indices of occurrences
        int ans[] = new int[arr.length];
        int k = 0; // Counter for occurrences
        for (int i = 0; i < arr.length; i++) { // Loop through the array
            if (arr[i] == target) { // Check if the current element matches the target
                ans[k] = i; // Store the index of the occurrence
                k++; // Increment the counter
            }
        }
    
        if (k == 0) { // If no occurrences were found
            System.out.println("Element not found");
        } else {
            for (int i = 0; i < k; i++) { // Loop through the stored indices
                System.out.println("Element found at index: " + ans[i]); // Print each index
            }
        }
    }
    
    static void finndMax(int arr[]) {
        int max = Integer.MIN_VALUE; // Initialize max to the smallest possible integer
        for (int i = 0; i < arr.length; i++) { // Loop through the array
            if (arr[i] > max) { // Check if the current element is greater than max
                max = arr[i]; // Update max
            }
        }
        System.out.println("Max element is: " + max); // Print the maximum element
    }
    
    static void finndMin(int arr[]) {
        int min = Integer.MAX_VALUE; // Initialize min to the largest possible integer
        for (int i = 0; i < arr.length; i++) { // Loop through the array
            if (arr[i] < min) { // Check if the current element is less than min
                min = arr[i]; // Update min
            }
        }
        System.out.println("Min element is: " + min); // Print the minimum element
    }
    
    static void linearSearch2D(int arr[][], int target, boolean findlast) {
        int outerIndex = -1; // Initialize outer index to -1 (not found)
        int innerIndex = -1; // Initialize inner index to -1 (not found)
        for (int i = 0; i < arr.length; i++) { // Loop through the outer array
            boolean found = false; // Flag to indicate if the element is found
            for (int j = 0; j < arr[0].length; j++) { // Loop through the inner array
                if (arr[i][j] == target) { // Check if the current element matches the target
                    outerIndex = i; // Update outer index
                    innerIndex = j; // Update inner index
                    if (!findlast) { // If not looking for the last occurrence
                        found = true; // Set found flag to true
                        break; // Break the inner loop
                    }
                }
            }
            if (found) { // If the element was found and not looking for the last occurrence
                break; // Break the outer loop
            }
        }
    
        if (outerIndex == -1) { // If no occurrence was found
            System.out.println("Element not found");
        } else {
            System.out.println("Element found at index: " + outerIndex + "," + innerIndex); // Print the index of the found element
        }
    }
    
    static void mulOccurences2D(int arr[][], int target) {
        int size = 0; // Initialize size to 0
        for (int i = 0; i < arr.length; i++) { // Loop through the outer array
            size += arr[i].length; // Calculate the total number of elements
        }
    
        int ans[][] = new int[size][2]; // Initialize an array to store the indices of occurrences
        int k = 0; // Counter for occurrences
        for (int i = 0; i < arr.length; i++) { // Loop through the outer array
            for (int j = 0; j < arr[0].length; j++) { // Loop through the inner array
                if (arr[i][j] == target) { // Check if the current element matches the target
                    ans[k][0] = i; // Store the outer index
                    ans[k][1] = j; // Store the inner index
                    k++; // Increment the counter
                }
            }
        }
    
        if (k == 0) { // If no occurrences were found
            System.out.println("Element not found");
        } else {
            for (int i = 0; i < k; i++) { // Loop through the stored indices
                System.out.println("Element found at index: " + ans[i][0] + "," + ans[i][1]); // Print each index
            }
        }
    }

    static void binarySearch(int arr[], int target){
        int ans = -1;
        int start = 0;
        int end = arr.length - 1;
        int mid = start + (end - start) / 2;
        while (start <= end) {
                if(arr[mid] == target){
                    ans = mid;
                }else if(arr[mid] < target){
                    start = mid + 1;
                }else{
                    end = mid - 1;
               }
        }
        
        if(ans == -1){
            System.out.println("Element is not present in array");
        }else{
            System.out.println("Element is present at index " + ans);
        }
    }
    public static void main(String[] args) {
        // int[] arr = { 1, 2, 3,5,6,89};
        // // int target = 2;
        // // linearSearch(arr, target, false);
        // // linearSearch(arr, target, true);
        // // multOccurences(arr, target);
        // finndMax(arr);
        // finndMin(arr);
        
        // int arr[][] = {
        //         { 1, 2, 3 },
        //         { 4, 5, 6 },
        //         { 5, 8, 5 }
        // };

        // linearSearch2D(arr, 5, false);
        // linearSearch2D(arr, 5, true);
        // mulOccurences2D(arr, 5);
        // findMaxSumSubarr(arr);

        // binarySearch(arr, 5);
    }
}
