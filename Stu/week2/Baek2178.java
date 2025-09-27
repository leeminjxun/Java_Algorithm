package Stu.week2;

import java.util.*;
import java.io.*;

public class Baek2178 {

    static int N;
    static int M;
    static int[][] arr;
    static boolean[][] visited;

    // 상하좌우 순으로 이동
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N][M];
        visited = new boolean[N][M]; // 기본 : false

        int count = 0;

        for (int i = 0; i < N; i++) {
            String s = br.readLine();

            for (int j = 0; j < M; j++) {
                arr[i][j] = s.charAt(j) - '0';
            }
        }

        visited[0][0] = true;
        BFS(0, 0);

        System.out.println(arr[N - 1][M - 1]);

    }

    static void BFS(int x, int y) {
        Queue<int []> queue = new LinkedList<>();
        queue.add(new int[] {x,y});

        while (!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if ( nextX < 0 || nextY < 0 || nextX >= N || nextY >= M ) continue;
                if (visited[nextX][nextY] || arr[nextX][nextY] == 0) continue;

                queue.add(new int[] {nextX, nextY});
                arr[nextX][nextY] = arr[nowX][nowY] + 1;
                visited[nextX][nextY] = true;
            }
        }


    }


}
