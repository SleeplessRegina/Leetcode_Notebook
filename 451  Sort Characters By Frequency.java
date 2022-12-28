// Given a string s, sort it in decreasing order based on the frequency of the characters. The frequency of a character is the number of times it appears in the string.

// Return the sorted string. If there are multiple answers, return any of them.

 

// Example 1:

// Input: s = "tree"
// Output: "eert"
// Explanation: 'e' appears twice while 'r' and 't' both appear once.
// So 'e' must appear before both 'r' and 't'. Therefore "eetr" is also a valid answer.
// Example 2:

// Input: s = "cccaaa"
// Output: "aaaccc"
// Explanation: Both 'c' and 'a' appear three times, so both "cccaaa" and "aaaccc" are valid answers.
// Note that "cacaca" is incorrect, as the same characters must be together.
// Example 3:

// Input: s = "Aabb"
// Output: "bbAa"
// Explanation: "bbaA" is also a valid answer, but "Aabb" is incorrect.
// Note that 'A' and 'a' are treated as two different characters.


//Heap(Priority Queue), Hash Table
class Solution {
    public String frequencySort(String s) {
        Map<Character, Integer> map = new HashMap<>();
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        //create a max heap so that we pop out to the new string is a decresing order.
        PriorityQueue<Character> pq = new PriorityQueue<>((a, b)->(map.get(b) - map.get(a)));
        pq.addAll(map.keySet());
        //use StringBuilder to create a new sorted string
        StringBuilder sb = new StringBuilder();

        while(!pq.isEmpty()){
            char c = pq.peek();
            for(int i = map.get(c); i > 0; i--){
                sb.append(c);
            }
            pq.poll();
        }
        return sb.toString();
    }
}