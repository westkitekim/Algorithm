package math;

/*
    Programmers Math
    Level 1 - 소수만들기
 */

class Solution {
    public int solution(int[] nums) {
        //answer값을 -1에서 0으로 바꿔줘야 한다(++ 연산을 할 것이기 때문)
        //int answer = -1;
        int answer = 0;

        //3개의 수를 차례대로 합산해야 하기 때문에 삼중 for문??
        for(int i = 0; i < nums.length; i++) {
            for(int j = i + 1; j < nums.length; j++) {
                for(int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if(isPrimeNum(sum)) answer++;
                }
            }
        }

        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.
        System.out.println("k");

        return answer;
    }

    //Prime Number를 판별하는 메서드
    public static boolean isPrimeNum(int n) {
        //소수인지 판별하여 반환할 변수 chk
        boolean chk = true;
        //2는 따로?
        if(n == 2) {
            chk = true;
        }

        //소수가 아닌 경우
        for(int i = 2; i < n; i++) {
            if((n % i) == 0) {
                chk = false;
            }
        }
        return chk;
    }
}

public class 소수만들기 {
    
}
