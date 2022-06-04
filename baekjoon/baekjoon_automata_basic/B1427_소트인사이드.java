package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class B1427_소트인사이드 {
    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String num = br.readLine();

        char[] arr = num.toCharArray();
        int[] arr2 = new int[num.length()];

        for (int i = 0; i < num.length(); i++) {
            arr2[i] = arr[i] - '0';
        }

        Arrays.sort(arr2);

        for (int i = arr.length - 1; i >= 0; i--) {
            System.out.print(arr2[i]);
        }
    }
}
