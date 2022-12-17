// Given an array of positive integers nums and a positive integer target, return the minimal length of a 
// subarray
//  whose sum is greater than or equal to target. If there is no such subarray, return 0 instead.

 

// Example 1:

// Input: target = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: The subarray [4,3] has the minimal length under the problem constraint.
// Example 2:

// Input: target = 4, nums = [1,4,4]
// Output: 1
// Example 3:

// Input: target = 11, nums = [1,1,1,1,1,1,1,1]
// Output: 0

class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        //use sliding window thoughts
        int start = 0, end = 0, sum = 0, res = Integer.MAX_VALUE;
        int n = nums.length;
        while(end < n){
            sum += nums[end];
            while(sum >= target){
                //size of the current subarray
                res = Math.min(res, end - start + 1);
                sum -= nums[start];
                //larger than target, then start need to move to right
                start++;
            }
            //else, end move to left
            end++;
        }
        //choose the min value of the subarray size
        return res == Integer.MAX_VALUE ? 0 : res;
    }
}