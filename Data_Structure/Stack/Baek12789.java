package Data_Structure.Stack;

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

        int N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        int next = 1;

        for (int i = 0; i < N; i++) {
            int number = Integer.parseInt(st.nextToken());

            if (number != next) {
                stack.push(number);
            } else next = number + 1;
        }

        while (true) {
            if (stack.peek() == next) {
                stack.pop();
                next += 1;
            }
            else if (stack.isEmpty()) {
                System.out.println("Nice");
                break;
            } else {
                System.out.println("Sad");
                break;
            }
        }

    }
}
