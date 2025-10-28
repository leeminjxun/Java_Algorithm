package Stu.waek4;

import java.util.*;
import java.io.*;

public class Swea1974 {

    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            int[][] puzzle = new int[9][9];

            int count = 0;

            for(int i = 0; i < 9; i++) {
                StringTokenizer st = new StringTokenizer(br.readLine());
                for(int j = 0; j < 9; j++) {
                    puzzle[i][j] = Integer.parseInt(st.nextToken());
                }
            }

            // 가로 완전 탐색
            boolean[][] visited = new boolean[9][9];
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    visited[i][puzzle[i][j] - 1] = true;
                }
            }

            count += checked(visited);

            // 세로 완전 탐색
            visited = new boolean[9][9];
            for(int i = 0; i < 9; i++) {
                for(int j = 0; j < 9; j++) {
                    visited[i][puzzle[j][i] - 1] = true;
                }
            }

            count += checked(visited);

            // 3X3 완전 탐색
            visited = new boolean[9][9];
            int row = 0;
            for(int i = 0; i <= 6; i +=3) {
                for(int j = 0; j <= 6; j += 3) {
                    for(int n = i; n < i + 3; n++) {
                        for(int m = j; m < j + 3; m++) {
                            visited[row][puzzle[n][m] - 1] = true;
                        }
                    }

                    row++;
                }
            }

            count += checked(visited);

            if(count == 3) {
                System.out.println("#" + test_case +" 1");
            } else {
                System.out.println("#" + test_case +" 0");
            }


        }
    }

    static int checked(boolean visited[][]) {

        for(int i = 0; i < 9; i++) {
            for(int j = 0; j < 9; j++) {
                if(!visited[i][j]) return 0;
            }
        }

        return 1;
    }
}
