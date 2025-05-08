package Data_Structure.Array.two_dimention;

// 백준 [2738] 문제 유형 = 2차원 배열

// 문제 : N*M크기 두 행렬 A와 B 가 주어졌을 때, 두 행렬을 더하는 프로그램을 작성하시오.

// 2중 for 문을 작성하여 해결한다.
// 2개의 배열 값을 모두 저장하기보다 하나의 배열 값만 저장한 후 두 번째 배열 값은 입력값 그대로 를 저장된 배열값에 더하여 출력한다.
// StringBuilder 를 사용하여 전체 배열값을 저장해 한번에 출력한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek2738 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[][] arr = new int[N][M];

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        // 2차원 배열 선언 및 초기화 완료

        StringBuilder sb = new StringBuilder(); // 출력값을 위한 StringBuilder 생성
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++){
                sb.append(arr[i][j] + Integer.parseInt(st.nextToken()) + " ");
            }
            sb.append("\n");
        }

        System.out.println(sb);

    }
}
