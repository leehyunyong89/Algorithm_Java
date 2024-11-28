
/*

N 번째 계단까지 갈 수 있는 총 경우의 수는 아래 두 가지 경우의 수의 총 합.
* N-2번째 계단까지 갈 수 있는 총 경우의 수
* N-1번째  계단까지 갈 수 있는 총 경우의 수

FOR문 속에서 i계단까지 올라갈 수 있는 경우의 수는
i-1 (prev1) 까지의 총 경우의 수
+
i-2 (prev2) 까지의 총 경우의 수 이다.

따라서 current = prev1 + prev2 임.

*/


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Problem of Climbing Stairs!");

        int stairs = 5;
        Solution solution = new Solution();
        System.out.println("5번째 계단까지 올라갈 수 있는 총 경우의 수는 " + solution.climbStairs(stairs) + "입니다.");

    }

    public static class Solution{
        public int climbStairs(int n) {

            if (n == 1) return 1; // 만약 계단 수가 1개라면 1 리턴. (한 가지 방법밖에 없으니까.)
            if (n == 2) return 2; // 만약 계단 수가 2개라면 2 리턴. (한 계단씩 가는 방법, 두 계단씩 가는 방법 이렇게 총 두 가지 방법이니까.)

            int prev2 = 1; // prev2 변수 초기화 : 첫 번째 계단까지 갈 수 있는 경우의 수.
            int prev1 = 2; // prev2 변수 초기화 : 두 번째 계단까지 갈 수 있는 경우의 수.

            for (int i = 3; i <= n; i++) {
                int current = prev1 + prev2; // i번째 계단까지 갈 수 있는 모든 경우의 수
                prev2 = prev1; // prev2 변수를 prev1 로 바꿔주기.
                prev1 = current; // prev1 변수를 current 변수로 바꿔주기.
            }

            return  prev1;
        }
    }
}