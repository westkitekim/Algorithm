package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  [BOJ 2468 안전영역 Silver1 - DFS/BFS, BruteForce]
 *  <문제>
 *  1. 높이는 1이상 100 이하의 정수
 *  2. 입력값 중 최대 높이 구해야할듯
 */
public class B2468_안전영역 {
    static int n;
    static int[][] arr; // 전체배열, 초기값 0 이므로 1만 세팅
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    // min, max값 구해야함
    static int max;
    static int min;

    static boolean[][] isVisited;
    static int maxCnt; // 총 개수

    public static void main(String[] args) throws IOException {
        init();

        int rain = min;
        maxCnt = Integer.MIN_VALUE;

        // while (rain++ <= max) => 틀림 => 모든 지역이 물에 잠기지 않는 경우 누락?
        for (rain = 0; rain <= max; rain++) {
            isVisited = new boolean[n][n]; // 새로 초기화
            int temp = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (arr[i][j] > rain && !isVisited[i][j]) {
                        temp++;
                        dfs(i, j, rain);
                    }
                }
            }
            if (maxCnt < temp) maxCnt = temp;
        }

        System.out.println(maxCnt);
    }

    static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        arr = new int[n][n];

        max = 0; min = Integer.MAX_VALUE;
        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());

            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
                if (max < arr[i][j]) max = arr[i][j];
                if (min > arr[i][j]) min = arr[i][j];
            }
        }
    }

    static void dfs(int x, int y, int rain) {
        isVisited[x][y] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (validRngChk(nx, ny) && !isVisited[nx][ny] && arr[nx][ny] > rain) {
                dfs(nx, ny, rain);
            }
        }
    }

    static boolean validRngChk(int nx, int ny) {
        return nx >= 0 && nx < n && ny >= 0 && ny < n;
    }
}
