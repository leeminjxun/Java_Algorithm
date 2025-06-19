package Data_Structure.Graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek24479 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        boolean visited[] = new boolean[N + 1];

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

        dfs(R, adjList, visited);

        System.out.println(sb);
    }

    public static void dfs(int n, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[n] = true;
        sb.append(n).append("\n");

        Iterator<Integer> iterator = adjList[n].listIterator();

        while (iterator.hasNext()) {
            int vertex = iterator.next();
            if (!visited[vertex]) dfs(vertex, adjList, visited);
        }

    }
}

//정점 개수 : 12
//간선 수 : 11

//1 2
//1 7
//1 8
//2 3
//2 6
//3 4
//3 5
//8 9
//8 12
//9 10
//9 11