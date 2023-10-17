package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

/**
 *  영영의 개수 \n, 면적의 너비 오름차순 정렬 출력, 공백
 */
public class B2538_영역구하기 {
    static int m, n, k, areaCnt;  // 세로, 가로, 직사각형 개수
    static int[][] map; // 전체배열, 초기값 0 이므로 1만 세팅
    static int[] dx = { -1, 1, 0, 0 };
    static int[] dy = { 0, 0, -1, 1 };
    static boolean[][] isVisited; // 1 -> 0 으로 변경할수도
    static int totCnt; // 분리된 영역의 개수

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder(); // totCnt

        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        map = new int[m][n];

        // 직사각형 내부 표시
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            int x1 = Integer.parseInt(st.nextToken());
            int y1 = Integer.parseInt(st.nextToken());
            int x2 = Integer.parseInt(st.nextToken());
            int y2 = Integer.parseInt(st.nextToken());

            // 직사각형 내부는 1로 표시
            // y축이 row임을 유의할 것
            for (int j = y1; j < y2; j++) { // y2 포함?
                for (int k = x1; k < x2; k++) {
                    map[j][k] = 1;
                }
            }
        }

        ArrayList<Integer> areaList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (map[i][j] == 0) { // 직사각형 외부 확인(방문여부 확인)
                    areaCnt = 0; //
                    dfs(i, j);
                    areaList.add(areaCnt); // 재귀 종료시 리스트에 각 분리된 영역의 면적 저장
                }
            }
        }

        // 너비 오름차순 정렬
        Collections.sort(areaList);

        // 출력
        sb.append(areaList.size()).append('\n'); // 영역의 개수 저장
        Iterator<Integer> it = areaList.iterator();
        while (it.hasNext()) {
            sb.append(it.next()).append(" ");
        }

        System.out.println(sb);
    }

    static void dfs(int x, int y) {
        map[x][y] = 1; // 방문체크
        areaCnt++; // 재귀호출시 영역의 개수 증가

        for (int i = 0; i < 4; i++) {
            int nx = x + dx[i];
            int ny = y + dy[i];

            if (validRngChk(nx, ny) && map[nx][ny] == 0) {
                dfs(nx, ny); // 재귀호출
            }
        }
    }

    static boolean validRngChk(int nx, int ny) {
        return nx >= 0 && nx < m && ny >= 0 && ny < n;
    }
}
