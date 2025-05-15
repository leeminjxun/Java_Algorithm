package Data_Structure.Stack;

// 백준 [4949] 문제 유형 = Stack

// 문제 : 균형잡힌 세상

// 괄호들의 균이 잘 맞춰져 있는지 판단하는 프로그램, 괄호는 소괄호와("()") 대괄호("[]") 2종류이다.

// 1. 모든 오른쪽 괄호들은 자신과 짝을 이룰 수 있는 왼쪽 괄호가 존재해야한다.
// 2. 모든 괄호들은 1:1 매칭만 가능하다.
// 3. 짝을 이루는 두 괄호가 있을 때, 그 사이에 있는 문자열도 균형이 잡혀야한다.

// 입력 : 각 문자열은 마지막 글자를 제외하고 영문 알파벳, 공백, 소괄호("( )"), 대괄호("[ ]")로 이루어져 있으며, 온점(".")으로 끝나고, 길이는 100글자보다 작거나 같다.
// 입력의 종료조건으로 맨 마지막에 온점 하나(".")가 들어온다.

// 출력 : 각 줄마다 해당 문자열이 균형을 이루고 있으면 "yes"를, 아니면 "no"를 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek4949 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();


        while (true) {
            String str = br.readLine();

            if (str.equals(".")) break;

            sb.append(balance(str)).append("\n");
        }

        System.out.println(sb);
    }

    public static String balance(String s) {
        Deque<Character> stack = new ArrayDeque<>();

        for (int i = 0; i < s.length(); i++){
            char ch = s.charAt(i);

            if (ch == '(' || ch == '[') { // 왼쪽 괄호가 나온 경우
                stack.push(ch);
            } else if (ch == ')') { // 오른쪽 소괄호가 나온 경우
                if (stack.isEmpty() || stack.peek() != '(') { // stack 이 비어있거나 stack의 최신 데이터가 왼쪽 소괄호 인 경우
                    return "no"; // break 하지 않아도 for 종료
                } else stack.pop(); // 한 쌍의 괄호가 되어 stack 을 비운다.
            } else if (ch == ']') { // 오른쪽 대괄호가 나온 경우
                if (stack.isEmpty() || stack.peek() != '[') { // stack 이 비어있거나 stack의 최신 데이터가 왼쪽 대괄호 인 경우
                    return "no";
                } else stack.pop();
            }
        }

        if (stack.isEmpty()) return "yes"; // 모든 괄호가 한 쌍의 괄호가 되어, 균형이 잡혀 yes 를 반환.
        else return "no"; // 괄호가 한 쌍이 되지 않아, 균형이 잡히지 않았다. no 를 반환.
    }
}
