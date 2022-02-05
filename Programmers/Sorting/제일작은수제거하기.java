package sorting;

/**
 *  Programmers Array
 *  Level 1 - 제일 작은 수 제거하기
 */
class Solution2 {
    public int[] solution(int[] arr) {
        /*
            variable 'answer' might not have been initialized
            배열을 선언만 하고 값을 할당하지 않아 생기는 Error
        */
        // 제일 작은 수를 제거할 것이기 때문에 입력받은 배열의 크기보다 1작은 배열 생성
        int[] answer = new int[arr.length - 1];

        // 원자값 2개 이상인 경우
        if(arr.length > 1) {
            int index = 0;

            // arr 배열에서 최소값 구하기
            int min = arr[0];
            for(int i = 1; i < arr.length; i++) {
                if(arr[i] < min) {
                    min = arr[i];
                }
            }

            // 새로운 배열에 최소값을 제외한 원자값 할당
            for(int i = 0; i < arr.length; i++) {
                if(arr[i] > min) {
                    answer[index++] = arr[i];
                }
            }
            // 특이점1 : 원자값이 1개인 경우 answer 배열은 null이 되므로 새로 할당하여 {-1} return
        } else if(arr.length == 1) {
            answer = new int[1];
            answer[0] = -1;
        }

        return answer;
    }
}

public class 제일_작은_수_제거하기 {
}
