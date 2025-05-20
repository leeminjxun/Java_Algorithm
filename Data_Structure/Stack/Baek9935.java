package Data_Structure.Stack;

// 백준 [9935] 문제 유형 = Stack

// 문제 : 문자열 폭팔

// 첫 번째 줄에 문장이 주어지고, 두 번째 줄에는 폭팔 문자열 이라는 특정 키워드가 주어진다.
// 첫 번째로 입력 받은 문에 폭팔 키워드가 있다면 그 키워드를 지운다. 그리고 문장을 이어 붙힌다.
// 문장을 이어 붙혔을 때, 폭팔 키워드가 생긴다면 그 키워드를 또다시 지우고 문장을 이어 붙힌다.
// 이런 식으로 모든 폭팔 키워드를 지운 후, 남은 문장을 출력한다.



import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Stack;

public class Baek9935 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String str = br.readLine();
        String bomb = br.readLine();
        char[] result = new char[str.length() + 1];


        // 1. stack 을 이용한 풀이 : 시간 복잡도 매우 높음
/*

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < str.length(); i++) {
            int count = 0;
            stack.push(str.charAt(i));

            if (stack.size() >= bomb.length()) {

                for (int j = 0; j < bomb.length(); j++) {

                    if (stack.get(stack.size() - bomb.length() + j) == bomb.charAt(j)) {
                        count++;
                    }
                    if (bomb.length() == count) {
                        for (int k = 0; k < bomb.length(); k++) {
                            stack.pop();
                        }
                    }
                }
            }
        }

        if (!stack.isEmpty()) {
            for (char ch : stack) {
                sb.append(ch);
            }
        } else sb.append("FRULA");

        System.out.println(sb);

*/

        // 2. 문자열 배열 을 이용한 풀이 : 시간 복잡도 낮음, stack 과는 관련이 없는 풀이

        int idx = 0;

        for (int i = 0; i < str.length(); i++) {
            result[idx] = str.charAt(i);
            if(isSame(result, idx, bomb)) idx -= bomb.length();

            idx++;
        }

        String res = String.valueOf(result, 0, idx);

        if(res.length() != 0) System.out.println(res);
        else System.out.println("FRULA");

    }

    private static boolean isSame(char[] s, int pos, String bomb) {

        if(pos < bomb.length() - 1) return false; // idx 값이 폭탄 문자열의 크기보다 작을 경우

        for (int i = bomb.length() -1; i >= 0; i--) {
            if (s[pos--] != bomb.charAt(i)) return false; // 현재의 문자열 s 가 특정 인덱스의 폭탄 문자 값과 다를 경우
        }

        return true; // 현재의 문자 배열 s 와 폭탄 문자열이 같을 경우
    }
}
