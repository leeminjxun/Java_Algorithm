package BOJ.Bronze;

// 백준 [10250] 문제 유형 = 수학
// 문제 : ACM 호텔

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10250 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb;
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;

        for (int i = 0; i < T; i++) {

            st = new StringTokenizer(br.readLine());
            sb = new StringBuilder();
            int H = Integer.parseInt(st.nextToken());
            int W = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int Y = ((N - 1) % H) + 1;
            int X = ((N - 1) / H) + 1;

            if (X < 10) sb.append(Y).append("0").append(X);
            else sb.append(Y).append(X);

            System.out.println(sb);
        }
    }
}
