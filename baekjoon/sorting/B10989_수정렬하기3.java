package sorting;

import java.io.*;
import java.util.Arrays;

public class B10989_수정렬하기3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine());
        int[] nnum = new int[N];

        for (int i = 0; i < N; i++) {
            nnum[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(nnum);

        for (int a : nnum) {
            sb.append(a).append('\n');
            sb.append(a + "\n");//메모리 초과 발생
        }

        br.close();
        System.out.println(sb);
    }
}
