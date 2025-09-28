package Stu.week2;

import Data_Structure.Graph.BFS;

import java.util.*;
import java.io.*;

public class Baek2606 {
    static int N;
    static int M;

    static int count = 0;
    static boolean[] visited;
    static LinkedList<Integer>[] adjList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        M = Integer.parseInt(br.readLine());

        adjList = new LinkedList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new LinkedList<>();
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());

            int v = Integer.parseInt(st.nextToken());
            int u = Integer.parseInt(st.nextToken());

            adjList[v].add(u);
            adjList[u].add(v);
        }

        for (int i = 0; i <= N; i++) {
            Collections.sort(adjList[i]);
        }

        visited = new boolean[N + 1];
        bfs(1);

        System.out.println(count);
    }

    static void bfs(int vertex) {
        visited[vertex] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.add(vertex);

        while (!queue.isEmpty()) {
            vertex = queue.poll();

            Iterator<Integer> iter = adjList[vertex].listIterator();

            while (iter.hasNext()) {
                int nextVertex = iter.next();

                if (!visited[nextVertex]) {
                    visited[nextVertex] = true;
                    queue.add(nextVertex);

                    count++;
                }
            }
        }

    }
}
