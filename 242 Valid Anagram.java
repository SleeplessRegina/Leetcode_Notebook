//Given two strings s and t, return true if t is an anagram of s, and false otherwise.

//An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase, typically using all the original letters exactly once.

 

//Example 1:

//Input: s = "anagram", t = "nagaram"
//Output: true
//Example 2:

//Input: s = "rat", t = "car"
//Output: false

// Note:
// You may assume the string contains only lowercase alphabets.

// Follow up:
// What if the inputs contain unicode characters? How would you adapt your solution to such case?


//solution 1
//use hashmap to store each character in one string, compre characters in other string with the map 
class Solution {
    public boolean isAnagram(String s, String t) {
        Map<Character, Integer> map = new HashMap<>();
        //corner case
        if(s.length() != t.length()){
            return false;
        }
    
        for(char c: s.toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for(char d: t.toCharArray()){
            if(map.containsKey(d)){
              map.put(d, map.get(d) - 1);
                if(map.get(d) == 0){
                    map.remove(d);
                }   
            }
            
        }
        return map.isEmpty();
    }
}

//solution 2
class Solution {
    public boolean isAnagram(String s, String t) {
       if(s.length() != t.length()) return false;
       // consists of lower english letters
        int[] cnt = new int[26]; 
        // count occurrences of each letter in the two strings and compare them
        for(int i = 0; i < s.length(); i++){
            cnt[s.charAt(i) - 'a']++; 
            cnt[t.charAt(i) -'a']--; 
            // one counter increase, one counter decrease
        }
        for(int count: cnt){
            // check if the counter get back to 0
            if(count != 0){ 
                return false;
            }
        }
        return true;
           
    }
}