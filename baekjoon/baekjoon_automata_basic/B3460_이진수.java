package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Baekjoon
 *  Bronze level3 - B3460 이진수
 *
 *  > bin 함수
 *  > toBinaryStirng() 함수 사용가능
 */
public class B3460_이진수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // Testcase

        for (int i = 0; i < T; i++) {

            int num = Integer.parseInt(br.readLine());
            int idx = 0;

            while (true) {
                if ((num % 2) == 1) {
                    System.out.print(idx);
                    System.out.print(" "); // if외부 선언시 나머지 0일때도 수행되어 공백 1개 이상 발생
                } else if ((num / 2) == 0) break;

                idx++;
                num = num / 2;
            }
            System.out.println(); // /r/n - enter
        }
    }
}
