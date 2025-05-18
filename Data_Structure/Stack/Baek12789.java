package Data_Structure.Stack;

// 백준 [9012] 문제 유형 = Stack

// 문제 : 도키도키 간식드리미

// 사람들은 현재 1열으로 줄을 서 있고, 맨 앞의 사람만 이동이 가능하다.
// 번호 표 순서대로만 통과할 수 있는 라인을 만들어 두었다.
// 이 라인과 대기열의 맨 앞사람 사이에는 한 사람 씩 1열으로 들어갈 수 있는 공간이 있다. (stack 공간)
// 현재 대기열의 사람들은 이 공간(stack 공간)으로 올 수는 있지만, 반대는 불가능하다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek12789 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine()); // 사람 수

        int[] arr = new int[N];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 대기열에 있는 사람의 번호표를 1차원 배열으로 입력받는다.
        }

        int next = 1; // 다음 들어갈 번호표를 나타내는 변수

        // 예제 : arr = [5, 4, 1, 3, 2]
        for (int i = 0; i < N; i++) { // 대기열에 있는 사람 수 만큼만 반복한다.
            if (arr[i] == next) { // 번호표가 같다면 (대기열 을 확인)
                next++; // 다음 번호표로 이동

                // stack 공간을 확인
                while (!stack.isEmpty()) { // stack 에 들어가 있는 순서에 맞지 않는 번호 표를 가진 사람이 없을 때 까지 반복
                    if (stack.peek() == next) { // stack 의 가장 최근에 들어간 번호표가 다음 번호표와 같다면
                        stack.pop(); // 그 번호 표를 가진 사람을 입장시킨다.
                        next++; // 다음 번호표를 가리킨다.
                    } else break;
                }
            } else {
                stack.push(arr[i]); // 번호표가 다를 경우, stack 대기열에 들어간다.
            }
        }

        if (stack.isEmpty()) System.out.println("Nice"); // 모두 입장 시킨 경우 : stack 이 비어있을 것이다.
        else System.out.println("Sad"); // 모두 입장 시키지 못한 경우


//        for (int i = 0; i < N; i++) {
//            int number = Integer.parseInt(st.nextToken());
//
//            if (number != next) {
//                stack.push(number);
//            } else next++;
//        }
//
//        while (true) {
//            if (stack.isEmpty()) {
//                System.out.println("Nice");
//                break;
//            } else {
//                if (stack.peek() == next) {
//                    stack.pop();
//                    next++;
//                } else {
//                    System.out.println("Sad");
//                    break;
//                }
//            }
//        }

    }
}
