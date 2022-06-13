package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 *  오류 원인 총 2가지
 *  1.
 *  2. 문제 이해 잘못 파악
 */
public class B16715_Inspiration {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N - 1];
        int radix = N; // N진법
        int sum = 0;

        // 16진법부터 (동일한 경우 작은진법으로 치환되기 위함)
        for (int i = N - 2; i >= 0; i--) {
            int quot = N;

            while (true) {
                sum += quot % radix;
                quot /= radix;

                if(quot < radix) {
                    sum += quot;
                    break;
                }
            }
            radix--;
            arr[i] = sum;
            sum = 0;
        }

        int max = arr[N - 2];
        int arrInx = N - 2;
        for (int i = N - 3; i >= 0; i--) {
            if(arr[i] >= max) {
                max = arr[i];
                arrInx = i;
            }
//            System.out.println(arrInx);
        }
//      ** 주의..
//         연산있으면 괄호로 좀 묶어라.. 계산오류남....후.
//      System.out.println(max + " " + arrInx + 2);
        System.out.println(max + " " + (arrInx + 2));
    }
}
