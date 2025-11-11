package BOJ.Bronze;

// 백준 [25314] 문제 유형 = 반복문

// 문제 : 코딩은 체육과목입니다.
// 첫 번째 줄에 제시된 정수 N 을 기준으로 정수 자료형을 출력한다.
// ex) N 이 4일 경우 long int, N 이 20 일 경우 long long long long long int
// long int 는 4 바이트 정수까지 저장할 수 있는 자료형이고,
// long long int 는 8 바이트 정수까지 저장할 수 있는 자료형이다.
// 그럼 12 바이트, 16 바이트 정수까지 저장할 수 있는 자료형은 무엇인지 구하는 프로그램을 작성하라.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek25314 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        String str = "";

        for (int i = 0; i < N/4; i++) str += "long ";

        System.out.println(str + "int");
    }
}
