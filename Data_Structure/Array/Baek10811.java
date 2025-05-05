package Data_Structure.Array;
// 백준 [10811] 문제 유형 = 1차원 배열

// 문제 : 바구니 뒤집기
// 도현이는 바구니를 총 N 개 가지고 있다. 각각의 바구에는 1번부터 N번 까지 번호가 매겨져 있다.
// 앞으로 M 번 바구니의 순서를 역순으로 바꾸려한다.

// 1 2 3 4 5
// 0 1 2 3 4


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10811 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        for (int i = 0; i < N; i++){
            arr[i] = i + 1;
        }

        for (int i = 0; i < M; i++){
            st = new StringTokenizer(br.readLine());

            int I = Integer.parseInt(st.nextToken()) - 1;
            int J = Integer.parseInt(st.nextToken()) - 1;

            while (I < J) {
                int temp = arr[I];
                arr[I++] = arr[J];
                arr[J--] = temp;
            }
        }

        br.close();

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
