package BOJ.Silver;

import java.io.*;
import java.util.*;

public class Baek2578 {

    static int[][] bingo;
    static boolean[][] bingoCheck;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        bingo = new int[5][5];
        bingoCheck = new boolean[5][5];

        for(int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {
                bingo[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int count = 0;

        for (int i = 0; i < 5; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j = 0; j < 5; j++) {

                // 사회자가 부르는 숫자
                int num = Integer.parseInt(st.nextToken());

                // n 번째 숫자
                count++;

                // 인덱스에 해당하는 빙고판 x 표시 후 빙고의 개수를 센다
                if(checkIndex(num) >= 3) {
                    System.out.println(count);
                    return ;
                }
            }
        }
    }
    // 인덱스에 해당하는 빙고판 x 표시
    static int checkIndex(int num) {

        // 빙고 선 개수
        int checkCount = 0;

        // 인덱스에 해당하는 빙고판 x 표시
        for(int i = 0; i < 5; i++) {
            for(int j = 0; j < 5; j++) {
                if(bingo[i][j] == num) {
                    bingoCheck[i][j] = true;
                }
            }
        }

        // 가로 줄 점검
        for(int i = 0; i < 5; i++) {
            checkCount++;
            for(int j = 0; j < 5; j++) {
                if(!bingoCheck[i][j]) {
                    checkCount--;
                    break;
                }
            }
        }

        // 세로 줄 점검
        for(int i = 0; i < 5; i++) {
            checkCount++;
            for(int j = 0; j < 5; j++) {
                if(!bingoCheck[j][i]) {
                    checkCount--;
                    break;
                }
            }
        }

        // 대각선 줄 점검
        checkCount++;
        for(int i = 0; i < 5; i++) {
            if(!bingoCheck[i][i]) {
                checkCount--;
                break;
            }
        }
        checkCount++;
        for(int i = 0; i < 5; i++) {
            if(!bingoCheck[i][4 - i]) {
                checkCount--;
                break;
            }
        }

        return checkCount;

    }

}