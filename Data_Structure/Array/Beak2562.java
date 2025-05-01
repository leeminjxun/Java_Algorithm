package Data_Structure.Array;
// 백준 [2562] 문제 유형 = 1차원 배열

// 9개의 서로 다른 자연수가 주어질 때, 이들 중 최댓값을 찾고 그 최댓이 몇 번째 수인지를 구하는 프로그을 작성하시오.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak2562 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int count = 0;
        int[] arr = new int[9];

        int Max = Integer.MIN_VALUE;

        for(int i = 0; i < arr.length; i++){
            arr[i] = Integer.parseInt(br.readLine());

            if(arr[i] > Max) {
                Max = arr[i];
                count = i + 1;
            }
        }

        System.out.println(Max);
        System.out.println(count);
    }
}
