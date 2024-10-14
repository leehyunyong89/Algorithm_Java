// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Solution solution = new Solution();

        // Test case 1: Input is a valid palindrome
        String test1 = "A man, a plan, a canal: Panama";
        System.out.println("Is palindrome? " + solution.isPalindrome(test1));  // Output: true

        // Test case 2: Input is not a palindrome
        String test2 = "race a car";
        System.out.println("Is palindrome? " + solution.isPalindrome(test2));  // Output: false
    }

    public static class Solution {
        public boolean isPalindrome(String s) {
            int left = 0;
            int right = s.length() - 1;

            while (left < right) {
                // Skip non-alphanumeric characters
                while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                    left++;
                }
                while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                    right--;
                }

                // Compare characters (case insensitive)
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) {
                    return false;
                }

                // Move pointers towards the center
                left++;
                right--;
            }

            return true;
        }
    }



}