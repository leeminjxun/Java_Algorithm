package Stu.waek4;

import java.util.*;
import java.io.*;

public class Swea1926 {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());

        for(int i = 1; i <= N; i++) {
            int thousands = i / 1000; // 천의 자리수
            int hundreds = (i - thousands * 1000) / 100; // 백의 자리수
            int tens = ((i - thousands * 1000) - hundreds * 100) / 10; // 십의 자리수
            int units = ((i - thousands * 1000) - hundreds * 100) - tens * 10; // 일의 자리수

            int clabCount = 0;

            if(thousands != 0 && thousands % 3 == 0) clabCount++;
            if(hundreds != 0 && hundreds % 3 == 0) clabCount++;
            if(tens != 0 && tens % 3 ==0) clabCount++;
            if(units != 0 && units % 3 ==0) clabCount++;

            if(clabCount == 0) {
                System.out.print(i + " ");
            } else {
                for(int j = 0; j < clabCount; j++) {
                    System.out.print("-");
                }
                System.out.print(" ");
            }

        }
    }
}
