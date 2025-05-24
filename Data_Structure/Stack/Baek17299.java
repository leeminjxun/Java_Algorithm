package Data_Structure.Stack;

// 백준 [17299] 문제 유형 = Stack

// 문제 : 오등큰수

// Ai가 수열 A에서 등장한 횟수를 F(Ai)라고 했을 때,
// Ai의 오등큰수는 오른쪽에 있으면서 수열 A에서 등장한 횟수가 F(Ai)보다 큰 수 중에서 가장 왼쪽에 있는 수를 의미한다.
// 그러한 수가 없는 경우에 오등큰수는 -1이다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek17299 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        int[] seg = new int[N];
        int[] F = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            int num = Integer.parseInt(st.nextToken());
            seg[i] = num;
            F[num - 1]++;
        }

        for (int i = 0; i < N; i++) {
            while (!stack.isEmpty() && F[seg[stack.peek()] - 1] < F[seg[i]] - 1) {
                seg[stack.pop()] = seg[i];
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) {
            seg[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(seg[i]).append(" ");
        }

        System.out.println(sb);

    }
}
