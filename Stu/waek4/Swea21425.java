package Stu.waek4;

import java.util.*;
import java.io.*;

public class Swea21425 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for(int tc = 0; tc < T; tc++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            int N = Integer.parseInt(st.nextToken());

            int count = 0;

            while(true) {
                if(A > B) {
                    B += A;
                    count++;
                    if(B > N) {
                        System.out.println(count);
                        break;
                    }
                } else{
                    A += B;
                    count++;
                    if(A > N) {
                        System.out.println(count);
                        break;
                    }
                }
            }
        }
    }
}
