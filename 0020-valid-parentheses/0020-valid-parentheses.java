class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();

        for(char c : s.toCharArray()) {
            if(!stack.isEmpty() && (stack.peek() == '(' && c == ')' ||stack.peek() == '[' && c == ']'||stack.peek() == '{' && c == '}' )) {
                stack.pop();
            } else {
                stack.push(c);
            }
        }

        if(stack.isEmpty()) 
        return true; 
        else 
        return false;
    }
}

/** 
Complexity analysis

Time complexity : O(n) because we simply traverse the given string one character at a time and push and pop operations on a stack take O(1) time.
Space complexity : O(n)as we push all opening brackets onto the stack and in the worst case, we will end up pushing all the brackets onto the stack. e.g. ((((((((((.
*/