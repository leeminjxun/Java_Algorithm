package Stu.weak5;

import java.util.*;
import java.io.*;

public class Swea1208 {
    public static void main(String args[]) throws Exception
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int dump = Integer.parseInt(br.readLine());

            int[] boxes = new int[100];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < 100; i++) {
                boxes[i] = Integer.parseInt(st.nextToken());
            }

            Arrays.sort(boxes);

            for(int i = 0; i < dump; i++) {

                boxes[99]--;
                boxes[0]++;

                Arrays.sort(boxes);

                if(boxes[99] - boxes[0] == 0) break;
            }

            System.out.println("#" + test_case + " " + (boxes[99] - boxes[0]));
        }
    }
}
