package BOJ.Silver;

import java.util.*;
import java.io.*;

public class Baek2628 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int K = Integer.parseInt(br.readLine());

        int[] colTemp = new int[K + 2];
        int[] rowTemp = new int[K + 2];

        int colCount = 0;
        int rowCount = 0;

        for(int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int direct = Integer.parseInt(st.nextToken());
            int position = Integer.parseInt(st.nextToken());

            if(direct == 0) {
                colCount++;
                colTemp[colCount] = position;
            } else {
                rowCount++;
                rowTemp[rowCount] = position;
            }
        }
        colCount++;
        colTemp[colCount] = M;

        int[] col = new int[colCount + 1];

        for(int i = 0; i < colCount + 1; i++) {
            col[i] = colTemp[i];
        }

        rowCount++;
        rowTemp[rowCount] = N;

        int[] row = new int[rowCount + 1];

        for(int i = 0; i < rowCount + 1; i++) {
            row[i] = rowTemp[i];
        }

        Arrays.sort(col);
        Arrays.sort(row);

        int maxSize = 0;

        for(int i = 0; i < col.length - 1; i++) {
            for(int j = 0; j < row.length - 1; j++) {
                int x = col[i + 1] - col[i];
                int y = row[j + 1] - row[j];

                int size = x * y;

                maxSize = Math.max(maxSize, size);
            }
        }

        System.out.println(maxSize);

    }
}
