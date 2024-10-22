import java.util.Stack;

public class Main {
    public static void main (String[] args) {
        System.out.println("Hello, World!");

        String testCase01 = "()";
        String testCase02 = "()[]{}";
        String testCase03 = "([{}])";
        String testCase04 = "([[}}{])]";

        Solution solution = new Solution();

        System.out.println(String.format("testCase01 테스트 결과 : %s", solution.isValid(testCase01)));
        System.out.println(String.format("testCase02 테스트 결과 : %s", solution.isValid(testCase02)));
        System.out.println(String.format("testCase03 테스트 결과 : %s", solution.isValid(testCase03)));
        System.out.println(String.format("testCase04 테스트 결과 : %s", solution.isValid(testCase04)));

    }

    public static class Solution {

        public boolean isValid(String s) {
            // Create an empty stack to keep track of opening brackets
            Stack<Character> stack = new Stack<Character>();

            // Loop through every character in the string
            for (char c : s.toCharArray()) {

                // If the character is an opening bracket, push it onto the stack
                if ((c == '(') || c == ('[') || c == ('{')) {
                    stack.push(c);
                } else { // If the character is a closing bracket
                    // If the stack is empty, there is no matching opening bracket, so return false
                    if (stack.isEmpty()) {
                        return false;
                    }
                    // Otherwise, get the top of the stack and check if it's the matching opening bracket
                    char top = stack.peek();
                    if ((c == ')' && top == '(') || (c == ']' && top == '[') || (c == '}' && top == '{')) {
                        // If it is, pop the opening bracket from the stack
                        stack.pop();
                    } else { // Otherwise, the brackets don't match, so return false
                        return false;
                    }
                }
            }
            // If the stack is empty, all opening brackets have been closed, so return true
            // Otherwise, there are unmatched opening brackets, so return false
            return  stack.empty();
        }
    }
}
