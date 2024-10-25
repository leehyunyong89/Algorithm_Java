
/*
Approach
배열이 이미 정렬되어 있기 때문에, 두 가지 포인터로 문제를 해결할 수 있음.

01. 두 가지 포인터 :
* i : 새로운 유니크 요소를 쓸 index. 0부터 시작.
* j : 배열 스캔하는 변수. 1부터 시작.

02. nums[j] , nums[i] 비교. 만약 다르다면 i를 1 증가시키고 nums[i] 값을 nums[j] 값으로 변경.
이 방식으로 하면 모든 유니크 요소들이 배열의 시작점에 복사됨.

03. 모든 반복이 끝나면, i + 1 의 값이 모든 유니크 요소들의 개수를 나타내주는 것. 더불어서 nums의 값들도 바뀌어 있음.
[0, 1, 2, _, _, _] 이런 식으로.

*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello problem!");
    }

    public static class Solution {
        public int removeDuplicates(int[] nums) {

            if (nums.length < 1) return 0; // 빈 배열 들어오면 0 리턴.

            int i = 0; // 다음 유니크 요소가 쓰여질 인덱스 포인트

            for (int j = 1; j < nums.length; j++) {
                if (nums[i] != nums[j]) { // 만약 유니크 요소를 만나면
                    i++; // 인덱스 포인트 1 증가
                    nums[i] = nums[j]; // nums[i] 의 값을 유니크 요소인 nums[j]값으로 복사.
                }
            }

            return i + 1;  // 유니크 요소들의 길이 리턴.

        }
    }
}