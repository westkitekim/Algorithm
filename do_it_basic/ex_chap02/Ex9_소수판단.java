package do_it_basic.ex_chap02;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  Do it 알고리즘[자바]
 *  - [실습 2-9]
 *  - 소수구하기
 */
public class Ex9_소수판단 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        for (int i = 2; i <= N; i++) {
            int j; // 소수 판별 위한 선언

            for (j = 2; j < N; j++) {
                if((i % j) == 0) break;
            }
            if(i == j) System.out.println(i);
        }
    }
}
