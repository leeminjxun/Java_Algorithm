package Data_Structure.Array;

// 백준 [10871] 문제 유형 : 1차원 배열

// 정수 N개로 이루어진 수열 A와 정수 X가 주어진다. 이때, A에서 X보다 작은 수를 모두 출력하는 프로그램을 작성하시오.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Beak10871 {
    public static void main(String[] args) throws IOException {

        // Scanner 로 입력 받는 방식

        /*Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int X = sc.nextInt();

        int[] A = new int[N];

        for (int i = 0; i < N; i++) {
            A[i]= sc.nextInt();
        }

        sc.close();

        for (int j = 0; j < N; j++){
            if(A[j] < X){
                System.out.print(A[j] + " ");
            }
        }*/

        // BufferedReader 으로 입력 받는 방식
        // Scanner 대비 더욱 좋은 성능을 보여준다.

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // String 을 token 단위로 끊어주는 StringTokenizer 클래스
        // ex) this is my string = this, is, my, string
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        // BufferedReader 객체가 읽는 문장을 가져와 space 기준으로 문자를 토큰화 한다.

        // 10 5 를 입력하였으니, N 에 10 / X 에 5 가 입력될 것이다.
        int N = Integer.parseInt(st.nextToken()); // st 의 토큰을 기준
        int X = Integer.parseInt(st.nextToken());

        // java 에서 String 객체는 변경이 불가능하다. 따라서 하나의 문자열을 다른 문자열과 연결하면 새 문자열이 생성되고, 이전의 문자열은 가비지 컬렉터로 들어간다.
        // ---> 문자열끼리 연결하는 내부 작업이 복잡하여 메모리 낭비가 심할 수 있다.

        // solution : StringBuilder : 변경 가능한 문자열
        // 아래의 코드에서는 StringBuilder 객체를 통해 append 메서드를 활용하여 문자열을 쉽고 간단하게 변경하게 한다.
        StringBuilder sb = new StringBuilder();

        st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < N; i++) {
            int value = Integer.parseInt(st.nextToken()); // 토큰화 된 문자를 value 로 나타낸다.

            if (value < X) {
                sb.append(value).append(" "); // StringBuilder 객체에 해당 value + "공백" 을 연결하는 코드
            }
        }
        System.out.println(sb);

    }
}
