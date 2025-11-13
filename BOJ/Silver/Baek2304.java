package BOJ.Silver;

import java.util.*;
import java.io.*;

public class Baek2304 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int[] arr = new int[10001];
        Stack<Integer> stack = new Stack<>();

        int start = 1001;
        int end = 0;

        for(int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            // 가로 인덱스
            int L = Integer.parseInt(st.nextToken());
            // 높이
            int H = Integer.parseInt(st.nextToken());

            arr[L] = H;

            start = Math.min(start, L);
            end = Math.max(end, L);
        }

        int area = 0;

        /** 왼쪽 -> 오른쪽 방향 **/

        // 초기값 설정 (이전 기둥의 높이)
        int temp = arr[start];
        for(int i = start + 1; i <= end; i++) {
            // 현재 기둥의 높이가 이전 기둥의 높이보다 작다면
            if(arr[i] < temp) {
                // stack 에 넣어놓는다.
                stack.push(i);
                // 현재 기둥의 높이가 이전 기둥의 높이와 같거나 크다면
            } else{
                // 이전 기둥의 높이를 기준으로 stack에 저장된 (이전 기둥의 높이보다 작았던) 인덱스 값으로 한다.
                while(!stack.isEmpty()) {
                    int x = stack.pop();

                    arr[x] = temp;
                }

                // 이전 큰 기둥으로 설정
                temp = arr[i];
            }
        }

        stack.clear();

        temp = arr[end];
        for(int i = end - 1; i >= start; i--) {
            if(arr[i] < temp) {
                stack.push(i);
            } else{
                while(!stack.isEmpty()) {
                    int x = stack.pop();

                    arr[x]= temp;
                }
                temp = arr[i];
            }
        }

        for(int i = start; i <= end; i++) {
            area += arr[i];
        }

        System.out.println(area);

    }
}
