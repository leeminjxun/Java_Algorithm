package Stu;

import java.util.*;
import java.io.*;

// 해당 문제에는 규칙이 존재.
// 처음엔 2중 for문을 쓰려했으나, 숫자가 커질수록 실행시간이 비약적으로 늘어날 것으로 예상
// 높이가 30, 길이가 50 일때 72 번째 손님의 방 번호는 1203 호
// 규칙 -> 72 를 30 으로 나누면 몫은 2 나머지는 12 : 방번호 = 나머지 + 0 + (몫 + 1)

// 만약 높이가 12, 길이가 6 일 경우에 10 번째 손님의 방 번호는 1001 호
//

public class Baek10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int T = Integer.parseInt(br.readLine());
        int count = 0;

        int XX = 0;
        int YY = 0;

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            if ((N % H) == 0) {
                XX = (N / H);
                YY = H;
            } else {
                XX = (N / H) + 1;
                YY = (N % H);
            }

            if (XX < 10) sb.append(YY).append("0").append(XX);
            else sb.append(YY).append(XX);

            System.out.println(sb);
        }


    }
}
