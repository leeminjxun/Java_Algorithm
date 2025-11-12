package Stu.weak5;

import java.util.*;
import java.io.*;

public class Swea4615 {
    static int[] dx = {1, 1, 0, -1, -1, -1, 0, 1}; 		// 오른쪽 부터 시계방향
    static int[] dy = {0, 1, 1, 1, 0, -1, -1, -1};

    static int N;
    static int M;

    static int[][] board;

    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++)
        {
            StringTokenizer st = new StringTokenizer(br.readLine());
            // 격자판 N * N
            N = Integer.parseInt(st.nextToken());

            // 돌을 놓을 횟수
            M = Integer.parseInt(st.nextToken());

            board = new int[N + 1][N + 1];

            board[N/2][N/2] = 2;
            board[N/2 + 1][N/2 + 1] = 2;
            board[N/2 + 1][N/2] = 1;
            board[N/2][N/2 + 1] = 1;

            int W = 0;
            int B = 0;

            for(int input = 0; input < M; input++) {
                st = new StringTokenizer(br.readLine());

                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                int color = Integer.parseInt(st.nextToken());

                putTheDoll(x, y, color);
            }

            for (int i = 1; i <= N; i++) {
                for (int j = 1; j <= N; j++) {
                    if(board[i][j] == 1) B++;
                    if(board[i][j] == 2) W++;
                }
            }

            System.out.println("#" + test_case + " " + B + " " + W);

        }
    }

    static void putTheDoll(int x, int y, int color) {
        board[x][y] = color;

        int nextX = 0;
        int nextY = 0;

        for(int i = 0; i < 8; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];

            if(nextX < 1 || nextY < 1 || nextX > N || nextY > N) continue;
            if(board[nextX][nextY] == 0) continue;

            int moveX = nextX;
            int moveY = nextY;

            if(board[nextX][nextY] != color) {
                while(true) {
                    moveX += dx[i];
                    moveY += dy[i];

                    if(moveX < 1 || moveY < 1 || moveX > N || moveY > N) break;
                    if(board[moveX][moveY] == 0) break;

                    if(board[moveX][moveY] == color) {
                        int fx = nextX;
                        int fy = nextY;
                        while(fx != moveX || fy != moveY) {
                            board[fx][fy] = color;

                            fx += dx[i];
                            fy += dy[i];
                        }

                        break;
                    }
                }
            }

        }
    }
}
