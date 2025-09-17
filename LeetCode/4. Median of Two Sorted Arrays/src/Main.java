

/*

problem :
 Given two sorted arrays nums1 and nums2 of size m and n respectively, return the median of the two sorted arrays.

The overall run time complexity should be O(log (m+n)).



Example 1:

Input: nums1 = [1,3], nums2 = [2]
Output: 2.00000
Explanation: merged array = [1,2,3] and median is 2.
Example 2:

Input: nums1 = [1,2], nums2 = [3,4]
Output: 2.50000
Explanation: merged array = [1,2,3,4] and median is (2 + 3) / 2 = 2.5.


Constraints:

nums1.length == m
nums2.length == n
0 <= m <= 1000
0 <= n <= 1000
1 <= m + n <= 2000
-106 <= nums1[i], nums2[i] <= 106

 */


import java.util.Arrays;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello Problem of Median of Two Sorted Arrays!");

        int[] nums1 = {1 , 3};
        int[] nums2 = {2};
        int[] nums3 = {1, 2};
        int[] nums4 = {3, 4};
        Solution solution = new Solution();
        System.out.println(solution.findMedianSortedArrays(nums3,nums4));
    }



    public static class Solution {

        public double findMedianSortedArrays (int[] nums01, int[] nums02) {
            double result = 0;

            // if both array's Length are zero, then return zero.
            if (nums01.length == 0 && nums02.length == 0) return 0;


            // 01 : merged array and sort
            int[] merged = new int[nums01.length + nums02.length];
            System.arraycopy(nums01, 0, merged, 0, nums01.length);
            System.arraycopy(nums02, 0, merged, nums01.length, nums02.length);
            Arrays.sort(merged);

            // 02 : get the length of the array
            int lengthOfMergedArray = merged.length;

            // 03 : get the middle index of the array
            int middleIndexOfMergedArray = lengthOfMergedArray / 2;

            // 04-01 : if the length equals to odd number, then return value is merged array [The quotient of merged array length and two]
            if (lengthOfMergedArray % 2 != 0) {
                result = merged[middleIndexOfMergedArray];
            } else  { // 04-02 : else then return value is [(merged array [The quotient of merged array and two  - 1] + merged array [The quotient of merged array and two]) / 2]
                result = (merged[middleIndexOfMergedArray - 1] + merged[middleIndexOfMergedArray]) / 2.0;
            }


            return  result;
        }
    }
}