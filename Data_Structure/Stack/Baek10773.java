package Data_Structure.Stack;

// 백준 [10773] 문제 유형 = Stack

// 문제 : 제로

// 첫 번째 줄에 정수 K 가 주어진다.
// 이후 K개의 줄에 정수가 1개씩 주어진다.
// 정수는 0에서 1,000,000 사이의 값을 가지며, 정수가 "0" 일 경우에는 가장 최근에 쓴 수를 지우고, 아닐 경우 해당 수를 쓴다.
// 정수가 "0"일 경우에 지울 수 있는 수가 있음을 보장할 수 있다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek10773 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Deque<Integer> stack = new ArrayDeque<>();

        int K = Integer.parseInt(br.readLine());

        int total = 0;

        for (int i = 0; i < K; i++) {
            int N = Integer.parseInt(br.readLine());

            if (N == 0) stack.pop();
            else stack.push(N);
        }

        while (!stack.isEmpty()) {
            total += stack.pop();
        }

        System.out.println(total);
    }
}
