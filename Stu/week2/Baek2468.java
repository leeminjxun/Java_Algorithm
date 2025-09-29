package Stu.week2;

import Data_Structure.Graph.BFS;

import java.util.*;
import java.io.*;

public class Baek2468 {

    static int N;
    static int count = 0;
    static int maxCount = 0;
    static int maxHeight = 0;

    static int[][] map;
    static boolean[][] visited;

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > maxHeight) maxHeight = map[i][j];
            }
        }

        for (int h = 0 ; h <= maxHeight; h++) {
            visited = new boolean[N][N];
            count = 0;
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++){
                    if (!visited[i][j] && map[i][j] > h) {
                        bfs(i, j, h);
                        count++;
                    }
                }
            }
            if (count > maxCount) maxCount = count;
        }
        System.out.println(maxCount);
    }

    static void bfs(int x, int y, int height) {
        visited[x][y] = true;
        Queue<int[] > queue = new LinkedList<>();
        queue.add(new int[] {x, y});

        while(!queue.isEmpty()) {
            int[] now = queue.poll();
            int nowX = now[0];
            int nowY = now[1];

            for (int i = 0; i < 4; i++) {
                int nextX = nowX + dx[i];
                int nextY = nowY + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
                if (visited[nextX][nextY] || map[nextX][nextY] <= height) continue;

                visited[nextX][nextY] = true;
                queue.add(new int[] {nextX, nextY});
            }
        }
    }
}
