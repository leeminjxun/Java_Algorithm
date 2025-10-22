package Stu.waek4;

import java.util.*;
import java.io.*;

public class Swea35469 {
    static int H;
    static int W;
    static char[][] array;
    static boolean[][] visited;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 행
            H = Integer.parseInt(st.nextToken());
            // 열
            W = Integer.parseInt(st.nextToken());

            // 격자판 값을 저장할 배열 생성
            array = new char[H][W];

            // 격자판 방문 여부를 저장할 배열 생성
            visited = new boolean[H][W];

            // 최소 연산을 저장할 변수
            int minCount = 0;

            int black = 0;

            // 1. 격자판 배열 읽어 array 에 저장
            // 2. black 의 개수 세기
            for (int i = 0; i < H; i++) {
                String S = br.readLine();
                for (int j = 0; j < W; j++) {
                    array[i][j] = S.charAt(j);

                    if(array[i][j] == '#') black++;
                }
            }

            // 경우의 수 나누기
            if (black == H * W) {       // 격자판의 모든 값이 # 일 경우
                minCount = (H > W) ? W : H;
            } else if (black == 0) {    // 격자판의 모든 값이 . 일 경우
                minCount  = 0;
            } else {                    // 격자판이 # 과 . 으로 섞여 있는 경우
                for (int i = 0; i < H; i++) {
                    for(int j = 0; j < W; j++) {
                        // 현재의 격자판의 행렬 값 이 # 일 경우
                        if(array[i][j] == '#' && !visited[i][j]) {
                            minCount += Cal(i, j);
                        }
                    }
                }
            }

            System.out.println(minCount);
        }
    }

    static int Cal(int h, int w) {
        int calCount = 0;
        int blackCount = 0;

        // 열 값을 w 로 유지하고, 행 값 을 반복문으로 비교
        for (int i = 0; i < H; i++) {
            if(array[i][w] == '#') {
                blackCount++;
            }
        }
        if(blackCount == H) {
            calCount++;
            for (int i = 0; i < H; i++) {
                visited[i][w] = true;
            }
        }

        blackCount = 0;

        // 행 값은 h 로 유지하고, 열 값을 반복문으로 비교
        for (int j = 0; j < W; j++) {
            if (array[h][j] == '#') {
                blackCount++;
            }
        }
        if (blackCount == W) {
            calCount++;
            for (int j = 0; j < W; j++) {
                visited[h][j] = true;
            }
        }

        return calCount;
    }
}
