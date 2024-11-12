
/*

// 이진 검색 사용 : x의 제곱근은 x/2를 초과할 수 없기 때문에 O(log x) 시간복잡도를 만족시키면서 풀 수 있음.
// 예외 처리 : x가 0 or 1일 때는 x 그대로 리턴. 왜냐하면 sqrt(0)=0, sqrt(1)=1 이기 때문.
// 이진 검색 셋팅
    // 두 가지 포인터 사용
        // left = 1 , right = x/2
        // 어떤 정수(x>1이라고 가정했을 때)든 그 수의 제곱근은 1~x/2 범위 안에 있기 때문.
// 이진 검색 로직
    // while 문 안에서 mid * mid 계산
       // 만약, mid * mid 가 x와 같다면, mid 리턴.
       // 만약, mid * mid 가 x보다 작다면, left 포인터 mid+1만큼 이동 (mid가 잠재적 제곱근일 수 있으면서, 조금 더 큰 제곱근이 나올 수도 있는 상태)
       // 만약, mid * mid 가 x보다 크다면, right 포인터 mid-1만큼 이동
    // return right : while 문이 종료됐을 때, right 포인터가 x의 제곱근이거나 제곱근에 가장 가까운 큰 정수임.


 */

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Problem of Sqrt(X)!");
    }

    public class Solution {
        public int mySqrt(int x) {
            // 예외 처리 : x가 0 or 1일 때는 x 그대로 리턴. 왜냐하면 sqrt(0)=0, sqrt(1)=1 이기 때문.
            if (x == 0 || x == 1) return x;

            // 두 가지 포인터 사용
            int left = 1 , right = x/2;  // 어떤 정수(x>1이라고 가정했을 때)든 그 수의 제곱근은 1~x/2 범위 안에 있기 때문.

            while (left <= right) {
                int mid = left + (right - left) / 2;
                long squre = (long) mid * mid; // long 자료형 사용 : int형은 2,147,483,647 만큼만 저장할 수 있기 때문에 Overflow 문제 발생을 방지하기 위해.

                if (squre == x) { // 정확한 제곱근 찾은 경우 mid 값 리턴.
                    return mid;
                } else if (squre < x) { // 조금 더 큰 정수를 찾기 위해 left 포인터 오른쪽으로(mid + 1만큼) 이동
                    left = mid + 1;
                } else { // right 포인터를 왼쪽으로(mid - 1만큼) 이동
                    right = mid - 1;
                }
            }

            // while 문이 종료될 때까지도 return값 없다면, right 포인터가 x의 제곱근이거나 제곱근에 가장 가까운 큰 정수임.
            return right;
        }
    }
}