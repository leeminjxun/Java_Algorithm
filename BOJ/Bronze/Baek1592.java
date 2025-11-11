package BOJ.Bronze;

import java.util.*;
import java.io.*;

public class Baek1592 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 사람 수
        int N = Integer.parseInt(st.nextToken());
        // 종료 시점 (공을 받은 횟수)
        int M = Integer.parseInt(st.nextToken());
        // 공 전달
        int L = Integer.parseInt(st.nextToken());

        int count = 0;

        int[] friends = new int[N + 1];
        int me = 1;

        friends[me]++;

        while(true) {


            if(friends[me] == M) break;

            // 받은 횟수가 홀수 일 경우 : 시계 방향으로 전달
            if(friends[me] % 2 != 0) {
                me += L;
                if(me > N) {
                    me -= N;
                }
            } else { // 받은 횟수가 짝수 일 경우 : 반 시계 방향으로 전달
                me -= L;
                if(me < 1) {
                    me += N;
                }
            }

            count++;
            friends[me]++;
        }

        System.out.println(count);
    }
}
