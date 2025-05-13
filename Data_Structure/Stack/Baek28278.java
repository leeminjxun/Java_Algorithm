package Data_Structure.Stack;

// 백준 [28278] 문제 유형 = Stack

// 문제 : 스택 2

// 정수를 저장하는 스택을 구현한 후, 입력으로 주어지는 다음 명령을 처리하는 프로그램을 작성하라.

// 1 X : 정수 X 를 스택에 넣는다. (1 <= X <= 100,000)
// 2 : 스택에 정수가 있다면, 맨 위의 정수를 빼고 출력한다. 없다면 대신 -1 을 출력한다.
// 3 : 스택에 있는 정수 개수를 출력한다.
// 4 : 스택이 비어있다면 1, 아니면 0 을 출력한다.
// 5 : 스택에 정수가 있다면 맨위의 정수를 출력한다. 없다면 -1 을 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek28278 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        int command = 0;

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            command = Integer.parseInt(st.nextToken());

            switch (command){
                case 1:
                    stack.push(Integer.parseInt(st.nextToken()));
                    break;

                case 2:
                    if (!stack.isEmpty()) sb.append(stack.pop()).append("\n");
                    else sb.append("-1\n");
                    break;

                case 3:
                    sb.append(stack.size()).append("\n");
                    break;

                case 4:
                    if (stack.isEmpty()) sb.append("1\n");
                    else sb.append("0\n");
                    break;

                case 5:
                    if (!stack.isEmpty()) sb.append(stack.peek()).append("\n");
                    else sb.append("-1\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
