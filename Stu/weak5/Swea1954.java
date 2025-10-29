package Stu.weak5;

import java.util.*;
import java.io.*;

public class Swea1954 {

    static int[] dx = {0, 1, 0, -1};
    static int[] dy = {1, 0, -1, 0};

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            int N = Integer.parseInt(br.readLine());

            int[][] arr = new int[N][N];

            int way = 0;
            int x = 0;
            int y = 0;

            int value  = 1;

            arr[x][y] = value++;

            for(int i = 0; i < 2 * N - 1; i++) {
                if(way > 3) way = 0;

                while(true) {
                    int nextX = x + dx[way];
                    int nextY = y + dy[way];

                    if(nextX >= N || nextY >= N || nextX < 0 || nextY < 0) break;
                    if(arr[nextX][nextY] != 0) break;

                    arr[nextX][nextY] = value++;
                    x = nextX;
                    y = nextY;
                }

                way++;
            }

            System.out.println("#" + tc);
            for(int i = 0; i < N; i++) {
                for(int j = 0; j < N; j++) {
                    System.out.print(arr[i][j] + " ");
                }
                System.out.println();
            }
        }
    }
}
