package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

//Refactoring
public class B1977_완전제곱수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        double M = Integer.parseInt(br.readLine()); // M은 초과로 계산
        double N = Integer.parseInt(br.readLine()); // N은 = 포함

        int mSqrt = Integer.parseInt(String.format("%.0f", Math.ceil(Math.sqrt(M)))); // 이게맞아..?
        int nSqrt = Integer.parseInt(String.format("%.0f", Math.floor(Math.sqrt(N)))); // 이게맞아..?

        int sum = 0;
        if((int)Math.sqrt(M) == (int)Math.sqrt(N)) System.out.println(-1);
        else {
            for (int i = mSqrt; i <= nSqrt; i++) {
                sum += i * i;
            }
            System.out.println(sum);
            System.out.println(mSqrt * mSqrt);
        }
    }
}
