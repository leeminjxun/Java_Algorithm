package BOJ.Silver;

// 백준 [2563] 문제 유형 = 2차원 배열

// 문제 :

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2563 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[100][100];
        int area = 0;

        // [ 풀이 1 : int 형 2차원 배열 ]
        /*for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for (int j = y; j < (y + 10); j++){
                for (int k = x; k < (x + 10); k++) arr[j][k] = 1;
            }
        }

        for (int i = 0; i < 100; i++){
            for (int j = 0; j < 100; j++){
                if (arr[i][j] == 1) area++;
            }
        }*/

        // [ 풀이 2 : boolean 형 2차원 배열 ]
        boolean[][] paper = new boolean[100][100];
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            int x = Integer.parseInt(st.nextToken()) - 1;
            int y = Integer.parseInt(st.nextToken()) - 1;

            for (int j = y; j < (y + 10); j++){
                for (int k = x; k < (x + 10); k++) {
                    if (!paper[j][k]){
                        paper[j][k] = true;
                        area++;
                    }
                }
            }
        }

        System.out.println(area);
    }
}
