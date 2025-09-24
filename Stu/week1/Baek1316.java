package Stu.week1;

import java.util.*;
import java.io.*;

public class Baek1316 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());
        int num; // 현재 알파벳

        int count = T;

        for (int i = 0; i < T; i++) {
            String s = br.readLine();

            int[] arr = new int[27];
            Arrays.fill(arr, 0);

            int num_dummy = 0; // 이전 알파벳

            for (int j = 0; j < s.length(); j++) {
                num = s.charAt(j) - 96;

                if (num != num_dummy) {
                    if (arr[num] == -1) {
                        count--;
                        break;
                    }
                    arr[num]++;
                    arr[num_dummy] = -1;
                }

                num_dummy = num;
            }
        }

        System.out.println(count);
    }
}
