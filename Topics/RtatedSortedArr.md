# Rotated Sorted Array

## Introduction
A rotated sorted array is an array that has been sorted in ascending order and then rotated (shifted) some number of times. For example, the array `[0, 1, 2, 4, 5, 6, 7]` might become `[4, 5, 6, 7, 0, 1, 2]` after a rotation.

## Problem Statement
Given a rotated sorted array, the task is to:
1. Find the minimum element.
2. Search for a target value.

## Finding the Minimum Element
To find the minimum element in a rotated sorted array, you can use a modified binary search algorithm. The key observation is that the minimum element is the only element whose previous element is greater than itself.

### Algorithm
1. Initialize `left` to 0 and `right` to the last index of the array.
2. While `left` is less than `right`:
    - Find the middle index `mid`.
    - If the element at `mid` is greater than the element at `right`, the minimum is in the right half.
    - Otherwise, the minimum is in the left half.
3. Return the element at the `left` index.

### Example
```python
def find_min(nums):
     left, right = 0, len(nums) - 1
     while left < right:
          mid = (left + right) // 2
          if nums[mid] > nums[right]:
                left = mid + 1
          else:
                right = mid
     return nums[left]
```

## Searching for a Target Value
To search for a target value in a rotated sorted array, you can also use a modified binary search.

### Algorithm
1. Initialize `left` to 0 and `right` to the last index of the array.
2. While `left` is less than or equal to `right`:
    - Find the middle index `mid`.
    - If the element at `mid` is the target, return `mid`.
    - Determine which half is properly sorted.
    - If the left half is sorted and the target is within the range of the left half, adjust `right`.
    - Otherwise, adjust `left`.
    - If the right half is sorted and the target is within the range of the right half, adjust `left`.
    - Otherwise, adjust `right`.
3. If the target is not found, return -1.

### Example
```python
def search(nums, target):
     left, right = 0, len(nums) - 1
     while left <= right:
          mid = (left + right) // 2
          if nums[mid] == target:
                return mid
          if nums[left] <= nums[mid]:
                if nums[left] <= target < nums[mid]:
                     right = mid - 1
                else:
                     left = mid + 1
          else:
                if nums[mid] < target <= nums[right]:
                     left = mid + 1
                else:
                     right = mid - 1
     return -1
```

## Conclusion
Rotated sorted arrays can be efficiently handled using modified binary search algorithms. By understanding the properties of the array, you can find the minimum element and search for a target value in logarithmic time.