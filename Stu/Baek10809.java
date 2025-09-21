package Stu;

import java.util.*;
import java.io.*;

public class Baek10809 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        // 알파벳 위치를 나타내는 배열
        int[] arr = new int[26];

        int index = 0;

        String alpha = br.readLine();

        Arrays.fill(arr, -1);

        for (int i = 0; i < alpha.length(); i++) {

            index = (int)alpha.charAt(i);

            if (arr[index - 97] == -1) arr[index - 97] = i;

        }

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
