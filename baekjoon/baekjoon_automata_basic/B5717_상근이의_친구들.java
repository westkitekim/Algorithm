package baekjoon_automata_basic;

import java.io.*;
import java.util.StringTokenizer;

// 출력 수정필요(하나씩 출력되는게 맞는가)
public class B5717_상근이의_친구들 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine(), " ");

            int M = Integer.parseInt(st.nextToken());
            int F = Integer.parseInt(st.nextToken());

            if (M == 0 && F == 0) break;

//          bw.write(M + F);
            System.out.println(M + F);
        }
        br.close();
    }
}
