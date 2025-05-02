package Data_Structure.Array;

// 백준 [5597] 문제 유형 = 1차원 배열

// 문제 : 과제 안내신 분..?
// 학생 30명 중 28 명이 과제를 제출 했다. 과제 제출을 하지 않은 학생 2명의 출석번호를 구하라.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Baek5597 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] arr = new int[30];

        for(int i = 0; i < (arr.length - 2); i++) {
            int check = Integer.parseInt(br.readLine());

            arr[check - 1] = 1; // 과제 낸 학생 번호에 해당하는 배열 값을 1으로 지정
        }

        // 배열 값 정렬 할 필요 X
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != 1) System.out.println(i + 1);
        }

    }
}
