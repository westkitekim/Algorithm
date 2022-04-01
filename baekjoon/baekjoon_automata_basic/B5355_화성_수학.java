package baekjoon_automata_basic;

import java.io.*;
import java.util.StringTokenizer;

public class B5355_화성_수학 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//      DecimalFormat form = new DecimalFormat("#.##"); // 출력시 적용 안됨

        int N = Integer.parseInt(br.readLine());
        int tCase = 0;
        String[] result = new String[N];

        for (int i = 0; i < N; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
//          int[] compute = Arrays.stream(math.split(" ")).mapToInt(Integer::parseInt).toArray(); // 문자열 배열 숫자배열로 변환, Stream API
            double value = Double.parseDouble(st.nextToken());

            while (st.hasMoreTokens()) {
//              if절 변수에 st.nextToken()을 넣어 NoSuchElementException 발생하였음
                String token = st.nextToken();
                if(token.equals("@")) {
                    value *= 3;
                } else if (token.equals("%")) {
                    value += 5;
                } else if (token.equals("#")) {
                    value -= 7;
                }
            }
//          소수점 변환
            result[i] = String.format("%.2f", value);
        }

        br.close();

        for (int i = 0; i < N; i++) {
            System.out.println(result[i]);
        }
    }
}
