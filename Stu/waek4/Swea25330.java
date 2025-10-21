package Stu.waek4;

import java.io.*;
import java.util.*;

public class Swea25330 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine());

        for (int tc = 0; tc < T; tc++) {
            String S = br.readLine();

            boolean result = true;

            // 각 숫자의 등장 횟수 를 저장하는 ArrayList
            List<Integer>[] position = new ArrayList[10];
            for (int i = 0; i < 10; i++) {
                position[i] = new ArrayList<>();
            }

            // if( 1 이 등장했을 경우 ) : position[1] = {index_0, index_2}
            for (int i = 0; i < S.length(); i++) {
                int num = S.charAt(i) - '0';
                position[num].add(i);
            }

            // 0~9 까지 숫자 비교 반복문
            for (int d = 0; d <= 9; d++) {

                // position[d] 가 비어있다는 것은 해당 숫자가 한번도 나오지 않았다는 것 : 조건 1 을 만족하지만 비교대상이 없으므로 continue
                if (position[d].isEmpty()) continue;

                // position[d] 가 2개가 아니라는 것은 조건 1을 위반하므로, 결과 는 no 가 나와야함
                if (position[d].size() != 2) {
                    result = false;
                    break;
                }

                // 이제는 해당 숫자가 2개 나왔으므로, 조건 1을 완전 만족함 -> 조건 2 비교로 이동
                // index 값을 순서대로 저장 (idx2 > idx1)
                int idx1 = position[d].get(0);
                int idx2 = position[d].get(1);

                // idx2 - idx1 - 1 의 값은 해당 숫자의 값이여야함
                // 아닐 경우에, no 를 출력하도록 함
                if(idx2 - idx1 - 1 != d) {
                    result = false;
                    break;
                }
            }

            System.out.println(result ? "yes" : "no");
        }
    }
}
