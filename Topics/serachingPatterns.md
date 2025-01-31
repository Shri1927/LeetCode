
# Searching Patterns

## Ternary Search

```java
public class day11 {
    
    public static void main(String[] args) {
        int arr[] = {1,23,43,54,65,66,76,87,89};
        int res = ternarySearch(arr, 76);
        if(res == -1){
            System.out.println("Element not found");
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
}
```

### Explanation

The `ternarySearch` function is an implementation of the ternary search algorithm. It works by dividing the array into three parts and determining in which part the target element lies. The process is repeated until the target element is found or the search space is exhausted.

1. **Initialization**: The function initializes `start` and `end` pointers to the beginning and end of the array, respectively.
2. **Loop**: The loop continues as long as `start` is less than or equal to `end`.
3. **Midpoints Calculation**: Two midpoints, `mid1` and `mid2`, are calculated to divide the array into three parts.
4. **Comparison**: The target element is compared with the elements at `mid1` and `mid2`.
   - If the target is less than or equal to the element at `mid1`, the search space is reduced to the left third.
   - If the target is greater than or equal to the element at `mid2`, the search space is reduced to the right third.
   - Otherwise, the search space is reduced to the middle third.
5. **Return**: The function returns the index of the target element if found, otherwise, it returns -1.

## Jump Search

```java
public class day11 {

    static int jumpSearch(int arr[], int target){

        int n = arr.length;
        int blockSize = (int) Math.sqrt(n);
        int start = 0;
        int end = blockSize;

        while(end < n && arr[end] <= target){
                start = end;
                end = end + blockSize;

                // if(end > n){
                //     end = n;
                // }
        }

        for(int i=start; i<end; i++){
            if(arr[i] == target){
                return i;
            }
        }

        return -1;
    }
}
```

### Explanation

The `jumpSearch` function is an implementation of the jump search algorithm. It works by dividing the array into blocks of a fixed size and jumping through the blocks to find the target element.

1. **Initialization**: The function initializes the size of the array `n` and the block size as the square root of `n`.
2. **Jumping**: The function jumps through the blocks until it finds a block where the target element could be present.
3. **Linear Search**: Once the block is found, a linear search is performed within the block to find the target element.
4. **Return**: The function returns the index of the target element if found, otherwise, it returns -1.

Both of these search algorithms are useful for different scenarios and can be chosen based on the specific requirements of the problem.