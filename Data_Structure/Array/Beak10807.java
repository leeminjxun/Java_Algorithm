package Data_Structure.Array;
// 백준 [10807] 문제 유형 = 1차원 배열

// 총 N개의 정수가 주어졌을 때, 정수 v가 몇 개인지 구하는 프로그램을 작성하시오.

import java.util.Scanner;

public class Beak10807 {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int count = 0; // 입력 받은 정수 v 와 N 개의 정수가 일치 할 시 count + 1
        int N = sc.nextInt();
        int[] arr = new int[N]; // 입력 받은 정수 N 의 크기를 가지는 배열 arr 선언

        for (int i = 0; i < N; i++){
            arr[i] = sc.nextInt(); // Space 를 기준으로 입력을 받는다.
        }

        sc.close(); // sc 를 종료한다.

        int v = sc.nextInt();

        for(int j = 0; j < N; j++){
            if (v == arr[j]){ // if 연산
                count++;
            }
        }

        System.out.println(count); // count 출력
    }

}
