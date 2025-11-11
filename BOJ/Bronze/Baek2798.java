package BOJ.Bronze;

import java.util.*;
import java.io.*;

// 브루트포스 알고리즘 or DFS
public class Baek2798 {
    static int N;
    static int M;
    static int[] cards;

    static int maxValue;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 카드 개수
        N = Integer.parseInt(st.nextToken());

        // 주어진 카드 합의 근사값
        M = Integer.parseInt(st.nextToken());

        cards = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            cards[i] = Integer.parseInt(st.nextToken());
        }

        maxValue = 0;
        DFS(0, 0, 0);

        System.out.println(maxValue);
    }

    static void DFS(int value, int count, int index) {

        if (value <= M) {
            if(count < 3 && index < N){

                // 현재의 카드를 선택하지 않았을 경우.
                DFS(value, count, index + 1);

                // 현재의 카드를 선택했을 경우.
                DFS(value + cards[index], count + 1, index + 1);
            }

            // 카드를 고른 수가 3, 즉 4번째 고를 경우에는 고르지 않고 max
            if(count == 3) maxValue = Math.max(maxValue, value);
        }
    }
}
