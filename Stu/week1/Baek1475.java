package Stu.week1;

import java.util.*;
import java.io.*;

public class Baek1475 {
    static int[] arr = new int[10];
    static int count = 1;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String s = br.readLine();

        Arrays.fill(arr, 1);
        int num;

        for (int i = 0; i < s.length(); i++) {
            num = (int)s.charAt(i) - 48;
            if (arr[num] > 0) {
                arr[num]--;
            } else {
                if (num == 9 && arr[6] > 0) arr[6]--;

                else if (num == 6 && arr[9] > 0) arr[9]--;

                else {
                    setPlus();
                    arr[num]--;
                }
            }
        }

        System.out.println(count);
    }

    public static void setPlus() {
        for (int i = 0; i < arr.length; i++) {
            arr[i]++;
        }
        count++;
    }

}
