package BOJ.Silver;

import java.io.*;
import java.util.*;

public class Baek2477 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 참외의 수
        int K = Integer.parseInt(br.readLine());

        int[] dir = new int[6];
        int[] len = new int[6];

        for(int i = 0; i < 6; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            dir[i] = Integer.parseInt(st.nextToken());
            len[i] = Integer.parseInt(st.nextToken());
        }

        int maxWidth = 0, maxHeight = 0;
        int maxWindex = -1, maxHindex = -1;

        for(int i = 0; i < 6; i++) {
            // 가장 큰 가로 길이 찾기 (동,서 방향)
            if(dir[i] == 1 || dir[i] == 2) {
                if(len[i] > maxWidth) {
                    maxWidth = len[i];
                    maxWindex = i;
                }
            }
            // 가장 큰 세로 길이 찾기 (남,북 방향)
            else {
                if(len[i] > maxHeight) {
                    maxHeight = len[i];
                    maxHindex = i;
                }
            }
        }

        // 최소 가로, 세로 값 찾기
        int minWidth = Math.abs(len[(maxHindex + 5) % 6] - len[(maxHindex + 1) % 6]);

        int minHeight = Math.abs(len[(maxWindex + 5) % 6] - len[(maxWindex + 1) % 6]);


        int area = (maxWidth * maxHeight) - (minWidth * minHeight);

        System.out.println(area * K);

    }
}
