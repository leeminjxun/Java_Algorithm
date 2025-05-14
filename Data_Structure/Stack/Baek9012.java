package Data_Structure.Stack;

// 백준 [9012] 문제 유형 = Stack

// 문제 : 괄호

// 한 쌍의 괄호 기호로 된 "()" 문자열을 기본 VPS 라고 한다.
// 만약 x 가 VPS 라면 이것을 괄호 한쌍에 넣은 (x) 또한 VPS 가 되며, 두 VPS x, y 를 접합시킨 (xy) 또한 VPS 이다.
// Ex ) VPS = "(())()", "((()))" / NOT VPS = "(()(", "(())()))", ")()()"
// VPS 인지 아닌지는 YES or NO 로 한 줄씩 나타낸다.

// 입력 데이터는 표준 입력을 사용한다.
// 입력은 T개의 테스트 데이터로 주어진다. 입력의 첫 번째 줄에는 입력 데이터의 수를 나타내는 정수 T가 주어진다.
// 각 테스트 데이터의 첫째 줄에는 괄호 문자열이 한 줄에 주어진다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            stack.clear();

            for (int j = 0; j < str.length(); j++) {
                char ch = str.charAt(j);

                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) { // stack 이 비어있는 상태이며 처음 문자가 ) 인 경우 --> 한 쌍의 괄호가 불가능 하므로
                        stack.push(ch); // 밑의 조건문을 통해 스택이 비어있지 않음 을 증명하기 위한 push
                        break; // break 을 통해 for 문 빠져나가는, 즉 해당 괄호 문자열 자체를 VPS 라 취급하지 않는다.
                    }
                    else stack.pop(); // ( ) 한 쌍의 괄호를 포함하므로, VPS 로 취급
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES").append("\n");
            } else sb.append("NO").append("\n");
        }

        System.out.println(sb);
    }
}
