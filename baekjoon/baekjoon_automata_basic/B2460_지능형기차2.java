package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2460_지능형기차2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = 0;
        int max = 0;
        int sum = 0;
        int current = 0;

        while(N < 10) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");
            int out = Integer.parseInt(st.nextToken()); // 내린사람
            int in = Integer.parseInt(st.nextToken()); // 탄 사람

            current += (in - out);

            if (current >= max) max = current; // 최대값

            N++;
        }
        System.out.println(max);
    }
}
