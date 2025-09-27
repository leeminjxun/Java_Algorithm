package Stu.week2;

import javax.sound.sampled.Line;
import java.io.*;
import java.util.*;

public class Baek1260 {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int V = Integer.parseInt(st.nextToken());

        boolean visited[];

        LinkedList<Integer>[] adjList = new LinkedList[N+1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<Integer>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            adjList[u].add(v);
            adjList[v].add(u);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        visited = new boolean[N + 1];
        dfs(V, adjList, visited);

        sb.append("\n");
        visited = new boolean[N + 1];
        bfs(V, adjList, visited);

        System.out.println(sb);
    }

    static void dfs (int vertex, LinkedList<Integer>[] adjList, boolean visited[]) {
        visited[vertex] = true;

        sb.append(vertex).append(" ");

        Iterator<Integer> iter = adjList[vertex].listIterator();

        while (iter.hasNext()) {
            int nextVertex = iter.next();
            if (!visited[nextVertex]) dfs(nextVertex, adjList, visited);
        }
    }

    static void bfs (int vertex, LinkedList<Integer>[] adjList, boolean visited[]) {
        visited[vertex] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {

            vertex = queue.poll();
            sb.append(vertex).append(" ");

            Iterator<Integer> iter = adjList[vertex].listIterator();

            while (iter.hasNext()){
                int nextVertex = iter.next();
                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);
                }
            }
        }
    }
}
