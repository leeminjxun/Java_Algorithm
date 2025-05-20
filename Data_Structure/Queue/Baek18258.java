package Data_Structure.Queue;

// 백준 [4949] 문제 유형 = Queue

// 문제 : 큐 2

// 정수를 저장하는 큐를 구현 한 후, 입력으로 주어지는 명령을 처리하는 프로그램을 작성.
// 1. push X : 정수 X 를 큐에 넣는 연산
// 2. pop : 큐에서 가장 앞에 있는 정수를 빼고, 그 수를 출력한다. 만약 큐가 비어있다면 -1 출력
// 3. size : 큐에 들어가있는 정수의 개수를 출력.
// 4. empty : 큐가 비어있다면 1, 아니라면 0 을 출력
// 5. front : 큐 가장 앞단에 있는 정수를 출력. 큐가 비어있을 경우 -1 출력
// 6. back : 큐의 가장 뒤에 있는 정수를 출력. 큐가 비어있을 경우 -1 출력

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.Buffer;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Queue;
import java.util.StringTokenizer;

public class Baek18258 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        Deque<Integer> queue = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());

        while(N-- > 0) {

            st = new StringTokenizer(br.readLine());

            switch (st.nextToken()) {
                case "push" :
                    queue.offer(Integer.parseInt(st.nextToken()));
                    break;
                case "pop" :
                    if (queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.poll()).append("\n");
                    break;
                case "size" :
                    sb.append(queue.size()).append("\n");
                    break;
                case "empty" :
                    if (queue.isEmpty()) sb.append("1").append("\n");
                    else sb.append("0").append("\n");
                    break;
                case "front" :
                    if (queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.peek()).append("\n");
                    break;
                case "back" :
                    if (queue.isEmpty()) sb.append("-1").append("\n");
                    else sb.append(queue.peekLast()).append("\n");
                    break;
            }
        }

        System.out.println(sb);
    }
}
