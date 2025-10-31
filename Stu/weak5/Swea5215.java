package Stu.weak5;

import java.io.*;
import java.util.*;

public class Swea5215 {
    static int[] T, K;
    static int N, L, Max;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= t; tc++) {

            StringTokenizer st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            L = Integer.parseInt(st.nextToken());

            T = new int[N];
            K = new int[N];

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                T[i] = Integer.parseInt(st.nextToken());
                K[i] = Integer.parseInt(st.nextToken());
            }

            Max = 0;

            DFS(0, 0, 0);

            System.out.println("#" + tc + " " + Max);

        }
    }

    static void DFS(int cnt, int tasteSum, int kalSum) {
        if(kalSum > L) return;

        if(cnt == N) {
            if(kalSum <= L) {
                Max = Math.max(Max, tasteSum);
                return;
            }
        }

        DFS(cnt + 1, tasteSum + T[cnt], kalSum + K[cnt]);
        DFS(cnt + 1, tasteSum, kalSum);
    }
}
