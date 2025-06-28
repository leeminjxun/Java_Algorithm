package Data_Structure.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.StringTokenizer;

// 인접행렬을 이용한 DFS 구현

public class DFS {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        System.out.print("정점의 개수 입력: ");
        int n = Integer.parseInt(br.readLine()) + 1;

        int[][] adjMat = new int[n][n];

        System.out.print("간선의 수 입력: ");
        int e = Integer.parseInt(br.readLine());

        System.out.println("간선 N 줄 입력 (u -> v) (예시 : 1 2)");
        for (int i = 0; i < e; i++) {
            st = new StringTokenizer(br.readLine());
            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjMat[u][v] = 1;
            adjMat[v][u] = 1;

        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(adjMat[i][j] + " ");
            }
            System.out.println();
        }

        System.out.print("탐색 시작 정점 입력 : ");
        int start = Integer.parseInt(br.readLine());
        dfs(adjMat, start);
    }

    static void dfs(int[][] adjMat, int startV) {
        StringBuilder sb = new StringBuilder();

        int n = adjMat.length;
        boolean[] visited = new boolean[n];
        Deque<Integer> stack = new ArrayDeque<>();

        System.out.println("DFS 탐색 시작 : " + startV);

        stack.push(startV);

        while (!stack.isEmpty()) {
            int vertex = stack.pop();

            if (!visited[vertex]){
                visited[vertex] = true;
                sb.append(vertex + " ");

                for (int i = n - 1; i >= 0; i--) {
                    if(adjMat[vertex][i] == 1 && !visited[i]) stack.push(i);
                }
            }
        }

        System.out.println(sb);
    }

}
