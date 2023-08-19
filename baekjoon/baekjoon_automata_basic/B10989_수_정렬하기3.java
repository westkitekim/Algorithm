package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10989_수_정렬하기3 {
    // 카운팅정렬
    public static void main(String[] args) throws IOException {
        // N(1 ≤ N ≤ 10,000,000)
        // 이 수는 10,000보다 작거나 같은 자연수이다.
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        int[] cntArr = new int[10001];

        // 입력받은수를 인덱스로 증가시킴
        for (int i = 0; i < n; i++) {
            cntArr[Integer.parseInt(br.readLine())]++;
        }
        br.close();

        StringBuilder sb = new StringBuilder();

        for (int i = 1; i < 10001; i++) {
            while (cntArr[i] > 0) {
                sb.append(i).append('\n');
                cntArr[i]--;
            }
        }

        System.out.println(sb);
    }
}
