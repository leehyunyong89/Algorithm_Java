public class Main {
    public static void main(String[] args) {
        System.out.println("Hello Problem of Length Of Last Word!");

        String ex01 = "Hello World";
        String ex02 = "    fly me        to the        moon   ";
        String ex03 = "luffy is still joyboy";

        Solution solution = new Solution();

        System.out.println(String.format("ex01 result : %s", solution.lengthOfLastWord(ex01)));
        System.out.println(String.format("ex02 result : %s", solution.lengthOfLastWord(ex02)));
        System.out.println(String.format("ex03 result : %s", solution.lengthOfLastWord(ex03)));

    }

    public static class Solution{
        public int lengthOfLastWord(String s) {

            int length = 0;
            int lastIndexPointer = 0;
            // 공백 기준 split
            String[] splitedStr = s.split(" ");

            // 마지막 인덱스 포인터 지정.
            lastIndexPointer = splitedStr.length-1;

            length = splitedStr[lastIndexPointer].length();

            return length;
        }
    }

    public static class SolutionOfOptimizedVersion{
        public int lengthOfLastWord(String s) {
            int length = 0;
            int i = s.length()-1;

            // 뒷 공백 건너뛰기
            while (i >= 0 && s.charAt(i) == ' '){
                i--;
            }

            // 마지막 단어의 글자수 세기
            while (i >= 0 && s.charAt(i) != ' ') {
                length++;
                i--;
            }

            return length;
        }
    }
}