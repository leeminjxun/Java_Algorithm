package Data_Structure.Queue;

// 백준 [2164] 문제 유형 = Queue

// 문제 : 카드 2

// 첫째줄에 정수 N 이 주어진다.

// N 개의 카드를 생성하고 카드의 번호는 1 ~ N 이다.
// 1번 카드가 제일 위에, N번 카드가 제일 아래에 위치한다.
// 다음 동작을 카드가 1개 남을 때 까지 반복한다.
// 우선, 제일 위에 있는 카드를 바닥에 버린다. 그 다음, 제일 위에 있는 카드를 제일 아래에 있는 카드 밑으로 옮긴다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek2164 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++) {
            queue.offer(i+1);
        }

        while (queue.size() > 1) {
            queue.poll();
            queue.offer(queue.poll());
        }

        System.out.println(queue.poll());

    }
}
