// Given an integer array nums and an integer k, return the k most frequent elements. You may return the answer in any order.

 

// Example 1:

// Input: nums = [1,1,1,2,2,3], k = 2
// Output: [1,2]
// Example 2:

// Input: nums = [1], k = 1
// Output: [1]


//Related topics: Heap(Priority Queue), Hashmap


class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        //use map to store integer and corresponding frequency 
        Map<Integer, Integer> map = new HashMap<>();
        //use queue compare frequency 
        PriorityQueue<Integer> heap = new PriorityQueue<>((a, b)->(map.get(a) - map.get(b)));
        for(int num: nums){
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for(int e: map.keySet()){
            heap.add(e);
            if(heap.size() > k){ //use k to controll when to stop poll
                heap.poll();
            }
        }
        //create a res array and once again use k to controll poll and giva value
        int[]res = new int[k];
        for(int i = 0; i< k ;i++){
            res[i] = heap.poll();
        }
        return res;
       
    }
}