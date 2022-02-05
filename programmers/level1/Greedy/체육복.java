package greedy;
/*
    Greedy
    Level 1 - 체육복
 */
import java.util.Arrays;

class Solution {
    public int solution(int n, int[] lost, int[] reserve) {
        //도난당한 학생 제외먼저 해놓고 나중에 변수상황 더하기(= 체육복 빌려준 경우)
        int answer = n - lost.length;

        Arrays.sort(lost);
        Arrays.sort(reserve);

        //여벌 체육복이 있는 학생이 도난당한 경우
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] == reserve[j]) {
                    answer++;//개수로는 도난당한 것이 아니므로 ++
                    lost[i] = -1;//학생의 번호가 아닌 -1로 변경
                    reserve[j] = -1;//위와 동일
                    break;
                }
            }
        }

        //도난당한 학생에게 체육복을 빌려주는 경우
        for(int i = 0; i < lost.length; i++) {
            for(int j = 0; j < reserve.length; j++) {
                if(lost[i] - 1 == reserve[j] || lost[i] + 1 == reserve[j]) {
                    answer++;
                    //lost[i] = -1;
                    reserve[j] = -1;
                    break;
                }
            }
        }

        return answer;
    }
}

public class 체육복 {
    public static void main(String[] args) {
    }
}
