//Given a string s, reverse the order of characters in each word 
//within a sentence while still preserving whitespace and initial word order.
 
//Example 1:
//Input: s = "Let's take LeetCode contest"
//Output: "s'teL ekat edoCteeL tsetnoc"

//Example 2:
//Input: s = "God Ding"
//Output: "doG gniD"

class Solution {
    public String reverseWords(String s) {
        StringBuilder res = new StringBuilder();
        //split with space
        String[] sentence = s.split(" ");
        
         for(int i = 0; i < sentence.length; i++){
            //use stringBuilder to append and reverse
             StringBuilder sb = new StringBuilder(sentence[i]);
             if(i != sentence.length - 1){
                 res.append(sb.reverse() + " ");
             }else{
                 res.append(sb.reverse());
             }
             
         }
         return res.toString();

    }
}