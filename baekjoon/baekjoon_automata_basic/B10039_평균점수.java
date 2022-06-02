package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B10039_평균점수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int scoreSum = 0; // 합산값 넣을 변수

        for (int i = 0; i < 5; i++) {
            int score = Integer.parseInt(br.readLine());

            scoreSum += score < 40 ? 40 : score; // 조건문 score setting

        }
        br.close();
        System.out.println(scoreSum / 5);
    }
}
