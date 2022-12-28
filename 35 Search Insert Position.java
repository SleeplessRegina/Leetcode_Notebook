// Given a sorted array of distinct integers and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

// You must write an algorithm with O(log n) runtime complexity.

 

// Example 1:

// Input: nums = [1,3,5,6], target = 5
// Output: 2
// Example 2:

// Input: nums = [1,3,5,6], target = 2
// Output: 1
// Example 3:

// Input: nums = [1,3,5,6], target = 7
// Output: 4

//binary search
class Solution {
    public int searchInsert(int[] nums, int target) {
        int i = 0, j = nums.length - 1;
        int mid = 0;
        while(i <= j){
            mid = i + (j - i)/2;
            if(nums[mid] == target){
                return mid;
            }else if(nums[mid] < target){
                i = mid + 1;
            }
            else{
                j = mid - 1;
            }
        }
        return i;
    }
}
