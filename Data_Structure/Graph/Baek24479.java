package Data_Structure.Graph;

// 백준 [24479] 문제 유형 = DFS

// 문제 : 알고리즘 수업 - 깊이 우선 탐색

// 첫째 줄에 정점의 수 N (5 ≤ N ≤ 100,000), 간선의 수 M (1 ≤ M ≤ 200,000), 시작 정점 R (1 ≤ R ≤ N)이 주어진다.

// 다음 M개 줄에 간선 정보 u v가 주어지며 정점 u와 정점 v의 가중치 1인 양방향 간선을 나타낸다.
// (1 ≤ u < v ≤ N, u ≠ v) 모든 간선의 (u, v) 쌍의 값은 서로 다르다.

// 첫째 줄부터 N개의 줄에 정수를 한 개씩 출력한다. i번째 줄에는 정점 i의 방문 순서를 출력한다.
// 시작 정점의 방문 순서는 1이다. 시작 정점에서 방문할 수 없는 경우 0을 출력한다.

// [풀이] : DFS 인접리스트 로 구현하였으며, 순환 호출(재귀) 방식을 이용하였다.
// 인접리스트는 ArrayList 에 2차원 배열을 합쳐 구현하였다.

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Baek24479 {
    static StringBuilder sb = new StringBuilder();
    static int cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int R = Integer.parseInt(st.nextToken());

        int visited[] = new int[N + 1];

        ArrayList<Integer>[] adjList = new ArrayList[N + 1];

        for (int i = 0; i <= N; i++) {
            adjList[i] = new ArrayList<>();
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

        cnt = 1;

        dfs(R, adjList, visited);

        for (int i = 1; i < visited.length; i++) {
            sb.append(visited[i]).append("\n");
        }
        System.out.println(sb);
    }

    public static void dfs(int n, ArrayList<Integer>[] adjList, int[] visited) {
        visited[n] = cnt;

        Iterator<Integer> iterator = adjList[n].listIterator();

        while (iterator.hasNext()) {
            int vertex = iterator.next();
            if (visited[vertex] == 0) {
                cnt++;
                dfs(vertex, adjList, visited);
            }
        }

    }
}