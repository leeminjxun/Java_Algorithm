package BOJ.Silver;

import java.io.*;
import java.util.*;

public class Baek2669 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean[][] arr = new boolean[101][101];

        for(int i = 0; i < 4; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            for(int n = y1; n < y2; n++) {
                for(int m = x1; m < x2; m++) {
                    if(!arr[n][m]){
                        arr[n][m] = true;
                    }
                }
            }
        }

        int count = 0;

        for(int i = 0; i < 101; i++) {
            for(int j = 0; j < 101; j++) {
                if(arr[i][j]) {
                    count++;
                }
            }
        }

        System.out.println(count);
    }
}
