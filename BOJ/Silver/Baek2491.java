package BOJ.Silver;

import java.util.*;
import java.io.*;


public class Baek2491 {
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int max = 1;
        int increaseCount = 1;
        int decreaseCount = 1;

        for(int i = 1; i < N; i++) {
            // 증가하는 경우
            if(arr[i] >= arr[i - 1]) {
                increaseCount++;
            } else {
                increaseCount = 1;
            }

            // 감소하는 경우
            if(arr[i] <= arr[i - 1]) {
                decreaseCount++;
            } else{
                decreaseCount = 1;
            }

            // 매 반복문 마다 연속으로 증가하거나 감소하는 값 중 더 큰 값을 max 변수에 대입한다. (max 보다 클 경우)
            max = Math.max(max, Math.max(increaseCount, decreaseCount));
        }

        System.out.println(max);
    }
}
