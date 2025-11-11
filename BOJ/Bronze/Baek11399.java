package BOJ.Bronze;

import java.util.*;
import java.io.*;

public class Baek11399 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[N];
        int minTime = 0;
        int time = 0;

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);

        for(int i = 0; i < N; i++) {
            time += arr[i];

            minTime += time;
        }

        System.out.println(minTime);

    }
}
