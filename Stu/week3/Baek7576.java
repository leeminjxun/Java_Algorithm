package Stu.week3;

import java.util.*;
import java.io.*;

public class Baek7576 {

    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int M;
    static int N;
    static int count = 0;

    static int[][] arr;
    static Queue<Position> queue = new LinkedList<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());

        arr = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] == 1) {
                    queue.add(new Position(i, j));
                }
            }
        }
        System.out.println(BFS());
    }

    static int BFS() {

        while (!queue.isEmpty()) {

            Position p = queue.poll();

            for (int i = 0; i < 4; i++) {
                int nextX = p.x + dx[i];
                int nextY = p.y + dy[i];

                if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) continue;

                if (arr[nextX][nextY] == 0) {
                    queue.add(new Position(nextX, nextY));
                    arr[nextX][nextY] = arr[p.x][p.y] + 1;
                }

            }

        }

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (arr[i][j] == 0) return -1;

                count = Math.max(count, arr[i][j]);
            }
        }

        if (count == 1) return 0;
        else return count - 1;
    }

    public static class Position {
        int x;
        int y;

        Position(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}

