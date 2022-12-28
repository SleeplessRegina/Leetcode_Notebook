// We define a harmonious array as an array where the difference between its maximum value and its minimum value is exactly 1.

// Given an integer array nums, return the length of its longest harmonious subsequence among all its possible subsequences.

// A subsequence of array is a sequence that can be derived from the array by deleting some or no elements without changing the order of the remaining elements.

 

// Example 1:

// Input: nums = [1,3,2,2,5,2,3,7]
// Output: 5
// Explanation: The longest harmonious subsequence is [3,2,2,2,3].
// Example 2:

// Input: nums = [1,2,3,4]
// Output: 2
// Example 3:

// Input: nums = [1,1,1,1]
// Output: 0

class Solution {
    public int findLHS(int[] nums) {
        int res = 0;
        int max = 0;
        //key: each Integer in array; 
        //Value: frequency of each integer
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 0; i < nums.length ; i++){
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1); 
        }

        for(int num: map.keySet()){
            if(map.containsKey(num) && map.containsKey(num + 1)){
                res = map.get(num) + map.get(num + 1);
                max = Math.max(max, res);
            }
        }
        return max;
    }
}
