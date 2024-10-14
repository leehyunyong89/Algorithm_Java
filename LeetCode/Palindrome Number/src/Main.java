// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isPalindrome(121));  // true
        System.out.println(solution.isPalindrome(-121)); // false
        System.out.println(solution.isPalindrome(10));   // false

    }


    public static class Solution {
        public boolean isPalindrome(int x) {
            // Negative numbers are not palindromes
            if (x < 0) {
                return false;
            }

            // Reverse the integer
            int original = x;
            int reversed = 0;

            while (x != 0) {
                int lastDigit = x % 10;   // Get the last digit
                reversed = reversed * 10 + lastDigit;  // Add it to the reversed number
                x = x / 10;  // Remove the last digit from x
            }

            // If the reversed number is the same as the original, it is a palindrome
            return original == reversed;
        }
    }

}