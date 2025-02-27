 class medianOfSortedMatrix {

    int median(int mat[][]) {
        int R = mat.length; // Number of rows in the matrix
        int C = mat[0].length; // Number of columns in the matrix
        int N = R * C; // Total number of elements in the matrix
        int medianIndex = N / 2; // Index of the median element
        int start = 1; // Start of the range for binary search
        int end = 2000; // End of the range for binary search
        
        while (start <= end) { // Binary search loop
            int assumedMean = start + (end - start) / 2; // Calculate the mid value
            
            int lesserElements = findLesserEl(mat, assumedMean); // Find the number of elements less than or equal to assumedMean
            if (lesserElements <= medianIndex) { // If lesser elements are less than or equal to median index
                start = assumedMean + 1; // Move the start to the right
            } else { // If lesser elements are more than median index
                end = assumedMean - 1; // Move the end to the left
            }
        }
        
        return start; // Return the median value
    }
    
    int findLesserEl(int mat[][], int assMedian) {
        
        int noOfSmallerElem = 0; // Initialize the count of smaller elements
        for (int i = 0; i < mat.length; i++) { // Loop through each row
            
            int start = 0; // Start index for binary search in the row
            int end = mat[i].length - 1; // End index for binary search in the row
            while (start <= end) { // Binary search loop
                int mid = start + (end - start) / 2; // Calculate the mid index
                
                if (mat[i][mid] <= assMedian) { // If mid element is less than or equal to assumed median
                    start = mid + 1; // Move the start to the right
                } else { // If mid element is greater than assumed median
                    end = mid - 1; // Move the end to the left
                }
            }
            noOfSmallerElem += start; // Add the count of smaller elements in the row
        }
        
        return noOfSmallerElem; // Return the total count of smaller elements
    }
}

// Dry run for the input: mat = [[1, 3, 5], [2, 6, 9], [3, 6, 9]]
public class Main {
    public static void main(String[] args) {
        medianOfSortedMatrix obj = new medianOfSortedMatrix();
        int[][] mat = {{1, 3, 5}, {2, 6, 9}, {3, 6, 9}};
        int result = obj.median(mat);
        System.out.println("Median is: " + result); // Expected output: 5
    }
}

/*
Dry run:
1. Initialize R = 3, C = 3, N = 9, medianIndex = 4, start = 1, end = 2000
2. First iteration of while loop:
   - assumedMean = 1000
   - findLesserEl(mat, 1000) returns 9 (all elements are <= 1000)
   - lesserElements = 9
   - lesserElements > medianIndex, so end = 999
3. Second iteration of while loop:
   - assumedMean = 500
   - findLesserEl(mat, 500) returns 9 (all elements are <= 500)
   - lesserElements = 9
   - lesserElements > medianIndex, so end = 499
4. Continue binary search until start = 5 and end = 4
5. Return start = 5 as the median
*/