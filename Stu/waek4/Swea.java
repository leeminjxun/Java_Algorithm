package Stu.waek4;

import java.util.*;
import java.io.*;

public class Swea {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());

        for(int testcase = 0; testcase < T; testcase++) {

            // 각 testcase 마다 해당 변수의 수는 0으로 초기화 되어야한다.
            int N = 0;
            int P = 0;
            int B = 0;

            int quizCount = 0;

            int maxValue = 0;

            /**
             * 변수 담기 시작
             */

            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            P = Integer.parseInt(st.nextToken());
            B = Integer.parseInt(st.nextToken());

            int[] A = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {

                A[i] = Integer.parseInt(st.nextToken());

                // 배열 중 가장 큰수를 quiz의 개수로 담는다.
                if(A[i] > quizCount) quizCount = A[i];
            }

            // 테스트 quiz 의 개수는 가장 큰 수의 배열보다 1이 더 크다.
            quizCount++;
            /**
             * 변수 담기 끝
             */

            for (int i = 0; i < quizCount; i++) {

                // 현재 퀴즈에 대한 수익을 저장할 변수를 지정한다.
                int value = 0;
                // 퀴즈 경우의 수 1번당 각 학습자의 수 만큼 반복해줘야한다.
                for(int j = 0; j < N; j++) {

                    // 현재 퀴즈의 수가 지정된 학습자의 베이직 퀴즈 수 보다 작거나 같을 경우
                    // -> 베이직 코스 B 원의 수익 * 퀴즈 개수를 얻는다.
                    if (A[j] >= ( i + 1 )) {
                        value += B * ( i + 1 );
                    } else { // 아닐 경우, 프로 버전을 구독한다.
                        value += P;
                    }
                }

                // 현재의 수익이 최대 수익보다 클 경우에, 현재 수익을 최데 수익으로 지정한다.
                if (value > maxValue) {
                    maxValue = value;
                }
            }

            System.out.println("#" + (testcase + 1) + " = " + maxValue);
        }

    }
}
