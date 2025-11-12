package BOJ.Silver;

import java.util.*;
import java.io.*;

public class Baek17413 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        String S = br.readLine();
        boolean tag = false;

        // 문자를 뒤집은 값을 저장하는 stack (후입선출)
        Stack < Character > stack = new Stack<>();

        for (int i = 0; i < S.length(); i++) {
            // 열린 꺽새를 만났을 경우.
            if(S.charAt(i) == '<') {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
                tag = true;
            }

            // 닫힌 꺽새 를 만났을 경우
            if(S.charAt(i) == '>') {
                sb.append(S.charAt(i)); // > 문자를 명시적으로 입력해야한다.
                tag = false;
                continue;
            }

            if(tag) { // 조건문에서 < 이후의 단어를 저장한다.
                sb.append(S.charAt(i));
            } else {
                if(S.charAt(i) == ' ') {
                    while(!stack.isEmpty()) {
                        sb.append(stack.pop());
                    }

                    sb.append(' ');
                } else {
                    stack.push(S.charAt(i));
                }
            }
            if(i == S.length() - 1) {
                while(!stack.isEmpty()) {
                    sb.append(stack.pop());
                }
            }

        }

        System.out.println(sb);
    }
}
