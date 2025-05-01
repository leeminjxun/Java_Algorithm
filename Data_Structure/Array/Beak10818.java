package Data_Structure.Array;
// 백준 [10818] 문제 유형 = 1차원 배열

// N 개의 정수가 주어진다. 이때, 최솟값과 최대값을 구하는 프로그램을 작성하시오.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Beak10818 {
    public static void main(String[] args) throws IOException {

        // Scanner 클래스로 입력 받는 방식

        /*Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int[] arr = new int[N];

        int Max = Integer.MIN_VALUE;
        int Min = Integer.MAX_VALUE;

        // 반복문을 사용해 최대, 최소 구하는 로직
        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt();

            if (arr[i] > Max) Max = arr[i];

            if (arr[i] < Min) Min = arr[i];
        }


        System.out.println(min + " " + max);*/

        // BufferedReader 클래스로 입력받는 방식
        // --> 위의 방법보다 4배 빠른 방법, 메모리도 4배 감소
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        int Max = Integer.MIN_VALUE; // Integer 로 나타낼 수 있는 가장 작은 수
        int Min = Integer.MAX_VALUE; // Integer 로 나타낼 수 있는 가장 큰 수

        int arr[] = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine()); // throws IOException 필수적

        for (int i = 0; i < N; i++) {
            // st.nextToken 은 String 클래스이기 때문에 parseInt 로 integer 형변환을 해줘야한다.
            arr[i] = Integer.parseInt(st.nextToken());

            if (arr[i] > Max) Max = arr[i];

            if (arr[i] < Min) Min = arr[i];
        }

        System.out.println(Min + " " + Max);

        br.close();
    }
}
