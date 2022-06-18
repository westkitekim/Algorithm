package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
    1. Refactoring
    2. 출력위치 파악
 */
public class B2490_윷놀이 {
    public static void main(String[] args)throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] arr = new String[3];

        int sum;
        int stsNum;
        for (int i = 0; i < 3; i++) {
            sum = 0;
            stsNum= 0;

            String[] bitArr = br.readLine().split(" ");

            while(stsNum < 4) {
                sum += Integer.parseInt(bitArr[stsNum]);
                stsNum++;
            }

            switch (sum) {
                case 0 :
                    arr[i] = "D";
                    break;
                case 1 :
                    arr[i] = "C";
                    break;
                case 2 :
                    arr[i] = "B";
                    break;
                case 3 :
                    arr[i] = "A";
                    break;
                case 4 :
                    arr[i] = "E";
                    break;
            }
            // 왜 여기에서 이상하게 출력?
        }
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i]);
        }
    }
}
