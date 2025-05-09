package Data_Structure.Array.two_dimention;

// 백준 [10798] 문제 유형 = 2차원 배열

// 문제 : 세로읽기
// 총 다섯줄의 입력이 주어진다. 각 줄에는 최소 1개, 최대 15개의 글자들이 빈칸 없이 빈칸없이 연속으로 주어진다.
// 주어지는 글자는 영어 대문자 'A'부터 'Z', 영어 소문자 'a' 부터 'z', 숫자 '0'부터 '9' 까지 중 하나이다.
// 각 줄의 시작과 마지막에 빈칸은 없다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Baek10798 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        char[][] arr = new char[5][15];

        int max = 0;

        for (int i = 0; i < 5; i++){
            String str = br.readLine(); // 한 행에 공백 없이 입력을 받으므로 br 객체를 사용하는 것이 올바르다.

            if(str.length() > max) max = str.length(); // max 크기는 입력을 받은 후 정해진다.

            for (int j = 0; j < str.length(); j++){
                arr[i][j] = str.charAt(j);
            }
        }

        for (int i = 0; i < max; i++){
            for (int j = 0; j < 5; j++){
                if (arr[j][i] == '\0') continue;

                System.out.print(arr[j][i]);
            }
        }

    }
}
