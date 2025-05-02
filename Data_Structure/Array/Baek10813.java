package Data_Structure.Array;
// 백준 [10813] 문제 유형 = 1차원 배열

// 문제 : 공 바꾸기
// 도현이는 바구니 N개를 가지고 있으며, 공을 M 번 바꾸려한다.
// 각 바구니에는 바구니 번호와 같은 공이 각각 1개 들어있다.
// 공을 바꿀 바구니 2개를 입력해 공을 바꾼다.
// 두 개의 정수 : I, J (I 번 바구니와 J 번 바구니에 들어있는 공을 바꾼다.)


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Baek10813 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());

        int[] arr = new int[N];

        int M = Integer.parseInt(st.nextToken());

        for (int i = 0; i < N; i++){
            arr[i] = i+1;
        }

        for (int i = 0; i < M; i ++){

            st = new StringTokenizer(br.readLine());

            int I = Integer.parseInt(st.nextToken());
            int J = Integer.parseInt(st.nextToken());

            // 공 바꾸기 로직
            int temp = arr[I - 1];
            arr[I - 1] = arr[J - 1];
            arr[J - 1] = temp;
        }

        for (int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
