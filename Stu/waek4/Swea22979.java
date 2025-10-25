package Stu.waek4;

import java.io.*;
import java.util.*;

public class Swea22979 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 1; tc <= T; tc++) {
            // 문자열 받기
            String S = br.readLine();

            // 연산 수 받기
            int K = Integer.parseInt(br.readLine());

            long opValue = 0;

            // 연산 정보 받기
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int op = 0; op < K; op++) {
                opValue += Long.parseLong(st.nextToken());
            }

            // opValue 가 문자열의 길이와 같거나 초과하는 경우의 수 또한 고려할 필요가 있다.
            // opValue 가 음수 일 경우, 어떤 방식으로 처리해야하는가?

            int len = S.length();

            // 정수 오버플로우 방지 변수
            int move = 0;

            // 총 연산 결과 가 양수 인 경우 -> S의 첫 번째 글자를 떼네어 마지막 글자 뒤에 붙이는 작업을 정확히 opValue 회 반복한다.
            // S 의 인덱스는 0부터 시작
            if(opValue > 0) {

                // opValue 가 문자열의 길이와 같거나 초과하는 경우
                if(opValue >= len) {
                    opValue %= len;
                }

                move = (int)opValue;

                // 출력 시작
                for(int i = move; i < len; i++) {
                    System.out.print(S.charAt(i));
                }
                for(int i = 0; i < move; i++) {
                    System.out.print(S.charAt(i));
                }
            }

            // 총 연산 결과 가 음수 인 경우 -> S의 마지막 글자를 떼네어 첫 번째 글자 앞에 붙이는 작업을 정확히 |opValue| 회 반복한다.
            else if(opValue < 0) {
                opValue = Math.abs(opValue);
                if(opValue >= len) {
                    opValue = opValue % len;
                }

                move = (int)opValue;

                for(int i = len - move; i < len; i++) {
                    System.out.print(S.charAt(i));
                }
                for(int i = 0; i < len - move; i++) {
                    System.out.print(S.charAt(i));
                }
            }

            else {
                System.out.print(S);
            }

            System.out.println();
        }


    }
}
