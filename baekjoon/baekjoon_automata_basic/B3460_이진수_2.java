package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B3460_이진수_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int T = Integer.parseInt(br.readLine()); // Testcase

        for (int i = 0; i < T; i++) {

            int num = Integer.parseInt(br.readLine());
            String binary = Integer.toBinaryString(num); // 이진수 변환

            for (int j = binary.length() - 1; j >= 0; j--) {
                if (binary.charAt(j) == '1') {
                    System.out.print(binary.length() - j - 1 + " ");
                }
            }
            System.out.println();
        }
    }
}
