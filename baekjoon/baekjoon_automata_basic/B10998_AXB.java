package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/**
 * Baekjoon 10998 - A×B
 * Bronze_5
 * automata_3
 */
public class B10998_AXB {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " "); // parameter2: 구분자 공백
        System.out.println(Integer.parseInt(st.nextToken()) * Integer.parseInt(st.nextToken()));
    }
}
