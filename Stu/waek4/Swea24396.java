package Stu.waek4;

import java.util.*;
import java.io.*;

public class Swea24396 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int testCase = 0; testCase < T; testCase++) {
            // B, W, X, Y, Z
            StringTokenizer st = new StringTokenizer(br.readLine());

            int B = Integer.parseInt(st.nextToken()); // 검은 공과 박스의 개수
            int W = Integer.parseInt(st.nextToken()); // 흰색 공과 박스의 개수
            int X = Integer.parseInt(st.nextToken()); // 검은 공은 검은 박스에 넣었을 떄 점수
            int Y = Integer.parseInt(st.nextToken()); // 흰 공을 흰 박스에 넣었을 때 점수
            int Z = Integer.parseInt(st.nextToken()); // 검은 공을 흰 박스에, 흰 공을 검은 박스에 넣었을 때의 점수

            int maxValue = Integer.MIN_VALUE;

            for(int i = 0; i <= Math.min(B, W); i++) {
                int value = (B - i) * X + (W - i) * Y + 2 * i * Z;

                maxValue = Math.max(maxValue, value);
            }

            System.out.println(maxValue);
        }
    }

}