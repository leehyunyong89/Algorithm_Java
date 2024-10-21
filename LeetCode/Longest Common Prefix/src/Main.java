
/*

01. Initialize an empty string ans to store the common prefix.
02. Sort the input list v lexicographically. This step is necessary because the common prefix should be common to all the strings, so we need to find the common prefix of the first and last string in the sorted list.
03. Iterate through the characters of the first and last string in the sorted list, stopping at the length of the shorter string.
04. If the current character of the first string is not equal to the current character of the last string, return the common prefix found so far.
05. Otherwise, append the current character to the ans string.
06. Return the ans string containing the longest common prefix.

*/



import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello world!");

        String[] v = {"Helo1345", "Hello", "Hel"};
        Solution solution = new Solution();
        System.out.println(String.format("LongestCommonPrefix : %s", solution.findLongestCommonPrefix(v)));
    }


    public static class Solution {
        public String findLongestCommonPrefix (String[] v) {
            StringBuilder ans = new StringBuilder();
            Arrays.sort(v);
            String first = v[0];
            String last = v[v.length - 1];
            for (int i = 0; i < Math.min(first.length(), last.length()); i++) {
                if (first.charAt(i) != last.charAt(i)) {
                    return ans.toString();
                }
                ans.append((first.charAt(i)));
            }
            return  ans.toString();
        }
    }


}