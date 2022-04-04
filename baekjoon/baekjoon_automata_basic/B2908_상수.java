package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class B2908_상수 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringBuffer sb = new StringBuffer(br.readLine());
        String reversedStr = sb.reverse().toString(); // 전체 문자열 뒤집기

        String[] firstNum = reversedStr.split(" ");

//      (1)
        /*
        if(Integer.parseInt(firstNum[0]) > Integer.parseInt(firstNum[1])) System.out.println(firstNum[0]);
        else System.out.println(firstNum[1]);
        */


//      (2)
        int max = 0;

        for (int i = 1; i < firstNum.length; i++) {
            max = Integer.parseInt(firstNum[0]);
            if(max < Integer.parseInt(firstNum[i])) max = Integer.parseInt(firstNum[i]);
        }
        System.out.println(max);
    }
}
