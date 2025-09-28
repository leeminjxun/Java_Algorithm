package Stu.week2;

import java.util.*;
import java.io.*;

public class Baek2667 {

    static int[][] map;
    static boolean[][] visited;
    static int[] blockCount; // 단지 수를 배열으로 나타냄

    static int N;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];
        visited = new boolean[N][N];
        blockCount = new int[N * N];

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < N; j++) {
                map[i][j] = s.charAt(j) - '0';
            }
        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j] && map[i][j] == 1) {
                    dfs(i, j, count);
                    count++;
                }
            }
        }

        Arrays.sort(blockCount);

        System.out.println(count);
        for (int i = 0; i < blockCount.length; i++) {
            if (blockCount[i] != 0) System.out.println(blockCount[i]);
        }
    }

    static void dfs(int x, int y, int count) {
        visited[x][y] = true;
        blockCount[count]++;

        for (int i = 0; i < 4; i++) {
            int nextX = x + dx[i];
            int nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
            if (visited[nextX][nextY] || map[nextX][nextY] == 0) continue;

            dfs(nextX, nextY, count);

        }
    }



}
