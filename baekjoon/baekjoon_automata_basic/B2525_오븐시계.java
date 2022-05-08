package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2525_오븐시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int currHour = Integer.parseInt(st.nextToken());
        int currMin = Integer.parseInt(st.nextToken());
        int cookT = Integer.parseInt(br.readLine()); // 추가된 시간(분)

        System.out.println((((currMin + cookT) / 60) + currHour) % 24 + " " + (currMin + cookT) % 60);
    }
}
