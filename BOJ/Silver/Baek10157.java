package BOJ.Silver;

import java.io.*;
import java.util.*;

public class Baek10157 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로 길이 (x 값)
        int C = Integer.parseInt(st.nextToken());
        // 세로 길이 (y 값)
        int R = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        int[][] arr = new int[C][R];

        int x = 0;
        int y = 0;

        // 아래, 오른쪽, 위, 왼쪽 순서로 이동
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};

        int direct = 0;

        for(int i = 1; i <= C * R; i++) {
            arr[x][y] = i;

            // 다음 이동 위치 지정
            int nextX = x + dx[direct];
            int nextY = y + dy[direct];

            // nextX와 nextY 가 조건에서 벗어나는 경우 -> 방향 틀기
            if(nextX < 0 || nextY < 0 || nextX >= C || nextY >= R || arr[nextX][nextY] != 0) {
                // 방향 + 1
                direct++;

                // 방향 + 1 한 상태가 3보다 클 경우
                if(direct > 3) {
                    // 0으로 초기화
                    direct = 0;
                }

                // 이동 위치 다시 지정
                nextX = x + dx[direct];
                nextY = y + dy[direct];
            }

            // 이동 위치를 실제 x 값으로 지정
            x = nextX;
            y = nextY;

            // 다음 반복문으로 이동
        }

        int findX = 0;
        int findY = 0;

        // 번호 찾기
        for(int i = 0; i < C; i++) {
            for(int j = 0; j < R; j++) {
                if(arr[i][j] == K) {
                    findX = i + 1;
                    findY = j + 1;
                }
            }
        }
        if(findX == 0 && findY == 0) {
            System.out.println("0");
        } else {
            System.out.println(findX + " " + findY);
        }

    }
}
