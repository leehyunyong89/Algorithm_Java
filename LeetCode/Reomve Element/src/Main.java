


/*
시간 복잡도 O(n)을 만족시키기 위해서, 두 가지 포인터 개념 사용.

01. 변수 i : 배열 반복 추적 변수
02. 변수 j : val값과 일치하지 않는 값을 입력하기 위한 포인터 인덱스 변수

val 값과 일치하지 않는 값을 찾을 때마다, 인덱스 j 값에 그 값을 입력. 그리고 j 값 1씩 증가.


 */


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Problem of Remove Element");
    }

    public static class Solution {
        public int removeElement (int[] nums, int val) {

            if (nums.length < 1) return 0;  // 아무값도 없는 nums 배열 들어온 경우 0 리턴.

            int j = 0; // 포인터 : 일치하지 않는 값을 입력하기 위한 포인터 인덱스

            for (int i = 0; i < nums.length; i++) {
                if (nums[i] != nums[j]) { // 요소가 val 값과 일치하지 않는다면
                    nums[j] = nums[i]; // 해당 요소를 j 인덱스 요소값으로 옮기고
                    j++;  // j값 1 증가.
                }
            }

            return j;  // 배열 길이 리턴.
        }
    }
}