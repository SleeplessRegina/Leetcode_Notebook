// Given a string array words, return an array of all characters that show up in all strings within the words (including duplicates). You may return the answer in any order.

 

// Example 1:

// Input: words = ["bella","label","roller"]
// Output: ["e","l","l"]
// Example 2:

// Input: words = ["cool","lock","cook"]
// Output: ["c","o"]

class Solution {
    public List<String> commonChars(String[] words) {
        ArrayList<String> res = new ArrayList<>();
        //use a hashmap to store chracters and characters' frequency 
        HashMap<Character, Integer> map = new HashMap<>();

        for(char c: words[0].toCharArray()){
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        // start from index 1 in words array
        for(int i = 1; i < words.length; i++){
            HashMap<Character, Integer> newMap = new HashMap<>();
            for(char c: words[i].toCharArray()){
                //compare with the previous map
                if(map.containsKey(c)){
                    newMap.put(c, newMap.getOrDefault(c, 0) + 1);
                    //update frequency
                    map.put(c, map.get(c) - 1);
                    //remove duplicates
                    if(map.get(c) == 0){
                        map.remove(c);
                    }                  
                }
            }
            //clear previous hashmap
            map.clear();
            //copy all the value from current hashmap
            map.putAll(newMap);

        }
        //add all strings to arrayList
        for(Character key: map.keySet()){
            for(int i = 0; i < map.get(key); i++){
                res.add(key.toString());              
            }
            
        }
        return res;
    }
}