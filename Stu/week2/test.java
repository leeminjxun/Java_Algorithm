package Stu.week2;

import java.util.*;
import java.io.*;

public class test {
    static int[][] map;
    static boolean[][] visited;
    static int N, result;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, -1, 1};

    public static void main(String[] args) throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        map = new int[N][N];

        int max = 0;
        for(int i=0; i<N; i++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            for(int j=0; j<N; j++){
                map[i][j] = Integer.parseInt(st.nextToken());
                max = Math.max(max, map[i][j]);
            }
        }

        for(int h=0; h<max; h++){
            visited = new boolean[N][N];
            int count = 0;  // 강수량에 따라 생기는 안전영역의 개수
            for(int i=0; i<N; i++){
                for(int j=0; j<N; j++){
                    if(!visited[i][j] && map[i][j] > h){    // 방문한 적 없는 지역이고 지역 높이가 height보다 높은(침수 안된) 경우
                        bfs(i, j, h);                       // count+1하고 해당 지역을 시작으로 bfs 탐색
                        count ++;
                    }
                }
                result = Math.max(count, result);   // 안전영역 최대값
            }
        }

        System.out.println(result);
    }

    public static void bfs(int x, int y, int height){
        Queue<int[]> que = new LinkedList<>();
        que.add(new int[]{x, y});
        visited[x][y] = true;

        while(!que.isEmpty()){
            int now[] = que.poll();
            for(int i=0; i<4; i++){
                int nx = now[0] + dx[i];
                int ny = now[1] + dy[i];
                if(nx>=0 && ny>=0 && nx<N && ny<N){ // 범위를 벗어나지 않고
                    if(!visited[nx][ny] && map[nx][ny] > height){   // 방문한적 없고 height보다 새로운 지점의 높이가 높은 경우
                        visited[nx][ny] = true;
                        que.add(new int[]{nx,ny});
                    }
                }
            }
        }

    }
}
