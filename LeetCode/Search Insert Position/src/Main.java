
/*

<문제 접근>
- 배열이 정렬되어 있기 때문에, 이진 검색을 통해 문제를 해결한다. 그래야 O(log n) 시간복잡도로 문제를 풀 수 있다.

<이진 검색>
01. 두 개의 포인터 초기화 : left (배열 처음), right (배열 마지막)
02. 이진 검색 Loop
- 중앙 인덱스 계산 : mid = left + (right - left) / 2
- 만약 nums[mid] == target 인 경우, mid 값 리턴. (target 찾은 경우)
- 만약 nums[mid] < target 인 경우, left 포인터를 mid + 1 만큼 이동. (오른쪽 절반 검색)
- 만약 nums[mid] > target 인 경우, right 포인터를 mid - 1 만큼 이동. (왼쪽 절반 검색)
03. 삽입 위치 리턴 : loop 문 끝났을 때, left 포인터 변수가 target이 삽입될 위치임.

*/


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Problem of Search Insert Position!");
    }



    public class Solution {
        public int searchInsert(int[] nums, int target) {

            int left = 0;
            int right = nums.length - 1;

            while (left <= right) {
                int mid = left + (right - left) /2;

                if (nums[mid] == target) {
                    return mid; // 타겟 찾음.
                } else if (nums[mid] < target) { // 중앙값이 target보다 작은 경우 오른쪽 검색
                    left = mid + 1;
                } else { // 중앙값이 target보다 큰 경우 왼쪽 검색
                    right = mid - 1;
                }
            }

            // target 못 찾은 경우, left가 삽입 포인트임.
            return left;
        }
    }

}