package Stu.weak5;

import java.io.*;
import java.util.*;

public class Swea1234 {

    static int N;
    static String password;

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st;
        for(int test_case = 1; test_case <= 10; test_case++) {
            st = new StringTokenizer(br.readLine());

            N = Integer.parseInt(st.nextToken());
            password = st.nextToken();

            while(true) {
                if(!BFS()) break;
            }

            System.out.println("#" + test_case + " " + password);
        }

    }

    static boolean BFS() {

        for(int index = 0; index < N - 1; index++) {
            if(password.charAt(index) == password.charAt(index + 1)) {
                if(index == 0) {
                    password = password.substring(2, N);
                } else {
                    password = password.substring(0, index) + password.substring(index + 2, N);
                }

                N = password.length();
                return true;
            }

        }

        return false;
    }
}
