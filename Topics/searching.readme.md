# Searching Algorithms

## Ternary Search

### Description
Ternary search is a divide-and-conquer algorithm that splits the array into three parts and determines which part may contain the target value.

### Example
Let's search for the value `7` in the sorted array `[1, 3, 5, 7, 9, 11, 13]`.

1. Divide the array into three parts:
    - First third: `[1, 3]`
    - Second third: `[5, 7]`
    - Third third: `[9, 11, 13]`
2. Compare the target value `7` with the end elements of the first and second thirds:
    - `7` is greater than `3` and less than `9`, so it must be in the second third.
3. Repeat the process on the second third `[5, 7]`:
    - Divide into three parts: `[5]`, `[7]`, `[]`
    - Compare `7` with `5` and `7`:
      - `7` is equal to `7`, so the target is found.

### Code
```python
def ternary_search(arr, left, right, key):
     if right >= left:
          mid1 = left + (right - left) // 3
          mid2 = right - (right - left) // 3

          if arr[mid1] == key:
                return mid1
          if arr[mid2] == key:
                return mid2

          if key < arr[mid1]:
                return ternary_search(arr, left, mid1 - 1, key)
          elif key > arr[mid2]:
                return ternary_search(arr, mid2 + 1, right, key)
          else:
                return ternary_search(arr, mid1 + 1, mid2 - 1, key)
     return -1

# Example usage
arr = [1, 3, 5, 7, 9, 11, 13]
key = 7
result = ternary_search(arr, 0, len(arr) - 1, key)
print("Index of {}: {}".format(key, result))
```

## Jump Search

### Description
Jump search is an algorithm for searching sorted arrays by jumping ahead by fixed steps and then performing a linear search within the block.

### Example
Let's search for the value `7` in the sorted array `[1, 3, 5, 7, 9, 11, 13]` with a step size of `2`.

1. Jump ahead by 2 steps:
    - Compare `7` with `1` (index 0) and `5` (index 2)
    - `7` is greater than `5`, so jump to the next block
2. Jump ahead by 2 steps:
    - Compare `7` with `7` (index 4)
    - `7` is equal to `7`, so the target is found.

### Code
```python
import math

def jump_search(arr, key):
     n = len(arr)
     step = int(math.sqrt(n))
     prev = 0

     while arr[min(step, n) - 1] < key:
          prev = step
          step += int(math.sqrt(n))
          if prev >= n:
                return -1

     for i in range(prev, min(step, n)):
          if arr[i] == key:
                return i
     return -1

# Example usage
arr = [1, 3, 5, 7, 9, 11, 13]
key = 7
result = jump_search(arr, key)
print("Index of {}: {}".format(key, result))
```