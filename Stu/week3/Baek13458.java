package Stu.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek13458 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine()); // 시험장 개수
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(st.nextToken()); // 각 시험장 당 수험생 수
        }

        st = new StringTokenizer(br.readLine());
        int B = Integer.parseInt(st.nextToken()); // 총 감독관이 관리하는 사람의 수
        int C = Integer.parseInt(st.nextToken()); // 부 감독관이 관리하는 사람의 수

        long total = N;

        for (int i = 0; i < N; i++) {

            if ((arr[i] - B) > 0) {
                if (((arr[i] - B) % C) != 0) total += ((arr[i] - B) / C) + 1;
                else total += (arr[i] - B) / C;
            }
        }

        System.out.println(total);

    }
}
