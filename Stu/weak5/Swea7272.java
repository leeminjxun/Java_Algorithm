package Stu.weak5;

import java.io.*;
import java.util.*;

public class Swea7272 {
    public static void main(String[] args) throws Exception {

        char[] one = {'A', 'D', 'O', 'P', 'Q', 'R'};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {
            st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            String B = st.nextToken();

            int count = 0;

            if (A.length() != B.length()) {
                System.out.println("#" + tc + " DIFF");
                continue;
            }

            for (int i = 0; i < A.length(); i++) {

                // NEW: 'B'가 하나만 등장하면 즉시 DIFF
                if (A.charAt(i) == 'B' || B.charAt(i) == 'B') {
                    if (A.charAt(i) == 'B' && B.charAt(i) == 'B') {
                        count++;
                        continue;
                    } else {
                        count = -1; // 불일치 마킹
                        break;
                    }
                }

                boolean isSameA = false;
                boolean isSameB = false;

                // 구멍 1개 문자 집합 검사
                for (int j = 0; j < one.length; j++) {
                    if (A.charAt(i) == one[j]) isSameA = true;
                    if (B.charAt(i) == one[j]) isSameB = true;
                }

                // 둘 다 1개 또는 둘 다 0개면 SAME
                if ((isSameA && isSameB) || (!isSameA && !isSameB)) {
                    count++;
                    continue;
                }

                // 하나만 1개면 DIFF
                count = -1;
                break;
            }

            if (count == -1) {
                System.out.println("#" + tc + " DIFF");
            } else if (count == A.length()) {
                System.out.println("#" + tc + " SAME");
            }
        }
    }
}
