package Data_Structure.Array;
// 백준 [1546] 문제 유형 = 1차원 배열

// 문제 : 평균
// 평균을 조작하는 프로그램을 만들자. 자신의 점수 중 최대 값인 점수 M 을 고른다.
// 모든 점수를 점수/M*100 으로 하여 평균을 다시 계산한다.


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Beak1546 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        double[] arr = new double[N];

        double sum = 0;

        StringTokenizer st = new StringTokenizer(br.readLine());;

        for (int i = 0; i < N; i++){
            arr[i] = Double.parseDouble(st.nextToken());
        }

        Arrays.sort(arr);

        for (int i = 0; i < N; i++){
            sum += arr[i] / arr[N - 1] * 100;
        }

        System.out.println(sum/N);

    }
}
