package BOJ.Gold;

// 백준 [17298] 문제 유형 = Stack

// 문제 : 오큰수

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek17298 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        // 2중 for 문으로 시간초과
//        for (int i = 0; i < N; i++){
//            for (int k = arr.length - 1; k > i; k --) { // k 는 i 보다 오른쪽에 있는 비교 대상
//                if (arr[k] > arr[i]) stack.push(arr[k]);
//            }
//
//            if (stack.isEmpty()) sb.append("-1 ");
//            else sb.append(stack.pop()).append(" ");
//
//            stack.clear();
//        }

        for (int i = 0; i < N; i++) {

            // stack 은 배열의 인덱스를 저장한다.
            // stack 이 비어있지 않고, 현재 위치의 값이 오른쪽의 값보다 작을 경우

            while(!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                arr[stack.pop()] = arr[i];
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            arr[stack.pop()] = -1;
        }

        for (int i = 0; i < N; i++) {
            sb.append(arr[i]).append(" ");
        }

        System.out.println(sb);

    }
}
