package BOJ.Platinum;

// 백준 [1725] 문제 유형 = Stack

// 문제 : 히스토그램

// 히스토그램이란 막대그래프를 의미한다.

// 히스토그램 내부에 가장 넓이가 큰 직사각형의 넓이를 구하는 프로그램을 작성하라.

// 입력 :
// 첫 행에는 N 이 주어진다. N 은 히스토그램의 가로 칸 수이다.
// N 행에 걸쳐 각 칸의 높이가 왼쪽에서부터 차례대로 주어진다.

// 출력 :
// 첫째 줄에 가장 큰 직사각형의 넓이를 출력한다. 이 값은 20억을 넘지 않는다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class Baek1725 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Deque<Integer> stack = new ArrayDeque<>();

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N+1];
        int result = 0;

        for (int i = 1; i <= N; i++) {
            arr[i] = Integer.parseInt(br.readLine());

            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                int idx = stack.pop();
                int h = arr[idx];
                int w = (stack.isEmpty()) ? i - 1 : i - stack.peek() - 1;

                result = Math.max(result, h * w);
            }

            stack.push(i);
        }

        while (!stack.isEmpty()) {
            int idx = stack.pop();
            int h = arr[idx];
            int w = (stack.isEmpty()) ? N : N - stack.peek();

            result = Math.max(result, h * w);
        }

        System.out.println(result);

    }
}


// 2 1 4 5 1 3 3
//     4 5      -> 8

//index =  [ 1 2 3 4 5 ]
//result = [ 1   4 5 6 2 ]

// arr[i] = br.readLine();
// stack 이 비어있거나, arr[stack.peek()] 이 arr[i] 보다 작은 경우
// stack = [ 1, 2, 3, 4 ] -> index 값

// i = 5 인 경우

// idx = 4 / h = 6 / w = 5 - (4 - 1) : 2 / Rec : 12
// stack = [ 1, 2, 3 ]
// idx = 3 / h = 5 / w = 5 - (3 - 1) : 3 / Rec : 15
// stack = [ 1, 2 ]
// idx = 2 / h = 4 / w = 5 - (2 - 1) : 4 / Rec : 16

// arr[1] < arr[5] 이므로 idx 가 1 인 경우에는 위의 과정에 포함되지 않는다.

// stack = [ 1 ]
// idx = 1 / h = 1 / w = 5 - (1 - 1) : 5 / Rec : 5


// 1 6 5 4 2

// 1 5 4 6 2



