package Stu.weak5;

import java.util.*;
import java.io.*;

public class Swea2805 {
    public static void main(String[] args) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());


        for(int test_case = 1; test_case <= T; test_case++)
        {
            int N = Integer.parseInt(br.readLine());

            // N 이 1인 경우는 예외로 둔다.
            if(N == 1) {
                System.out.println("#" + test_case + " " + br.readLine());
                continue;
            }

            // 수확 가능 범위를 동적으로 변경
            int position = N / 2;

            // 수익을 저장하는 변수
            int profit = 0;

            // 세로 길이 만큼 반복문 진행
            for(int i = 0; i < N; i++) {
                String S = br.readLine();

                // 수학 가능 범위 만큼 profit 에 더해준다.
                for(int j = position; j < N - position; j++) {
                    profit += S.charAt(j) - 48;
                }

                // i 값이 N/2 보다 작을 경우 : 수확 범위가 넓어짐
                if(i < N/2) position--;
                // i 값이 N/2 보다 크거나 같을 경우 : 수확 범위가 좁아짐
                if(i >= N/2) position++;
            }

            System.out.println("#" + test_case + " " + profit);
        }
    }
}
