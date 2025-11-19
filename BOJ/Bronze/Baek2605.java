package BOJ.Bronze;

import java.io.*;
import java.util.*;

public class Baek2605 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        for(int i = 0; i < N; i++) {
            arr[i] = i + 1;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            int pick = Integer.parseInt(st.nextToken());

            // 0 일 경우에 머무른다.
            if(pick == 0) {
                continue;
            }

            int temp = 0;

            for(int j = i; j > i - pick; j--) {

                temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;

            }
        }

        for(int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
