package baekjoon.binary_tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Baekjoon Silver1 no.9934 완전이진트리
 *
 * @Desc 중위순회
 */
// BMS = false
public class B9934_완전이진트리_completeBT {
    static int k;                           // level
    static int[] arrInput;                  // 입력값 배열
    static List<ArrayList<Integer>> list;   // 단계별 노드 (단계별 입력값 개수 알수 없기 때문에 list -> list)

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        k = Integer.parseInt(br.readLine()); // level

        StringTokenizer st = new StringTokenizer(br.readLine()); // 입력값
        StringBuilder sb = new StringBuilder();

        // 완전이진트리 총 노드개수 = 2^k - 1
        arrInput = new int[(int) Math.pow(2, k) - 1];

        // 입력값 배열 초기화
        for (int i = 0; i < arrInput.length; i++) {
            arrInput[i] = Integer.parseInt(st.nextToken());
        }

        // depth별 리스트 초기화
        list = new ArrayList<>();
        for (int i = 0; i < k; i++) { // list.size = k
            list.add(new ArrayList<>()); // 내부 리스트 초기화
        }

        // 완전이진탐색
        searchBinary(0, arrInput.length, 0);

        for (int i = 0; i < k; i++) {
            for (int j : list.get(i)) {
                sb.append(j).append(" ");
            }
            sb.append("\n");
        }

        System.out.println(sb);
    }

    static void searchBinary(int start, int end, int depth) {
        // 재귀 탈출문
        if (depth == k) {
            return;
        }

        // 중간 인덱스값
        int mid = (start + end) / 2;

        // depth에 따라 노드 삽입
        list.get(depth).add(arrInput[mid]);

        // 왼쪽노드 (start ~ (mid - 1))
        searchBinary(start, mid - 1, depth + 1);
        // 오른쪽노드 ((mid + 1 ) ~ end)
        searchBinary(mid + 1, end, depth + 1);
    }
}
