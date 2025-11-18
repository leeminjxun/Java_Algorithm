package BOJ.Silver;

import java.io.*;
import java.util.*;

public class Baek2564 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 블록의 가로와 세로 길이
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        // 상점 개수
        int N = Integer.parseInt(br.readLine());

        int[] direct = new int[N];

        int[] len = new int[N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            direct[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        int xDirect = Integer.parseInt(st.nextToken());
        int xLen = Integer.parseInt(st.nextToken());

        int minDistance = 0;

        // 경비원이 북쪽에 있는 경우
        if(xDirect == 1) {
            for(int i = 0; i < N; i++) {
                // 북 쪽 지점
                if(direct[i] == 1) {
                    minDistance += Math.abs(len[i] - xLen);
                }
                // 남 쪽 지점
                else if(direct[i] == 2) {
                    int leftDistance = xLen + y + len[i];
                    int rightDistance = (x - xLen) + y + (x- len[i]);

                    minDistance += Math.min(leftDistance, rightDistance);
                }
                // 서 쪽 지점
                else if(direct[i] == 3) {
                    minDistance += (xLen + len[i]);
                }
                // 동 쪽 지점
                else {
                    minDistance += ((x - xLen) + len[i]);
                }
            }
        }
        // 경비원이 남쪽에 있는 경우
        else if(xDirect == 2) {
            for(int i = 0; i < N; i++) {
                // 북 쪽 지점
                if(direct[i] == 1) {
                    int leftDistance = xLen + y + len[i];
                    int rightDistance = (x - xLen) + y + (x- len[i]);

                    minDistance += Math.min(leftDistance, rightDistance);
                }
                // 남 쪽 지점
                else if(direct[i] == 2) {
                    minDistance += Math.abs(len[i] - xLen);
                }
                // 서 쪽 지점
                else if(direct[i] == 3) {
                    minDistance += (xLen + (y - len[i]));
                }
                // 동 쪽 지점
                else {
                    minDistance += ((x - xLen) + (y - len[i]));
                }
            }
        }

        // 경비원이 서쪽에 있는 경우
        else if(xDirect == 3) {
            for(int i = 0; i < N; i++) {
                // 북 쪽 지점
                if(direct[i] == 1) {
                    minDistance += (xLen + len[i]);
                }
                // 남 쪽 지점
                else if(direct[i] == 2) {
                    minDistance += ((y - xLen) + len[i]);
                }
                // 서 쪽 지점
                else if(direct[i] == 3) {
                    minDistance += Math.abs(len[i] - xLen);
                }
                // 동 쪽 지점
                else {

                    int leftDistance = xLen + x + len[i];
                    int rightDistance = (y - xLen) + x + (y - len[i]);

                    minDistance += Math.min(leftDistance, rightDistance);
                }
            }
        }

        // 경비원이 동쪽에 있는 경우
        else {
            for(int i = 0; i < N; i++) {
                // 북 쪽 지점
                if(direct[i] == 1) {
                    minDistance += (xLen + (x - len[i]));
                }
                // 남 쪽 지점
                else if(direct[i] == 2) {
                    minDistance += ((y - xLen) + (x - len[i]));
                }
                // 서 쪽 지점
                else if(direct[i] == 3) {
                    int leftDistance = xLen + x + len[i];
                    int rightDistance = (y - xLen) + x + (y - len[i]);

                    minDistance += Math.min(leftDistance, rightDistance);
                }
                // 동 쪽 지점
                else {
                    minDistance += Math.abs(len[i] - xLen);

                }
            }
        }

        System.out.println(minDistance);
    }
}
