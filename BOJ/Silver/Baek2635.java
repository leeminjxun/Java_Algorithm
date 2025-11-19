package BOJ.Silver;

import java.io.*;
import java.util.*;

public class Baek2635 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        int[] maxArray = new int[1000]; // 충분히 크게
        int maxCount = 0;

        // 첫 번째 수 고정
        for (int second = N; second >= 1; second--) {
            int[] arr = new int[1000];
            arr[0] = N;
            arr[1] = second;
            int count = 2;

            while (true) {
                int next = arr[count - 2] - arr[count - 1];
                if (next < 0) break;
                arr[count++] = next;
            }

            if (count > maxCount) {
                maxCount = count;
                for (int i = 0; i < count; i++) {
                    maxArray[i] = arr[i];
                }
            }
        }

        System.out.println(maxCount);
        for (int i = 0; i < maxCount; i++) {
            System.out.print(maxArray[i] + " ");
        }
    }
}
