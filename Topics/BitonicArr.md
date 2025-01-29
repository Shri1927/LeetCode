# Bitonic Array

A bitonic array is an array of integers that is first strictly increasing and then strictly decreasing. 

## Properties

1. There is a single peak element in the array.
2. The array increases monotonically up to the peak element.
3. The array decreases monotonically after the peak element.

## Example

Consider the following bitonic array:

```
[1, 3, 8, 12, 4, 2]
```

- The peak element is `12`.
- The array increases from `1` to `12`.
- The array decreases from `12` to `2`.

## Common Problems

1. **Find the peak element in a bitonic array**
2. **Search for an element in a bitonic array**

## Algorithms

### Finding the Peak Element

To find the peak element, you can use a modified binary search algorithm:

```python
def find_peak(arr):
    low, high = 0, len(arr) - 1
    while low < high:
        mid = (low + high) // 2
        if arr[mid] > arr[mid + 1]:
            high = mid
        else:
            low = mid + 1
    return low
```

### Searching for an Element

To search for an element, you can split the array into two parts at the peak element and perform binary search on both parts:

```python
def binary_search(arr, low, high, target, ascending=True):
    while low <= high:
        mid = (low + high) // 2
        if arr[mid] == target:
            return mid
        if ascending:
            if arr[mid] < target:
                low = mid + 1
            else:
                high = mid - 1
        else:
            if arr[mid] > target:
                low = mid + 1
            else:
                high = mid - 1
    return -1

def search_bitonic(arr, target):
    peak = find_peak(arr)
    index = binary_search(arr, 0, peak, target, ascending=True)
    if index != -1:
        return index
    return binary_search(arr, peak + 1, len(arr) - 1, target, ascending=False)
```

## Conclusion

Bitonic arrays have unique properties that allow for efficient searching and peak finding using modified binary search algorithms. Understanding these properties and algorithms can help solve related problems effectively.


[1,2,6,8,9]
[3,4,7,11]
k=5

