// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test cases
        System.out.println(solution.isPalindrome(121));  // true
        System.out.println(solution.isPalindrome(-121)); // false
        System.out.println(solution.isPalindrome(10));   // false


        // Upgrade Version Test cases

        UpgradeVersionOfSolution upgradeVersionOfSolution = new UpgradeVersionOfSolution();
        System.out.println(upgradeVersionOfSolution.isPalindrome(121));  // true
        System.out.println(upgradeVersionOfSolution.isPalindrome(-121)); // false
        System.out.println(upgradeVersionOfSolution.isPalindrome(10));   // false


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


    public static class UpgradeVersionOfSolution {
        public boolean isPalindrome(int x) {
            // Special cases:
            // When x < 0, it is not a palindrome.
            // If x ends with a zero and is not zero, it is not a palindrome.
            if (x < 0 || (x % 10 == 0 && x != 0)) {
                return false;
            }

            int reversedHalf = 0;
            while (x > reversedHalf) {
                int lastDigit = x % 10;   // Get the last digit
                reversedHalf = reversedHalf * 10 + lastDigit;  // Reverse half of the number
                x = x / 10;  // Remove the last digit from the original number
            }

            // If the number is a palindrome, the first half should be equal to the reversed second half
            // or x should be equal to reversedHalf/10 in case of odd number of digits
            return x == reversedHalf || x == reversedHalf / 10;
        }
    }


}