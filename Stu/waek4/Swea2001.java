package Stu.waek4;

import java.util.*;
import java.io.*;

public class Swea2001 {

    static int N;
    static int M;
    static int[][] region;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 1; testCase <= T; testCase++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 격자판 (N * N)
            N = Integer.parseInt(st.nextToken());
            region = new int[N][N];

            // 파리채 칸 (M * M)
            M = Integer.parseInt(st.nextToken());

            int maxValue = 0;
            int value = 0;

            for(int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                for(int j = 0; j < N; j++) {
                    region[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            for(int i = 0; i < N - M + 1; i++) {
                for(int j = 0; j < N - M + 1; j++) {
                    value = move(i, j);

                    if(value > maxValue) {
                        maxValue = value;
                    }
                }
            }

            System.out.println("#" + testCase + " " + maxValue);
        }
    }

    static int move(int x, int y) {

        int value = 0;

        for (int i = 0; i < M; i++) {
            for (int j = 0; j < M; j++) {
                int nextX = x + i;
                int nextY = y + j;

                value += region[nextX][nextY];
            }
        }

        return value;
    }
}
