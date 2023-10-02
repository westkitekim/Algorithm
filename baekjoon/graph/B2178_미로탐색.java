package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/**
 *  [BOJ 2178 미로탐색 Silver1 - DFS/BFS]
 *  <문제>
 *  1. (1, 1)에서 출발하여 (N, M)의 위치로 이동 -> 배열 Index 0 유의
 *  2. 서로 인접한 칸으로만 이동
 *  3. 최소의 칸 수 -> how?
 */
public class B2178_미로탐색 {
    static int n, m;
    static int[][] maze;
    static boolean[][] visited;
    static int[] dx = {0, 0, 1, -1};
    static int[] dy = {1, -1, 0, 0};

    public static void main(String[] args) throws IOException {
        init();

        bfs(0, 0);
        System.out.println(maze[n - 1][m - 1]);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        maze = new int[n][m];
        visited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            String str = br.readLine();
            for (int j = 0; j < m; j++) {
                maze[i][j] = Integer.parseInt(str.substring(j, j + 1));
            }
        }

        visited[0][0] = true; // why?? 시작전에 방문여부 체크
    }

    static void bfs(int x, int y) {
        Queue<Spot> que = new LinkedList<>();
        que.add(new Spot(x, y));

        while (!que.isEmpty()) {
            Spot now = que.poll();

            for (int i = 0; i < 4; i++) {
                int nx = now.x + dx[i];
                int ny = now.y + dy[i];

                // nx, ny 유효성 체크
                if (nx < 0 || ny < 0 || nx >= n || ny >= m) {
                    continue;
                }

                // 방문여부 확인
                if (visited[nx][ny] || maze[nx][ny] == 0) {
                    continue;
                }

                // 다음 값 할당
                que.add(new Spot(nx, ny));
                maze[nx][ny] = maze[now.x][now.y] + 1;
                visited[nx][ny] = true;
            }
        }
    }
}

class Spot {
    int x, y;
    Spot(int x, int y) {
        this.x = x;
        this.y = y;

    }
}
