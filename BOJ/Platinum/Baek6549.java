package BOJ.Platinum;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

public class Baek6549 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        String s;

        Deque<Integer> stack = new ArrayDeque<>();

        while (!(s = br.readLine()).equals("0")) {
            st = new StringTokenizer(s);

            int N = Integer.parseInt(st.nextToken());
            long[] arr = new long[N+1];

            long result = 0;

            for (int i = 1; i <= N; i++) {
                arr[i] = Long.parseLong(st.nextToken());

                while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                    int idx = stack.pop();
                    long h = arr[idx];
                    long w = (stack.isEmpty()) ? i - 1 : i - stack.peek() - 1;

                    result = Math.max(result, h * w);
                }

                stack.push(i);
            }

            while (!stack.isEmpty()) {
                int idx = stack.pop();
                long h = arr[idx];
                long w = (stack.isEmpty()) ? N : N - stack.peek();

                result = Math.max(result, h * w);
            }

            sb.append(result).append("\n");

        }

        System.out.println(sb);
    }
}
