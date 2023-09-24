package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

// 시간초과...
public class B1940_주몽 {
    static int[] list;
    static int n, m;
    static int result;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine()); // static n을 안써서 계속 0으로 나왔음..
        m = Integer.parseInt(br.readLine()); // 합, 아직 필요X
        list = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int temp = Integer.parseInt(st.nextToken());
            list[i] = temp;
        }

        combination(0, 2, 0, list, new boolean[n]);
        System.out.println(result);
    }

    private static void combination(int depth, int r, int start, int[] input, boolean[] isVisited) {
        if (depth == r) {
            int sum = 0;
            for (int i = 0; i < n; i++) {
                if (isVisited[i]) {
//                  System.out.print(input[i]);
                    sum += input[i];
                }
            }
            // 2 7 4 1 5 3
            // 2 7
            // 2 4 - 3 -> nlogn
            // 투포인터 -> 2
            if (sum == m) result++;
            return;
        }
        for (int i = start; i < n; i++) {
            isVisited[i] = true;
            combination(depth + 1, r, i + 1, input, isVisited);
            isVisited[i] = false;
        }
    }
}
