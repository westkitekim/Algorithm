package baekjoon_automata_basic;

import java.text.SimpleDateFormat;
import java.util.Date;

public class B10699_오늘_날짜 {
    public static void main(String[] args) {
        Date date = new Date();
//      YYYY-MM-DD -> 2022-03-85 출력
//      YYYY는 Week year Component 사용
//      Weak year Component : 365 / 7 = 52.142857...
//      12월 30일의 경우 53주로 들어가 다음년도로 계산되는 오류 발생
//      -> yyyy-MM-dd 소문자 유의
        SimpleDateFormat dtFormat = new SimpleDateFormat("yyyy-MM-dd");

        String today = dtFormat.format(date);

        System.out.println(today);
    }
}
