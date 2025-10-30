import java.util.*;
import java.io.*;

class Swea1206
{
    public static void main(String args[]) throws Exception
    {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));


        for(int test_case = 1; test_case <= 10; test_case++)
        {
            int N = Integer.parseInt(br.readLine());

            int[] arr = new int[N];

            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }

            int roomCount = 0;

            for(int i = 2; i < N - 2; i++) {
                int maxLength = arr[i - 2];

                if(arr[i - 1] > maxLength) maxLength = arr[i - 1];

                if(arr[i + 1] > maxLength) maxLength = arr[i + 1];

                if(arr[i + 2] > maxLength) maxLength = arr[i + 2];

                if(maxLength < arr[i]) roomCount += arr[i] - maxLength;

            }

            System.out.println("#" + test_case + " " + roomCount);

        }
    }
}