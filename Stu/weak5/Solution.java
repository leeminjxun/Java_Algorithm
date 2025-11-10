package Stu.weak5;

import java.util.*;
import java.io.*;

class Solution
{
    public static void main(String args[]) throws Exception
    {
        char[] one = {'A', 'D', 'O', 'P',  'Q', 'R'};

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for(int test_case = 1; test_case <= T; test_case++)
        {
            st = new StringTokenizer(br.readLine());

            String A = st.nextToken();
            String B = st.nextToken();

            if(A.length() != B.length()) {
                System.out.println("#" + test_case + " DIFF");
                continue;
            }

            int count = 0;

            for(int i = 0; i < A.length(); i++) {
                if(A.charAt(i) == 'B' && B.charAt(i) == 'B') {
                    count++;
                    continue;
                }

                boolean isSameA = false;
                boolean isSameB = false;
                for(int j = 0; j < one.length; i++) {
                    if(A.charAt(i) == one[j]) isSameA = true;
                    if(B.charAt(i) == one[j]) isSameB = true;
                }

                if ( (isSameA && isSameB) || (!isSameA && !isSameB) ) {
                    count++;

                    isSameA = false;
                    isSameB = false;

                    continue;
                }

                if(isSameA != isSameB) {
                    System.out.println("#" + test_case + " DIFF");
                    break;
                }
            }

            if(count == A.length()) {
                System.out.println("#" + test_case + " SAME");
            }
        }
    }
}