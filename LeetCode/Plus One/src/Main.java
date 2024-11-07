
/*

1의 자리 숫자가 9인지 아닌지에 따라 나눠서 생각.

만약, 1의 자리 숫자가 9가 아니라면 단순히 digits 배열 가장 마지막요소에 +1 해서 리턴.
만약, 1의 자리 숫자가 9라면.
    만약, digits 배열 길이가 1이라면. > int[] digits = [ 1, 0 ]
    만약, digits 배열 길이가 1보다 크다면.
        i포인터 -1씩 감소시키면서 digits[i] 에 +1 해주기. (while 문)
            만약, 만약 1을 더한 숫자가 10이 된다면, 해당 요소는 0으로 만들고 다음 반복 시작.
                그게 아니라면 해당 요소에 1을 더한 뒤 해당 배열 반환.
        while문 다 끝났는데도 리턴 안 되었다는 것은 모든 자리가 9라는 것. ('9','999')
            기존 digits 배열 길이보다 한 자리 더 큰 배열로 초기화.
            그리고 가장 첫 번째 요소 '0'으로 만들어주고 digits 배열 리턴.


*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Problem of Plus One!");
    }


    public static class Solution{
        public int[] plusOne(int[] digits){

            // 만약, 1의 자리 숫자가 9가 아니라면 단순히 digits 배열 가장 마지막요소에 +1 해서 리턴.
            if (digits[digits.length-1] != 9) {
                digits[digits.length-1] = digits[digits.length-1] + 1;
                return digits;
            } else { // 만약, 1의 자리 숫자가 9라면.
                if (digits.length == 1) {  // 만약, digits 배열 길이가 1이라면 (digits = [9]인 경우)
                    digits = new int[2];
                    digits[0] = 1;
                    return digits;
                } else { // digits 배열 길이가 1보다 크다면.
                    // digits[i] 가 0이 아닐 때까지 i포인터 -1씩 감소시키면서 digits[i] 에 +1 해주기.
                    int i = digits.length-2;

                    while (i >= 0) { // i가 0보다 같거나 클 때까지 계속 반복.

                        if (digits[i] + 1 == 10) { // 만약 1을 더한 숫자가 10이 된다면, 해당 요소는 0으로 만들고 다음 반복 시작.
                            digits[i] = 0;
                            i--;
                        }
                        else { // 그게 아니라면 해당 요소에 1을 더한 뒤 해당 배열 반환.
                            digits[i] = digits[i] + 1;
                            return digits;
                        }
                    }

                    // while문이 끝날 때까지 digits 배열 반환 안 된 상태라면 99,999 등 모든 자리가 9인 숫자 배열이라는 뜻.
                    digits = new int[digits.length + 1]; // 기존 digits 배열 길이보다 한 자리 더 큰 배열로 초기화.
                    digits[0] = 1; // 그리고 가장 첫 번째 요소 '0'으로 만들어주고
                    return digits; // digits 배열 리턴.
                }
            }
        }
    }
}