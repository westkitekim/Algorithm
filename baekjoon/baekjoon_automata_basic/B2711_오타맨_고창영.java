package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class B2711_오타맨_고창영 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testNum = Integer.parseInt(br.readLine());
        int loopNum = 0;

        ArrayList<String> out = new ArrayList<>();

        while(loopNum < testNum) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int deleteIdx = Integer.parseInt(st.nextToken());
            String str = st.nextToken();

            String first = str.substring(0, deleteIdx - 1);
            String second = str.substring(deleteIdx);

            out.add(first.concat(second));
            loopNum++;
        }

        for (String a : out) {
            System.out.println(a);
        }
    }
}
