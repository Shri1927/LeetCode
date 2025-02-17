public class day11 {
    
    public static void main(String[] args) {
        int arr[] = {1,23,43,54,65,66,76,87,89}; // Example array
        int res = ternarySearch(arr, 76); // Perform ternary search for 76
        if(res == -1){
            System.out.println("Element not found"); // Print if element is not found
        }else{
            System.out.println("Element Found at index "+res); // Print the index of the found element
        }
    }

    static int ternarySearch(int arr[], int target){

        int start = 0; // Initialize start index
        int end = arr.length - 1; // Initialize end index
        int ans = -1; // Initialize answer to -1 (not found)

        while(start <= end){ // Loop until start index is less than or equal to end index
            int mid1 = start + (end - start)/3; // Calculate first mid index
            int mid2 = end - (end - start)/3; // Calculate second mid index

            if(target <= arr[mid1]){ // If target is less than or equal to first mid element
                if(target == arr[mid1]){ // If target is equal to first mid element
                    ans = mid1; // Update answer to first mid index
                    break; // Break the loop
                }
                end = mid1 - 1; // Move end index to mid1 - 1
            }else if(target >= arr[mid2]){ // If target is greater than or equal to second mid element
                if(target == arr[mid2]){ // If target is equal to second mid element
                    ans = mid2; // Update answer to second mid index
                    break; // Break the loop
                }
                start = mid2 + 1; // Move start index to mid2 + 1
            }else{ // If target is between mid1 and mid2
                start = mid1 + 1; // Move start index to mid1 + 1
                end = mid2 - 1; // Move end index to mid2 - 1
            }
        }

        return ans; // Return the answer
    }

    static int jumpSearch(int arr[], int target){

        int n = arr.length; // Get the length of the array
        int blockSize = (int) Math.sqrt(n); // Calculate the block size
        int start = 0; // Initialize start index
        int end = blockSize; // Initialize end index

        while(end < n && arr[end] <= target){ // Loop until end index is less than array length and end element is less than or equal to target
            start = end; // Update start index to end index
            end = end + blockSize; // Move end index to next block

            if(end > n){ // If end index exceeds array length
                end = n; // Set end index to array length
            }
        }

        for(int i=start; i<end; i++){ // Loop through the block
            if(arr[i] == target){ // If current element is the target
                return i; // Return the index
            }
        }

        return -1; // Return -1 if target is not found
    }
}
