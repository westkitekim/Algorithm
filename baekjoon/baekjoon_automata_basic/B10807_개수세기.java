package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10807_개수세기 {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // T에 대한 검증 미존재
        int T = Integer.parseInt(br.readLine());
        String sb = br.readLine();
        int num = Integer.parseInt(br.readLine());

        String[] arr = sb.split(" ");

        int countArr = 0;

        for (int i = 0; i < arr.length; i++) {
            if(num == Integer.parseInt(arr[i])) countArr++;
        }

        System.out.println(countArr);
    }
}
