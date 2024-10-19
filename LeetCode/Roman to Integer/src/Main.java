
/*

Intuition:
        The key intuition lies in the fact that in Roman numerals, when a smaller value appears before a larger value, it represents subtraction, while when a smaller value appears after or equal to a larger value, it represents addition.

Explanation:
1. The unordered map m is created and initialized with mappings between Roman numeral characters and their corresponding integer values. For example, 'I' is mapped to 1, 'V' to 5, 'X' to 10, and so on.

2. The variable ans is initialized to 0. This variable will accumulate the final integer value of the Roman numeral string.

3. The for loop iterates over each character in the input string s.
For the example "IX":
* When i is 0, the current character s[i] is 'I'. Since there is a next character ('X'), and the value of 'I' (1) is less than the value of 'X' (10), the condition m[s[i]] < m[s[i+1]] is true. In this case, we subtract the value of the current character from ans.

ans -= m[s[i]];
ans -= m['I'];
ans -= 1;
ans becomes -1.

* When i is 1, the current character s[i] is 'X'. This is the last character in the string, so there is no next character to compare. Since there is no next character, we don't need to evaluate the condition. In this case, we add the value of the current character to ans.

ans += m[s[i]];
ans += m['X'];
ans += 10;
ans becomes 9.


For the example "XI":

* When i is 0, the current character s[i] is 'X'. Since there is a next character ('I'), and the value of 'X' (10) is greater than the value of 'I' (1), the condition m[s[i]] < m[s[i+1]] is false. In this case, we add the value of the current character to ans.

ans += m[s[i]];
ans += m['X'];
ans += 10;
ans becomes 10.

* When i is 1, the current character s[i] is 'I'. This is the last character in the string, so there is no next character to compare. Since there is no next character, we don't need to evaluate the condition. In this case, we add the value of the current character to ans.

ans += m[s[i]];
ans += m['I'];
ans += 1;
ans becomes 11.

4. After the for loop, the accumulated value in ans represents the integer conversion of the Roman numeral string, and it is returned as the result.


*/






import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {

        // Create globalVariables;
        String romanNumeralValue, printingMessage;


        // Create an ArrayList to store String RomanNumeral
        ArrayList<String> list = new ArrayList<>();

        // Add elements of romanNumerals that you want to test to the ArrayList
        list.add("III");
        list.add("LVIII");
        list.add("MCMXCIV");
        list.add("IXMCV");
        list.add("CMMCIXV");

        // Converting ArrayList to Array
        String[] romanNumeralsArray = new String[list.size()];
        romanNumeralsArray = list.toArray(romanNumeralsArray);

        // Converting romanNumerals to int
        Solution solution = new Solution();
        for (String romanNumeral : romanNumeralsArray) {
            romanNumeralValue = romanNumeral;
            printingMessage = String.format("Converting '%s' to int is %d", romanNumeralValue, solution.romanToInt(romanNumeralValue));
            System.out.println(printingMessage);
        }
    }

    public static class Solution {
        public int romanToInt(String s) {

            Map<Character, Integer> m = new HashMap<>();

            m.put('I', 1);
            m.put('V',5);
            m.put('X',10);
            m.put('L',50);
            m.put('C',100);
            m.put('D',500);
            m.put('M',1000);

            int ans = 0;

            for (int i = 0; i < s.length(); i++) {
                if (i < s.length() - 1 && m.get(s.charAt(i)) < m.get(s.charAt(i+1))) {
                    ans -= m.get(s.charAt(i));
                } else {
                    ans += m.get(s.charAt(i));
                }
            }
            return ans;
        }
    }

}