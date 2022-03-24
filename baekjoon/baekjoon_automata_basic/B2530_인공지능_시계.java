package baekjoon_automata_basic;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class B2530_인공지능_시계 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String currT = br.readLine();
        StringTokenizer st = new StringTokenizer(currT, " ");
        int seconds = Integer.parseInt(br.readLine());

        int hour = Integer.parseInt(st.nextToken()); // 14
        int min = Integer.parseInt(st.nextToken()); // 30
        int sec = Integer.parseInt(st.nextToken()); // 0

        // 순서 주의ㅠㅠ
        sec += seconds;

        min += sec / 60;
        sec %= 60;

        hour += min / 60;
        min %= 60;

        hour %= 24;

        System.out.println(hour + " " + min + " " + sec);
    }
}
    /* 삽질 코드
    private static int[] secConvert(int seconds) {
        int[] cvResult = new int[3];

        cvResult[2] = seconds % 60;
        cvResult[1] = (seconds / 60) % 60;
        cvResult[0] = ((seconds / 60) / 60);

        return cvResult;
    }

    private static int[] timeConvert(int[] time) {

        if(time[2] >= 60) {
            time[2] -= 60;
            time[1] += 1;
        }

        if(time[1] >= 60) {
            time[1] -= 60;
            time[0] += 1;
        }

        return time;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String currT= br.readLine();
        int cookT = Integer.parseInt(br.readLine());

        int[] seconds = secConvert(cookT);

        String[] times = currT.split(" ");
        int[] times2 = new int[3];

        for (String a : times) {
            for (int i = 0; i < times.length; i++) {
                times2[i] =Integer.parseInt(a);
            }
        }

        for (int i = 0; i < times.length; i++) {
            times2[i] += seconds[i];
            timeConvert(times2);
        }

        System.out.println(times2[0] + " " + times2[1] + " " + times[2]);
    }

     */
