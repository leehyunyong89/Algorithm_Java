
/*

* i,j 포인터 사용 : 각 스트링 변수 마지막 인덱스 포인터
* int형 변수 carry 사용 : 1+1=2 결과 나왔을 때 다음 자리로 넘겨줄 데이터 저장 변수
* StringBuilder형 변수 result 사용 : 더해지는 결과를 저장는 변수.
* charAt(i)-'0' 사용 : 스트링을 int로 변환하기 위함.
* sum % 2 사용 : 계산 결과는 0,1만 나와야 하기 때문.
* sum / 2 사용 : 1+1 or 1+1+1 의 결과가 나왔을 때 다음 자리로 넘겨줄 데이터 계산.
* result.reverse()사용 : 계산 다 끝나면 result 변수는 거꾸로 정렬되어 있음. 따라서 reverse 함수 써서 순서 바꿔주기.
* */


public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Problem of Add Binary!");
        String a = "11";
        String b = "1";

        System.out.println(0%2);
    }


    public class Solution{
        public String addBinary(String a, String b) {
            StringBuilder result = new StringBuilder();
            int i = a.length() - 1;
            int j = b.length() - 1;
            int carry = 0;


            while (i >= 0 || j >= 0 || carry != 0) {
                int sum = carry; // 이전 단계에서 받은 carry 변수로 sum 시작.

                // i 인덱스에 있는 a 값 더해주기.
                if (i >= 0) {
                    sum += a.charAt(i) - '0'; // charAt(i)-'0' 사용 : 스트링을 int로 변환하기 위함.
                    i--;
                }

                // j 인덱스에 있는 b 값 더해주기.
                if (j >= 0) {
                    sum += b.charAt(j) - '0';
                    j--;
                }

                // 계산 결과를 result 변수에 더해주기
                result.append(sum % 2);

                // 다음 자리로 넘겨줄 '1' 있는지 파악
                carry = sum / 2;
            }

            // 계산 다 끝나면 result 변수는 거꾸로 정렬되어 있음. 따라서 reverse 함수 써서 순서 바꿔주기.
            return result.reverse().toString();
        }
    }
}