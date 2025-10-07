package Stu.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10026 {
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    static int count = 0;
    static int N;
    static char[][] arr_normal;
    static char[][] arr_blindness;
    static boolean[][] visited;


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        arr_normal = new char[N][N]; // 적록색약이 아닌 배열
        arr_blindness = new char[N][N]; // 적록색약인 배열

        for (int i = 0; i < N; i++) {
            String s = br.readLine();
            for (int j = 0; j < N; j++) {
                arr_normal[i][j] = s.charAt(j);
                if (s.charAt(j) == 'G') {
                    arr_blindness[i][j] = 'R';
                } else arr_blindness[i][j] = s.charAt(j);
            }
        }

        // 1. 적록색약이 아닌 경우 탐색
        visited = new boolean[N][N];

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, arr_normal);
                    count++;
                }
            }
        }

        System.out.print(count + " ");

        // 2. 적록색약이 맞는 경우 탐색
        visited = new boolean[N][N];
        count = 0;

        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++) {
                if (!visited[i][j]) {
                    DFS(i, j, arr_blindness);
                    count++;
                }
            }
        }

        System.out.print(count);

    }

    static void DFS(int x, int y, char[][] arr) {
        visited[x][y] = true;

        int nextX, nextY;

        for (int i = 0; i < 4; i++) {
            nextX = x + dx[i];
            nextY = y + dy[i];

            if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= N) continue;
            if (visited[nextX][nextY] || arr[nextX][nextY] != arr[x][y]) continue;

            DFS(nextX, nextY, arr);
        }
    }
}
