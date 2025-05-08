package Data_Structure.Array.two_dimention;

// 백준 [2566] 문제 유형 = 2차원 배열

// 문제 : 최댓값
// 9X9 격자판에 쓰여진 81개의 자연수 또는 0 이 주어질 때, 이들 중 최댓값을 쓰고 그 최댓값이 몇 행, 몇 열에 위치한 수 인지 구하라.

import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2566 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int[][] arr = new int[9][9];

        int max = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;

        for (int i = 0; i < arr.length; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < arr[i].length; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());

                if (arr[i][j] > max){
                    max = arr[i][j];
                    row = i + 1;
                    col = j + 1;
                }
            }
        }

        System.out.println(max);
        System.out.print(row + " " + col);

    }
}
