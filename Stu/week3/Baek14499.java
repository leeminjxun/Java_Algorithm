package Stu.week3;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek14499 {

    // 동 서 북 남
    static int[] dx = {0, 0, -1, 1};
    static int[] dy = {1, -1, 0, 0};

    static int N;
    static int M;
    static int x;
    static int y;

    static int[][] map;
    static int[] dice = new int[7];


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(st.nextToken());
        int command;

        map = new int[N][M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < K; i++) {
            command = Integer.parseInt(st.nextToken());

            if (roll(command)) {
                System.out.println(dice[1]); // 주사위 윗면 출력
            }
        }
    }

    static Boolean roll(int command) {

        int nextX = x + dx[command - 1];
        int nextY = y + dy[command - 1];
        if (nextX < 0 || nextY < 0 || nextX >= N || nextY >= M) return false;

        int temp = dice[6];

        switch (command) {
            case 1: // 동쪽 일 경우
                dice[6] = dice[3];
                dice[3] = dice[1];
                dice[1] = dice[4];
                dice[4] = temp;
                break;

            case 2: // 서쪽 일 경우
                dice[6] = dice[4];
                dice[4] = dice[1];
                dice[1] = dice[3];
                dice[3] = temp;
                break;

            case 3: // 북쪽 일 경우
                dice[6] = dice[5];
                dice[5] = dice[1];
                dice[1] = dice[2];
                dice[2] = temp;
                break;

            case 4: // 남쪽 일 경우
                dice[6] = dice[2];
                dice[2] = dice[1];
                dice[1] = dice[5];
                dice[5] = temp;
                break;
        }

        x = nextX;
        y = nextY;

        if (map[x][y] == 0) map[x][y] = dice[6];
        else {
            dice[6] = map[x][y];
            map[x][y] = 0;
        }

        return true;
    }
}
