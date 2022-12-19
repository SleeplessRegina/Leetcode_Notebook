
// Given a string s containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

// An input string is valid if:

// Open brackets must be closed by the same type of brackets.
// Open brackets must be closed in the correct order.
// Every close bracket has a corresponding open bracket of the same type.
 

// Example 1:

// Input: s = "()"
// Output: true
// Example 2:

// Input: s = "()[]{}"
// Output: true
// Example 3:

// Input: s = "(]"
// Output: false

class Solution {
    public boolean isValid(String s) {
        //using stack to store characters
        Stack<Character> stack = new Stack<>();
        //corner case
        if(s.isEmpty() || s.length() == 1){
            return false;
        }
        //check if characters are paired
        for(int i = 0; i < s.length(); i++){
            if(s.charAt(i) == '(' || s.charAt(i) == '{' || s.charAt(i) == '[' ){
                stack.push(s.charAt(i));
            }
            else if((s.charAt(i) == ')' && !stack.isEmpty() && stack.peek() == '(') 
            || s.charAt(i) == '}' && !stack.isEmpty() && stack.peek() == '{' 
            || s.charAt(i) == ']'&& !stack.isEmpty() && stack.peek() == '['){
                    stack.pop();        
            }else{
                //if not paired 
                return false;
            }
        }
        //check if the stack is empty or contain unpaired character
        return stack.isEmpty();
    }
}