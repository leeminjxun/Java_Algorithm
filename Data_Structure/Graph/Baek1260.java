package Data_Structure.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek1260 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        boolean visited[];

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken()); // 시작 정점

        LinkedList<Integer>[] adjList = new LinkedList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int u = Integer.parseInt(st.nextToken());
            int v = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        visited  = new boolean[N + 1];
        dfs(V, adjList, visited);

        sb.append("\n");

        visited  = new boolean[N + 1];
        bfs(V, adjList, visited);

        System.out.println(sb);
    }

    public static void dfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[v] = true;

        sb.append(v).append(" ");

        Iterator<Integer> iterator = adjList[v].listIterator();

        while (iterator.hasNext()) {
            int vertex = iterator.next();
            if (!visited[vertex]) {
                dfs(vertex, adjList, visited); // DFS 재귀호출
            }
        }

    }

    public static void bfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        Queue<Integer> queue = new LinkedList<Integer>();
        visited[v] = true;
        queue.add(v);

        while (!queue.isEmpty()) {
            v = queue.poll();
            sb.append(v).append(" ");

            Iterator<Integer> iterator = adjList[v].listIterator();

            while (iterator.hasNext()) {
                int v_2 = iterator.next();
                if (!visited[v_2]) {
                    visited[v_2] = true;
                    queue.add(v_2);
                }
            }

        }

    }

}
