package Data_Structure.Graph;

// DFS를 인접리스트 사용한 방법 중에서 재귀적 순환 호출 방식을 이용해 구현한다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class graph_recursion {
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken()); // 정점 개수
        int M = Integer.parseInt(st.nextToken()); // 간선 개수
        int V = Integer.parseInt(st.nextToken()); // 탐색 시작 번호

        boolean visited[] = new boolean[N + 1]; // 방문 여부 검사 배열 N 은 정점

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

        dfs(V, adjList, visited);

        System.out.println(sb);
    }

    public static void dfs(int v, LinkedList<Integer>[] adjList, boolean[] visited) {
        visited[v] = true;
        sb.append(v).append(" ");

        Iterator<Integer> iterator = adjList[v].listIterator();

        while (iterator.hasNext()) {
            int vertex = iterator.next();
            if (!visited[vertex]) {
                dfs(vertex, adjList, visited);
            }
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