package Stu.waek4;

import java.util.*;
import java.io.*;


public class Swea23791 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[] A = new int[N];
            int[] B = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                A[i] = Integer.parseInt(st.nextToken());
            }

            st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                B[i] = Integer.parseInt(st.nextToken());
            }

            boolean[] picked = new boolean[N + 1];
            char[] res = new char[N + 1];

            int idxA = 0;
            int idxB = 0;

            for(int turn = 0; turn < N; turn++) {
                if(turn % 2 == 0) {
                    while(picked[A[idxA]]) idxA++;
                    int player = A[idxA];

                    picked[player] = true;
                    res[player] = 'A';

                } else {
                    while(picked[B[idxB]]) idxB++;
                    int player = B[idxB];

                    picked[player] = true;
                    res[player] = 'B';
                }
            }

            for (int i = 1; i < N + 1; i++) {
                System.out.print(res[i]);
            }
        }
    }
}
