package Data_Structure.Array;
// 백준 [10810] 문제 유형 = 1차원 배열

// 도현이는 바구니 N 개를 가지고 있고, 각 바구니는 1~N 까지 번호가 매겨진다. 또한 바구니 번호에 해당하는 공이 여러개 있다.
// 가장 처음 바구니에는 공이 들어있지 않으며 (?? 이걸 왜 쓴지는 잘 모르겠음), 바구니에는 공을 1개만 넣을 수 있다.
// 도현이는 앞으로 공을 M 번 넣으려 한다. 공을 넣을 때는 바구니의 범위 와 공의 번호를 지정하고, 정한 바구니에는 모두 정한 번호의 공 만 던질 수 있다.
// 세 정수 I(처음 바구니 범위), J(끝 바구니 범위), K(던질 공의 번호)

// --> for (처음 바구니 범위 - 1, 끝 바구니 범위 까지) 바구니 배열에 공의 번호 대입


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Beak10810 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 바구니 개수

        int[] arr = new int[N]; // 연속된 바구니들을 나타내는 배열

        int M = Integer.parseInt(st.nextToken()); // 공을 넣는 행위를 반복해는 개수

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int I = Integer.parseInt(st.nextToken()); // 시작 바구니 번호
            int J = Integer.parseInt(st.nextToken()); // 끝 바구니 번호
            int K = Integer.parseInt(st.nextToken()); // 바구니에 들어갈 공의 번호

            for (int j = I - 1; j < J; j++) arr[j] = K;

        }

        br.close();

        for(int i = 0; i < arr.length; i++){
            System.out.print(arr[i] + " ");
        }
    }
}
