package BOJ.Silver;

import java.io.*;
import java.util.*;

public class Baek10158 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        // 가로, 세로 길이
        int W = Integer.parseInt(st.nextToken());
        int H = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());

        // 개미의 x, y 값
        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        int time = Integer.parseInt(br.readLine());

        x += time % (W * 2);
        y += time % (H * 2);

        if(x > W) x = Math.abs(W * 2 - x);
        if(y > H) y = Math.abs(H * 2 - y);

        System.out.println(x + " " + y);

    }
}
