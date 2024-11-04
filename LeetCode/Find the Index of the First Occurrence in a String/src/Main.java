

/*

* KMP (Knuth-Morris-Pratt) 알고리즘 이용해서 풀었음.

* 이유 : needle과 haystack이 일치하지 않았을 때 다시 처음부터 되돌아가서 불필요한 비교를 또 하지 않아도 되기 때문.

* key concept :
- 접두사이면서 접미사인 string 정보를 저장하는 Array를 만들기.
- 일치하지 않는 글자가 발생했을 때, 그 이전까지 가장 긴 접두사이면서 접미사인 string 정보를 확인하고 그 길이만큼 건너뛴 후 다시 비교 시작.

* 시간복잡도
> O(n + m) : n은 haystack 길이, m은 needle 길이
> LPS 배열 만들 때 O(m) 시간 소요.
> 검색 단계에서 O(n) 시간 소요.
> 따라서 시간복잡도(Time Complexity)는 O(n + m).



*/

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Problem of Find the Index of the Occurrence in a String!");
    }



    public static class Solution {
        public int strStr(String haystack, String needle) {

            if (needle.isEmpty()) return 0; // needle 값이 비어 있는 경우 0 반환.

            int[] lps = buildLPS(needle); // LPS 배열 만들기

            int i = 0; // haystack Pointer
            int j = 0; // needle Pointer


            while (i < haystack.length()) {
                if (haystack.charAt(i) == needle.charAt(j)) {
                    i++;
                    j++;
                }

                if (j == needle.length()) {
                    return i - j; // 패턴 찾은 경우
                } else if (i < haystack.length() && haystack.charAt(i) != needle.charAt(j)) {
                    if (j != 0) {
                        j = lps[j - 1]; // 불필요한 비교를 건너뛰기 위해 LPS 배열 이용.
                    } else  {
                        i++; // 만약 j가 0이면, 간단하게 i도 1증가
                    }
                }
            }


            return  -1; // 패턴 못 찾은 경우
        }

        // LPS (Longest Prefix Suffix) 배열 만드는 함수
        private int[] buildLPS(String needle) {
            int[] lps = new int[needle.length()];
            int length = 0; // 이전에 가장 긴 prefix suffix 길이 저장
            int i = 1;

            while (i < needle.length()) {
                if (needle.charAt(i) == needle.charAt(length)) {
                    length++;
                    lps[i] = length;
                    i++;
                } else {
                    if (length != 0) {
                        length = lps[length - 1]; // 이전까지 가장 긴 접두사 접미사 길이 시도해보기
                    } else {
                        lps[i] = 0;
                        i++;
                    }
                }
            }

            return lps;
        }
    }
}