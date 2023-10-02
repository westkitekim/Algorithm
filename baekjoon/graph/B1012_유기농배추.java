package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 *  [BOJ 1012 유기농 배추 Silver2 - DFS/BFS]
 *  <문제>
 *  1. 0은 배추가 심어져 있지 않은 땅이고, 1은 배추가 심어져 있는 땅
 *  2. 필요한 흰 지렁이 최소 개수
 *  3. n, m switch 주의
 */
public class B1012_유기농배추 {
    static int testcase;
    static int m, n, k;
    static int[][] arr; // 전체배열, 초기값 0 이므로 1만 세팅
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };

    static boolean[][] isVisited;
    static int totCnt; // 총 개수


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder(); // totCnt
        StringTokenizer st;

        // testcase
        testcase = Integer.parseInt(br.readLine());
        for (int i = 0; i < testcase; i++) {
            st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());
            arr = new int[n][m];
            isVisited = new boolean[n][m];
            int x, y;

            // 반복문 수 확인
//            for (int j = 0; j < m; j++) {
//                Arrays.fill(arr[j], 0); // 일차원배열만 가능하기 때문에 for문 한번 싸줘야함
//            }
            /*
            public static void fill(Object[] a, Object val) {
                for (int i = 0, len = a.length; i < len; i++)
                    a[i] = val;
            }
            */
            // 배열 할당
            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                x = Integer.parseInt(st.nextToken());
                y = Integer.parseInt(st.nextToken());
                arr[y][x] = 1;
            }

            totCnt = 0;
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < m; k++) {
                    if (arr[j][k] == 1 && isVisited[j][k] == false) {
                        totCnt++;
                        dfs(k, j);
                    }
                }
            }
            sb.append(totCnt).append('\n');
        }
        System.out.println(sb);

    } // main

    static void dfs(int x, int y) {
        isVisited[y][x] = true;

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (validRngChk(nx, ny) && !isVisited[ny][nx] && arr[ny][nx] == 1) {
                dfs(nx, ny);
            }
        }
    }

    static boolean validRngChk(int nx, int ny) {
        return nx >= 0 && nx < m && ny >= 0 && ny < n;
    }
}
