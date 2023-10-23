package baekjoon.graph;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B1992_쿼드트리 {
    static int[][] map;
    static int n;
    static StringBuilder sb = new StringBuilder();


    public static void main(String[] args) throws IOException {
        init(); // 입력값 초기화

        QuadTree(0, 0, n); // 쿼드트리 분할작업 수행

        System.out.println(sb); // 출력
    }

    private static void init() throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        map = new int[n][n];

        String row;
        for (int i = 0; i < n; i++) {
            row = br.readLine();
            for (int j = 0; j < n; j++) {
                map[i][j] = Integer.parseInt(row.substring(j, j + 1));
//                map[i][j] = row.charAt(j) - '0';
            }
        }
    }

    static void QuadTree(int x, int y, int len) {
        if (isAvailable(x, y, len)) {
            sb.append(map[x][y]);
            return;
        }

        // 분할 시작
        // 분할이 필요한 경우만 괄호 추가 '()' -> equals "depth"
        int dividedLen = len / 2;

        sb.append('(');

        // 4개영역 재귀수행
        QuadTree(x, y, dividedLen);
        QuadTree(x, y + dividedLen, dividedLen);
        QuadTree(x + dividedLen, y, dividedLen);
        QuadTree(x + dividedLen, y + dividedLen, dividedLen);

        sb.append(')');
    }

    // 압축 가능 여부 확인
    // 전체배열 순회 -> 배열값 모두 동일한지 체크
    static boolean isAvailable(int x, int y, int len) {
        int val = map[x][y]; // 조회 영역의 첫 번째 값, 상대적 인덱스(0, 0)

        // 분할영역 순회 고려
        for (int i = x; i < x + len; i++) {
            for (int j = y; j < y + len; j++) {
                if (val != map[i][j]) return false;
            }
        }
        return true;
    }
}
