package BOJ.Silver;

import java.io.*;
import java.util.*;

public class Baek1244 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 스위치 개수
        int sNumber = Integer.parseInt(br.readLine());

        // 스위치 배열
        int[] S = new int[sNumber + 1];


        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int index = 1; index <= sNumber; index++) {

            S[index] = Integer.parseInt(st.nextToken());
        }

        // 학생 수
        int student = Integer.parseInt(br.readLine());

        for(int index = 0; index < student; index++) {
            st = new StringTokenizer(br.readLine());

            // 여학생인지 남학생인지
            int boyOrGirl = Integer.parseInt(st.nextToken());
            // 배부 받은 번호
            int N = Integer.parseInt(st.nextToken());

            // 남학생의 경우 N 의 배수에 해당하는 스위치의 상태를 변경한다.
            if(boyOrGirl == 1) {
                for(int i = 1; i <= sNumber / N; i++) {
                    int mul = N * i;

                    S[mul] = (S[mul] == 1) ? 0 : 1;
                }
            }

            // 여학생의 경우, N 을 기준으로 양쪽이 대칭인 최대 인덱스의 스위치를 변경한다.
            if(boyOrGirl == 2) {

                S[N] = (S[N] == 1) ? 0 : 1;

                int left = N - 1;
                int right = N + 1;

                while(true) {


                    if(left < 1 || right > sNumber) break;

                    if(S[left] == S[right]) {
                        S[left] = (S[left] == 1) ? 0 : 1;
                        S[right] = (S[right] == 1) ? 0 : 1;

                        left--;
                        right++;
                    } else {
                        break;
                    }
                }
            }

        }

        for(int index = 1; index <= sNumber; index++) {
            System.out.print(S[index] + " ");
            if (index % 20 == 0) {
                System.out.println();
            }
        }

    }

}
