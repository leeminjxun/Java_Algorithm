package Data_Structure.Stack;

// 백준 [10773] 문제 유형 = Stack

// 문제 : 괄호

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek9012 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Character> stack = new ArrayDeque<Character>();

        int T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            String str = br.readLine();

            stack.clear();

            for (int j = 0; j < str.length(); i++) {
                char ch = str.charAt(j);

                if (ch == '(') {
                    stack.push(ch);
                } else {
                    if (stack.isEmpty()) {
                        stack.push(ch);
                        break;
                    }
                    else stack.pop();
                }
            }

            if (stack.isEmpty()) {
                sb.append("YES\n");
            } else sb.append("NO\n");
        }

        System.out.println(sb);
    }
}
