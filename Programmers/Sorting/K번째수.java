package sorting;
/*
    Programmers Sorting
    Level 1 - K번째 수
 */
import java.util.*;

class Solution {
    public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        //이거 때문에 계속 ArrayIndexOutOfBoundsException 났음..
        //배열은 7번 라인과 같이 메모리 할당하고 넣어야 한다. 나는 바보가 아니다.
        //int[] answer = {}; 삽질하던 원래 코드

        //배열 자르기 Arrays.copyOfRange()
        for(int i = 0; i < commands.length; i++) {
            int startNum = commands[i][0] - 1;
            int endNum = commands[i][1];

            int[] arr1 = new int[endNum - startNum];
            arr1 = Arrays.copyOfRange(array, startNum, endNum);
            Arrays.sort(arr1);

            answer[i] = arr1[commands[i][2] - 1];

        }
        return answer;
    }
}

public class K번째수 {
}
