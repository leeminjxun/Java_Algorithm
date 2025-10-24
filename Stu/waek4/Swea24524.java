package Stu.waek4;

import java.util.*;
import java.io.*;

public class Swea24524 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int test_case = 1; test_case <= T; test_case++) {
            int N = Integer.parseInt(br.readLine());

            int[] checkPoint = new int[N];

            // 최소 값
            int minValue = Integer.MAX_VALUE;

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                checkPoint[i] = Integer.parseInt(st.nextToken());
            }

            // 해당 좌표에 대한 값 1개를 빼고 모든 경의 수를 계산한다.
            for(int i = 1; i < N - 1; i++) {
                // 비교 값
                int value = 0;

                for(int j = 0; j < N - 1; j++) {
                    if(j == i) {
                        continue;
                    } else if(j == i - 1) {
                        value += Math.abs(checkPoint[j + 2] - checkPoint[j]);
                    } else {
                        value += Math.abs(checkPoint[j + 1] - checkPoint[j]);
                    }
                }

                minValue = Math.min(minValue, value);
            }

            System.out.println(minValue);
        }
    }
}