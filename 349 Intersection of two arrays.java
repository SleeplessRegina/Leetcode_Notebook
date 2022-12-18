// Given two integer arrays nums1 and nums2, return an array of their intersection. Each element in the result must be unique and you may return the result in any order.

 

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]
// Example 2:

// Input: nums1 = [4,9,5], nums2 = [9,4,9,8,4]
// Output: [9,4]
// Explanation: [4,9] is also accepted.


class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        ArrayList<Integer> res = new ArrayList<>();
        Set<Integer> set1 = new HashSet<>();
        //store one array in one hashset, and compare set with another array
        for(int num: nums1){
            set1.add(num);
        }
         for(int num: nums2){
             if(set1.contains(num)){
                 res.add(num);
                 set1.remove(num);
             }
        }
        //chnage arraylist to arrays
        int[] ans = new int[res.size()];
        for(int i = 0; i < ans.length; i++){
            ans[i] = res.get(i);
        }
        return ans;
       


    }
}