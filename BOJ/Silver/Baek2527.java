package BOJ.Silver;

import java.io.*;
import java.util.*;

public class Baek2527 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        for(int tc = 0; tc < 4; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int p1 = Integer.parseInt(st.nextToken());
            int q1 = Integer.parseInt(st.nextToken());

            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());
            int p2 = Integer.parseInt(st.nextToken());
            int q2 = Integer.parseInt(st.nextToken());
            // 공통부분 없음 -> d
            if(p1 < x2 || q1 < y2 || p2 < x1 || q2 < y1) {
                System.out.println("d");
            }
            // 점이 공통됨 -> c
            else if((x1 == p2 && y1 == q2) || (x1 == p2 && q1 == y2) || (p1 == x2 && q1 == y2) || (p1 == x2 && y1 == q2)) {
                System.out.println("c");
            }
            // 선분이 공통됨 -> b
            else if(x1 == p2 || p1 == x2 || y1 == q2 || q1 == y2) {
                System.out.println("b");
            }
            // 직사각형이 공통됨
            else {
                System.out.println("a");
            }

        }
    }
}
