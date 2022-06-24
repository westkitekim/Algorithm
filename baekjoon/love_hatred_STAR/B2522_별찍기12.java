package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2522_별찍기12 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        // 2N - 1
        // for 변수 활용
        int N = Integer.parseInt(br.readLine());

        for (int i = 1; i <= N; i++) {
            for (int j = 1; j <= N - i; j++) {
                System.out.print(" ");
            }

            for (int k = N - i + 1; k <= N; k++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = 0; i < N - 1; i++) {
            for (int j = N - i - 3; j < N - 2; j++) {
                System.out.print(" ");
            }

            for (int k = 0; k < N - i - 1; k++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
}
