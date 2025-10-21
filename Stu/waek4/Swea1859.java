package Stu.waek4;

import java.util.*;
import java.io.*;

public class Swea1859 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        // 테스트케이스 실행
        for (int testcase = 1; testcase <= T; testcase++) {

            // 날짜 수
            int N = Integer.parseInt(br.readLine());
            int[] price = new int[N];

            // 각 날의 매매가 저장
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                price[i] = Integer.parseInt(st.nextToken());
            }

            // 최대 수익
            long maxProfit = 0;
            // 최대 값
            int maxPrice = 0;

            for (int i = N - 1; i >= 0; i--) {
                if (price[i] < maxPrice) {
                    maxProfit += maxPrice - price[i];
                } else {
                    maxPrice = price[i];
                }
            }

            System.out.println("#" + T + " " + maxProfit);
        }
    }
}
